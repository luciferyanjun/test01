package com.lachesis.mnis.datasync.inter.nurse.mapper;

import java.util.List;

import com.lachesis.mnis.datasync.entity.lis.PatLabTestDetail;
import com.lachesis.mnis.datasync.entity.lis.PatLabTestMas;

/**
 * 同步检验数据
 * 
 * @author qingzhi.liu 2015.05.31
 *
 */
public interface LabTestSyncMapper {

	public void insertPatLabTestMas(PatLabTestMas queryBean);

	public PatLabTestMas findLabTestByNo(PatLabTestMas labTestMas);

	public void insetLabTestDetail(List<PatLabTestDetail> item);

}
