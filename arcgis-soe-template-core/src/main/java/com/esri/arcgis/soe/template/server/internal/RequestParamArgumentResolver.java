package com.esri.arcgis.soe.template.server.internal;

import com.esri.arcgis.server.json.JSONObject;
import com.esri.arcgis.soe.template.server.RestDelegate;
import com.esri.arcgis.soe.template.server.RestRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestParam;

public final class RequestParamArgumentResolver implements ArgumentResolver {

    private final ObjectMapper objectMapper;

    public RequestParamArgumentResolver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  RestRequest request, RestDelegate handler) throws Exception {
        Class<?> type = parameter.getParameterType();
        RequestParam annotation = parameter
                .getParameterAnnotation(RequestParam.class);
        String value = annotation.value();

        JSONObject operationInput = new JSONObject(request.getOperationInput());
        Object param = operationInput.opt(value);
        return objectMapper.readValue(param != null ? param.toString() : null,
                type);
    }

    @Override
    public boolean resolves(MethodParameter parameter) {
        return parameter.getParameterAnnotation(RequestParam.class) != null;
    }
}
