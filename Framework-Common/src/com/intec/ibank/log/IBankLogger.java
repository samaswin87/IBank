package com.intec.ibank.log;


import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

import com.intec.ibank.utils.Utilities;

/**
 * The Class ContractIQLogger.
 */
public class IBankLogger {

    /** The root category logger. */
    protected org.apache.log4j.Logger rootCategoryLogger = null;
    
    /** The logger. */
    private static IBankLogger logger = null;

    /**
     * Instantiates a new contract iq logger.
     */
    private IBankLogger() {
        rootCategoryLogger = org.apache.log4j.Logger.getLogger(getClass().getName());
        String logPropertyFileName = Utilities.getRealFileName("log4j.properties");
        PropertyConfigurator.configure(logPropertyFileName);
    }

    /**
     * Instantiates a new contract iq logger.
     *
     * @param fPath the f path
     */
    protected IBankLogger(String fPath) {
        rootCategoryLogger = org.apache.log4j.Logger.getLogger("FILE_LOGGER");
        FileAppender fileAppender = null;
        try {
            fileAppender = new FileAppender(new SimpleLayout(), fPath, true);
            rootCategoryLogger.addAppender(fileAppender);
            rootCategoryLogger.setLevel(Level.INFO);
        } catch (Exception e) {
            e.printStackTrace();
        //TODO --> Throwing of  IllegalArugumentException();
        }
    }

    /**
     * Instantiates a new contract iq logger.
     *
     * @param fPath the f path
     * @param category the category
     */
    protected IBankLogger(String fPath, String category) {
        rootCategoryLogger = org.apache.log4j.Logger.getLogger(category);
        FileAppender fileAppender = null;
        try {
            fileAppender = new FileAppender(new SimpleLayout(), fPath, true);
            rootCategoryLogger.addAppender(fileAppender);
            rootCategoryLogger.setLevel(Level.INFO);
        } catch (Exception e) {
            e.printStackTrace();
        //TODO --> Throwing of  IllegalArugumentException();
        }
    }

    /**
     * Sets the file appender.
     *
     * @param fPath the new file appender
     */
    public void setFileAppender(String fPath) {
        try {
            rootCategoryLogger.removeAllAppenders();
            FileAppender fileAppender = new FileAppender(new SimpleLayout(), fPath, true);
            rootCategoryLogger.addAppender(fileAppender);
        } catch (Exception e) {
            e.printStackTrace();
        //TODO --> Throwing of  IllegalArugumentException();
        }
    }

    /**
     * Gets the logger instance.
     *
     * @return the logger instance
     */
    private static IBankLogger getLoggerInstance() {
    	if (logger == null) {
        	newInstance();
        }
        return logger;
    }
    
    /**
     * New instance.
     */
    private synchronized static void newInstance() {
        if (logger == null) {
            logger = new IBankLogger();
        }
    }

    /**
     * Log.
     *
     * @param rc the rc
     * @param level the level
     * @param message the message
     */
    public static void log(int rc, int level, String message) {
        getLoggerInstance().writeLog(message, rc, level);
    }
    
    /**
     * Log.
     *
     * @param rc the rc
     * @param message the message
     */
    public static void log(int rc, String message) {
        getLoggerInstance().writeLog(message, rc, Level.INFO_INT);
    }
    
    /**
     * Log.
     *
     * @param x the x
     */
    public static void log(String x) {    	
    	System.out.println(x);
        getLoggerInstance().writeLog(x, 0, Level.INFO_INT);
    }
    
    /**
     * Log.
     *
     * @param rc the rc
     * @param x the x
     */
    public static void log(int rc, Throwable x) {
    	x.printStackTrace();
        getLoggerInstance().writeLog(x, rc, Level.ERROR_INT);
    }
    
    /**
     * Log.
     *
     * @param x the x
     */
    public static void log(Throwable x) {
    	x.printStackTrace();
        getLoggerInstance().writeLog(x, 0, Level.ERROR_INT);
    }

    /**
     * Log.
     *
     * @param msg the msg
     * @param x the x
     */
    public static void log(String msg, Throwable x) {
    	x.printStackTrace();
        getLoggerInstance().writeLog(msg, x, 0, Level.ERROR_INT);
    }
    
    /**
     * Write log.
     *
     * @param message the message
     * @param rc the rc
     * @param level the level
     */
    private void writeLog(String message, int rc, int level) {
        message = "[System] " + message;
    	System.out.println(message);
        rootCategoryLogger.log(Level.toLevel(level), message);
    }
    
    /**
     * Write log.
     *
     * @param ex the ex
     * @param rc the rc
     * @param level the level
     */
    private void writeLog(Throwable ex, int rc, int level) {
         String error = "[Exception] " +ex;
         rootCategoryLogger.error( error, ex);
    }
    
    /**
     * Write log.
     *
     * @param msg the msg
     * @param ex the ex
     * @param rc the rc
     * @param level the level
     */
    private void writeLog(String msg, Throwable ex, int rc, int level) {
        String error = "[Exception] " + ex + " [Message] " + msg;
        rootCategoryLogger.error( error, ex);
   }
}
