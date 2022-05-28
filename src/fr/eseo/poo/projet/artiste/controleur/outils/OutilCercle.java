package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

import java.awt.event.MouseEvent;

public class OutilCercle extends OutilForme{
	@Override
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
	}

	@Override
	protected VueForme creerVueForme() {
		Cercle cercle;
		if(this.getDebut().equals(this.getFin())) {
			cercle = new Cercle(this.getDebut());
		}
		else {
			double largeur = this.getFin().getAbscisse()-this.getDebut().getAbscisse();
			double hauteur = this.getFin().getOrdonnee()-this.getDebut().getOrdonnee();
			double cote = Math.max(Math.abs(largeur), Math.abs(hauteur));
			Ligne trace = new Ligne(this.getDebut(),cote, cote);
			if (largeur<0) trace.setLargeur(-cote);
			if (hauteur<0) trace.setHauteur(-cote);
			Coordonnees pos = new Coordonnees(trace.getCadreMinX(),trace.getCadreMinY());
			cercle= new Cercle(pos, Math.max(Math.abs(trace.getLargeur()),Math.abs(trace.getHauteur())));
			cercle.setCouleur(this.getPanneauDessin().getCouleurCourante());
		}
		cercle.setRempli(this.getPanneauDessin().getModeRemplissage());
		return new VueCercle((cercle));
	}
}
