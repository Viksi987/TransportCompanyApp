package org.informatica.entity;

import java.time.LocalDate;

public class Transport {

    private int id;
    private String startPoint;
    private String endPoint;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String cargoType; // GOODS / PASSENGERS
    private Double cargoWeight;
    private double price;
    private boolean paid;

    private int clientId;
    private int driverId;
    private int vehicleId;
    private int companyId;

    public Transport(String startPoint, String endPoint,
                     LocalDate departureDate, LocalDate arrivalDate,
                     String cargoType, Double cargoWeight,
                     double price,
                     int clientId, int driverId, int vehicleId, int companyId) {

        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
        this.price = price;
        this.paid = false;
        this.clientId = clientId;
        this.driverId = driverId;
        this.vehicleId = vehicleId;
        this.companyId = companyId;
    }
    public Transport(int id, String startPoint, String endPoint,
                     LocalDate departureDate, LocalDate arrivalDate,
                     String cargoType, Double cargoWeight,
                     double price, boolean paid,
                     int clientId, int driverId, int vehicleId, int companyId) {

        this.id = id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
        this.price = price;
        this.paid = paid;
        this.clientId = clientId;
        this.driverId = driverId;
        this.vehicleId = vehicleId;
        this.companyId = companyId;
    }

    public String getStartPoint() { return startPoint; }
    public String getEndPoint() { return endPoint; }
    public LocalDate getDepartureDate() { return departureDate; }
    public LocalDate getArrivalDate() { return arrivalDate; }
    public String getCargoType() { return cargoType; }
    public Double getCargoWeight() { return cargoWeight; }
    public double getPrice() { return price; }
    public boolean isPaid() { return paid; }
    public int getClientId() { return clientId; }
    public int getDriverId() { return driverId; }
    public int getVehicleId() { return vehicleId; }
    public int getCompanyId() { return companyId; }


    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", " + startPoint + " -> " + endPoint +
                ", price=" + price +
                ", paid=" + paid +
                '}';
    }
}
