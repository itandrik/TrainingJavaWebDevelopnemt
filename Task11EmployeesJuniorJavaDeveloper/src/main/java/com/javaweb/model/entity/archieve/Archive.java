package com.javaweb.model.entity.archieve;

import com.javaweb.model.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrii Chernysh
 */
public class Archive {
    //private Map<ManagerMemento,WeakReference<ManagerMemento>> flyweight;
    private List<ManagerMemento> managersArchive;
    private static class Holder {
        private static final Archive instance =
                new Archive();
    }

    public static Archive getInstance() {
        return Holder.instance;
    }

    private Archive() {
        //flyweight = new WeakHashMap<>();
        managersArchive = new ArrayList<>();
    }

    public void addMangerToArchive(ManagerMemento managerMemento){
        if (!managersArchive.contains(managerMemento)) {
            managersArchive.add(managerMemento);
        }
    }

    public ManagerMemento getManagerFromArchive(Employee manager){
        return managersArchive.stream().filter(
                (elem) ->
                    manager.getName().equals(elem.getName()) &&
                    manager.getAdoptionDate().equals(elem.getAdoptionDate()) &&
                    manager.getBirthDate().equals(elem.getBirthDate()))
                .findAny().orElse(null);
    }
}
