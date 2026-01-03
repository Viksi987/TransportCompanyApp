package org.informatica.service;

import org.informatica.entity.Employee;
import java.util.List;

public interface EmployeeService {

    void create(Employee employee);

    List<Employee> findAll();

    void delete(int id);

    List<Employee> findByQualification(String qualification);

    List<Employee> findAllSortedBySalary(boolean ascending);
}
