package com.javaweb.Task3Aircraft.weapons;

/**
 * @author Andrii Chernysh on 12-Jan-17. E-Mail : itcherry97@gmail.com
 */
public class Weapon {
    private String name;
    private int ammoQuantity;
    private WeaponState state;
    private WeaponNoAmmoState noAmmoState = new WeaponNoAmmoState(this);
    private WeaponWithAmmoState withAmmoState = new WeaponWithAmmoState(this);

    public Weapon(String name, int ammoQuantity) {
        this.name = name;
        this.ammoQuantity = ammoQuantity;
    }

    public void fire() {
        checkAmmo();
        state.fire();
    }

    public void recharge(int patronQuantity) {
        ammoQuantity = patronQuantity;
        System.out.println("Weapon " + name +
                " has been successfully recharged!! Quantity of ammo : " +
                ammoQuantity);
    }

    public void checkAmmo(){
        if(ammoQuantity <= 0){
            state = noAmmoState;
        } else {
            state = withAmmoState;
        }
    }
    public void setState(WeaponState state) {
        this.state = state;
    }

    public void setAmmoQuantity(int ammoQuantity) {
        this.ammoQuantity = ammoQuantity;
    }

    public String getName() {
        return name;
    }

    public int getAmmoQuantity() {
        return ammoQuantity;
    }
}
