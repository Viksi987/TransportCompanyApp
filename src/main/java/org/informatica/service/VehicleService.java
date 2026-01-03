package org.informatica.service;

import org.informatica.entity.Vehicle;
import java.util.List;

public interface VehicleService {
    void create(Vehicle vehicle);
    List<Vehicle> findAll();
    void delete(int id);
}
