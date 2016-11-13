package com.javaweb.model.entity;

import com.javaweb.model.entity.agricultural.AgriculturalAirplaneType;
import com.javaweb.model.entity.freight.FreightAirplaneType;
import com.javaweb.model.entity.passenger.PassengerAirplaneType;

/**
 * Created by Dron on 13-Nov-16.
 */
public enum InitializeAirplanes {
    AN_2СХ(AgriculturalAirplaneType.BIPLANE, Aircraft.ManufacturerCountry.USSR,
            1,254,true,2000,140,900,1,1980,1400,30,236,155);

    private final AgriculturalAirplaneType agriculturalAirplaneType;
    private final PassengerAirplaneType passengerAirplaneType;
    private final FreightAirplaneType freightAirplaneType;
    //private final String name;
    private final Aircraft.ManufacturerCountry manufacturerCountry;
    private final int engineQuantity;
    private final double maxSpeed;
    private final boolean hasPilot;
    private final double price;
    private final double fuelConsumption;
    private final double rangeOfFlight;
    private final int passengerCapacity;
    private final double carryingCapacity;
    private final double amountOfPesticides;
    private final double sprayingAreaSquare;
    private final double landingSpeed;
    private final double takeOffSpeed;

    InitializeAirplanes(AgriculturalAirplaneType agriculturalAirplaneType,
                        Aircraft.ManufacturerCountry manufacturerCountry,
                        int engineQuantity, double maxSpeed, boolean hasPilot,
                        double price, double fuelConsumption,
                        double rangeOfFlight, int passengerCapacity,
                        double carryingCapacity, double amountOfPesticides,
                        double sprayingAreaSquare, double landingSpeed,
                        double takeOffSpeed) {
        this.agriculturalAirplaneType = agriculturalAirplaneType;
        this.manufacturerCountry = manufacturerCountry;
        this.engineQuantity = engineQuantity;
        this.maxSpeed = maxSpeed;
        this.hasPilot = hasPilot;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.rangeOfFlight = rangeOfFlight;
        this.passengerCapacity = passengerCapacity;
        this.carryingCapacity = carryingCapacity;
        this.amountOfPesticides = amountOfPesticides;
        this.sprayingAreaSquare = sprayingAreaSquare;
        this.landingSpeed = landingSpeed;
        this.takeOffSpeed = takeOffSpeed;
    }

    public AgriculturalAirplaneType getAgriculturalAirplaneType() {
        return agriculturalAirplaneType;
    }

    public Aircraft.ManufacturerCountry getManufacturerCountry() {
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

    public double getPrice() {
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

    public double getAmountOfPesticides() {
        return amountOfPesticides;
    }

    public double getSprayingAreaSquare() {
        return sprayingAreaSquare;
    }

    public double getLandingSpeed() {
        return landingSpeed;
    }

    public double getTakeOffSpeed() {
        return takeOffSpeed;
    }

    public PassengerAirplaneType getPassengerAirplaneType() {
        return passengerAirplaneType;
    }

    public FreightAirplaneType getFreightAirplaneType() {
        return freightAirplaneType;
    }
}
