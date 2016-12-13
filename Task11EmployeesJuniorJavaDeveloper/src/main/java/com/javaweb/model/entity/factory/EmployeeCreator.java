package com.javaweb.model.entity.factory;

import com.javaweb.model.entity.Employee;
import com.javaweb.model.entity.EmployeeType;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public interface EmployeeCreator {
    Employee createEmployee(String name,String birthDate,
                            String adoptionDate);
    static Employee getEmployee(String name,
                                        String birthDate,
                                        String adoptionDate,
                                        EmployeeType type){
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
}
