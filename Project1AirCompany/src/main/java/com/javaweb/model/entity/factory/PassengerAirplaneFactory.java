package com.javaweb.model.entity.factory;

import com.javaweb.model.entity.InitializeAirplanes;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.passenger.PassengerAirplane;


public class PassengerAirplaneFactory implements AircraftFactory {

    @Override
    public FreightAirplane getFreightAirplane(InitializeAirplanes initValues) {
        return null;
    }

    @Override
    public PassengerAirplane getPassengerAirplane(InitializeAirplanes initValues) {
        switch (initValues.getAirplaneType()){
            case PASSENGER_NARROW:
                return PassengerAirplane.getInstancePassengerAirplane(initValues);
            case PASSENGER_WIDE:
                return PassengerAirplane.getInstancePassengerAirplane(initValues);
            default:
                return null;
        }
    }

    @Override
    public AgriculturalAirplane getAgriculturalAirplane(InitializeAirplanes initValues) {
        return null;
    }
}
