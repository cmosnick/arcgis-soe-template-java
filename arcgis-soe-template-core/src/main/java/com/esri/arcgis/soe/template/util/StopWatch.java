package com.esri.arcgis.soe.template.util;

public class StopWatch {

    private boolean isRunning;
    private boolean hasElapsed;
    private long startTime;
    private long elapsedTime;

    public StopWatch() {
    }

    public static StopWatch createAndStart() {
        StopWatch timer = new StopWatch();
        timer.start();
        return timer;
    }

    public void start() {
        if (isRunning) {
            throw new IllegalStateException("StopWatch is already running.");
        }
        isRunning = true;
        hasElapsed = false;
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        if (!isRunning) {
            throw new IllegalStateException("StopWatch is not running.");
        }
        elapsedTime = System.currentTimeMillis() - startTime;
        isRunning = false;
        hasElapsed = true;
    }

    public long elapsedTimeMillis() {
        if (isRunning) {
            throw new IllegalStateException("StopWatch is already running.");
        }
        if (!hasElapsed) {
            throw new IllegalStateException("StopWatch was not run.");
        }
        return elapsedTime;
    }

    public double elapsedTimeSeconds() {
        return elapsedTimeMillis() / 1000.0d;
    }
}
