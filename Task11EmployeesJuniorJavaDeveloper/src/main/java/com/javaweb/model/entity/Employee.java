package com.javaweb.model.entity;

import com.javaweb.model.entity.archive.Archive;
import com.javaweb.model.entity.archive.ManagerMemento;
import com.javaweb.model.entity.factory.EmployeeCreator;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
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
                Manager manager = (Manager)EmployeeCreator.getEmployee(
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

                return EmployeeCreator.getEmployee(getName(),getBirthDate(),
                        getAdoptionDate(),type);
            }
        }
        return null;
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
