package com.esri.arcgis.soe;

import com.esri.arcgis.soe.template.server.RestDelegate;
import com.esri.arcgis.soe.template.server.RestRequest;
import com.esri.arcgis.soe.template.server.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Component
public class PassThroughDelegate {

    protected final Logger logger = LoggerFactory.getLogger(PassThroughDelegate.class);

    @RequestMapping(value = {"*"})
    public RestResponse query(
            RestRequest request,
            RestDelegate handler) throws IOException {
        logger.debug("Passing through request ...");

        return handler.process(request, null);
    }
}
