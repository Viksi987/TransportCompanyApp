package org.informatica.entity;

public class Employee {

    private int id;
    private String name;
    private String position;        // DRIVER, MANAGER
    private double salary;
    private String qualification;   // SPECIAL_CARGO, PASSENGERS_12_PLUS
    private int companyId;

    public Employee() {
    }

    public Employee(String name, String position, double salary,
                    String qualification, int companyId) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.qualification = qualification;
        this.companyId = companyId;
    }

    public Employee(int id, String name, String position, double salary,
                    String qualification, int companyId) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.qualification = qualification;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", qualification='" + qualification + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
