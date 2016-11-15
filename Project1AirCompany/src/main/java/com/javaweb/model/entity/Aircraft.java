package com.javaweb.model.entity;

/**
 * Created by Dron on 13-Nov-16.
 */
public abstract class Aircraft {
    private String name;
    //private //double weight;
    private ManufacturerCountry manufacturerCountry;
    private int engineQuantity;//Inner class with engine
    private double maxSpeed;
    private boolean hasPilot;
    private long price;
    private double fuelConsumption;
    private double rangeOfFlight;
    private int passengerCapacity;
    private double carryingCapacity;

    /**
     * Created by Dron on 13-Nov-16.
     */
    public enum ManufacturerCountry {
        USSR, FRANCE, USA, GERMANY
    }

    public Aircraft(InitializeAirplanes init) {
        setName(init.name());
        setManufacturerCountry(init.getManufacturerCountry());
        setEngineQuantity(init.getEngineQuantity());
        setPassengerCapacity(init.getPassengerCapacity());
        setCarryingCapacity(init.getCarryingCapacity());
        setMaxSpeed(init.getMaxSpeed());
        setHasPilot(init.hasPilot());
        setPrice(init.getPrice());
        setFuelConsumption(init.getFuelConsumption());
        setRangeOfFlight(init.getRangeOfFlight());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturerCountry(ManufacturerCountry manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    public void setEngineQuantity(int engineQuantity) {
        this.engineQuantity = engineQuantity;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setHasPilot(boolean hasPilot) {
        this.hasPilot = hasPilot;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setRangeOfFlight(double rangeOfFlight) {
        this.rangeOfFlight = rangeOfFlight;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public String getName() {
        return name;
    }

    public ManufacturerCountry getManufacturerCountry() {
        return manufacturerCountry;
    }

    public int getEngineQuantity() {
        return engineQuantity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public boolean isHasPilot() {
        return hasPilot;
    }

    public long getPrice() {
        return price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getRangeOfFlight() {
        return rangeOfFlight;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }
}