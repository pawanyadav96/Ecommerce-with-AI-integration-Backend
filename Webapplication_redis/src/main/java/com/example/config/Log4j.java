package com.example.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {
	public static final Logger logger = LogManager.getLogger(Log4j.class);

	
	private static void main(String[]args) {
		process();

	}
	public static void process() {
		logger.trace("From the trace method");
		logger.debug("From the debug method");
		logger.info("From the info method");
		logger.warn("From the warn method");
		logger.error("From the error method");
		logger.fatal("From the fatal method");

	}
}
