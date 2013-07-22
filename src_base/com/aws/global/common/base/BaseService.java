package com.aws.global.common.base;

import org.apache.log4j.Logger;

/**
 * Base class for service layer implementation classes.
 * @author bryan.wong
 */
public class BaseService {

	/** Log4j Instance. */
	private static Logger logger = Logger.getLogger(BaseService.class);

	/**
	 * Logs DEBUG to Log4j instance.
	 * @param className currently invoked class
	 * @param functionName currently invoked method
	 * @param message message to write
	 */
	public void log(String className, String functionName, String message) {
		logger.info("[" + className + "] [" + functionName + "] " + message);
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
	 * @param throwable instance
	 */
	public void logErr(String className, String functionName, String message, Throwable t) {
		logger.error("[" + className + "] [" + functionName + "] " + message, t);
	}
}
