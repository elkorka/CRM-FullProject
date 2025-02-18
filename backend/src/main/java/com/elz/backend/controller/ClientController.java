package com.elz.backend.controller;

import com.elz.backend.Exceptions.ClientNotFoundException;
import com.elz.backend.dto.ClientDto;
import com.elz.backend.entities.Client;
import com.elz.backend.services.servicesImpl.ClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/client")
@Slf4j
public class ClientController {

    private final ClientServiceImpl clientServiceImpl;

    public ClientController(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto client) {

            clientServiceImpl.createClient(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ClientDto getClientById(@PathVariable Integer id ) throws ClientNotFoundException {
        return clientServiceImpl.getClientById(id);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDto>> getAllClient(){
        return ResponseEntity.ok(this.clientServiceImpl.getAllClient());
    }

    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void updateClient(@PathVariable Integer id, @RequestBody ClientDto clientDto){
        this.clientServiceImpl.updateClient(id,clientDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteClientById(@PathVariable Integer id) throws ClientNotFoundException {
        this.clientServiceImpl.deleteClientById(id);
    }

}
