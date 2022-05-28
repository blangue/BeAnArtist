package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

import java.awt.Color;
import java.awt.Graphics2D;

public class VueLigne extends VueForme{
	public VueLigne(Ligne ligne) {
		super(ligne);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Ligne l = (Ligne) this.getForme();
		Color couleurBase = g2d.getColor();
		g2d.setColor(forme.getCouleur());
		g2d.drawLine((int) l.getC1().getAbscisse(),(int) l.getC1().getOrdonnee(),
				(int) l.getC2().getAbscisse(), (int) l.getC2().getOrdonnee());
		g2d.setColor(couleurBase);
	}
}
