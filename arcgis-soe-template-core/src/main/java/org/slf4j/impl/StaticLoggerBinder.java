package org.slf4j.impl;

import com.esri.arcgis.soe.template.util.LogAdaptorFactory;
import org.slf4j.ILoggerFactory;

public class StaticLoggerBinder {

    public static String REQUESTED_API_VERSION = "1.7.18";

    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    private static final String LOGGER_FACTORY_CLASS_STR = LogAdaptorFactory.class
            .getName();

    private final ILoggerFactory loggerFactory;

    private StaticLoggerBinder() {
        loggerFactory = new LogAdaptorFactory();
    }

    public static final StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    public String getLoggerFactoryClassStr() {
        return LOGGER_FACTORY_CLASS_STR;
    }
}
