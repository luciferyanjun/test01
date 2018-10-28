package com.lachesis.mnis.datasync.Exception;

/**
 * 业务异常捕获类
 * @author qingzhi.liu  2015.05.18
 *
 */
public class BusinessException extends RuntimeException{

	public BusinessException(String message) {
		super(message);
	}

}
