package org.informatica.service;

import org.informatica.dao.TransportDAO;
import org.informatica.dao.TransportDAOImpl;
import org.informatica.entity.Transport;

import java.util.List;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class TransportServiceImpl implements TransportService {

    private final TransportDAO dao = new TransportDAOImpl();

    @Override
    public void create(Transport transport) {
        if (transport.getPrice() <= 0) {
            throw new IllegalArgumentException("Цената трябва да е положителна");
        }
        dao.addTransport(transport);
    }

    @Override
    public List<Transport> findAll() {
        return dao.getAllTransports();
    }

    @Override
    public void markAsPaid(int id) {
        dao.markAsPaid(id);
    }
    @Override
    public double getCompanyRevenue(int companyId) {
        return dao.getCompanyRevenue(companyId);
    }
    @Override
    public List<Transport> findAllSortedByDestination() {
        return dao.getAllTransports().stream()
                .sorted(Comparator.comparing(Transport::getEndPoint,
                        String.CASE_INSENSITIVE_ORDER))
                .toList();
    }
    @Override
    public void exportTransportsToFile(String filePath) {
        List<Transport> transports = dao.getAllTransports();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Transport t : transports) {
                writer.write(t.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void importTransportsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Превози от файл:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getTotalTransportCount() {
        return dao.countAllTransports();
    }
    @Override
    public double getTotalPaidRevenue() {
        return dao.getTotalPaidRevenue();
    }

}
