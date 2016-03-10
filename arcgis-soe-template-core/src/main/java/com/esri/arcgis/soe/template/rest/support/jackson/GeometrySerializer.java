package com.esri.arcgis.soe.template.rest.support.jackson;

import com.esri.arcgis.geometry.IGeometry;
import com.esri.arcgis.soe.template.rest.json.JSONGeometryMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@SuppressWarnings("serial")
public class GeometrySerializer extends AbstractSerializer<IGeometry> {

    private JSONGeometryMapper geometryMapper = new JSONGeometryMapper();

    protected GeometrySerializer(ObjectMapper objectMapper) {
        super(objectMapper, IGeometry.class);
    }

    @Override
    protected String serialize(IGeometry value) throws IOException,
            JsonGenerationException {
        return this.geometryMapper.writeGeometry(value, false);
    }

}
