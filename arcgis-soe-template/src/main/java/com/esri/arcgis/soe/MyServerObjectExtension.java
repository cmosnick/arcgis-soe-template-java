package com.esri.arcgis.soe;

import com.esri.arcgis.interop.AutomationException;
import com.esri.arcgis.interop.extn.ArcGISExtension;
import com.esri.arcgis.interop.extn.ServerObjectExtProperties;
import com.esri.arcgis.server.json.JSONArray;
import com.esri.arcgis.server.json.JSONException;
import com.esri.arcgis.server.json.JSONObject;
import com.esri.arcgis.soe.template.server.AbstractRestServerObjectExtension;
import com.esri.arcgis.system.ServerUtilities;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@ArcGISExtension
@ServerObjectExtProperties(displayName = "My SOE",
        description = "A simple template server object extension",
        interceptor = false,
        servicetype = "MapService")
public class MyServerObjectExtension extends AbstractRestServerObjectExtension {

    @Override
    protected void doConfigure(
            AnnotationConfigApplicationContext applicationContext) {
        super.doConfigure(applicationContext);

        applicationContext.register(MyServerObjectExtensionConfig.class);
    }

    @Override
    protected void doShutdown() {
        super.doShutdown();
    }

    @Override
    public String getSchema() throws IOException, AutomationException {
        try {
            JSONObject mySOE = ServerUtilities.createResource(
                    "My SOE", "A simple template server object extension", false, false);
            JSONArray subResourcesArray = new JSONArray();
            subResourcesArray.put(ServerUtilities.createResource("hello",
                    "Hello resource", false, false));
            mySOE.put("resources", subResourcesArray);
            return mySOE.toString();
        } catch (JSONException e) {
            getLogger().debug(e.getMessage());
            return ServerUtilities.sendError(500,
                    "Exception occurred: " + e.getMessage(), null);
        }
    }
}
