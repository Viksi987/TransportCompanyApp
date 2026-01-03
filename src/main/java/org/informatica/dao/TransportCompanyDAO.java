package org.informatica.dao;

import org.informatica.entity.TransportCompany;

import java.util.List;

public interface TransportCompanyDAO {

    void addCompany(TransportCompany company);

    TransportCompany getCompanyById(int id);

    List<TransportCompany> getAllCompanies();

    void updateCompany(TransportCompany company);

    void deleteCompany(int id);
}
