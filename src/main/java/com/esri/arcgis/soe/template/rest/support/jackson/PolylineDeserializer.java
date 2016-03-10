package com.esri.arcgis.soe.template.rest.support.jackson;

import com.esri.arcgis.geometry.IPolyline;
import com.esri.arcgis.soe.template.rest.json.JSONGeometryMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@SuppressWarnings("serial")
public class PolylineDeserializer extends AbstractDeserializer<IPolyline> {

    private JSONGeometryMapper geometryMapper = new JSONGeometryMapper();

    protected PolylineDeserializer(ObjectMapper objectMapper) {
        super(IPolyline.class, objectMapper);
    }

    @Override
    protected IPolyline deserialize(String json) throws IOException,
            JsonProcessingException {
        return this.geometryMapper.readPolyline(json);
    }

}
