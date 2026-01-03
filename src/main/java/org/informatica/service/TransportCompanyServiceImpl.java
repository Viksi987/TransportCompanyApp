package org.informatica.service;

import org.informatica.dao.TransportCompanyDAO;
import org.informatica.dao.TransportCompanyDAOImpl;
import org.informatica.entity.TransportCompany;

import java.util.List;

public class TransportCompanyServiceImpl implements TransportCompanyService {

    private final TransportCompanyDAO companyDAO =
            new TransportCompanyDAOImpl();

    @Override
    public void createCompany(TransportCompany company) {

        if (company.getName() == null || company.getName().isBlank()) {
            throw new IllegalArgumentException("Името на компанията е задължително!");
        }

        if (company.getPhone() == null || company.getPhone().isBlank()) {
            throw new IllegalArgumentException("Телефонът е задължителен!");
        }

        companyDAO.addCompany(company);
    }

    @Override
    public TransportCompany findById(int id) {
        return companyDAO.getCompanyById(id);
    }

    @Override
    public List<TransportCompany> findAll() {
        return companyDAO.getAllCompanies();
    }

    @Override
    public void updateCompany(TransportCompany company) {
        companyDAO.updateCompany(company);
    }

    @Override
    public void deleteCompany(int id) {
        companyDAO.deleteCompany(id);
    }
}
