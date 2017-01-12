package com.javaweb.Task3Aircraft.Aircrafts;

import com.javaweb.Task3Aircraft.weapons.Weapon;

/**
 * @author Andrii Chernysh on 12-Jan-17. E-Mail : itcherry97@gmail.com
 */
public interface AircraftState {
    void fire(Weapon weapon);
    void recharge(Weapon weapon, int patronQuantity);
}
