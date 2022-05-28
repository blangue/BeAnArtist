package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Cercle extends Ellipse{

	protected double r = this.getB();

	public Cercle() {
	}

	public Cercle(Coordonnees position) {
		super(position);
	}

	public Cercle(double diametre) {
		super(diametre,diametre);
	}

	public Cercle(Coordonnees position, double diametre) {
		super(position, diametre, diametre);
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public double perimetre() {
		return 2*Math.PI*getR();
	}

	@Override
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}

	@Override
	public void setLargeur(double largeur) {
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}

	@Override
	public boolean contient(Coordonnees point) {
		Coordonnees centre = new Coordonnees(this.getPosition().getAbscisse(),this.getPosition().getOrdonnee());
		centre.deplacerDe(r,r);
		return centre.distanceVers(point) <= r;
	}

	@Override
	public String toString() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
		DecimalFormat df = new DecimalFormat("0.0#", symbols);
		String verifRempli = this.estRempli()? "[Cercle-Rempli]":"[Cercle]";
		String ret = verifRempli+" : pos (" + df.format(this.getPosition().getAbscisse()) + " , " +
				df.format(this.getPosition().getOrdonnee())+ ") dim " + df.format(this.getHauteur()) + " x "
				+ df.format(this.getLargeur())+ " périmètre : " + df.format(this.perimetre()) + " aire : "
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
