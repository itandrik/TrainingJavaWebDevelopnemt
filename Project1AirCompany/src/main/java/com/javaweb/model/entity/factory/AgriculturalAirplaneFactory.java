package com.javaweb.model.entity.factory;

import com.javaweb.model.entity.InitializeAirplanes;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.agricultural.AgriculturalBiplane;
import com.javaweb.model.entity.agricultural.AgriculturalMonoplane;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.passenger.PassengerAirplane;


public class AgriculturalAirplaneFactory implements AircraftFactory {

    @Override
    public FreightAirplane getFreightAirplane(InitializeAirplanes initValues) {
        return null;
    }

    @Override
    public PassengerAirplane getPassengerAirplane(InitializeAirplanes initValues) {
        return null;
    }

    @Override
    public AgriculturalAirplane getAgriculturalAirplane(
            InitializeAirplanes initValues) {
        switch (initValues.getAirplaneType()) {
            case AGRICULTURAL_BIPLANE:
                return new AgriculturalBiplane(initValues);
            case AGRICULTURAL_MONOPLANE:
                return new AgriculturalMonoplane(initValues);
            default:
                return null;
        }
    }
}
