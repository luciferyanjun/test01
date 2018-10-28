package com.lachesis.mnis.datasync.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lachesis.mnis.datasync.entity.Glucose;
import com.lachesis.mnis.datasync.entity.bean.GlucoseForHisDel;
import com.lachesis.mnis.datasync.inter.his.mapper.HISDataMapper;
import com.lachesis.mnis.datasync.utils.DateUtil;
import com.lachesis.mnis.datasync.utils.DynamicHttpClinetCall;

/**
 * 血糖相关操作
 * 
 * @author lei.lei
 *
 */
@Controller
@RequestMapping("/his")
@Transactional
public class GlucoseAction { 
	@Autowired
	private HISDataMapper hisDataMapper; 
	@RequestMapping(value = "/test")
	public @ResponseBody String test() {
		return "success";
	} 
	/**
	 * @param glucoseStr
	 * @return
	 */
	@RequestMapping(value = "/insertGlucose")
	public @ResponseBody BaseVo insertGlucose(@RequestBody String glucoseStr) {
		BaseVo vo = new BaseVo();
		
		if (glucoseStr == null) {
			vo.setRslt("-1");
			vo.setMsg("没有上传任何血糖数据");
			return vo;
		} else {
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			try {
				Glucose glucose = mapper.readValue(glucoseStr, Glucose.class);
				System.out.println("  ----》his insertGlucose start! ------->"+DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
				Glucose selectGlucose = hisDataMapper.selectGlucose(glucose);
				if(selectGlucose==null){
					hisDataMapper.insertGlucose(glucose);
				}else{
					hisDataMapper.updateGlucose(glucose);
				}
				System.out.println("  ----》his insertGlucose start! ------->"+DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
//				boolean r = addToHis(glucose,"insert");
//				if(r){
//					vo.setRslt("0");
//					vo.setMsg("");
//					return vo;
//				}else{
//					vo.setRslt("-1");
//					vo.setMsg("调用webservice执行失败");
//					return vo;
//				}
				vo.setRslt("0");
				vo.setMsg("");
				return vo;
			} catch (Exception e) {
				vo.setRslt("-1");
				vo.setMsg("JSON转换失败");
				e.printStackTrace();
				return vo;
			}
		}
	}
	
	/**
	 * @param glucoseStr
	 * @return
	 */
	@RequestMapping(value = "/updateGlucose")
	public @ResponseBody BaseVo updateGlucose(@RequestBody String glucoseStr) {
		BaseVo vo = new BaseVo();
		
		if (glucoseStr == null) {
			vo.setRslt("-1");
			vo.setMsg("没有上传任何血糖数据");
			return vo;
		} else {
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			try {
				Glucose glucose = mapper.readValue(glucoseStr, Glucose.class);
				System.out.println("  ----》his updateGlucose start! ------->"+DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
				Glucose selectGlucose = hisDataMapper.selectGlucose(glucose);
				if(selectGlucose==null){
					hisDataMapper.insertGlucose(glucose);
				}else{
					hisDataMapper.updateGlucose(glucose);
				}
				System.out.println("  ----》his updateGlucose start! ------->"+DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
//				boolean r = addToHis(glucose,"update");
//				if(r){
//					vo.setRslt("0");
//					vo.setMsg("");
//					return vo;
//				}else{
//					vo.setRslt("-1");
//					vo.setMsg("调用webservice执行失败");
//					return vo;
//				}
				vo.setRslt("0");
				vo.setMsg("");
				return vo;
			} catch (Exception e) {
				vo.setRslt("-1");
				vo.setMsg("JSON转换失败");
				e.printStackTrace();
				return vo;
			}
		}
	}
	
	@RequestMapping(value = "/deleteGlucose")
	public @ResponseBody BaseVo deleteGlucose(@RequestBody String glucoseStr) {
		BaseVo vo = new BaseVo();
		if (glucoseStr == null) {
			vo.setRslt("-1");
			vo.setMsg("没有上传任何血糖数据");
			return vo;
		} else {
			try{
				
				ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
				GlucoseForHisDel glucose = mapper.readValue(glucoseStr,GlucoseForHisDel.class);
				System.out.println("  ----》his deleteGlucose start! ------->"+DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
				if(glucose!=null){
						hisDataMapper.deleteGlucose(glucose);
					}
				System.out.println("  ----》his deleteGlucose start! ------->"+DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
				vo.setRslt("0");
				vo.setMsg("");
				return vo;
			}catch(Exception e){
				vo.setRslt("-1");
				vo.setMsg("JSON转换失败");
				e.printStackTrace();
				return vo;
			}
		}
	}

	/**
	 * 把录入的血糖值写入到HIS里面
	 * 
	 * @param glucose
	 */
	private boolean addToHis(Glucose glucose,String method) {

		return DynamicHttpClinetCall.insertGlucose(glucose,method);
		
	}
	
	 
}
