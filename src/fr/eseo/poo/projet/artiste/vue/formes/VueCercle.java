package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Cercle;

import java.awt.Color;
import java.awt.Graphics2D;

public class VueCercle extends VueEllipse{
	public VueCercle(Cercle cercle) {
		super(cercle);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Cercle el = (Cercle) this.getForme();
		Color couleurBase = g2d.getColor();
		g2d.setColor(forme.getCouleur());
		if (el.estRempli()){
			g2d.fillOval((int) el.getPosition().getAbscisse(),(int) el.getPosition().getOrdonnee(),(int) el.getLargeur(),
					(int) el.getHauteur());
		}
		g2d.drawOval((int) el.getPosition().getAbscisse(),(int) el.getPosition().getOrdonnee(),(int) el.getLargeur(),
				(int) el.getHauteur());
		g2d.setColor(couleurBase);
	}
}
