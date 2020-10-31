/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

/**
 *
 * @author LAutodidacte
 */
public class Client {

    private int soldeCompte;
    private String nom;

    public Client() {
    }

    public Client(int soldeCompte, String nom) {
        this.soldeCompte = soldeCompte;
        this.nom = nom;
    }

    public int getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(int soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
