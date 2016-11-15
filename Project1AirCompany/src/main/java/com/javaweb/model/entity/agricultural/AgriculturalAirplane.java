package com.javaweb.model.entity.agricultural;


import com.javaweb.model.entity.Aircraft;
import com.javaweb.model.entity.InitializeAirplanes;

public abstract class AgriculturalAirplane extends Aircraft {
    protected double amountOfPesticides;
    protected double sprayingAreaSquare;
    protected double landingSpeed;
    protected double takeOffSpeed;

    public AgriculturalAirplane(InitializeAirplanes init) {
        super(init);
        this.amountOfPesticides = init.getAmountOfPesticides();
        this.sprayingAreaSquare = init.getSprayingAreaSquare();
    }

    public double getAmountOfPesticides() {
        return amountOfPesticides;
    }

    public void setAmountOfPesticides(double amountOfPesticides) {
        this.amountOfPesticides = amountOfPesticides;
    }

    public double getSprayingAreaSquare() {
        return sprayingAreaSquare;
    }

    public void setSprayingAreaSquare(double sprayingAreaSquare) {
        this.sprayingAreaSquare = sprayingAreaSquare;
    }

    protected abstract void setLandingSpeed(double speed);

    protected abstract void setTakeOffSpeed(double speed);

    protected abstract double getLandingSpeed();

    protected abstract double getTakeOffSpeed();
}
