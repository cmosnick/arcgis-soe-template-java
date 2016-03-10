package com.esri.arcgis.soe.template.util;

import java.io.IOException;

public class ArcObjectsInteropException extends RuntimeException {

    private static final long serialVersionUID = -8856518229037015245L;

    public ArcObjectsInteropException() {
    }

    public ArcObjectsInteropException(String message) {
        super(message);
    }

    public ArcObjectsInteropException(IOException cause) {
        super(cause);
    }

    public ArcObjectsInteropException(String message, IOException cause) {
        super(message, cause);
    }

    public ArcObjectsInteropException(String message, IOException cause,
                                      boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
