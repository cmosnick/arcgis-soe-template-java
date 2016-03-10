package com.esri.arcgis.soe.template.util;

import com.esri.arcgis.system.IClone;

import java.io.IOException;

public class CloneEquals {

    public CloneEquals() {
    }

    public boolean equals(IClone o1, IClone o2) {
        if (o1 == null && o2 == null)
            return true;
        if (o1 == null || o2 == null)
            return false;
        if (o1 == o2)
            return true;
        try {
            return o1.isEqual(o2);
        } catch (IOException e) {
            throw new ArcObjectsInteropException(
                    "Exception when comparing IClone objects", e);
        }
    }

}
