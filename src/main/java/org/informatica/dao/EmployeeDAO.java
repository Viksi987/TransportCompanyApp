package org.informatica.dao;

import org.informatica.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    void deleteEmployee(int id);
}
