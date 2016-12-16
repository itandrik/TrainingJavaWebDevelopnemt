package com.javaweb.Task9HideComputerRealisation;

/**
 * @author Andrii Chernysh on 16-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class GPU implements ProcessUnit {
    private double frequency;
    private String name;
    private int cacheCapacity;

    public GPU(double frequency, String name, int cacheCapacity) {
        this.frequency = frequency;
        this.name = name;
        this.cacheCapacity = cacheCapacity;
    }

    @Override
    public double getFrequency() {
        return frequency;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCacheCapacity() {
        return cacheCapacity;
    }
}
