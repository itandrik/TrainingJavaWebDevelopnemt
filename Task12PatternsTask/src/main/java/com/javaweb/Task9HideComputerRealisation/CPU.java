package com.javaweb.Task9HideComputerRealisation;

/**
 * @author Andrii Chernysh on 16-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class CPU implements ProcessUnit {
    private double frequency;
    private String name;
    private int cacheCapacity;
    private int quantityOfCores;
    private int generation;

    public CPU(double frequency, String name, int cacheCapacity,
               int quantityOfCores, int generation) {
        this.frequency = frequency;
        this.name = name;
        this.cacheCapacity = cacheCapacity;
        this.quantityOfCores = quantityOfCores;
        this.generation = generation;
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

    public int getQuantityOfCores() {
        return quantityOfCores;
    }

    public int getGeneration() {
        return generation;
    }
}
