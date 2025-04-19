package com.elz.backend.repository;

import com.elz.backend.dto.ProduitDto;
import com.elz.backend.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {

    Produit findByNom(String nom);
    Produit findByCode(String code);

//    @Query("SELECT p FROM produit p WHERE p.nom LIKE :kw")
//    List<Produit> searchProduit(@Param(value = "kw") String keyword);

}
