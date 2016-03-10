package com.esri.arcgis.soe.template.rest.support.jackson;

import com.esri.arcgis.geodatabase.IRecordSet;
import com.esri.arcgis.geometry.*;
import com.esri.arcgis.soe.template.rest.api.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@SuppressWarnings("serial")
public class ArcGISTypesModule extends SimpleModule {

    private ObjectMapper objectMapper;

    public ArcGISTypesModule() {
        super("ArcObjectsModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        this.objectMapper = context.getOwner();

        addDeserializer(IGeometry.class, new GeometryDeserializer(
                this.objectMapper));
        addDeserializer(IPoint.class, new PointDeserializer(this.objectMapper));
        addDeserializer(IMultipoint.class, new MultipointDeserializer(
                this.objectMapper));
        addDeserializer(IPolyline.class, new PolylineDeserializer(
                this.objectMapper));
        addDeserializer(IPolygon.class, new PolygonDeserializer(
                this.objectMapper));
        addDeserializer(IEnvelope.class, new EnvelopeDeserializer(
                this.objectMapper));
        addSerializer(IGeometry.class,
                new GeometrySerializer(this.objectMapper));

        addDeserializer(ISpatialReference.class,
                new SpatialReferenceDeserializer(this.objectMapper));
        addSerializer(ISpatialReference.class, new SpatialReferenceSerializer(
                this.objectMapper));

        super.setupModule(context);
    }
}
