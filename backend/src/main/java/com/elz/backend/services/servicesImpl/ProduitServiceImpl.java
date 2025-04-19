package com.elz.backend.services.servicesImpl;

import com.elz.backend.Exceptions.PreduitAlreadyExistException;
import com.elz.backend.Exceptions.ProduitNotFoundException;
import com.elz.backend.dto.ProduitDto;
import com.elz.backend.entities.Produit;
import com.elz.backend.mappers.ProduitMapper;
import com.elz.backend.repository.ProduitRepository;
import com.elz.backend.services.ProduitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    @Override
    public ProduitDto createProduit(ProduitDto produitDto) throws PreduitAlreadyExistException {

        Produit produitExistant= produitRepository.findByNom(produitDto.getNom());
        if (produitExistant!=null){
            throw new PreduitAlreadyExistException("Un produit avec ce nom existe déja ");
        }
        log.info("GetNom produitDTO : {} ",produitDto.getNom());
        Produit nouveauProduit=produitMapper.mapToEntity(produitDto);
        Produit produitSaved=produitRepository.save(nouveauProduit);
        log.info("Nouveau produit créer : {} ",produitSaved.getNom());

        return produitMapper.maptoDTO(produitSaved);
    }

    @Override
    public ProduitDto getProduitById(Long id) throws ProduitNotFoundException {
        Produit produit=produitRepository.findById(id)
                .orElseThrow( ()-> new ProduitNotFoundException("Aucun produit trouvé avec cet ID "+id));
        return produitMapper.maptoDTO(produit);
    }

    @Override
    public ProduitDto getProduitByCode(String code) throws ProduitNotFoundException {
        Produit produitDansBdd=produitRepository.findByCode(code);
        if (produitDansBdd==null){
            throw new ProduitNotFoundException("Aucun produit trouvé avec ce code "+code);
        }
        return produitMapper.maptoDTO(produitDansBdd);
    }

    @Override
    public ProduitDto getProduitByNom(String nom) throws ProduitNotFoundException {
        Produit produit=produitRepository.findByNom(nom);
        if (produit==null){
            log.info("");
            throw new ProduitNotFoundException("Aucun produit trouvé avec cet nom");
        }
        return produitMapper.maptoDTO(produit);
    }

//    @Override
//    public List<ProduitDto> searchProduit(String keyword) {
//        List<Produit> produitDtoList=produitRepository.searchProduit(keyword);
//        if (produitDtoList.isEmpty()){
//            log.info("Aucun produit trouvé avec ce nom");
//            return List.of();
//        }
//        return produitMapper.mapToListDTO(produitDtoList);
//    }

    @Override
    public List<ProduitDto> getAllProduit() {
        List<Produit> produitList=produitRepository.findAll();
        if (produitList.isEmpty()){
            log.info("Aucun produit trouvé avec ce nom");
            return List.of();
        }
        return produitMapper.mapToListDTO(produitList);
    }

    @Override
    public ProduitDto updateproduit(Long id, ProduitDto produitDto) throws ProduitNotFoundException, PreduitAlreadyExistException {
        Produit produitExistant=produitRepository.findById(id)
                .orElseThrow(()->new ProduitNotFoundException("Aucun produit trouvé avec cet ID "+id));

        produitExistant.setPrix(produitDto.getPrix());
        produitExistant.setDescription(produitDto.getDescription());

        //Verifier si le nom a changé et que le nouveau nom n'existe pas pour duplication
        if (!produitExistant.getNom().equals(produitDto.getNom())){
            Produit produitAvecNom=produitRepository.findByNom(produitDto.getNom());
            if (produitAvecNom!=null){
                throw new PreduitAlreadyExistException("Nom produit déja existant : "+produitDto.getNom());
            }
            produitExistant.setNom(produitDto.getNom());
        }
        produitExistant.setUpdatedAt(LocalDateTime.now());

        Produit produitmodifier=produitRepository.save(produitExistant);

        return produitMapper.maptoDTO(produitmodifier);
    }

    @Override
    public void deleteProduitById(Long id) throws ProduitNotFoundException {
        Produit produitExistant=produitRepository.findById(id)
                .orElseThrow(()->new ProduitNotFoundException("Aucun produit trouvé avec cet ID"));

        produitRepository.deleteById(id);
        log.info("Produit supprimé avec succés : {}",produitExistant.getNom());
    }
}
