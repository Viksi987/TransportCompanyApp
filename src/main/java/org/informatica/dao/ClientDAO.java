package org.informatica.dao;

import org.informatica.entity.Client;
import java.util.List;

public interface ClientDAO {
    void addClient(Client client);
    List<Client> getAllClients();
    void deleteClient(int id);
}
