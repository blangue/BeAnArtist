package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Ellipse extends Forme implements Remplissable {
	boolean remplissage = false;
	double a = this.getLargeur()/2;
	double b = this.getHauteur()/2;

	public Ellipse() {
	}

	public Ellipse(Coordonnees position) {
		super(position);
	}

	public Ellipse(double largeur, double hauteur) {
		super(largeur,hauteur);
		if (hauteur<0 || largeur<0)
			throw new IllegalArgumentException("Merci d'entrer une hauteur et une largeur positives");
	}

	public Ellipse(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		if (hauteur<0 || largeur<0)
			throw new IllegalArgumentException("Merci d'entrer une hauteur et une largeur positives");
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public double aire() {
		return Math.PI*this.getA()*this.getB();
	}

	@Override
	public double perimetre() {
		double h = Math.pow((this.getA()-this.getB())/(this.getA()+this.getB()),2);
		return Math.PI*(this.getA()+ this.getB())*(1+3*h/(10+Math.sqrt(4-3*h)));
	}

	@Override
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		if (hauteur<0) throw new IllegalArgumentException("Merci d'entrer une hauteur positive");
	}

	@Override
	public void setLargeur(double largeur) {
		super.setLargeur(largeur);
		if (largeur<0) throw new IllegalArgumentException("Merci d'entrer une hauteur positive");
	}

	@Override
	public void deplacerVers(double newX, double newY) {
		super.deplacerVers(newX, newY);
	}

	@Override
	public boolean contient(Coordonnees point) {
		Coordonnees centre = new Coordonnees(this.getPosition().getAbscisse(),this.getPosition().getOrdonnee());
		centre.deplacerDe(a,b);

		double x = point.getAbscisse();
		double y = point.getOrdonnee();


		return Math.pow((x-centre.getAbscisse())/a,2)+Math.pow((y-centre.getOrdonnee())/b,2) <= 1 ;
	}

	@Override
	public String toString() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
		DecimalFormat df = new DecimalFormat("0.0#", symbols);
		String verifRempli = this.estRempli()? "[Ellipse-Rempli]":"[Ellipse]";
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

	@Override
	public boolean estRempli() {
		return this.remplissage;
	}

	@Override
	public void setRempli(boolean val) {
		this.remplissage = val;
	}
}
