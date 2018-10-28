package com.lachesis.mnis.datasync.handler;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;

public class StringTypeHandler implements TypeHandler<String> {
	private static Logger logger = org.slf4j.LoggerFactory
			.getLogger(StringTypeHandler.class);

	private static String ISO88591_ENCODE = "ISO8859_1";
	private static String UTF8_ENCODE = "UTF-8";
	private static String GBK_ENCODE = "GBK";

	public String getResult(ResultSet rs, String columnName)
			throws SQLException {
		String gender="gender";
		try {
			if (null != rs.getString(columnName)) {
				String val = null;
				String columnValue = rs.getString(columnName);
				if (ISO88591_ENCODE.equals(getEncode(columnValue))) {
					
					val=new String(rs.getString(columnName).getBytes(
							ISO88591_ENCODE), GBK_ENCODE);
					if(gender.equals(columnName)){
						val = "男".equals(val)?"M":"F";
					}
					return val;
					/*return new String(rs.getString(columnName).getBytes(
							ISO88591_ENCODE), GBK_ENCODE);*/
				}
			}
		} catch (UnsupportedEncodingException e) {
			logger.debug("StringTypeHandler encode Exception");
		}
		return rs.getString(columnName);
	}

	public String getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return cs.getString(columnIndex);
	}

	// 返回编码格式
	private String getEncode(String str) {
		String encode = null;
		if (verifyEncode(str, GBK_ENCODE)) {
			encode = GBK_ENCODE;
		} else if (verifyEncode(str, ISO88591_ENCODE)) {
			encode = ISO88591_ENCODE;
		} else if (verifyEncode(str, UTF8_ENCODE)) {
			encode = UTF8_ENCODE;
		}

		return encode;
	}

	// 判断编码格式是否相符
	private boolean verifyEncode(String str, String encode) {
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				return true;
			}
		} catch (UnsupportedEncodingException e) {
			logger.debug("StringTypeHandler encode UnsupportedEncoding");
		}
		return false;
	}

	public String getResult(ResultSet arg0, int arg1) throws SQLException {
		return arg0.getString(arg1);
	}

	public void setParameter(PreparedStatement arg0, int arg1, String arg2,
			JdbcType arg3) throws SQLException {
		
	}


}
