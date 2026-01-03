package org.informatica.service;

import org.informatica.entity.TransportCompany;

import java.util.List;

public interface TransportCompanyService {

    void createCompany(TransportCompany company);

    TransportCompany findById(int id);

    List<TransportCompany> findAll();

    void updateCompany(TransportCompany company);

    void deleteCompany(int id);
}
