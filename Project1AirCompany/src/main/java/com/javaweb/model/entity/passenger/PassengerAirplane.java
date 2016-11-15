package com.javaweb.model.entity.passenger;


import com.javaweb.model.entity.Aircraft;
import com.javaweb.model.entity.InitializeAirplanes;


public abstract class PassengerAirplane extends Aircraft {
    private double fuselageDiameter;
    private double fuselageLength;
    private ComfortGrade comfortGrade;
    private static final double FUSELAGE_DIAMETER_WIDE1 = 5.0;
    private static final double FUSELAGE_DIAMETER_WIDE2 = 6.0;
    private static final double FUSELAGE_DIAMETER_NARROW = 4.0;

    protected enum ComfortGrade {
        FIVE_STAR("★★★★★"),
        FOUR_STAR("★★★★"),
        THREE_STAR("★★★"),
        TWO_STAR("★★"),
        ONE_STAR("★");

        private final String starsString;

        ComfortGrade(String starsString) {
            this.starsString = starsString;
        }

        public String getStarsString() {
            return starsString;
        }
    }

    public abstract void checkComfort();

    public PassengerAirplane(InitializeAirplanes init) {
        super(init);
        this.fuselageDiameter = init.getFuselageDiameter();
        this.fuselageLength = init.getFuselageLength();
    }

    public static PassengerAirplane getInstancePassengerAirplane(
            InitializeAirplanes init) {
        if ((init.getFuselageDiameter() >= FUSELAGE_DIAMETER_WIDE1) &&
                (init.getFuselageDiameter() <= FUSELAGE_DIAMETER_WIDE2)) {
            return new PassengerWideFuselage(init);
        } else if (init.getFuselageDiameter() <= FUSELAGE_DIAMETER_NARROW) {
            return new PassengerNarrowFuselage(init);
        } else {
            return null;
        }
    }

    public double getFuselageDiameter() {
        return fuselageDiameter;
    }

    public void setFuselageDiameter(double fuselageDiameter) {
        this.fuselageDiameter = fuselageDiameter;
    }

    public double getFuselageLength() {
        return fuselageLength;
    }

    public void setFuselageLength(double fuselageLength) {
        this.fuselageLength = fuselageLength;
    }

    public String getComfortGrade() {
        return comfortGrade.getStarsString();
    }

    public void setComfortGrade(ComfortGrade comfortGrade) {
        this.comfortGrade = comfortGrade;
    }
}
