package com.lachesis.mnis.datasync.web;



import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lachesis.mnis.datasync.timer.HISPatientDataSyncTask;
import com.lachesis.mnis.datasync.web.intercon.HIPService;
import com.lachesis.mnis.datasync.web.intercon.HIPServiceLocator;
@Service("interconnectionService")
public class Interconnection { 
	private String message =null;
	private String action =null;
	private String system =null; 
	//武汉市中心医院-互联互通接口调用
	public   void CallWs( String  inHospNo ) { 
				action = "PatientRegistryFindCandidatesQuery";
		 
	          message = "<PRPA_IN201305UV02 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\" xmlns=\"urn:hl7-org:v3\" xsi:schemaLocation=\"urn:hl7-org:v3 ../multicacheschemas/PRPA_IN201305UV02.xsd\">\n" +
	                "  <id root=\"2.16.156.10011.0\" extension=\"22a0f9e0-4454-11dc-a6be-3603d6866807\"/>\n" +
	                "  <creationTime value=\"20070803130624\"/>\n" +
	                "  <interactionId root=\"2.16.840.1.113883.1.6\" extension=\"PRPA_IN201305UV02\"/>\n" +
	                "  <processingCode code=\"P\"/>\n" +
	                "  <processingModeCode code=\"R\"/>\n" +
	                "  <acceptAckCode code=\"AL\"/>\n" +
	                "  <receiver typeCode=\"RCV\">\n" +
	                "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
	                "      <id root=\"2.16.156.10011.0.1.1\" extension=\"2.16.156.10011.0.1.1\"/>\n" +
	                "    </device>\n" +
	                "  </receiver>\n" +
	                "  <sender typeCode=\"SND\">\n" +
	                "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
	                "      <id root=\"2.16.156.10011.0.1.2\" extension=\"2.16.156.10011.0.1.2\"/>\n" +
	                "    </device>\n" +
	                "  </sender>\n" +
	                "  <controlActProcess classCode=\"CACT\" moodCode=\"EVN\">\n" +
	                "    <code code=\"PRPA_TE201305UV02\" codeSystem=\"2.16.840.1.113883.1.6\"/>\n" +
	                "    <queryByParameter>\n" +
	                "      <queryId root=\"2.16.156.10011.0\" extension=\"22a0f9e0-4454-11dc-a6be-3603d6866807\"/>\n" +
	                "      <statusCode code=\"new\"/>\n" +
	                "      <initialQuantity value=\"2\"/>\n" +
	                "      <matchCriterionList>\n" +
	                "        <minimumDegreeMatch>\n" +
	                "          <value xsi:type=\"INT\" value=\"100\"/>\n" +
	                "          <semanticsText>匹配程度</semanticsText>\n" +
	                "        </minimumDegreeMatch>\n" +
	                "      </matchCriterionList>\n" +
	                "      <parameterList>\n" +
	                 "        <livingSubjectId>\n" +
	                "          <value root=\"2.16.156.10011.0.2.2\" extension=\""+inHospNo+"\"></value>\n" +
	                "          <semanticsText>"+inHospNo+"</semanticsText>\n" +
	                "        </livingSubjectId>\n" +
	                "      </parameterList>\n" +
	                "    </queryByParameter>\n" +
	                "  </controlActProcess>\n" +
	                "</PRPA_IN201305UV02>\n";
	          system = "S47";

	        HIPService hipService = new HIPServiceLocator();

	        try {
	        	   hipService.getplatformHttpPort()
	        			.HIPMessageServer(action,message,system);
			} catch (RemoteException e) { 
				//e.printStackTrace();
			} catch (ServiceException e) { 
				//e.printStackTrace();
			} 
	}  
	
	/*  public static void main(String args[]){
		 Interconnection i=new Interconnection();
		 i.CallWs("1425720");
	 }   */
	
	}
 
