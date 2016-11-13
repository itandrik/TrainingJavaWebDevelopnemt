package com.javaweb.model.entity.factory;

import com.javaweb.model.entity.InitializeAirplanes;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.passenger.PassengerAirplane;
import com.javaweb.model.entity.passenger.PassengerNarrowFuselage;
import com.javaweb.model.entity.passenger.PassengerWideFuselage;


public class PassengerAirplaneFactory implements AircraftFactory {

    @Override
    public FreightAirplane getFreightAirplane(InitializeAirplanes initValues) {
        return null;
    }

    @Override
    public PassengerAirplane getPassengerAirplane(InitializeAirplanes initValues) {
        switch (initValues.getPassengerAirplaneType()){
            case NARROW_FUSELAGE:
                return new PassengerNarrowFuselage();
            case WIDE_FUSELAGE:
                return new PassengerWideFuselage();
            default:
                return null;
        }
    }

    @Override
    public AgriculturalAirplane getAgriculturalAirplane(InitializeAirplanes initValues) {
        return null;
    }
}
