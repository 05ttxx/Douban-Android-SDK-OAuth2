package com.bluesunshine.douban4droid.model.app;

/**
 * 
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanException extends Exception {

	private int errorCode;
	private String errorMsg;

	public DoubanException(int code, String msg) {
		super(msg);
		this.errorCode = code;
		this.errorMsg = msg;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg
	 *            the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
