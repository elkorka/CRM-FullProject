package com.elz.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProduitDto {
    private Long idProduit;
    @NotBlank(message = "Un nom de produit est obligatoire")
    @Size(min = 1,max = 50,message = "Le nom du produit doit contenir entre 1 et 50 caractères")
    private String nom;

    @NotBlank(message = "le code nest obligatoire et doit etre unique")
    @Size(min =1 ,max = 15,message = "Le code doit avoir au maximun 15 caractéres")
    private String code;

    @NotBlank(message = "Le prix est obligatoire")
    private double prix;

    @Size(min = 0,max = 150,message = "La description doit avoir au maximun 150 caractéres")
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
