package com.lachesis.mnis.datasync.inter.lis.mapper;

import java.util.Date;
import java.util.List;

import com.lachesis.mnis.datasync.entity.lis.PatLabTestMas;

public interface LISDataMapper {

	public java.util.Date getDatabaseServerTime();

	public List<PatLabTestMas> getLabTestMas(Date startTime);

}
