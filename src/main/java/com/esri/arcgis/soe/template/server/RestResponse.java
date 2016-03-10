package com.esri.arcgis.soe.template.server;

import com.esri.arcgis.soe.template.rest.json.JSONConverter;

import java.util.Arrays;

public final class RestResponse {

    private final String responseProperties;
    private final byte[] responseBody;

    public RestResponse(String responseProperties, byte[] responseBody) {
        this.responseProperties = responseProperties;
        this.responseBody = responseBody;
    }

    public byte[] getResponseBody() {
        return responseBody != null ? Arrays.copyOf(responseBody,
                responseBody.length) : null;
    }

    public String getResponseProperties() {
        return responseProperties;
    }

    @Override
    public String toString() {
        return "RestResponse [responseProperties=" + responseProperties
                + ", responseBody=" + JSONConverter.toString(responseBody)
                + "]";
    }
}
