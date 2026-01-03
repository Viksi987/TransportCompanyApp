package org.informatica.entity;

public class Vehicle {

    private int id;
    private String type;            // BUS, TRUCK, TANKER
    private String registrationNumber;
    private double capacity;
    private int companyId;

    public Vehicle() {
    }

    // За INSERT
    public Vehicle(String type, String registrationNumber, double capacity, int companyId) {
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
        this.companyId = companyId;
    }

    // За SELECT
    public Vehicle(int id, String type, String registrationNumber, double capacity, int companyId) {
        this.id = id;
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", capacity=" + capacity +
                ", companyId=" + companyId +
                '}';
    }
}
