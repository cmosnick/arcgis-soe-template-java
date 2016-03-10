package com.esri.arcgis.soe.template.util;

import com.esri.arcgis.system.ServerUtilities;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LogAdaptorFactory implements ILoggerFactory {

    private final ConcurrentMap<String, Logger> loggerMap;
    private boolean showShortLogName;

    public LogAdaptorFactory() {
        loggerMap = new ConcurrentHashMap<String, Logger>();
    }

    public void setShowShortLogName(boolean showShortLogName) {
        this.showShortLogName = showShortLogName;
    }

    public boolean isShowShortLogName() {
        return showShortLogName;
    }

    /**
     * Return an appropriate {@link LogAdaptor} instance by name.
     */
    public Logger getLogger(String name) {
        if (name == null) {
            throw new NullPointerException("Argument 'name' is required.");
        }
        Logger logger = loggerMap.get(name);
        if (logger != null) {
            return logger;
        } else {
            Logger newInstance = new LogAdaptor(
                    ServerUtilities.getServerLogger(), name, showShortLogName);
            Logger oldInstance = loggerMap.putIfAbsent(name, newInstance);
            return oldInstance == null ? newInstance : oldInstance;
        }
    }
}
