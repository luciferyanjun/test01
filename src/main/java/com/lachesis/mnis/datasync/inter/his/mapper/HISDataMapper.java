package com.lachesis.mnis.datasync.inter.his.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lachesis.mnis.datasync.entity.Glucose;
import com.lachesis.mnis.datasync.entity.bean.GlucoseForHisDel;
import com.lachesis.mnis.datasync.entity.lis.PatLabTestDetail;
import com.lachesis.mnis.datasync.entity.lis.PatLabTestMas;
import com.lachesis.mnis.datasync.entity.patient.PatCureInfo;
import com.lachesis.mnis.datasync.entity.pub.ComBed;
import com.lachesis.mnis.datasync.entity.pub.ComUser;
import com.lachesis.mnis.datasync.entity.pub.ComWard;
import com.lachesis.mnis.datasync.entity.pub.ComWardUser;

/**
 * 查询his病人信息接口
 * @author qingzhi.liu  2015.05.14
 *
 */
public interface HISDataMapper {
	
	/**
	 * 获取上一次时间更新后办理入院、出院的病人  （不包括数据变动人员）
	 * @param lastUpdateTime  上一次同步更新时间
	 * @return
	 */
	public List<PatCureInfo> getHisChangePatCureInfo(String wardCode, String lastUpdateTime);
	
	/**
	 * 获取his某病区（科室）下的全部在院病人
	 * @param wardCode 病区编号（科室编号）
	 * @return 
	 */
	public List<PatCureInfo> getHisInAllPatCureInfo(String wardCode);
	
	/**
	 * 获取全院病区信息
	 * @param upTime  获取该时间后的数据
	 * @return
	 */
	public List<ComWard> getComWards(String upTime);
	
	/**
	 * 获取用户信息
	 * @param upTime  获取该时间后修改的数据
	 * @return
	 */
	public List<ComUser> getComUsers(String wardCode);
	
	/**
	 * 用户病区设置表
	 * @return
	 */
	public List<ComWardUser> getComWardUsers();
	
	/**
	 * 获取病床信息
	 * @param upTime  病床最后更新时间 可为空
 	 * @return
	 */
	public List<ComBed> getComBeds(String upTime);
	
	/**
	 * 获取检验主记录数据
	 * @param map  更新时间段条件
	 * @return
	 */
	public List<PatLabTestMas> getLabTestMas(Map<String, String> map);
	
	
	/**
	 * 获取检验明细数据
	 * @param map  更新时间段条件
	 * @return
	 */
	public List<PatLabTestDetail> getLabTestDetails(Map<String, String> map);

	public Date getDatabaseServerTime();
	
	public void insertGlucose(Glucose glucose);
	
	public void updateGlucose(Glucose glucose);
	
	public Glucose selectGlucose(Glucose glucose);
	
	public void deleteGlucose(GlucoseForHisDel glucose);
	
}
