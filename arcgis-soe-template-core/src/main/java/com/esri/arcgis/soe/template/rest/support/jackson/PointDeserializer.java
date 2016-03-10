package com.esri.arcgis.soe.template.rest.support.jackson;

import com.esri.arcgis.geometry.IPoint;
import com.esri.arcgis.soe.template.rest.json.JSONGeometryMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@SuppressWarnings("serial")
public class PointDeserializer extends AbstractDeserializer<IPoint> {

    private JSONGeometryMapper geometryMapper = new JSONGeometryMapper();

    protected PointDeserializer(ObjectMapper objectMapper) {
        super(IPoint.class, objectMapper);
    }

    @Override
    protected IPoint deserialize(String json) throws IOException,
            JsonProcessingException {
        return this.geometryMapper.readPoint(json);
    }

}
