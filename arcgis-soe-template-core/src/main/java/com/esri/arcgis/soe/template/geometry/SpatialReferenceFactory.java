package com.esri.arcgis.soe.template.geometry;

import java.io.IOException;

import com.esri.arcgis.geometry.ISpatialReference;
import com.esri.arcgis.geometry.ISpatialReferenceResolution;
import com.esri.arcgis.geometry.ISpatialReferenceTolerance;
import com.esri.arcgis.geometry.SpatialReferenceEnvironment;
import com.esri.arcgis.soe.template.util.ArcObjectsInteropException;
import com.esri.arcgis.system.Cleaner;

public class SpatialReferenceFactory {

	public SpatialReferenceFactory() {
	}

	public ISpatialReference create(int factoryCode) {
		try {
			SpatialReferenceEnvironment spatialReferenceEnvironment = new SpatialReferenceEnvironment();
			ISpatialReference sr = spatialReferenceEnvironment
					.createSpatialReference(factoryCode);
			ISpatialReferenceResolution resolution = (ISpatialReferenceResolution)sr;
			resolution.constructFromHorizon();
			ISpatialReferenceTolerance tolerance = (ISpatialReferenceTolerance)sr;
			tolerance.setDefaultXYTolerance();
			// SpatialReferenceEnvironment is a singleton.
			// It is a good practice to release the singletons
			// using com.esri.system.Cleaner.release()
			Cleaner.release(spatialReferenceEnvironment);
			return sr;
		} catch (IOException e) {
			throw new ArcObjectsInteropException(
					String.format(
							"Cannot create spatial reference from factory code '%1$d'.",
							factoryCode), e);
		}
	}
}
