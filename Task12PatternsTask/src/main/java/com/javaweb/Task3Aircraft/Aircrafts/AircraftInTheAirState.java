package com.javaweb.Task3Aircraft.Aircrafts;

import com.javaweb.Task3Aircraft.weapons.Weapon;

/**
 * @author Andrii Chernysh on 12-Jan-17. E-Mail : itcherry97@gmail.com
 */
public class AircraftInTheAirState implements AircraftState{
    @Override
    public void fire(Weapon weapon) {
        weapon.fire();
    }

    @Override
    public void recharge(Weapon weapon, int patronQuantity) {
        System.out.println("Cannot recharge weapon, while in the air");
    }
}
