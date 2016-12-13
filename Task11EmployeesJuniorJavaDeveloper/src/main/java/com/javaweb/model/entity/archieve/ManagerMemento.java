package com.javaweb.model.entity.archieve;

import com.javaweb.model.entity.Worker;

import java.util.List;

/**
 * Created by Dron on 13-Dec-16.
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
