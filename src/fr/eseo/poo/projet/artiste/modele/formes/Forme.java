package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coloriable;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.awt.Color;

public abstract class Forme implements Coloriable {

    public static final double HAUTEUR_PAR_DEFAUT = 20.0;
    public static final double LARGEUR_PAR_DEFAUT = 20.0;
    public static final Color COULEUR_PAR_DEFAUT = javax.swing.UIManager.getColor("Panel.foreground");

    private Coordonnees position;
    private double hauteur;
    private double largeur;
    private Color couleur;

    public Forme () {
        this.position = new Coordonnees();
        this.hauteur = HAUTEUR_PAR_DEFAUT;
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.couleur = COULEUR_PAR_DEFAUT;
    }

    public Forme (Coordonnees position) {
        this.position = position;
        this.hauteur = HAUTEUR_PAR_DEFAUT;
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.couleur = COULEUR_PAR_DEFAUT;
    }

    public Forme (double largeur, double hauteur) {
        this.position = new Coordonnees();
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.couleur = COULEUR_PAR_DEFAUT;
    }

    public Forme (Coordonnees position, double largeur, double hauteur) {
        this.position = position;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.couleur = COULEUR_PAR_DEFAUT;
    }

    public Coordonnees getPosition() {
        return position;
    }

    public void setPosition(Coordonnees position) {
        this.position = position;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public void deplacerDe (double deltaX, double deltaY) {
        this.position.deplacerDe(deltaX, deltaY);
    }

    public void deplacerVers (double newX, double newY) {
        this.position.deplacerVers(newX, newY);
    }

    public double getCadreMinX (){
        return Math.min(this.getPosition().getAbscisse()+this.getLargeur(),this.getPosition().getAbscisse());
    }

    public double getCadreMaxY (){
        return Math.max(this.getPosition().getOrdonnee()+this.getHauteur(),this.getPosition().getOrdonnee());
    }

    public double getCadreMaxX () {
        return Math.max(this.getPosition().getAbscisse()+this.getLargeur(),this.getPosition().getAbscisse());
    }

    public double getCadreMinY () {
        return Math.min(this.getPosition().getOrdonnee()+this.getHauteur(),this.getPosition().getOrdonnee());
    }

    public abstract double aire();

    public abstract double perimetre();

    public abstract boolean contient(Coordonnees point);

    @Override
    public Color getCouleur() {
        return couleur;
    }

    @Override
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
