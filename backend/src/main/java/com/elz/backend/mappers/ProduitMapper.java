package com.elz.backend.mappers;

import com.elz.backend.dto.ProduitDto;
import com.elz.backend.entities.Produit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    Produit mapToEntity(ProduitDto produitDto);
    ProduitDto maptoDTO(Produit produit);

    List<Produit> mapToListEntity(List<ProduitDto> produitDtoList);
    List<ProduitDto> mapToListDTO(List<Produit> produitList);
}
