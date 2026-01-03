package org.informatica.dao;

import org.informatica.config.DBConnection;
import org.informatica.entity.Transport;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransportDAOImpl implements TransportDAO {

    @Override
    public void addTransport(Transport t) {

        String sql = """
            INSERT INTO transport
            (start_point, end_point, departure_date, arrival_date,
             cargo_type, cargo_weight, price, paid,
             client_id, driver_id, vehicle_id, company_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, t.getStartPoint());
            ps.setString(2, t.getEndPoint());
            ps.setDate(3, Date.valueOf(t.getDepartureDate()));
            ps.setDate(4, Date.valueOf(t.getArrivalDate()));
            ps.setString(5, t.getCargoType());
            ps.setObject(6, t.getCargoWeight());
            ps.setDouble(7, t.getPrice());
            ps.setBoolean(8, t.isPaid());
            ps.setInt(9, t.getClientId());
            ps.setInt(10, t.getDriverId());
            ps.setInt(11, t.getVehicleId());
            ps.setInt(12, t.getCompanyId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transport> getAllTransports() {
        List<Transport> list = new ArrayList<>();

        String sql = "SELECT * FROM transport";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Transport t = new Transport(
                        rs.getInt("id"),
                        rs.getString("start_point"),
                        rs.getString("end_point"),
                        rs.getDate("departure_date").toLocalDate(),
                        rs.getDate("arrival_date").toLocalDate(),
                        rs.getString("cargo_type"),
                        rs.getDouble("cargo_weight"),
                        rs.getDouble("price"),
                        rs.getBoolean("paid"),   // ⬅⬅⬅ КЛЮЧОВИЯ РЕД
                        rs.getInt("client_id"),
                        rs.getInt("driver_id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("company_id")
                );
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void markAsPaid(int transportId) {
        String sql = "UPDATE transport SET paid = 1 WHERE id = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, transportId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public double getCompanyRevenue(int companyId) {

        String sql = """
        SELECT SUM(price)
        FROM transport
        WHERE company_id = ? AND paid = 1
    """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, companyId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    @Override
    public int countAllTransports() {
        String sql = "SELECT COUNT(*) FROM transport";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public double getTotalPaidRevenue() {
        String sql = "SELECT SUM(price) FROM transport WHERE paid = 1";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
