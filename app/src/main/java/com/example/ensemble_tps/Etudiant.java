package com.example.ensemble_tps;

public class Etudiant extends Personne {
    private int annee;
    private String matiere;
    private double moyenne;
    public Etudiant() {
        super();
        this.annee = 0;
        this.matiere = "";
        this.moyenne = 0.0;
    }
    public Etudiant(String prenom, String nom, String eMail,int annee, String matiere, double moyenne) {
        super(prenom, nom, eMail);
        this.annee = annee;
        this.matiere = matiere;
        this.moyenne = moyenne;
    }
    public int getAnnee() {
        return annee;
    }
    public String getMatiere() {
        return matiere;
    }
    public double getMoyenne() {
        return moyenne;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Année : " + annee + "\n" +
                "Matière : " + matiere + "\n" +
                "Moyenne : " + moyenne;
    }
}