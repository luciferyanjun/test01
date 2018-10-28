package com.lachesis.mnis.datasync.inter.nurse.mapper;

import java.util.List;

import com.lachesis.mnis.datasync.entity.order.PatOrderGroup;
import com.lachesis.mnis.datasync.entity.order.PatOrderItem;
import com.lachesis.mnis.datasync.entity.patient.PatCureInfo;

/**
 * 数据同步到mnis
 * @author qingzhi.liu
 *
 */
public interface DataSyncMapper {
	
	/**
	 * 同步病人信息时，先删除病人存在信息  
	 * @param patCureInfo 患者信息
	 * @return
	 */
	public int delChangePatCurInfos(PatCureInfo patCureInfo);
	
	/**
	 * 把病人信息插入移动护理库
	 * @param patCureInfos  需要插入的数据集
	 * @return
	 */
	public int insertPatCurInfoList(List<PatCureInfo> patCureInfos);

	/**
	 * 将所有未在列表中的病人置为出院
	 */
	public void updateAllToOut(String wardCode, List<PatCureInfo> patList);

	public PatCureInfo getPatByPatId(String pat_id);

	public void insertPatCurInfo(PatCureInfo patCureInfo);

	public void updatePatCurInfo(PatCureInfo patCureInfo);

	public String findInsulinOrderByNo(String orderNo);

	public void insertInsulinOrder(PatOrderGroup labTestMas);

	public List<PatCureInfo> getInHospPat(String dept_code);

	public String findOralOrderByNo(String orderNo);

	public void insertOralOrder(PatOrderGroup labTestMas);

	public void insertInsulinOrderItem(PatOrderItem patOrderItem);

	public void insertOralOrderItem(PatOrderItem patOrderItem);
	
}
