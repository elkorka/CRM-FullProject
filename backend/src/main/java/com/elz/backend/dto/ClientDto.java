package com.elz.backend.dto;

import com.elz.backend.entities.Client;
import lombok.*;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ClientDto {
    private int idClient;

    private String nom;

    private String prenom;

    private String email;

    private String telephone;
    private String adresse;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

   /* public ClientDto mapToDto(Client client){
        if (client==null){
            return null;
            //throw exception
        }
        ClientDto c =new ClientDto();
        c.setIdClient(client.getIdClient());
        c.setNom(client.getNom());
        c.setPrenom(client.getPrenom());
        c.setAdresse(client.getAdresse());
        c.setEmail(client.getEmail());
        c.setTelephone(client.getTelephone());
        c.setUpdatedAt(client.getUpdatedAt());
        c.setCreatedAt(client.getCreatedAt());

        return c;
    }

    public Client mapToEntity(ClientDto clientDto){
        Client c=new Client();
        if (clientDto==null){
            return null;
            //throw exception
        }
        Client ce =new Client();
        ce.setNom(clientDto.getNom());
        ce.setPrenom(clientDto.getPrenom());
        ce.setAdresse(clientDto.getAdresse());
        ce.setEmail(clientDto.getEmail());
        ce.setTelephone(clientDto.getTelephone());
        ce.setUpdatedAt(clientDto.getUpdatedAt());
        ce.setCreatedAt(clientDto.getCreatedAt());

        return ce;
    }
*/
}
