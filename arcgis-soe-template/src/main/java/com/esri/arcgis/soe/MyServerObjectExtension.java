package com.esri.arcgis.soe;

import com.esri.arcgis.interop.extn.ArcGISExtension;
import com.esri.arcgis.interop.extn.ServerObjectExtProperties;
import com.esri.arcgis.soe.template.server.AbstractRestServerObjectInterceptor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@ArcGISExtension
@ServerObjectExtProperties(displayName = "My SOE",
        description = "A simple template server object extension",
        interceptor = false,
        servicetype = "MapService")
public class MyServerObjectExtension extends AbstractRestServerObjectInterceptor {

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
}
