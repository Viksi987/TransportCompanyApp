package org.informatica.service;

import org.informatica.dao.EmployeeDAO;
import org.informatica.dao.EmployeeDAOImpl;
import org.informatica.entity.Employee;

import java.util.List;
import java.util.Comparator;


public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO dao = new EmployeeDAOImpl();

    @Override
    public void create(Employee employee) {

        if (employee.getName() == null || employee.getName().isBlank()) {
            throw new IllegalArgumentException("Името е задължително");
        }

        if (employee.getSalary() <= 0) {
            throw new IllegalArgumentException("Заплатата трябва да е положителна");
        }

        dao.addEmployee(employee);
    }

    @Override
    public List<Employee> findAll() {
        return dao.getAllEmployees();
    }

    @Override
    public void delete(int id) {
        dao.deleteEmployee(id);
    }
    @Override
    public List<Employee> findByQualification(String qualification) {
        return dao.getAllEmployees().stream()
                .filter(e -> e.getQualification().equalsIgnoreCase(qualification))
                .toList();
    }
    @Override
    public List<Employee> findAllSortedBySalary(boolean ascending) {

        if (ascending) {
            return dao.getAllEmployees().stream()
                    .sorted(Comparator.comparingDouble(Employee::getSalary))
                    .toList();
        } else {
            return dao.getAllEmployees().stream()
                    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                    .toList();
        }
    }

}


