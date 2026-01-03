package org.informatica.service;

import org.informatica.dao.VehicleDAO;
import org.informatica.dao.VehicleDAOImpl;
import org.informatica.entity.Vehicle;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {

    private final VehicleDAO dao = new VehicleDAOImpl();

    @Override
    public void create(Vehicle vehicle) {

        if (vehicle.getRegistrationNumber() == null ||
                vehicle.getRegistrationNumber().isBlank()) {
            throw new IllegalArgumentException("Регистрационният номер е задължителен");
        }

        if (vehicle.getCompanyId() <= 0) {
            throw new IllegalArgumentException("Невалиден Company ID");
        }

        dao.addVehicle(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return dao.getAllVehicles();
    }

    @Override
    public void delete(int id) {
        dao.deleteVehicle(id);
    }
}
