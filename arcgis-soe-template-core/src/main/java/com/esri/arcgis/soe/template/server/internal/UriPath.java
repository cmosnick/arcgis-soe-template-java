package com.esri.arcgis.soe.template.server.internal;

import com.esri.arcgis.soe.template.server.RestRequest;
import org.springframework.util.StringUtils;

public class UriPath {

    private final String resource;
    private final String operation;

    public UriPath(String resource, String operation) {
        this.resource = resource;
        this.operation = operation;
    }

    public UriPath(RestRequest request) {
        this(request.getResourceName(), request.getOperationName());
    }

    public String getPath() {
        // build the URI path to the requested resource and operation
        StringBuilder pathBuilder = new StringBuilder("/");
        if (!StringUtils.isEmpty(resource)) {
            pathBuilder.append(resource);
        }
        if (!StringUtils.isEmpty(operation)) {
            if (pathBuilder.length() > 0
                    && pathBuilder.charAt(pathBuilder.length() - 1) != '/') {
                pathBuilder.append('/');
            }
            pathBuilder.append(operation);
        }
        return pathBuilder.toString();
    }
}
