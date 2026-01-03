package org.informatica.service;

import org.informatica.entity.Transport;
import java.util.List;

public interface TransportService {
    void create(Transport transport);
    List<Transport> findAll();
    void markAsPaid(int id);
    double getCompanyRevenue(int companyId);
    List<Transport> findAllSortedByDestination();
    void exportTransportsToFile(String filePath);
    void importTransportsFromFile(String filePath);
    int getTotalTransportCount();
    double getTotalPaidRevenue();

}
