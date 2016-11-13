package com.javaweb.model.entity.factory;


import com.javaweb.model.entity.InitializeAirplanes;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.passenger.PassengerAirplane;


public interface AircraftFactory {
    FreightAirplane getFreightAirplane(InitializeAirplanes initValues);
    PassengerAirplane getPassengerAirplane(InitializeAirplanes initValues);
    AgriculturalAirplane getAgriculturalAirplane(InitializeAirplanes initValues);
}
