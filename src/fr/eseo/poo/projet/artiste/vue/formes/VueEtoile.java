package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class VueEtoile extends VueForme {
	public VueEtoile(Etoile etoile) {
		super(etoile);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Etoile etoile = (Etoile) this.getForme();
		Color couleurBase = g2d.getColor();
		g2d.setColor(forme.getCouleur());
		Polygon poly = new Polygon();
		for (int i = 0; i < etoile.getCoordonnees().size(); i++) {
			poly.addPoint((int) Math.round(etoile.getCoordonnees().get(i).getAbscisse()),
					(int) Math.round(etoile.getCoordonnees().get(i).getOrdonnee()));
			System.out.print((int) Math.round(etoile.getCoordonnees().get(i).getAbscisse())+","+
					(int) Math.round(etoile.getCoordonnees().get(i).getOrdonnee())+" ");
		}
			System.out.println();
		if (etoile.estRempli()) g2d.fillPolygon(poly);
		g2d.drawPolygon(poly);
		g2d.setColor(couleurBase);

	}
}
