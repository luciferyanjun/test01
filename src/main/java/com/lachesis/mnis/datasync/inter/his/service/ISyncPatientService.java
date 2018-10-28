package com.lachesis.mnis.datasync.inter.his.service;

import java.util.Date;
import java.util.List;

import com.lachesis.mnis.datasync.entity.order.PatOrderGroup;
import com.lachesis.mnis.datasync.entity.patient.PatCureInfo;
import com.lachesis.mnis.datasync.entity.pub.ComBed;
import com.lachesis.mnis.datasync.entity.pub.ComUser;
import com.lachesis.mnis.datasync.entity.pub.ComWard;
import com.lachesis.mnis.datasync.entity.pub.ComWardUser;

/**
 * 同步his病人信息接口
 * @author qingzhi.liu 2015.05.14
 *
 */
public interface ISyncPatientService {
	
	/**
	 * 获取上一次时间更新后办理入院、出院的病人  （不包括数据变动人员）
	 * @param upTime 增量更新时间
	 * @return
	 */
	public List<PatCureInfo> getHisChangePatCureInfo(String wardCode, String upTime);
	
	/**
	 * 获取his某病区（科室）下的全部在院病人
	 * @param wardCode  病区编号
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
	 * 获取病床信息
	 * @param upTime  病床最后更新时间 可为空
 	 * @return
	 */
	public List<ComBed> getComBeds(String upTime);
	
	
	/**
	 * 用户病区设置表
	 * @return
	 */
	public List<ComWardUser> getComWardUsers();
	
	/**
	 * 同步执行医嘱
	 * @return
	 */
	public Date getDatabaseServerTime();

	public List<PatOrderGroup> getPatInsulinOrder(String deptId,Date upTime);

	public List<PatOrderGroup> getPatOralOrder(String dept_code, Date upTime);

}
