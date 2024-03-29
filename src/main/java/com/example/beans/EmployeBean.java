package com.example.beans;

import com.example.dao.EmployeDAO;
import com.example.model.Employe;
import com.example.model.Post;
import com.example.model.Projet;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class EmployeBean implements Serializable {

    private EmployeDAO employeDAO;
    private List<Employe> employes;
    private Employe nouvelEmploye;

    // Ajout des champs pour le nom de l'employé et du projet
    private String nomEmploye;
    private String nomProjet;

    @PostConstruct
    public void init() {
        employeDAO = new EmployeDAO();
        employes = employeDAO.listerEmployes();
        nouvelEmploye = new Employe();
    }

    public void ajouterEmploye() {
        employeDAO.ajouterEmploye(nouvelEmploye);
        employes.add(nouvelEmploye);
        nouvelEmploye = new Employe(); // Réinitialiser pour un nouvel ajout
    }

    public void supprimerEmploye(Long employeId) {
        employeDAO.supprimerEmploye(employeId);
        employes.removeIf(e -> e.getId().equals(employeId));
    }

    public void modifierEmploye(Employe employe) {
        employeDAO.modifierEmploye(employe);
    }

    // Getters et Setters

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public Employe getNouvelEmploye() {
        return nouvelEmploye;
    }

    public void setNouvelEmploye(Employe nouvelEmploye) {
        this.nouvelEmploye = nouvelEmploye;
    }

    // Getter et Setter pour le nom de l'employé
    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    // Getter et Setter pour le nom du projet
    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }
}
