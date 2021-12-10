package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class Log {

    private  static Logger logger = LogManager.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName) {
        logger.info(String.format("\n" + "Executing Test: %s \n", sTestCaseName));
    }

    public static void info(String message) {
        logger.info(message);
        Reporter.log(message);
    }

    public static void testClassName(Class<?> testClass) {
        info(String.format("\n Test class name: %s \n", testClass.getSimpleName()));
    }

    @BeforeMethod(alwaysRun = true)
    public void logTestName(Method method) {
        String msg = method.getName().replaceAll("/([A-Z])/g", " $1").trim();
        msg = msg.substring(0, 1).toUpperCase() + msg.substring(1);
        Log.startTestCase(msg);
    }

}
