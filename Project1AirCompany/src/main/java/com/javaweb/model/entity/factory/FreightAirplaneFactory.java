package com.javaweb.model.entity.factory;

import com.javaweb.model.entity.InitializeAirplanes;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.passenger.PassengerAirplane;


public class FreightAirplaneFactory implements AircraftFactory {
    @Override
    public FreightAirplane getFreightAirplane(InitializeAirplanes initValues) {
        switch (initValues.getAirplaneType()){
            case FREIGHT_HEAVY:
                return FreightAirplane.getInstanceFreightAirplane(initValues);
            case FREIGHT_LIGHT:
                return FreightAirplane.getInstanceFreightAirplane(initValues);
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
