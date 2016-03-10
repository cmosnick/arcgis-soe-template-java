package com.esri.arcgis.soe.template.server;

import com.esri.arcgis.soe.template.security.SecurityContext;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class RestRequest {

    private String capabilities;
    private String resourceName;
    private String operationName;
    private String operationInput;
    private String outputFormat;
    private String requestProperties;
    private SecurityContext securityContext;
    private ServerObjectExtensionContext serverContext;
    private Map<String, Object> attributes = new LinkedHashMap<String, Object>();

    RestRequest(String capabilities, String resourceName, String operationName,
                String operationInput, String outputFormat,
                String requestProperties,
                ServerObjectExtensionContext serverContext,
                SecurityContext securityContext) {
        this.capabilities = capabilities;
        this.resourceName = resourceName;
        this.operationName = operationName;
        this.operationInput = operationInput;
        this.outputFormat = outputFormat;
        this.requestProperties = requestProperties;
        if (serverContext == null) {
            throw new NullPointerException(
                    "Argument 'serverContext' must not be null.");
        }
        this.serverContext = serverContext;
        if (securityContext == null) {
            throw new NullPointerException(
                    "Argument 'securityContext' must not be null.");
        }
        this.securityContext = securityContext;
    }

    public static final RestRequest create(String capabilities,
                                           String resourceName, String operationName, String operationInput,
                                           String outputFormat, String requestProperties, RestRequest context) {
        if (context == null) {
            throw new NullPointerException(
                    "Argument 'context' must not be null.");
        }
        return new RestRequest(capabilities, resourceName, operationName,
                operationInput, outputFormat, requestProperties,
                context.getServerContext(), context.getSecurityContext());
    }

    public String getCapabilities() {
        return capabilities;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getOperationName() {
        return operationName;
    }

    public String getOperationInput() {
        return operationInput;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public String getRequestProperties() {
        return requestProperties;
    }

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public ServerObjectExtensionContext getServerContext() {
        return serverContext;
    }

    public void setAttribute(String name, Object o) {
        attributes.put(name, o);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public boolean removeAttribute(String name) {
        return attributes.remove(name) != null;
    }

    public Iterator<String> getAttributeNames() {
        return Collections.unmodifiableSet(attributes.keySet()).iterator();
    }

    public Map<String, Object> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }

    @Override
    public String toString() {
        return "RestRequest [capabilities=" + capabilities + ", resourceName="
                + resourceName + ", operationName=" + operationName
                + ", operationInput=" + operationInput + ", outputFormat="
                + outputFormat + ", requestProperties=" + requestProperties
                + ", securityContext=" + securityContext + ", serverContext="
                + serverContext + ", attributes=" + attributes + "]";
    }
}