package com.esri.arcgis.soe.template.server.internal;

import com.esri.arcgis.soe.template.server.RestDelegate;
import com.esri.arcgis.soe.template.server.RestRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;

import javax.xml.bind.annotation.XmlRootElement;

public final class RequestBodyArgumentResolver implements ArgumentResolver {

    private final ObjectMapper objectMapper;

    public RequestBodyArgumentResolver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  RestRequest request, RestDelegate handler) throws Exception {
        Class<?> type = parameter.getParameterType();
        return objectMapper.readValue(request.getOperationInput(), type);
    }

    @Override
    public boolean resolves(MethodParameter parameter) {
        Class<?> type = parameter.getParameterType();
        return type.getAnnotation(XmlRootElement.class) != null;
    }
}
