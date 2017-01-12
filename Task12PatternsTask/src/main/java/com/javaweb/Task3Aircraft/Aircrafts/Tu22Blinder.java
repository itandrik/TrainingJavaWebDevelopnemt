package com.javaweb.Task3Aircraft.Aircrafts;

import com.javaweb.Task3Aircraft.weapons.Weapon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @author Andrii Chernysh on 12-Jan-17. E-Mail : itcherry97@gmail.com
 */
public class Tu22Blinder extends Aircraft implements MilitaryAircraft {
    private Deque<Weapon> weapons;
    private Weapon currentWeapon;
    private Iterator<Weapon> weaponIterator;

    public Tu22Blinder(String aircraftName) {
        super(aircraftName);
        weapons = new ArrayDeque<>();
        weaponIterator = weapons.iterator();
    }

    @Override
    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
        if(currentWeapon == null){
            currentWeapon = weapon;
        }
    }

    @Override
    public void removeWeapon(Weapon weapon) {
        weapons.remove(weapon);
        weaponIterator = weapons.iterator();
    }

    @Override
    public void nextWeapon() {
        if(!isEmptyWeaponList()) {
            makeWeaponsDequeCircular();
            currentWeapon = weaponIterator.next();
        }
    }

    private boolean isEmptyWeaponList(){
        if(weapons.isEmpty()) {
            System.out.println("No weapon on the aircraft");
        }
        return weapons.isEmpty();
    }

    private void makeWeaponsDequeCircular() {
        if (!weaponIterator.hasNext()) {
            weaponIterator = weapons.iterator();
        }
    }

    @Override
    public void fire() {
        currentWeapon.fire();
    }

    @Override
    public void fireFromAllWeapons() {
        for (Weapon weapon:weapons) {
            weapon.fire();
        }
    }
}
