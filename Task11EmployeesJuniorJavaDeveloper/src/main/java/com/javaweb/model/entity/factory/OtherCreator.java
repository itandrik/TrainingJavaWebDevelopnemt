package com.javaweb.model.entity.factory;

import com.javaweb.model.entity.Employee;
import com.javaweb.model.entity.OtherEmployee;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public class OtherCreator implements EmployeeCreator{

    @Override
    public Employee createEmployee(String name,String birthDate,
                                   String adoptionDate) {
        return new OtherEmployee(name,birthDate,adoptionDate);
    }
}
