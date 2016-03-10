package com.esri.arcgis.soe.template.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;

import java.io.IOException;

public final class ResourceReader {

    private final Resource resource;

    public ResourceReader(Resource resouce) {
        if (resouce == null) {
            throw new NullPointerException(
                    "Argument 'resource' must not be null.");
        }
        this.resource = resouce;
    }

    public byte[] getData() {
        try {
            return IOUtils.toByteArray(resource.getInputStream());
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    public String getText() {
        try {
            return IOUtils.toString(resource.getInputStream());
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
