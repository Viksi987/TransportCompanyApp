package org.informatica.dao;

import org.informatica.config.DBConnection;
import org.informatica.entity.TransportCompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransportCompanyDAOImpl implements TransportCompanyDAO {

    @Override
    public void addCompany(TransportCompany company) {
        String sql = "INSERT INTO transport_company (name, address, phone) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, company.getName());
            stmt.setString(2, company.getAddress());
            stmt.setString(3, company.getPhone());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public TransportCompany getCompanyById(int id) {
        String sql = "SELECT * FROM transport_company WHERE id = ?";
        TransportCompany company = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                company = new TransportCompany(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public List<TransportCompany> getAllCompanies() {
        List<TransportCompany> companies = new ArrayList<>();
        String sql = "SELECT * FROM transport_company";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                companies.add(new TransportCompany(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public void updateCompany(TransportCompany company) {
        String sql = "UPDATE transport_company SET name=?, address=?, phone=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, company.getName());
            stmt.setString(2, company.getAddress());
            stmt.setString(3, company.getPhone());
            stmt.setInt(4, company.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompany(int id) {
        String sql = "DELETE FROM transport_company WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
