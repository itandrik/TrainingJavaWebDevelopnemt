package com.javaweb.Task3Aircraft.weapons;

/**
 * @author Andrii Chernysh on 12-Jan-17. E-Mail : itcherry97@gmail.com
 */
public class WeaponNoAmmoState implements WeaponState{
    private Weapon weapon;

    public WeaponNoAmmoState(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void fire() {
        System.out.println("No ammo on aircraft for weapon : " + weapon.getName());
    }
}
