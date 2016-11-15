package com.javaweb.model.entity.freight;


import com.javaweb.model.entity.Aircraft;
import com.javaweb.model.entity.InitializeAirplanes;

public abstract class FreightAirplane extends Aircraft {
    private double freightWeight;
    private static final int WEIGHT_OF_HEAVY_AIRCRAFT = 136;
    private static final int WEIGHT_OF_LIGHT_AIRCRAFT = 7;

    public FreightAirplane(InitializeAirplanes init) {
        super(init);
        this.freightWeight = init.getFreightWeight();
    }

    public static FreightAirplane getInstanceFreightAirplane(
            InitializeAirplanes init) {
        if (init.getFreightWeight() >= WEIGHT_OF_HEAVY_AIRCRAFT) {
            return new FreightHeavyWeight(init);
        } else if (init.getFreightWeight() <= WEIGHT_OF_LIGHT_AIRCRAFT) {
            return new FreightLightWeight(init);
        } else {
            return null;
        }
    }

    public double getFreightWeight() {
        return freightWeight;
    }

    public void setFreightWeight(double freightWeight) {
        this.freightWeight = freightWeight;
    }


}
