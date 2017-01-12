package com.javaweb.Task3Aircraft.Aircrafts;

import com.javaweb.Task3Aircraft.weapons.Weapon;

/**
 * @author Andrii Chernysh on 12-Jan-17. E-Mail : itcherry97@gmail.com
 */
public class AircraftOnTheGroundState implements AircraftState{
    @Override
    public void fire(Weapon weapon) {
        System.out.println("Cannot fire, while on the ground!");
    }

    @Override
    public void recharge(Weapon weapon, int patronQuantity) {
        weapon.recharge(patronQuantity);
    }
}
