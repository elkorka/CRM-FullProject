package com.elz.backend.services;

import com.elz.backend.Exceptions.ClientNotFoundException;
import com.elz.backend.dto.ClientDto;

import java.util.List;

public interface ClientService {
    void createClient(ClientDto clientDto);
    ClientDto getClientById(Integer id) throws ClientNotFoundException;
    List<ClientDto> getAllClient();
    void updateClient(int id,ClientDto clientDto);
    void deleteClientById(Integer id) throws ClientNotFoundException;

}
