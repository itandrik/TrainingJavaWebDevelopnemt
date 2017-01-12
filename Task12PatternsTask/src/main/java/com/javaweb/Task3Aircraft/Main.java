package com.javaweb.Task3Aircraft;

import com.javaweb.Task3Aircraft.Aircrafts.MilitaryAirplaneImpl;
import com.javaweb.Task3Aircraft.weapons.Weapon;

/**
 * @author Andrii Chernysh on 11-Jan-17.
 *         E-Mail : itcherry97@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        MilitaryAirplaneImpl plane = new MilitaryAirplaneImpl("Tu 22 Blinder");
        Weapon machineGun = new Weapon("Machine gun MG-81",1500);
        Weapon rocketGun = new Weapon("Rocket gun FAU-81",1);

        plane.addWeapon(machineGun);
        plane.addWeapon(rocketGun);

        plane.fire();
        plane.land();
        plane.takeOff();

        plane.fire();
        plane.nextWeapon();
        plane.fire();
        plane.nextWeapon();
        plane.fire();
        plane.fireFromAllWeapons();

        plane.removeWeapon(machineGun);
        plane.removeWeapon(rocketGun);
        plane.fire();
    }
}
