package com.esri.arcgis.soe.template.server;

import org.springframework.web.util.UriTemplate;

import java.util.List;

public interface RestDelegateMappings {

    void registerDelegate(String path, RestDelegate delegate);

    void registerDelegate(String path, RestDelegate delegate,
                          int priority);

    void registerDelegate(UriTemplate path, RestDelegate delegate);

    void registerDelegate(UriTemplate path, RestDelegate delegate,
                          int priority);

    RestDelegate getMatchingDelegate(String path);
}
