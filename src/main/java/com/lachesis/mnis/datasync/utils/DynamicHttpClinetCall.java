package com.lachesis.mnis.datasync.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lachesis.mnis.datasync.entity.Glucose;

//动态构造调用串，灵活性更大
public class DynamicHttpClinetCall {
	private static final Logger log = Logger.getLogger(DynamicHttpClinetCall.class);
	private static String namespace;
	private static String wsdlLocation;
	private String methodName;
	public static String machineId = "GlucoseMeter_M7";
	/*
	 * 初始化webservice配置
	 */
	public void initConfig() {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("config/webservice.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
			namespace = properties.getProperty("his.namespace");
			wsdlLocation = properties.getProperty("his.url");
		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

	/*
	 * 获取webservice客户端
	 * @param namespace
	 * @param methodName
	 * @param wsdlLocation
	 */
	public DynamicHttpClinetCall(String methodName) {
		// 如果webservice配置为空，那么初始化
		if (StringUtils.isEmpty(namespace) || StringUtils.isEmpty(wsdlLocation)) {
			initConfig();
		}
		this.methodName = methodName;
	}

	/**
	 * 外呼HIS调用
	 * 
	 * @param patameterMap
	 * @return
	 * @throws Exception
	 */
	private Object[] invoke(String soapRequest) throws Exception {
		HttpPost postMethod = new HttpPost(wsdlLocation);// webservice客户端
		postMethod.setHeader("Content-Type", "application/soap+xml;charset=UTF-8");
		postMethod.setHeader("SOAPAction", "");
		DefaultHttpClient httpClient = new DefaultHttpClient(); // HTTP客户端
		Object[] o = new Object[2];
		try {
			StringEntity requestEntity = new StringEntity(soapRequest,"utf-8");
			postMethod.setEntity(requestEntity);

			HttpResponse response= httpClient.execute(postMethod);
			int statusCode = response.getStatusLine().getStatusCode();
			
			HttpEntity entity = response.getEntity();  
            String respContent = EntityUtils.toString(entity , "utf-8").trim();
            
			o[0] = statusCode;
			o[1] = respContent;
			if (statusCode == 500) {
				log.error("error 500 info" + postMethod);
			}
			postMethod.abort();  
            httpClient.getConnectionManager().shutdown();  
		} catch (Exception e) {
			o[0] = 400;
			o[1] = "连接到服务器出错";
		} finally {
			// 关闭HTTP连接
			postMethod.abort();
			httpClient.getConnectionManager().shutdown();  
		}
		return o;
	}

	/*
	 * 报文拼接
	 * @param patameterMap
	 * @return
	 */
	private String buildRequest(Map<String, String> patameterMap) {
		StringBuffer soapRequestData = new StringBuffer();
		soapRequestData.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		soapRequestData.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
				+ " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
				+ " xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		soapRequestData.append("<soap:Body>");
		soapRequestData.append("<" + methodName + " xmlns=\"" + namespace + "\">");

		Set<String> nameSet = patameterMap.keySet();
		for (String name : nameSet) {
			soapRequestData.append("<" + name + ">" + patameterMap.get(name) + "</" + name + ">");
		}

		soapRequestData.append("</" + methodName + ">");
		soapRequestData.append("</soap:Body>");
		soapRequestData.append("</soap:Envelope>");
		log.info(soapRequestData.toString());
		return soapRequestData.toString();
	}
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		//System.out.println("result:" + insertGlucose(glucose));
		System.out.println(parseGetGlucoseMeterConfigResult("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">   <soapenv:Body>      <manageEMRWSResponse xmlns=\"http://tempuri.org/\">         <ns1:manageEMRWSReturn xmlns:ns1=\"http://business.emr.whzxyy.com\"><![CDATA[<?xml version=\"1.0\" standalone=\"yes\" ?><DocumentElement><ResultCode>0</ResultCode><ResultContent>999999999,T_999999999_2016022590000_7血糖记录保存成功;</ResultContent></DocumentElement>]]></ns1:manageEMRWSReturn>      </manageEMRWSResponse>   </soapenv:Body></soapenv:Envelope>"));
	}
	
	/**
	 * 写血糖数据到HIS
	 * 
	 * @param glucose：血糖对象
	 * @throws Exception
	 */
	public static boolean insertGlucose(Glucose glucose, String method) {
		DynamicHttpClinetCall dynamicHttpclientCall = new DynamicHttpClinetCall("manageEMRWS");

		Map<String, String> patameterMap = new HashMap<String, String>();

		patameterMap.put("reqType", "uploadGlucose");
		patameterMap.put("reqXml", createXML(glucose, method));
		// 外呼HIS 报文
		String soapRequest = dynamicHttpclientCall.buildRequest(patameterMap);
		log.debug("调用webservice！参数：" + soapRequest);
		Object[] o = null;
		try {
			o = dynamicHttpclientCall.invoke(soapRequest);
		} catch (Exception e) {
			log.error(e);
			return false;
		}
		int statusCode = (Integer) o[0];
		String xml = (String) o[1];
		if (statusCode == 200) {
			log.debug("调用成功！返回：" + xml);
			return parseGetGlucoseMeterConfigResult(xml);
		} else {
			log.error("调用失败！返回：" + statusCode + xml);
			return false;
		}
	}

	private static String createXML(Glucose glucose, String method) {
		StringBuffer buff = new StringBuffer("<![CDATA[<?xml version=\"1.0\" standalone=\"yes\"?><DocumentElement><ResultCode>0</ResultCode><ResultContent>Sucess</ResultContent><glucoseList><glucose>");
		buff.append("<PatientNo>").append(glucose.getPatient().getInHospNo()).append("</PatientNo>");
		buff.append("<GlucoseId>").append(glucose.getGlucose_id()).append("</GlucoseId>");
		buff.append("<HisId>").append("</HisId>");
		String time;
		if(glucose.getGlucoseTime() !=null && glucose.getGlucoseTime().indexOf("/")>0){
			time = glucose.getGlucoseTime().replace("/", "-");
		}else{
			time =glucose.getGlucoseTime();
		}
		buff.append("<TestTime>").append(time).append("</TestTime>");
		buff.append("<TestValue>").append(glucose.getValue()).append("</TestValue>");
		buff.append("<ResultType>").append(glucose.getType()).append("</ResultType>");
		if("update".equals(method)){
			buff.append("<SaveOrUpdate>").append("Update").append("</SaveOrUpdate>");
		}else if("insert".equals(method)){
			buff.append("<SaveOrUpdate>").append("Save").append("</SaveOrUpdate>");
		}else if("delete".equals(method)){
			buff.append("<SaveOrUpdate>").append("Delete").append("</SaveOrUpdate>");
		}else{
			throw new RuntimeException("只能是增、删、改中的一种操作!");
		}
		buff.append("<SaveOrUpdate>").append("Save").append("</SaveOrUpdate>");
		buff.append("<OperaterId>").append(glucose.getNurse_code()).append("</OperaterId>");
		buff.append("<OperaterName>").append(glucose.getNurse_name()).append("</OperaterName>");
		String s = "Normal";
		if("-1".equals(glucose.getFlag())){
			s="Low";
		}else if("1".equals(glucose.getFlag())){
			s="High";
		}
		buff.append("<TestIsNormal>").append(s).append("</TestIsNormal>");
		buff.append("<RefValue>").append("4.4-10").append("</RefValue>");
		buff.append("</glucose>").append("</glucoseList>").append("</DocumentElement>");
		buff.append("]]>");
		return buff.toString();
	}

	public static boolean parseGetGlucoseMeterConfigResult(String xml) {
		try {
			Document document = new SAXReader().read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
			// 根节点
			Element root = document.getRootElement();
			// 数据返回
			Element response = root.element("Body").element("manageEMRWSResponse");
			// 返回结果
			String result = response.element("manageEMRWSReturn").getText();
			// 失败原因
			Document document2 = new SAXReader().read(new ByteArrayInputStream(result.getBytes("UTF-8")));
			Element root2 = document2.getRootElement();
			String code = root2.elementText("ResultCode");
			if("0".equals(code)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

