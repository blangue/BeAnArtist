package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Carre extends Rectangle{
	public Carre() {
	}

	public Carre(Coordonnees position) {
		super(position);
	}

	public Carre(double cote) {
		super(cote,cote);
	}

	public Carre(Coordonnees position, double cote) {
		super(position, cote, cote);
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
	public String toString() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
		DecimalFormat df = new DecimalFormat("0.0#", symbols);
		String verifRempli = this.estRempli()? "[Carre-Rempli]":"[Carre]";
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
