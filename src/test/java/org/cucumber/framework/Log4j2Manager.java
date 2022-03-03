package org.cucumber.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Manager {

    private static Logger logger = LogManager.getLogger();

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message,Throwable t) {
        logger.error(message, t);
    }

}
