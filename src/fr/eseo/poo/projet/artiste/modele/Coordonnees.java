package fr.eseo.poo.projet.artiste.modele;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Coordonnees {

	public static final double ABSCISSE_PAR_DEFAUT=0.0;
	public static final double ORDONNEE_PAR_DEFAUT=0.0;
	
	double abscisse;
	double ordonnee;
	
	public Coordonnees() {
		this.abscisse = ABSCISSE_PAR_DEFAUT;
		this.ordonnee = ORDONNEE_PAR_DEFAUT;
	}
	
	public Coordonnees(double abscisse, double ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}

	public double getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
	}

	public double getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}
	
	public void deplacerVers(double abs, double ord) {
		this.setAbscisse(abs);
		this.setOrdonnee(ord);
	}
	
	public void deplacerDe(double abs, double ord) {
		this.abscisse += abs;
		this.ordonnee += ord;
	}
	
	public double distanceVers(double abs, double ord) {
		return	Math.sqrt(Math.pow(abs-this.abscisse,2) + Math.pow(ord-this.ordonnee,2));
	}
	
	public double distanceVers(Coordonnees coord) {
		return	Math.sqrt(Math.pow(coord.abscisse-this.abscisse,2) + Math.pow(coord.ordonnee-this.ordonnee,2));
	}
	
	public double angleVers(Coordonnees coord) {
		double angle = Math.acos((coord.getAbscisse() - this.getAbscisse())/this.distanceVers(coord));
		if (coord.getOrdonnee()-this.getOrdonnee()<0) angle=-angle;
		return angle;
	}
	

	@Override
	public String toString() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
		DecimalFormat df = new DecimalFormat("0.0#",symbols);
		String abs = String.valueOf(df.format(this.abscisse));
		String ord = String.valueOf(df.format(this.ordonnee));
		return "(" + abs + " , " + ord + ")";
	}


	public boolean equals(Coordonnees coord) {
		return this.getAbscisse() == coord.getAbscisse() && this.getOrdonnee() == coord.getOrdonnee();
	}
}
