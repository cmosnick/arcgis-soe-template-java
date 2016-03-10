package com.esri.arcgis.soe.template.rest.api;

import javax.xml.bind.annotation.XmlType;

@XmlType
public enum SpatialRelationship {

    esriSpatialRelIntersects, esriSpatialRelContains, esriSpatialRelCrosses, esriSpatialRelEnvelopeIntersects, esriSpatialRelIndexIntersects, esriSpatialRelOverlaps, esriSpatialRelTouches, esriSpatialRelWithin, esriSpatialRelRelation
}
