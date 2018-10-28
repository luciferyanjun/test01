package com.lachesis.mnis.datasync.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateToStringHandler implements TypeHandler<String> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateToStringHandler.class);
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
	public String getResult(ResultSet rs, String fld) throws SQLException {
		Date myDate = rs.getTimestamp(fld);
		return formatDate(myDate, DATE_FORMAT);
	}

	public String getResult(ResultSet rs, int fldIdx) throws SQLException {
		Date myDate = rs.getTimestamp(fldIdx);
		return formatDate(myDate, DATE_FORMAT);
	}

	public String getResult(CallableStatement callable, int fldIdx)
			throws SQLException {
		Date myDate = callable.getTimestamp(fldIdx);
		return formatDate(myDate, DATE_FORMAT);
	}

	public void setParameter(PreparedStatement pstat, int fldIdx, String value,
			JdbcType arg3) throws SQLException {
		 Timestamp sqlDate = null;
		if (value != null && !"".equals(value)) {
			try {
				java.util.Date dateVal = formatToDate(value, DATE_FORMAT);
				sqlDate = new Timestamp(dateVal.getTime());
			} catch (ParseException e) {
				LOGGER.error("", e);
			}
			pstat.setTimestamp(fldIdx, sqlDate);
		}
	}

	private static String formatDate(java.util.Date date,String formatStr) {
		
		String result = null;
		SimpleDateFormat time=new SimpleDateFormat(formatStr); 
		if (date != null) {
			result = time.format(date);
			if( result.equals("1900-01-01 00:00") ) {
				result = null;
			}
		}
		return result;
	}
	
	public static java.util.Date formatToDate(String dateStr,String strFormat) throws ParseException {
	
		Date date=null;
		DateFormat sdf = new SimpleDateFormat(strFormat);
		date = sdf.parse(dateStr);
		return date;
	}
}
