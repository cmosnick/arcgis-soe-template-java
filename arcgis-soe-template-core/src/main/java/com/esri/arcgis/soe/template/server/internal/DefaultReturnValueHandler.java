package com.esri.arcgis.soe.template.server.internal;

import com.esri.arcgis.geodatabase.IRecordSet;
import com.esri.arcgis.soe.template.rest.json.JSONConverter;
import com.esri.arcgis.soe.template.server.RestRequest;
import com.esri.arcgis.soe.template.server.RestResponse;
import com.esri.arcgis.system.IJSONArray;
import com.esri.arcgis.system.IJSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;

import javax.xml.bind.annotation.XmlRootElement;

public final class DefaultReturnValueHandler implements ReturnValueHandler {

    private final ObjectMapper objectMapper;

    public DefaultReturnValueHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public RestResponse handleReturnValue(Object returnValue,
                                          MethodParameter parameter, RestRequest request) throws Exception {
        Class<?> type = parameter.getParameterType();
        XmlRootElement xmlRootElement = type
                .getAnnotation(XmlRootElement.class);
        if (RestResponse.class.isAssignableFrom(type)) {
            return (RestResponse) returnValue;
        } else if (String.class.isAssignableFrom(type)) {
            return new RestResponse(null,
                    JSONConverter.toByteArray((String) returnValue));
        } else if (xmlRootElement != null) {
            return new RestResponse(null,
                    objectMapper.writeValueAsBytes(returnValue));
        } else if (IRecordSet.class.isAssignableFrom(type)) {
            return new RestResponse(null,
                    objectMapper.writeValueAsBytes(returnValue));
        } else if (IJSONObject.class.isAssignableFrom(type)) {
            return new RestResponse(null,
                    JSONConverter.toByteArray(((IJSONObject) returnValue)
                            .toJSONString(null)));
        } else if (IJSONArray.class.isAssignableFrom(type)) {
            return new RestResponse(null,
                    JSONConverter.toByteArray(((IJSONArray) returnValue)
                            .toJSONString(null)));
        }
        throw new IllegalArgumentException(String.format(
                "Cannot handle return value: %1$s", returnValue));
    }

    @Override
    public boolean handles(MethodParameter parameter) {
        if (parameter.getParameterIndex() != -1) {
            throw new IllegalArgumentException(
                    "Method parameter must be a return value.");
        }
        Class<?> type = parameter.getParameterType();
        return RestResponse.class.isAssignableFrom(type)
                || IRecordSet.class.isAssignableFrom(type)
                || type.getAnnotation(XmlRootElement.class) != null
                || IRecordSet.class.isAssignableFrom(type)
                || IJSONObject.class.isAssignableFrom(type)
                || IJSONArray.class.isAssignableFrom(type);

    }
}
