package org.informatica.service;

import org.informatica.dao.ClientDAO;
import org.informatica.dao.ClientDAOImpl;
import org.informatica.entity.Client;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private final ClientDAO dao = new ClientDAOImpl();

    @Override
    public void create(Client client) {
        if (client.getName() == null || client.getName().isBlank()) {
            throw new IllegalArgumentException("Името е задължително");
        }

        if (client.getCompanyId() <= 0) {
            throw new IllegalArgumentException("Невалиден Company ID");
        }
        dao.addClient(client);
    }

    @Override
    public List<Client> findAll() {
        return dao.getAllClients();
    }

    @Override
    public void delete(int id) {
        dao.deleteClient(id);
    }
}
