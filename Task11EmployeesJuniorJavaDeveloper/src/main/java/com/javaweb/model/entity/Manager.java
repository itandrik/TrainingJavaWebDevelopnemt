package com.javaweb.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrii Chernysh;
 *       E-MAIL : itcherry97@gmail.com;
 */
public class Manager extends Employee{
    private List<Worker> attachedWorkers = new ArrayList<>();

    public Manager(String name, String birthDate, String adoptionDate) {
        super(name, birthDate, adoptionDate);
        setEmployeeType(EmployeeType.MANAGER);
    }

    public Manager(String name, String birthDate, String adoptionDate, List<Worker>attachedWorkers) {
        super(name, birthDate, adoptionDate);
        this.attachedWorkers = attachedWorkers;
    }

    public List<Worker> getAttachedWorkers() {
        return attachedWorkers;
    }

    public boolean attachWorker(Worker worker){
        return attachedWorkers.add(worker);
    }

    public boolean detachWorker(Worker worker){
        return attachedWorkers.remove(worker);
    }

    public void setAttachedWorkers(List<Worker> attachedWorkers) {
        this.attachedWorkers = attachedWorkers;
    }
}
