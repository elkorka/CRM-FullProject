package com.elz.backend.entities;

import java.util.Date;

public class Contrat {
    private int idProduit;
    private Client client;
    private Produit produit;
    private Date dateSignature;
    private float montant;
    //like date updated
    private Date dateExpiration;
    private String pJointe;
}
