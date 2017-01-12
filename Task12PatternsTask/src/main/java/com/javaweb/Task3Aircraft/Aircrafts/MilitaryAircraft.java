package com.javaweb.Task3Aircraft.Aircrafts;

import com.javaweb.Task3Aircraft.weapons.Weapon;

/**
 * @author Andrii Chernysh on 12-Jan-17. E-Mail : itcherry97@gmail.com
 */
public interface MilitaryAircraft {
    void addWeapon(Weapon weapon);
    void removeWeapon(Weapon weapon);
    void nextWeapon();
    void fire();
    void fireFromAllWeapons();
}
