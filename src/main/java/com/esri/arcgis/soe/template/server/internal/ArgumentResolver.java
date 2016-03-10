package com.esri.arcgis.soe.template.server.internal;

import com.esri.arcgis.soe.template.server.RestDelegate;
import com.esri.arcgis.soe.template.server.RestRequest;
import org.springframework.core.MethodParameter;

public interface ArgumentResolver {

    public Object resolveArgument(MethodParameter parameter,
                                  RestRequest request, RestDelegate handler) throws Exception;

    public boolean resolves(MethodParameter parameter);
}
