package com.esri.arcgis.soe.template.server.internal;

import com.esri.arcgis.server.IServerObject;
import com.esri.arcgis.soe.template.security.SecurityContext;
import com.esri.arcgis.soe.template.server.RestDelegate;
import com.esri.arcgis.soe.template.server.RestRequest;
import com.esri.arcgis.soe.template.server.ServerObjectExtensionContext;
import com.esri.arcgis.system.IServerEnvironment;
import org.springframework.core.MethodParameter;

import java.security.Principal;
import java.util.Map;

public final class ContextObjectArgumentResolver implements ArgumentResolver {

    public ContextObjectArgumentResolver() {

    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  RestRequest request, RestDelegate handler) throws Exception {
        Class<?> type = parameter.getParameterType();
        if (RestRequest.class.isAssignableFrom(type)) {
            return request;
        } else if (RestDelegate.class.isAssignableFrom(type)) {
            return handler;
        } else if (ServerObjectExtensionContext.class.isAssignableFrom(type)) {
            return request.getServerContext();
        } else if (SecurityContext.class.isAssignableFrom(type)) {
            return request.getSecurityContext();
        } else if (Principal.class.isAssignableFrom(type)) {
            return request.getSecurityContext().getUserPrincipal();
        } else if (IServerObject.class.isAssignableFrom(type)) {
            return request.getServerContext().getServerObject();
        } else if (IServerEnvironment.class.isAssignableFrom(type)) {
            return request.getServerContext().getServerEnvironment();
        } else if (Map.class.isAssignableFrom(type)) {
            return request.getAttributes();
        }
        return null;
    }

    @Override
    public boolean resolves(MethodParameter parameter) {
        Class<?> type = parameter.getParameterType();
        return RestRequest.class.isAssignableFrom(type)
                || RestDelegate.class.isAssignableFrom(type)
                || ServerObjectExtensionContext.class.isAssignableFrom(type)
                || SecurityContext.class.isAssignableFrom(type)
                || Principal.class.isAssignableFrom(type)
                || IServerObject.class.isAssignableFrom(type)
                || IServerEnvironment.class.isAssignableFrom(type)
                || Map.class.isAssignableFrom(type);

    }
}
