package com.esri.arcgis.soe.template.server.internal;

import com.esri.arcgis.soe.template.server.RestRequest;
import com.esri.arcgis.soe.template.server.RestResponse;
import org.springframework.core.MethodParameter;

public interface ReturnValueHandler {

    public RestResponse handleReturnValue(Object returnValue,
                                          MethodParameter parameter, RestRequest request) throws Exception;

    public boolean handles(MethodParameter parameter);
}
