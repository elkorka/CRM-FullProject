package com.elz.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Data
@Builder
public class ClientDto {
    private int idClient;

    private String nom;

    private String prenom;

    private String email;

    private String telephone;
    private String adresse;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
