package com.javaweb.model.entity;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public class Worker extends Employee{
    private boolean isAttached = false;
    public Worker(String name, String birthDate, String adoptionDate) {
        super(name, birthDate, adoptionDate);
        setEmployeeType(EmployeeType.WORKER);
    }

    public boolean isAttached() {
        return isAttached;
    }

    public void setAttached(boolean attached) {
        isAttached = attached;
    }
}
