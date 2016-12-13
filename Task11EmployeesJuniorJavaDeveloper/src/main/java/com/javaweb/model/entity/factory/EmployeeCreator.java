package com.javaweb.model.entity.factory;

import com.javaweb.model.entity.Employee;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public interface EmployeeCreator {
    Employee createEmployee(String name,String birthDate,
                            String adoptionDate);
}
