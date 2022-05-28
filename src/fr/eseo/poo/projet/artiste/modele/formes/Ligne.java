package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Ligne extends Forme {
	
	Coordonnees c1;
	Coordonnees c2;
	public static final double EPSILON = 0.1;

	public Ligne() {
		this.c1 = new Coordonnees();
		this.c2 = new Coordonnees();
	}
	
	public Ligne (Coordonnees position) {
		super(position);
		this.setPosition(position);
		this.setC2(new Coordonnees(position.getAbscisse()+this.getLargeur(),
				position.getOrdonnee()+this.getHauteur()));
	}
	
	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
		this.c1 = new Coordonnees();
		this.setC2(new Coordonnees(this.getC1().getAbscisse()+largeur,c1.getOrdonnee()+hauteur));
	}
	
	public Ligne (Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		this.c1 = position;
		this.c2 = new Coordonnees(c1.getAbscisse()+largeur,c1.getOrdonnee()+hauteur);		
	}
	
	public Coordonnees getC1() {
		return this.c1;
	}
	public void actualiseC2 (){
		this.c2 = new Coordonnees(this.getC1().getAbscisse()+this.getLargeur(),this.getC1().getOrdonnee()+this.getHauteur());
	}
	@Override
	public void setPosition(Coordonnees position) {
		super.setPosition(position);
		this.c1=position;
		this.actualiseC2();
	}

	public void setC1(Coordonnees c1) {
		super.setPosition(c1);
		this.c1=this.getPosition();
		this.setHauteur(c2.getOrdonnee() - this.c1.getOrdonnee());
		this.setLargeur(c2.getAbscisse() - this.c1.getAbscisse());
	}


	public Coordonnees getC2() {
		return this.c2;
	}

	public void setC2(Coordonnees c2) {
		this.c2 = c2;
		this.setHauteur(c2.getOrdonnee() - c1.getOrdonnee());
		this.setLargeur(c2.getAbscisse() - c1.getAbscisse());
	}

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return this.c1.distanceVers(c2);
	}

	@Override
	public boolean contient(Coordonnees point) {
		double c1PointC2 = this.getC1().distanceVers(point)+this.getC2().distanceVers(point);
		return c1PointC2 - this.perimetre() <= EPSILON;
	}

	@Override
	public String toString() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
		double angle = Math.toDegrees(c1.angleVers(c2));
		if (angle<0) angle+=360;
		DecimalFormat df = new DecimalFormat("0.0#", symbols);
		String ret = "[Ligne] c1 : (" + df.format(c1.getAbscisse()) + " , " + df.format(c1.getOrdonnee())
				+ ") c2 : (" + df.format(c2.getAbscisse()) + " , " + df.format(c2.getOrdonnee())
				+ ") longueur : " + df.format(this.perimetre()) + " angle : " + df.format(angle) + "° ";

		char[] tabRvb = {'R','V','B'};
		char[] tabRgb = {'R','G','B'};
		char[] lang;
		if ("fr".equals(Locale.getDefault().getLanguage())) {
			lang = tabRvb;
		} else {
			lang = tabRgb;
		}
		return ret + "couleur = " + lang[0] + this.getCouleur().getRed() + "," + lang[1] + this.getCouleur().getGreen()
				+ ","+ lang[2] + this.getCouleur().getBlue();
	}

	@Override
	public void deplacerDe(double deltaX, double deltaY) {
		super.deplacerDe(deltaX, deltaY);
		c2.deplacerDe(deltaX, deltaY);
	}


	@Override
	public void deplacerVers(double x, double y) {
		super.deplacerVers(x, y);
		c1.deplacerVers(x,y);
		actualiseC2();
	}


}
