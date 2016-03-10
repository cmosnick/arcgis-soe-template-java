package com.esri.arcgis.soe.template.rest.api;

import org.apache.commons.lang.StringUtils;

public class ArcGISServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String causeMessage;
    private final Integer code;
    private final String[] details;

    public ArcGISServiceException(Integer code, String causeMessage,
                                  String[] details) {
        super(String.format("%1$d: %2$s [%3$s]", code, causeMessage,
                details != null ? StringUtils.join(details, ",") : ""));
        if (code == null) {
            throw new NullPointerException("Argument 'code' is required.");
        }
        if (causeMessage == null) {
            throw new NullPointerException(
                    "Argument 'causeMessage' is required.");
        }
        this.causeMessage = causeMessage;
        this.code = code;
        this.details = details;
    }

    public Integer getCode() {
        return code;
    }

    public String getCauseMessage() {
        return causeMessage;
    }

    public String[] getDetails() {
        return details;
    }
}
