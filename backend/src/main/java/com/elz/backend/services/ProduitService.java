package com.elz.backend.services;

import com.elz.backend.Exceptions.PreduitAlreadyExistException;
import com.elz.backend.Exceptions.ProduitNotFoundException;
import com.elz.backend.dto.ProduitDto;

import java.util.List;

public interface ProduitService {

    ProduitDto createProduit(ProduitDto produitDto) throws PreduitAlreadyExistException;
    ProduitDto getProduitById(Long id) throws ProduitNotFoundException;
    ProduitDto getProduitByCode(String code) throws ProduitNotFoundException;
    ProduitDto getProduitByNom(String code) throws ProduitNotFoundException;
//    List<ProduitDto> searchProduit(String keyword);
    List<ProduitDto> getAllProduit();
    ProduitDto updateproduit(Long id, ProduitDto produitDto) throws ProduitNotFoundException, PreduitAlreadyExistException;
    void deleteProduitById(Long id) throws ProduitNotFoundException;
}
