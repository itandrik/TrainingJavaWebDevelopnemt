package com.javaweb.model;

import com.javaweb.model.entity.*;
import com.javaweb.model.entity.archive.Archive;
import com.javaweb.model.entity.archive.ManagerMemento;
import com.javaweb.model.entity.factory.EmployeeCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Andrii Chernysh; E-MAIL : itcherry97@gmail.com;
 */
public class Model {
    private List<Employee> company;
    private Archive archive;

    public Model() {
        this.company = new ArrayList<>();
        this.archive = Archive.getInstance();
    }

    /**
     * Temp method for testing.
     * DELETE THIS METHOD WHEN WILL BE RELEASE
     */
    public void initEmployees() {
        for (InitValues value : InitValues.values()) {
            Employee employee = EmployeeCreator.getEmployee(
                    value.getName(), value.getBirthDate(),
                    value.getAdoptionDate(), value.getType());
            switch (value.getType()) {
                case MANAGER:
                    List<Worker> workersAttached = new ArrayList<Worker>();
                    value.getAttachedWorkers()
                            .forEach((elem) -> {
                                workersAttached.add(new Worker(elem.getName(),
                                        elem.getBirthDate(), elem.getAdoptionDate()));
                            });
                    ((Manager) employee).setAttachedWorkers(workersAttached);
                    break;
                case OTHER:
                    ((OtherEmployee) employee)
                            .setDescription(value.getDescription());
                    break;
            }
            company.add(employee);
        }
    }

    public void addEmployee(Employee e) {
        company.add(e);
    }

    public void removeEmployee(Employee e, Manager managerForAssigning) {
        if(e instanceof Manager) {
            if (!company.isEmpty()) {
                if (company.remove(e) && managerForAssigning != null) {
                    for (Worker worker : ((Manager)e).getAttachedWorkers()) {
                        managerForAssigning.attachWorker(worker);
                    }
                    ManagerMemento memento = new ManagerMemento(
                            ((Manager) e).getAttachedWorkers(),
                            e.getName(),e.getBirthDate(),
                            e.getAdoptionDate());
                    archive.addMangerToArchive(memento);
                }
            }
        } else {
            company.remove(e);
        }
    }

    public Employee findEmployeeByName(String name) {
        return company.stream().filter(elem -> elem.getName().equals(name))
                .findAny().orElse(null);
    }

    public void changeTypeOfEmployee(Employee e, EmployeeType type) {
        Objects.requireNonNull(e);
        e.changeTypeOfEmployee(type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Employee employee : company) {
            sb.append(i);
            sb.append(") Name : ");
            sb.append(employee.getName());
            sb.append("; Date of birth : ");
            sb.append(employee.getBirthDate());
            sb.append(";\n\tDate of adoption : ");
            sb.append(employee.getAdoptionDate());
            if (employee.getEmployeeType().equals(EmployeeType.OTHER)) {
                sb.append(";\n\tDescription : ");
                sb.append(((OtherEmployee) employee).getDescription());
            } else if (employee.getEmployeeType().equals(EmployeeType.MANAGER)) {
                sb.append(";\n\tList of attached workers : [");
                for (Worker manager : ((Manager) employee).getAttachedWorkers()) {
                    sb.append(manager.getName());
                    sb.append(" , ");
                }
                sb.append("];");
            }
            i++;
            sb.append("\n");
        }
        return "\t\tCompany : \n" + sb.toString();
    }
}
