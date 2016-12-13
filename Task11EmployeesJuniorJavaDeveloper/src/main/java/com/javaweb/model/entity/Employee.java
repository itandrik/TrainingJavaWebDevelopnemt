package com.javaweb.model.entity;

import com.javaweb.model.entity.archieve.Archive;
import com.javaweb.model.entity.archieve.ManagerMemento;
import com.javaweb.model.entity.factory.EmployeeCreator;
import com.javaweb.model.entity.factory.ManagerCreator;
import com.javaweb.model.entity.factory.OtherCreator;
import com.javaweb.model.entity.factory.WorkerCreator;

/**
 * Created by Dron on 13-Dec-16.
 */
public abstract class Employee {
    private String name;
    private String birthDate;
    private String adoptionDate;
    private EmployeeType employeeType;

    public Employee(String name, String birthDate, String adoptionDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.adoptionDate = adoptionDate;
    }

    public Employee changeTypeOfEmployee(EmployeeType type) {
        Archive archive = Archive.getInstance();
        if (!type.equals(this.employeeType)) {
            ManagerMemento managerMemento =
                    archive.getManagerFromArchive(this);
            if ((this.employeeType.equals(EmployeeType.OTHER) ||
                    this.employeeType.equals(EmployeeType.WORKER)) &&
                    type.equals(EmployeeType.MANAGER) &&
                    managerMemento != null) {
                Manager manager = (Manager) createEmployee(
                        managerMemento.getName(),
                        managerMemento.getBirthDate(),
                        managerMemento.getAdoptionDate(), type);
                manager.setAttachedWorkers(managerMemento.getAttachedWorkers());
            } else if(this.employeeType.equals(EmployeeType.MANAGER) &&
                    (type.equals(EmployeeType.OTHER) ||
                            type.equals(EmployeeType.WORKER))){
                //перекинути всіх підлеглих на іншого
                ManagerMemento manager = new ManagerMemento(
                        ((Manager)this).getAttachedWorkers(),
                        getName(),getBirthDate(),getAdoptionDate());
                archive.addMangerToArchive(manager);
                return createEmployee(getName(),getBirthDate(),
                        getAdoptionDate(),type);
            }
        }
        return null;
    }

    private Employee createEmployee(String name,String birthDate,
                           String adoptionDate, EmployeeType type){
        EmployeeCreator factory;
        switch (type){
            case MANAGER:
                factory = new ManagerCreator();
                break;
            case OTHER:
                factory = new OtherCreator();
                break;
            case WORKER:
                factory = new WorkerCreator();
                break;
            default:
                throw new RuntimeException("No such type of employee");
        }
        return factory.createEmployee(name,birthDate,adoptionDate);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAdoptionDate(String adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAdoptionDate() {
        return adoptionDate;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
}
