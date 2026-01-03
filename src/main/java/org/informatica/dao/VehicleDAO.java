package org.informatica.dao;

import org.informatica.entity.Vehicle;
import java.util.List;

public interface VehicleDAO {
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    void deleteVehicle(int id);
}
