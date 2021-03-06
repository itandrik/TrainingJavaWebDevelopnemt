package com.javaweb.model.entity.archive;

import com.javaweb.model.entity.Worker;

import java.util.List;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public class ManagerMemento {
    private List<Worker> attachedWorkers;
    private String name;
    private String birthDate;
    private String adoptionDate;

    public ManagerMemento(List<Worker> attachedWorkers, String name, String birthDate, String adoptionDate) {
        this.attachedWorkers = attachedWorkers;
        this.name = name;
        this.birthDate = birthDate;
        this.adoptionDate = adoptionDate;
    }

    public List<Worker> getAttachedWorkers() {
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

}
