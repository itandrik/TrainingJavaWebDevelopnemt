package com.javaweb.model.entity.freight;


import com.javaweb.model.entity.InitializeAirplanes;

public class FreightHeavyWeight extends FreightAirplane {
    private double unitLoadDeviceCapacity;
    private double quantityOfULD;

    public FreightHeavyWeight(InitializeAirplanes init) {
        super(init);
        this.unitLoadDeviceCapacity = init.getUnitLoadDeviceCapacity();
        this.quantityOfULD = init.getQuantityOfULD();
    }

    public boolean checkCorrectWeight(){
        return unitLoadDeviceCapacity*quantityOfULD <= getFreightWeight();
    }

    public double getUnitLoadDeviceCapacity() {
        return unitLoadDeviceCapacity;
    }

    public void setUnitLoadDeviceCapacity(double unitLoadDeviceCapacity) {
        this.unitLoadDeviceCapacity = unitLoadDeviceCapacity;
    }

    public double getQuantityOfULD() {
        return quantityOfULD;
    }

    public void setQuantityOfULD(double quantityOfULD) {
        this.quantityOfULD = quantityOfULD;
    }
}
