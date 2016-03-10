package com.esri.arcgis.soi.attributesecurityfilter;

import com.esri.arcgis.datasourcesGDB.SqlWorkspace;
import com.esri.arcgis.geodatabase.ISqlWorkspace;
import com.esri.arcgis.geodatabase.IWorkspace;
import com.esri.arcgis.geodatabase.esriDatasetType;
import com.esri.arcgis.interop.extn.ArcGISExtension;
import com.esri.arcgis.interop.extn.ServerObjectExtProperties;
import com.esri.arcgis.soe.template.server.AbstractRestServerObjectInterceptor;
import com.esri.arcgis.soe.template.server.MapServerUtilities;
import com.esri.arcgis.soe.template.server.ServerObjectExtensionException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@ArcGISExtension
@ServerObjectExtProperties(displayName = "Attribute Security Filter",
        description = "Enables basic feature-level security for query operation using an attribute filter",
        interceptor = true,
        servicetype = "MapService")
public class AttributeSecurityFilter extends AbstractRestServerObjectInterceptor {

    @Override
    protected void doConfigure(
            AnnotationConfigApplicationContext applicationContext) {
        super.doConfigure(applicationContext);

        applicationContext.register(AttributeSecurityFilterConfig.class);

        IWorkspace workspace = MapServerUtilities
                .findFirstWorkspaceContainingDataset(getServerContext(), esriDatasetType.esriDTTable, "Filter_Group_Agency");
        if (workspace == null) {
            throw new ServerObjectExtensionException(
                    "The map for this map service must contain at "
                            + "least one workspace that contains the filter schema.");
        }
        ISqlWorkspace sqlWorkspace = null;
        try {
            sqlWorkspace = new SqlWorkspace(workspace);
        } catch (IOException e) {
            throw new ServerObjectExtensionException(
                    "The workspace containing the filter schema must an SQL workspace (e.g. from a query layer).");
        }
        ConfigurableListableBeanFactory beanFactory = applicationContext
                .getBeanFactory();
        beanFactory.registerSingleton("sqlWorkspace", sqlWorkspace);
    }

    @Override
    protected void doShutdown() {
        super.doShutdown();
    }
}
