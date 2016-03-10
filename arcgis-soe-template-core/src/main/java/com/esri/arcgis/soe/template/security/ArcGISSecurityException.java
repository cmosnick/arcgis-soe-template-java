package com.esri.arcgis.soe.template.security;

import com.esri.arcgis.soe.template.rest.api.ArcGISServiceException;

public class ArcGISSecurityException extends ArcGISServiceException {

    private static final long serialVersionUID = 1L;

    public ArcGISSecurityException(Integer code, String causeMessage,
                                   String[] details) {
        super(code, causeMessage, details);
    }

}
