package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Forme;

import java.awt.Graphics2D;

public abstract class VueForme {
	protected final Forme forme ;

	public VueForme(Forme forme) {
		this.forme = forme;
	}

	public Forme getForme() {
		return forme;
	}

	public abstract void affiche (Graphics2D g2d);
}
