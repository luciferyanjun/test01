package com.lachesis.mnis.datasync.inter.lis.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lachesis.mnis.datasync.entity.lis.PatLabTestDetail;
import com.lachesis.mnis.datasync.entity.lis.PatLabTestMas;

/**
 * 同步his病人信息接口
 * 
 * @author qingzhi.liu 2015.05.14
 *
 */
public interface ISyncLisService {

	public List<PatLabTestMas> getLabTestMas(Date startTime);

	public Date getDatabaseServerTime();

}
