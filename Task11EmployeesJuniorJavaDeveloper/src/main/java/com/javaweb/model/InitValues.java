package com.javaweb.model;

import com.javaweb.model.entity.EmployeeType;

import java.util.Arrays;
import java.util.List;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public enum InitValues {
    W1(EmployeeType.WORKER, "Worker 1", "03-01-1989", "04-06-2005",null, null),
    W2(EmployeeType.WORKER, "Worker 2", "04-02-1982", "05-09-2006",null, null),
    W3(EmployeeType.WORKER, "Worker 3", "05-03-1981", "06-10-2007",null, null),
    W4(EmployeeType.WORKER, "Worker 4", "06-04-1983", "06-11-2008",null, null),
    W5(EmployeeType.WORKER, "Worker 5", "07-05-1984", "07-12-2009",null, null),
    W6(EmployeeType.WORKER, "Worker 6", "08-06-1985", "08-13-2003",null, null),

    M1(EmployeeType.MANAGER, "Manager 1", "03-01-1989", "04-07-2012", Arrays.asList(W1,W2), null),
    M2(EmployeeType.MANAGER, "Manager 2", "04-02-1983", "05-08-2013",Arrays.asList(W3,W4), null),
    M3(EmployeeType.MANAGER, "Manager 3", "05-03-1984", "06-09-2014",Arrays.asList(W5,W6), null),

    O1(EmployeeType.OTHER, "Other 1", "03-12-1989", "03-03-2015",null, "Director"),
    O2(EmployeeType.OTHER, "Other 2", "10-01-1231", "07-04-2016",null, "Secretary");

    EmployeeType type;
    String name;
    String birthDate;
    String adoptionDate;
    List<InitValues> attachedWorkers;
    String description;

    InitValues(EmployeeType type, String name,
               String birthDate, String adoptionDate,
               List<InitValues> attachedWorkers, String description) {
        this.type = type;
        this.name = name;
        this.attachedWorkers = attachedWorkers;
        this.birthDate = birthDate;
        this.adoptionDate = adoptionDate;
        this.description = description;
    }

    public EmployeeType getType() {
        return type;
    }

    public List<InitValues> getAttachedWorkers() {
        return attachedWorkers;
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

    public String getDescription() {
        return description;
    }
}
