package com.esri.arcgis.soe.template.server;

public interface RestDelegate {

    RestResponse process(RestRequest request, RestDelegate handler);
}
