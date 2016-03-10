package com.esri.arcgis.soe.template.util;

import java.io.IOException;

public class UncheckedIOException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UncheckedIOException() {
		super();
	}

	public UncheckedIOException(String message, IOException cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UncheckedIOException(String message, IOException cause) {
		super(message, cause);
	}

	public UncheckedIOException(String message) {
		super(message);
	}

	public UncheckedIOException(IOException cause) {
		super(cause);
	}

}
