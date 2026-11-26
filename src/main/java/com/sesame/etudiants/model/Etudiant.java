package com.sesame.etudiants.model;

public class Etudiant {

    private Long id;
    private String nom;
    private String email;
    private String filiere;

    public Etudiant() {
    }

    public Etudiant(Long id, String nom, String email, String filiere) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.filiere = filiere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
}
