package com.javaweb.Task3Aircraft.Aircrafts;

/**
 * @author Andrii Chernysh on 12-Jan-17. E-Mail : itcherry97@gmail.com
 */
public abstract class Aircraft {
    private AircraftState state;
    private String aircraftName;
    private AircraftInTheAirState inTheAirState = new AircraftInTheAirState();
    private AircraftOnTheGroundState onTheGroundState = new AircraftOnTheGroundState();

    public Aircraft(String aircraftName) {
        this.aircraftName = aircraftName;
        state = onTheGroundState;
    }

    public void takeOff() {
        if (state instanceof AircraftInTheAirState) {
            System.out.println("Plane already in the air");
        } else {
            System.out.println("Taking off...");
            state = inTheAirState;
        }
    }

    public void land() {
        if (state instanceof AircraftOnTheGroundState) {
            System.out.println("Plane already on the ground");
        } else {
            System.out.println("Landing...");
            state = onTheGroundState;
        }
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public AircraftState getAircraftState() {
        return state;
    }
}
