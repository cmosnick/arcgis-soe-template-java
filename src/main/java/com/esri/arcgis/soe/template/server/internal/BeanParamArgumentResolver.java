package com.esri.arcgis.soe.template.server.internal;

import com.esri.arcgis.soe.template.server.RestDelegate;
import com.esri.arcgis.soe.template.server.RestRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;

import javax.ws.rs.BeanParam;

public final class BeanParamArgumentResolver implements ArgumentResolver {

    private final ObjectMapper objectMapper;

    public BeanParamArgumentResolver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  RestRequest request, RestDelegate handler) throws Exception {
        Class<?> type = parameter.getParameterType();
        BeanParam annotation = parameter
                .getParameterAnnotation(BeanParam.class);
        if (annotation != null) {
            return objectMapper.readValue(request.getOperationInput(), type);
        }
        return null;
    }

    @Override
    public boolean resolves(MethodParameter parameter) {
        return parameter.getParameterAnnotation(BeanParam.class) != null;
    }
}
