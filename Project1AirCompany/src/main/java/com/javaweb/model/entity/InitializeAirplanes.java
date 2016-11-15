package com.javaweb.model.entity;

/**
 * Created by Dron on 13-Nov-16.
 */
public enum InitializeAirplanes {
    AN_2СХ(AirplaneType.AGRICULTURAL_BIPLANE, Aircraft.ManufacturerCountry.USSR,
            1,254,true,2000,140,900,1,1980,1400,30,236,155,-1,false,false, -1,-1,
            -1,-1,false,-1,false,-1);


    private final AirplaneType airplaneType;
    private final Aircraft.ManufacturerCountry manufacturerCountry;
    private final int engineQuantity;
    private final double maxSpeed;
    private final boolean hasPilot;
    private final long price;
    private final double fuelConsumption;
    private final double rangeOfFlight;
    private final int passengerCapacity;
    private final double carryingCapacity;
    private final double amountOfPesticides;
    private final double sprayingAreaSquare;
    private final double landingSpeed;
    private final double takeOffSpeed;
    private final double freightWeight;
    private final boolean isPostal;
    private final boolean isUsingForJumping;
    private final double unitLoadDeviceCapacity;
    private final double quantityOfULD;
    private final double fuselageDiameter;
    private final double fuselageLength;
    private final boolean hasWifi;
    private final int capacityCarryOnLuggage;
    private final boolean hasLunch;
    private final int quantityOfStewardess;


    InitializeAirplanes(AirplaneType airplaneType,
                        Aircraft.ManufacturerCountry manufacturerCountry,
                        int engineQuantity, double maxSpeed, boolean hasPilot,
                        long price, double fuelConsumption,
                        double rangeOfFlight, int passengerCapacity,
                        double carryingCapacity, double amountOfPesticides,
                        double sprayingAreaSquare, double landingSpeed,
                        double takeOffSpeed, double freightWeight,
                        boolean isUsingForJumping, boolean isPostal,
                        double unitLoadDeviceCapacity, double quantityOfULD,
                        double fuselageDiameter,double fuselageLength,
                        boolean hasWifi, int capacityCarryOnLuggage,
                        boolean hasLunch,int quantityOfStewardess){
        this.airplaneType = airplaneType;
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
        this.freightWeight = freightWeight;
        this.isPostal = isPostal;
        this.isUsingForJumping = isUsingForJumping;
        this.unitLoadDeviceCapacity = unitLoadDeviceCapacity;
        this.quantityOfULD = quantityOfULD;
        this.fuselageDiameter = fuselageDiameter;
        this.fuselageLength = fuselageLength;
        this.hasWifi = hasWifi;
        this.capacityCarryOnLuggage = capacityCarryOnLuggage;
        this.hasLunch = hasLunch;
        this.quantityOfStewardess = quantityOfStewardess;
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

    public boolean hasPilot() {
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

    public AirplaneType getAirplaneType() {
        return airplaneType;
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

    public double getFreightWeight() {
        return freightWeight;
    }

    public boolean isPostal() {
        return isPostal;
    }

    public boolean isUsingForJumping() {
        return isUsingForJumping;
    }

    public double getUnitLoadDeviceCapacity() {
        return unitLoadDeviceCapacity;
    }

    public double getQuantityOfULD() {
        return quantityOfULD;
    }

    public double getFuselageDiameter() {
        return fuselageDiameter;
    }

    public double getFuselageLength() {
        return fuselageLength;
    }

    public boolean hasWifi() {
        return hasWifi;
    }

    public int getCapacityCarryOnLuggage() {
        return capacityCarryOnLuggage;
    }

    public boolean hasLunch() {
        return hasLunch;
    }

    public int getQuantityOfStewardess() {
        return quantityOfStewardess;
    }
}
