package com.javaweb.model.entity.passenger;

import com.javaweb.model.entity.InitializeAirplanes;

/**
 * Created by Dron on 13-Nov-16.
 */
public class PassengerNarrowFuselage extends PassengerAirplane {
    private boolean hasWifi;
    private int capacityCarryOnLuggage;
    private static final byte QUANTITY_OF_CARRY_ON_5_STARS = 50;
    private static final byte QUANTITY_OF_CARRY_ON_4_STARS = 40;
    private static final byte QUANTITY_OF_CARRY_ON_3_STARS = 30;
    private static final byte QUANTITY_OF_CARRY_ON_2_STARS = 15;

    public PassengerNarrowFuselage(InitializeAirplanes init) {
        super(init);
        this.hasWifi = init.hasWifi();
        this.capacityCarryOnLuggage = init.getCapacityCarryOnLuggage();
        checkComfort();
    }

    @Override
    public void checkComfort() {
        if(hasWifi){
            if(capacityCarryOnLuggage >= QUANTITY_OF_CARRY_ON_5_STARS){
                setComfortGrade(ComfortGrade.FIVE_STAR);
            }else if((capacityCarryOnLuggage >= QUANTITY_OF_CARRY_ON_3_STARS) &&
                    (capacityCarryOnLuggage <= QUANTITY_OF_CARRY_ON_4_STARS)){
                setComfortGrade(ComfortGrade.THREE_STAR);
            }
        }else{
            if((capacityCarryOnLuggage >= QUANTITY_OF_CARRY_ON_2_STARS) &&
                    capacityCarryOnLuggage < QUANTITY_OF_CARRY_ON_4_STARS){
                setComfortGrade(ComfortGrade.TWO_STAR);
            }else if(capacityCarryOnLuggage <= QUANTITY_OF_CARRY_ON_2_STARS){
                setComfortGrade(ComfortGrade.ONE_STAR);
            }
        }
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public int getCapacityCarryOnLuggage() {
        return capacityCarryOnLuggage;
    }

    public void setCapacityCarryOnLuggage(int capacityCarryOnLuggage) {
        this.capacityCarryOnLuggage = capacityCarryOnLuggage;
    }
}
