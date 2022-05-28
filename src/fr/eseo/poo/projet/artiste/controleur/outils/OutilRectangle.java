package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueRectangle;

public class OutilRectangle extends OutilForme{
	@Override
	protected VueForme creerVueForme() {
		Rectangle rect;
		if(this.getDebut().equals(this.getFin())) {
			rect = new Rectangle(this.getDebut());
		}
		else {
			Ligne trace = new Ligne(this.getDebut(),this.getFin().getAbscisse()-this.getDebut().getAbscisse(),
					this.getFin().getOrdonnee()-this.getDebut().getOrdonnee());
			Coordonnees pos = new Coordonnees(trace.getCadreMinX(),trace.getCadreMinY());
			rect= new Rectangle(pos, Math.abs(trace.getLargeur()),Math.abs(trace.getHauteur()));
			rect.setCouleur(this.getPanneauDessin().getCouleurCourante());
			rect.setRempli(this.getPanneauDessin().getModeRemplissage());
		}
		rect.setRempli(this.getPanneauDessin().getModeRemplissage());
		return new VueRectangle(rect);
	}
}
