package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Rectangle extends Forme implements Remplissable {
	boolean remplissage = false;

	public Rectangle() {
	}

	public Rectangle(Coordonnees position) {
		super(position);
	}

	public Rectangle(double largeur, double hauteur) {
		super(largeur, hauteur);
		if (largeur<0 || hauteur<0)
			throw new IllegalArgumentException("Merci d'entrer une hauteur et une largeur positives");
	}

	public Rectangle(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		if (largeur<0 || hauteur<0)
			throw new IllegalArgumentException("Merci d'entrer une hauteur et une largeur positives");
	}

	@Override
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		if (hauteur<0)
			throw new IllegalArgumentException("Merci d'entrer une hauteur positive");

	}

	@Override
	public void setLargeur(double largeur) {
		super.setLargeur(largeur);
		if (largeur<0)
			throw new IllegalArgumentException("Merci d'entrer une largeur positive");

	}

	@Override
	public boolean estRempli() {
		return this.remplissage;
	}

	@Override
	public void setRempli(boolean val) {
		this.remplissage = val;
	}

	@Override
	public double aire() {
		return this.getHauteur()*this.getLargeur();
	}

	@Override
	public double perimetre() {
		return 2*this.getHauteur()+2*this.getLargeur();
	}

	@Override
	public boolean contient(Coordonnees point) {
		return (point.getOrdonnee()<=this.getCadreMaxY() && point.getOrdonnee()>=this.getCadreMinY())
				&& (point.getAbscisse()<=this.getCadreMaxX() && point.getAbscisse()>=getCadreMinX());
	}

	@Override
	public String toString() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
		DecimalFormat df = new DecimalFormat("0.0#", symbols);
		String verifRempli = this.estRempli()? "[Rectangle-Rempli]":"[Rectangle]";
		String ret = verifRempli+" : pos (" + df.format(this.getPosition().getAbscisse()) + " , "
				+ df.format(this.getPosition().getOrdonnee())+ ") dim " + df.format(this.getLargeur()) + " x "
				+ df.format(this.getHauteur())+ " périmètre : " + df.format(this.perimetre()) + " aire : "
				+ df.format(this.aire());
		char[] lang;
		if ("fr".equals(Locale.getDefault().getLanguage())) {
			lang = new char[]{'R', 'V', 'B'};
		} else {
			lang = new char[]{'R', 'G', 'B'};
		}
		return ret + " couleur = " + lang[0] + this.getCouleur().getRed() + "," + lang[1] + this.getCouleur().getGreen()
				+ ","+ lang[2] + this.getCouleur().getBlue();
	}
}
