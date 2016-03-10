package com.esri.arcgis.soe.template.server;

public class ServerObjectExtensionException extends RuntimeException {

    private static final long serialVersionUID = 7329486672922211862L;

    public ServerObjectExtensionException() {
    }

    public ServerObjectExtensionException(String message) {
        super(message);
    }

    public ServerObjectExtensionException(Throwable cause) {
        super(cause);
    }

    public ServerObjectExtensionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerObjectExtensionException(String message, Throwable cause,
                                          boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
