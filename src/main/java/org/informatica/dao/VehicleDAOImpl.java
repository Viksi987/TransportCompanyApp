package org.informatica.dao;

import org.informatica.config.DBConnection;
import org.informatica.entity.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {

    @Override
    public void addVehicle(Vehicle vehicle) {
        String sql = """
            INSERT INTO vehicle (type, registration_number, capacity, company_id)
            VALUES (?, ?, ?, ?)
            """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, vehicle.getType());
            ps.setString(2, vehicle.getRegistrationNumber());
            ps.setDouble(3, vehicle.getCapacity());
            ps.setInt(4, vehicle.getCompanyId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicle";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                vehicles.add(new Vehicle(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("registration_number"),
                        rs.getDouble("capacity"),
                        rs.getInt("company_id")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public void deleteVehicle(int id) {
        String sql = "DELETE FROM vehicle WHERE id=?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
