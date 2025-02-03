package com.elz.backend.services.servicesImpl;

import com.elz.backend.Exceptions.ClientNotFoundException;
import com.elz.backend.dto.ClientDto;
import com.elz.backend.entities.Client;
import com.elz.backend.mappers.ClientMapper;
import com.elz.backend.repository.ClientRepository;
import com.elz.backend.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    @Override
    public void createClient(ClientDto clientDto) {


        Optional<Client> clientDansleBD=clientRepository.findByEmail(clientDto.getEmail());

        if (clientDansleBD.isEmpty()){
            log.info("Création d'un nouveau client : {}" , clientDto);
            clientRepository.save(clientMapper.mapToClientEntity(clientDto));
        }
    }

    @Override
    public ClientDto getClientById(Integer id) throws ClientNotFoundException {

        Client client = this.clientRepository.findById(id).orElse(null);
        //log.info("Client Id is null");
        if (client==null) throw new ClientNotFoundException("Client not Found");
        ClientDto clientDto=clientMapper.mapToClientDto(client);

        return Optional.of(clientDto).orElseThrow(
                ()-> new ClientNotFoundException("Aucun cllient n'existe avec ce id")
        );

    }

    @Override
    public List<ClientDto> getAllClient() {
        List<Client> clientList =this.clientRepository.findAll();
        if (clientList.isEmpty()){
            log.info("Liste client vide");
            return null;
        }
        return clientMapper.mapToListClientDto(clientList);

    }

    @Override
    public void updateClient(int id,ClientDto clientDto) {
        Optional<Client> clientDansBdd= clientRepository.findById(id);
        if (clientDansBdd.isPresent()){
            if (clientDansBdd.get().getIdClient()==clientDto.getIdClient()){
                clientDansBdd.get().setAdresse(clientDto.getAdresse());
                clientDansBdd.get().setNom(clientDto.getNom());
                clientDansBdd.get().setPrenom(clientDto.getPrenom());
                clientDansBdd.get().setEmail(clientDto.getEmail());
                clientDansBdd.get().setTelephone(clientDto.getTelephone());
                clientDansBdd.get().setUpdatedAt(LocalDateTime.now());
                clientRepository.save(clientDansBdd.get());

            }
        }

    }

    @Override
    public void deleteClientById(Integer id) throws ClientNotFoundException {
        Client client = this.clientRepository.findById(id).orElse(null);
        log.info("Suppression Client ");
        if (client==null) throw new ClientNotFoundException("Client not Found");
        this.clientRepository.deleteById(id);
    }


}
