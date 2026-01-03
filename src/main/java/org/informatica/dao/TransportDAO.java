package org.informatica.dao;

import org.informatica.entity.Transport;
import java.util.List;

public interface TransportDAO {
    void addTransport(Transport transport);
    List<Transport> getAllTransports();
    void markAsPaid(int transportId);
    double getCompanyRevenue(int companyId);
    int countAllTransports();
    double getTotalPaidRevenue();

}
