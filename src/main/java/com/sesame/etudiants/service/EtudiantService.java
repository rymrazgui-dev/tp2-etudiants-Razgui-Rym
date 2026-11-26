package com.sesame.etudiants.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sesame.etudiants.model.Etudiant;
import com.sesame.etudiants.repository.EtudiantRepository;

/**
 * Couche metier : regles de gestion, appelle le repository.
 */
@Service
public class EtudiantService {

    private final EtudiantRepository repository;

    // Injection de dependance par le constructeur
    public EtudiantService(EtudiantRepository repository) {
        this.repository = repository;
    }

    public List<Etudiant> lister() {
        return repository.findAll();
    }

    public Etudiant trouver(Long id) {
        return repository.findById(id);
    }

    public List<Etudiant> rechercherParFiliere(String filiere) {
        return repository.findByFiliere(filiere);
    }

    public Etudiant creer(Etudiant etudiant) {
        if (etudiant.getNom() == null || etudiant.getNom().isBlank()) {
            throw new IllegalArgumentException("Le nom ne doit pas etre vide");
        }
        if (etudiant.getEmail() == null || etudiant.getEmail().isBlank()) {
            throw new IllegalArgumentException("L'email ne doit pas etre vide");
        }
        return repository.save(etudiant);
    }

    public boolean supprimer(Long id) {
        return repository.deleteById(id);
    }
}
