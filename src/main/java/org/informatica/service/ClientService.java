package org.informatica.service;

import org.informatica.entity.Client;
import java.util.List;

public interface ClientService {
    void create(Client client);
    List<Client> findAll();
    void delete(int id);
}
