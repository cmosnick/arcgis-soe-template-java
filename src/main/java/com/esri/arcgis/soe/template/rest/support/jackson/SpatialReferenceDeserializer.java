package com.esri.arcgis.soe.template.rest.support.jackson;

import com.esri.arcgis.geometry.ISpatialReference;
import com.esri.arcgis.soe.template.rest.json.JSONGeometryMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@SuppressWarnings("serial")
public class SpatialReferenceDeserializer extends
        AbstractDeserializer<ISpatialReference> {

    private JSONGeometryMapper geometryMapper = new JSONGeometryMapper();

    protected SpatialReferenceDeserializer(ObjectMapper objectMapper) {
        super(ISpatialReference.class, objectMapper);
    }

    @Override
    protected ISpatialReference deserialize(String json) throws IOException,
            JsonProcessingException {
        ISpatialReference spatialReference = this.geometryMapper
                .readSpatialReference(json);
        return spatialReference;
    }

}
