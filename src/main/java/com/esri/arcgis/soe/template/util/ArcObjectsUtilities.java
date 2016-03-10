package com.esri.arcgis.soe.template.util;

import com.esri.arcgis.geometry.ISpatialReference;
import com.esri.arcgis.geometry.SpatialReferenceEnvironment;
import com.esri.arcgis.system.Cleaner;
import com.esri.arcgis.system.IPropertySet;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public final class ArcObjectsUtilities {

    private ArcObjectsUtilities() {
    }

    public static Object getProperty(IPropertySet properties, Object name) {
        try {
            Object[] namesHolder = new Object[1];
            Object[] valuesHolder = new Object[1];
            properties.getAllProperties(namesHolder, valuesHolder);
            String[] names = (String[]) namesHolder[0];
            Object[] values = (Object[]) valuesHolder[0];
            Object value = null;
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(name)) {
                    value = values[i];
                }
            }
            return value;
        } catch (IOException ex) {
            throw new ArcObjectsInteropException(String.format(
                    "Failed to read property '%1$s'.", name), ex);
        }
    }

    public static Map<String, Object> toMap(IPropertySet properties) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Object[] namesHolder = new Object[1];
            Object[] valuesHolder = new Object[1];
            properties.getAllProperties(namesHolder, valuesHolder);
            String[] names = (String[]) namesHolder[0];
            Object[] values = (Object[]) valuesHolder[0];
            for (int i = 0; i < names.length; i++) {
                map.put(names[i], values[i]);
            }
            return map;
        } catch (IOException ex) {
            throw new ArcObjectsInteropException("Failed to read properties.",
                    ex);
        }
    }

    public static ISpatialReference createSpatialReference(int factoryCode)
            throws UnknownHostException, IOException {
        SpatialReferenceEnvironment spatialReferenceEnvironment = new SpatialReferenceEnvironment();
        ISpatialReference spatialReference = spatialReferenceEnvironment
                .createSpatialReference(factoryCode);
        // SpatialReferenceEnvironment is a singleton.
        // It is a good practice to release the singletons
        // using com.esri.system.Cleaner.release()
        Cleaner.release(spatialReferenceEnvironment);
        return spatialReference;
    }

}
