package com.sesame.etudiants.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sesame.etudiants.model.Etudiant;

/**
 * Couche d'acces aux donnees : les etudiants sont gardes en memoire.
 */
@Repository
public class EtudiantRepository {

    private final List<Etudiant> etudiants = new ArrayList<>();

    // Prochain identifiant a attribuer (1 a 3 sont pris par les etudiants de depart)
    private long compteur = 4;

    public EtudiantRepository() {
        etudiants.add(new Etudiant(1L, "Amine", "amine@sesame.tn", "Informatique"));
        etudiants.add(new Etudiant(2L, "Yasmine", "yasmine@sesame.tn", "Informatique"));
        etudiants.add(new Etudiant(3L, "Karim", "karim@sesame.tn", "Gestion"));
    }

    public List<Etudiant> findAll() {
        return new ArrayList<>(etudiants);
    }

    // Retourne l'etudiant ou null s'il n'existe pas
    public Etudiant findById(Long id) {
        for (Etudiant e : etudiants) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public List<Etudiant> findByFiliere(String filiere) {
        List<Etudiant> resultat = new ArrayList<>();
        for (Etudiant e : etudiants) {
            if (e.getFiliere() != null && e.getFiliere().equalsIgnoreCase(filiere)) {
                resultat.add(e);
            }
        }
        return resultat;
    }

    // Attribue l'identifiant puis enregistre l'etudiant
    public Etudiant save(Etudiant etudiant) {
        etudiant.setId(compteur++);
        etudiants.add(etudiant);
        return etudiant;
    }

    // Retourne true si l'etudiant existait
    public boolean deleteById(Long id) {
        Etudiant e = findById(id);
        if (e == null) {
            return false;
        }
        etudiants.remove(e);
        return true;
    }
}
