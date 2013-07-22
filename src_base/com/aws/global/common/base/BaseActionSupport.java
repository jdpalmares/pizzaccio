package com.aws.global.common.base;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.aws.global.common.constants.GlobalConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Custom Base ActionSupport class.
 * @author bryan.wong
 */
@SuppressWarnings("serial")
@ParentPackage("awsExample")
@Results({
  @Result(name=GlobalConstants.RESULT_INDEX, location=GlobalConstants.RESULT_INDEX_PAGE),
  @Result(name=GlobalConstants.RESULT_NOT_LOGGED_IN, location=GlobalConstants.RESULT_LOGIN_PAGE),
  @Result(name=GlobalConstants.RESULT_NOT_AUTHORIZE, location=GlobalConstants.RESULT_NO_ACCESS)
})
public class BaseActionSupport extends ActionSupport {

	/** Log4j Instance. */
	private static Logger logger = Logger.getLogger(BaseActionSupport.class);

	/**
	 * Logs DEBUG to Log4j instance.
	 * @param className currently invoked class
	 * @param functionName currently invoked method
	 * @param message message to write
	 */
	public void log(String className, String functionName, String message) {
		logger.debug("[" + className + "] [" + functionName + "] " + message);
	}

	/**
	 * Logs ERROR to Log4j instance.
	 * @param className currently invoked class
	 * @param functionName currently invoked method
	 * @param message message to write
	 */
	public void logErr(String className, String functionName, String message) {
		logger.error("[" + className + "] [" + functionName + "] " + message);
	}

	/**
	 * Logs ERROR to Log4j instance.
	 * @param className currently invoked class
	 * @param functionName currently invoked method
	 * @param message message to write
	 * @param t throwable instance
	 */
	public void logErr(String className, String functionName, String message, Throwable t) {
		logger.error("[" + className + "] [" + functionName + "] " + message, t);
	}
}
