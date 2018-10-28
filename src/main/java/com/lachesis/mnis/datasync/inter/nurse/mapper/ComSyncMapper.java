package com.lachesis.mnis.datasync.inter.nurse.mapper;

import java.util.List;

import com.lachesis.mnis.datasync.entity.SysDataSync;
import com.lachesis.mnis.datasync.entity.SysDataSyncLog;
import com.lachesis.mnis.datasync.entity.pub.ComBed;
import com.lachesis.mnis.datasync.entity.pub.ComUser;
import com.lachesis.mnis.datasync.entity.pub.ComWard;
import com.lachesis.mnis.datasync.entity.pub.ComWardUser;

/**
 * 数据同步到mnis
 * @author qingzhi.liu 2015.05.18
 */
public interface ComSyncMapper {
	
	/**
	 * 修改同步更新表数据
	 * @param dataSync 修改数据载体
	 * @return
	 */
	public int upDataSync(SysDataSync dataSync);
	
	/**
	 * 同步更新日志
	 * @param syncLog  日志载体
	 * @return
	 */
	public int insertDataSyncLog(SysDataSyncLog syncLog);
	
	/**
	 * 获取his表更新参数和最后更新时间
	 * @return
	 */
	public SysDataSync getDataSync(String tableName);
	
	/**
	 * 获取全院病区信息（科室表）
	 * @return
	 */
	public List<ComWard> getComWards();
	
	/**
	 * 添加科室信息
	 * @param comWards  更新病区数据集
	 * @return
	 */
	public void insertComWard(ComWard comWard);
	
	/**
	 * 根据科室ID查询科室
	 * @param code
	 * @return
	 */
	public ComWard getComWardById(String code);
	
	/**
	 * 删除所有未在列表中的科室信息
	 * @param comWards  所有科室列表
	 * @return
	 */
	public void removeWardAllNotIn(List<ComWard> comWards);
	
	/**
	 * 修改科室信息
	 */
	public void updateComWard(ComWard comWard);
	
	/**
	 * 插入用户信息
	 * @param comUsers
	 * @return
	 */
	public int insertComUser(ComUser comUsers);
	
	public void insertComUsers(List<ComUser> comUser);
	
	/**
	 * 根据工号查找用户信息
	 * @return
	 */
	public List<ComUser> getComUser(String code);
	
	/**
	 * 修改用户信息 （不能先删除在新增，因为有密码）
	 * @param user
	 * @return
	 */
	public int updateComUser(ComUser user);
	
	/**
	 * 把所有未在列表中的用户禁用
	 */
	public void removeUserAllNotIn(List<ComUser> comUsers);
	
	/**
	 * 删除用户信息
	 * @param code 用户编号
	 * @return
	 */
	public int deleteComUser(String code);
	
	/**
	 * 新增床位信息
	 * @param comBeds   床位数据
	 * @return
	 */
	public int insertComBeds(List<ComBed> comBeds);
	
	/**
	 * 删除病床信息
	 * @param code  床号编码
	 * @return
	 */
	public int deleteComBed(String code);
	
	/**
	 * 同步用户病区设置
	 * @param comWardUsers
	 * @return
	 */
	public int insertComWardUsers(List<ComWardUser> comWardUsers);
	
	/**
	 * 删除用户病区设置
	 * @param comWardUser
	 * @return
	 */
	public int deleteComWardUser(ComWardUser comWardUser);

	/**
	 * 添加用户角色表
	 * @param list
	 */
	public void insertComUserRole(List<ComUser> list);

	public void insertComWardUser(ComUser comUser);

}
