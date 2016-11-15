package com.javaweb.model.entity.passenger;

import com.javaweb.model.entity.InitializeAirplanes;

/**
 * Created by Dron on 13-Nov-16.
 */
public class PassengerWideFuselage extends PassengerAirplane {
    private boolean hasLunch;
    private int quantityOfStewardess;
    private static final byte QUANTITY_OF_STEWARDESS_5_STARS = 10;
    private static final byte QUANTITY_OF_STEWARDESS_4_STARS = 7;
    private static final byte QUANTITY_OF_STEWARDESS_3_STARS = 5;
    private static final byte QUANTITY_OF_STEWARDESS_2_STARS = 3;

    public PassengerWideFuselage(InitializeAirplanes init) {
        super(init);
        this.hasLunch = init.hasLunch();
        this.quantityOfStewardess = init.getQuantityOfStewardess();
        checkComfort();
    }

    public boolean isHasLunch() {
        return hasLunch;
    }

    public void setHasLunch(boolean hasLunch) {
        this.hasLunch = hasLunch;
    }

    public int getQuantityOfStewardess() {
        return quantityOfStewardess;
    }

    public void setQuantityOfStewardess(int quantityOfStewardess) {
        this.quantityOfStewardess = quantityOfStewardess;
    }

    @Override
    public void checkComfort() {
        if (hasLunch) {
            if (quantityOfStewardess >= QUANTITY_OF_STEWARDESS_5_STARS) {
                setComfortGrade(ComfortGrade.FIVE_STAR);
            } else if (quantityOfStewardess >= QUANTITY_OF_STEWARDESS_4_STARS) {
                setComfortGrade(ComfortGrade.FOUR_STAR);
            } else if (quantityOfStewardess >= QUANTITY_OF_STEWARDESS_3_STARS) {
                setComfortGrade(ComfortGrade.THREE_STAR);
            } else {
                setComfortGrade(ComfortGrade.ONE_STAR);
            }
        } else if ((quantityOfStewardess >= QUANTITY_OF_STEWARDESS_3_STARS) &&
                (quantityOfStewardess <= QUANTITY_OF_STEWARDESS_2_STARS)) {
            setComfortGrade(ComfortGrade.TWO_STAR);
        }

    }
}