package com.esri.arcgis.soe;

import com.esri.arcgis.server.json.JSONObject;
import com.esri.arcgis.soe.template.server.RestRequest;
import com.esri.arcgis.soe.template.server.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Component
public class HelloDelegate {

    protected final Logger logger = LoggerFactory.getLogger(HelloDelegate.class);

    @RequestMapping(value = {"/hello"})
    public RestResponse handleHelloResourceRequest(
            RestRequest request) throws IOException {
        logger.debug("Handling hello resource request ...");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Hello, World!");
        byte[] data = jsonObject.toString().getBytes("utf-8");

        return new RestResponse(null, data);
    }
}
