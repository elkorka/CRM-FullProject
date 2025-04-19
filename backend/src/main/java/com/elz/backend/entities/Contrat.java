package com.elz.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContrat")
    private Long idContrat;
    @OneToOne
    private Client client;
    @OneToOne
    private Produit produit;
    private Date dateSignature;
    private double montant;
    //like date updated
    private Date dateExpiration;
    private String pJointe;
}
