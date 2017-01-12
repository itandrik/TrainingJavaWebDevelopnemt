package com.javaweb.Task3Aircraft.weapons;

/**
 * @author Andrii Chernysh on 12-Jan-17. E-Mail : itcherry97@gmail.com
 */
public class WeaponWithAmmoState implements WeaponState {
    private Weapon weapon;

    public WeaponWithAmmoState(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void fire() {
        weapon.setAmmoQuantity(weapon.getAmmoQuantity()-1);
        System.out.println(weapon.getName() +
                " successfully fired!! Quantity of ammo : " +
                weapon.getAmmoQuantity());
    }
}
