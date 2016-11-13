package com.javaweb.model.entity.factory;

import com.javaweb.model.entity.InitializeAirplanes;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.freight.FreightHeavyWeight;
import com.javaweb.model.entity.freight.FreightLightWeight;
import com.javaweb.model.entity.freight.FreightMediumWeight;
import com.javaweb.model.entity.passenger.PassengerAirplane;


public class FreightAirplaneFactory implements AircraftFactory {
    @Override
    public FreightAirplane getFreightAirplane(InitializeAirplanes initValues) {
        switch (initValues.getFreightAirplaneType()){
            case HEAVYWEIGHT:
                return new FreightHeavyWeight();
            case MEDIUMWEIGHT:
                return new FreightMediumWeight();
            case LIGHTWEIGHT:
                return new FreightLightWeight();
            default:
                return null;
        }
    }

    @Override
    public PassengerAirplane getPassengerAirplane(InitializeAirplanes initValues) {
        return null;
    }

    @Override
    public AgriculturalAirplane getAgriculturalAirplane(InitializeAirplanes initValues) {
        return null;
    }
}
