package com.lachesis.mnis.datasync.inter.his.mapper;

import java.util.Date;
import java.util.List;

import com.lachesis.mnis.datasync.entity.order.PatOrderGroup;

/**
 * 获取医嘱信息
 * @author qingzhi.liu 2015.06.03
 *
 */
public interface HisOrdersDataMapper {
	
	/**
	 * 获取临时医嘱 根据录入时间段查询新增医嘱信息
	 * @param map
	 * @return
	 */
	public List<PatOrderGroup> getPatInsulinOrderGroups(String deptId,Date planTime);

	public List<PatOrderGroup> getPatOralOrderGroups(String deptId, Date upTime);
	
}
