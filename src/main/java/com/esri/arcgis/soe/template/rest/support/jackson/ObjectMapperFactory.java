package com.esri.arcgis.soe.template.rest.support.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

public class ObjectMapperFactory {

    public ObjectMapperFactory() {
    }

    public ObjectMapper create() {
        ObjectMapper objectMapper = new ObjectMapper();

        ArcGISTypesModule aoModule = new ArcGISTypesModule();
        objectMapper.registerModule(aoModule);

        JaxbAnnotationModule jaxbModule = new JaxbAnnotationModule();
        objectMapper.registerModule(jaxbModule);

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper;
    }

}
