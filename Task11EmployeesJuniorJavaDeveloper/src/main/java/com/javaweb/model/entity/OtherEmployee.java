package com.javaweb.model.entity;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public class OtherEmployee extends Employee{
    private String description;

    public OtherEmployee(String name, String birthDate, String adoptionDate) {
        super(name, birthDate, adoptionDate);
        setEmployeeType(EmployeeType.OTHER);
    }

    public OtherEmployee(String name, String birthDate, String adoptionDate, String description) {
        super(name, birthDate, adoptionDate);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
