package com.javaweb.Task3Aircraft.Aircrafts;

/**
 * @author Andrii Chernysh on 12-Jan-17. E-Mail : itcherry97@gmail.com
 */
public abstract class Aircraft {
    private AircraftState state = AircraftState.ON_THE_GROUND;
    private String aircraftName;

    public Aircraft(String aircraftName) {
        this.aircraftName = aircraftName;
    }

    public void takeOff() {
        if (state == AircraftState.IN_THE_AIR) {
            System.out.println("Plane already in the air");
        } else {
            state = AircraftState.IN_THE_AIR;
        }
    }

    public void land() {
        if (state == AircraftState.ON_THE_GROUND) {
            System.out.println("Plane already on the ground");
        } else {
            state = AircraftState.ON_THE_GROUND;
        }
    }

    public AircraftState getAircraftState() {
        return state;
    }
}
