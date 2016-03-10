package com.esri.arcgis.soe.template.server;

public class ServerObjectExtensionError extends Error {

    private static final long serialVersionUID = -3963123500437489557L;

    public ServerObjectExtensionError() {
    }

    public ServerObjectExtensionError(String message) {
        super(message);
    }

    public ServerObjectExtensionError(Throwable cause) {
        super(cause);
    }

    public ServerObjectExtensionError(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerObjectExtensionError(String message, Throwable cause,
                                      boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
