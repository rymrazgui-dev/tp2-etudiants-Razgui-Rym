package com.sesame.etudiants.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sesame.etudiants.model.Etudiant;
import com.sesame.etudiants.service.EtudiantService;


@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService service;

    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    @GetMapping
    public List<Etudiant> lister(@RequestParam(required = false) String filiere) {
        if (filiere != null && !filiere.isBlank()) {
            return service.rechercherParFiliere(filiere);
        }
        return service.lister();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> lire(@PathVariable Long id) {
        Etudiant e = service.trouver(id);
        if (e == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(e);
    }


    @PostMapping
    public ResponseEntity<Etudiant> creer(@RequestBody Etudiant etudiant) {
        Etudiant cree = service.creer(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body(cree);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (!service.supprimer(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> erreurValidation(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
