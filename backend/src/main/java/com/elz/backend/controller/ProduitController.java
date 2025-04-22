package com.elz.backend.controller;

import com.elz.backend.Exceptions.PreduitAlreadyExistException;
import com.elz.backend.Exceptions.ProduitNotFoundException;
import com.elz.backend.dto.ProduitDto;
import com.elz.backend.services.ProduitService;
import com.elz.backend.services.servicesImpl.ProduitServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/produit")
public class ProduitController {
    private final ProduitService produitService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProduitDto> createProduit(@RequestBody ProduitDto produitDto) throws PreduitAlreadyExistException {
       ProduitDto produitSaved=  produitService.createProduit(produitDto);
       return ResponseEntity.status(HttpStatus.CREATED).body(produitSaved);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProduitDto> getProduitById(@PathVariable Long id) throws ProduitNotFoundException {
        ProduitDto produitDto=produitService.getProduitById(id);
        return ResponseEntity.ok(produitDto);
    }

    @GetMapping(path = "/code")
    public ResponseEntity<ProduitDto> getProduitByCode(@RequestParam String code) throws ProduitNotFoundException {
        ProduitDto produitDto=produitService.getProduitByCode(code);
        return ResponseEntity.ok(produitDto);
    }

//    @GetMapping(path = "/search")
//    public ResponseEntity<List<ProduitDto>> rechercheProduit(@RequestParam(name = "code",defaultValue = "") String keyword){
//        List<ProduitDto> produitDtoList=produitService.searchProduit("%"+keyword+"%");
//        return ResponseEntity.ok(produitDtoList);
//    }

    @GetMapping
    public ResponseEntity<List<ProduitDto>> findAllProduit(){
        List<ProduitDto> produitDtoList=produitService.getAllProduit();
        return ResponseEntity.ok(produitDtoList);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProduitDto> updateProduit(@PathVariable Long id,@RequestBody ProduitDto produitDto) throws PreduitAlreadyExistException, ProduitNotFoundException {
        ProduitDto produitDto1=produitService.updateproduit(id,produitDto);
        return ResponseEntity.ok(produitDto1);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePorduitById(@PathVariable Long id) throws ProduitNotFoundException {
         produitService.deleteProduitById(id);
    }
}
