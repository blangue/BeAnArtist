package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;

import java.awt.Color;
import java.awt.Graphics2D;

public class VueRectangle extends VueForme{

	public VueRectangle(Forme forme) {
		super(forme);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Rectangle rect = (Rectangle) this.getForme();
		Color couleurBase = g2d.getColor();
		g2d.setColor(forme.getCouleur());
		g2d.drawRect((int) rect.getPosition().getAbscisse(), (int) rect.getPosition().getOrdonnee(),
				 (int) rect.getLargeur(), (int) rect.getHauteur());
		if (rect.estRempli()) g2d.fillRect((int) rect.getPosition().getAbscisse(),
				(int) rect.getPosition().getOrdonnee(),
				(int) rect.getLargeur(), (int) rect.getHauteur());
		g2d.setColor(couleurBase);
	}
}
