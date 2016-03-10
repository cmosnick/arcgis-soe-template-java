package com.esri.arcgis.soe.template.util;

import com.esri.arcgis.interop.AutomationException;
import com.esri.arcgis.system.AoInitialize;
import com.esri.arcgis.system.EngineInitializer;
import com.esri.arcgis.system.esriLicenseProductCode;
import com.esri.arcgis.system.esriLicenseStatus;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * This class is intended for use in integration tests that rely on the ArcObjects runtime.
 */
public class ArcObjectsInitializer {

    private static ArcObjectsInitializer instance = new ArcObjectsInitializer();

    private AoInitialize aoInit;

    private ArcObjectsInitializer() {
    }

    public static ArcObjectsInitializer getInstance() {
        return instance;
    }

    public void init() throws UnknownHostException, IOException {
        EngineInitializer.initializeEngine();
        this.aoInit = new AoInitialize();

        if (aoInit
                .isProductCodeAvailable(esriLicenseProductCode.esriLicenseProductCodeArcServer) == esriLicenseStatus.esriLicenseAvailable) {
            aoInit.initialize(esriLicenseProductCode.esriLicenseProductCodeArcServer);
        } else if (aoInit
                .isProductCodeAvailable(esriLicenseProductCode.esriLicenseProductCodeAdvanced) == esriLicenseStatus.esriLicenseAvailable) {
            aoInit.initialize(esriLicenseProductCode.esriLicenseProductCodeAdvanced);
        } else if (aoInit
                .isProductCodeAvailable(esriLicenseProductCode.esriLicenseProductCodeStandard) == esriLicenseStatus.esriLicenseAvailable) {
            aoInit.initialize(esriLicenseProductCode.esriLicenseProductCodeStandard);
        } else if (aoInit
                .isProductCodeAvailable(esriLicenseProductCode.esriLicenseProductCodeBasic) == esriLicenseStatus.esriLicenseAvailable) {
            aoInit.initialize(esriLicenseProductCode.esriLicenseProductCodeBasic);
        } else if (aoInit
                .isProductCodeAvailable(esriLicenseProductCode.esriLicenseProductCodeEngineGeoDB) == esriLicenseStatus.esriLicenseAvailable) {
            aoInit.initialize(esriLicenseProductCode.esriLicenseProductCodeEngineGeoDB);
        } else {
            throw new IllegalStateException(
                    "The ArcGIS product license is insufficient to initialize product.");
        }
    }

    public void shutdown() throws AutomationException, IOException {
        if (this.aoInit != null) {
            this.aoInit.shutdown();
        }
    }
}
