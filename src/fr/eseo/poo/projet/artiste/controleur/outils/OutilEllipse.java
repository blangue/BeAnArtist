package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme{
	@Override
	protected VueForme creerVueForme() {
		Ellipse el;
		if(this.getDebut().equals(this.getFin())) {
			el = new Ellipse(this.getDebut());
		}
		else {
			Ligne trace = new Ligne(this.getDebut(),this.getFin().getAbscisse()-this.getDebut().getAbscisse(),
					this.getFin().getOrdonnee()-this.getDebut().getOrdonnee());
			Coordonnees pos = new Coordonnees(trace.getCadreMinX(),trace.getCadreMinY());
			el= new Ellipse(pos, Math.abs(trace.getLargeur()),Math.abs(trace.getHauteur()));
			el.setCouleur(this.getPanneauDessin().getCouleurCourante());
			el.setRempli(this.getPanneauDessin().getModeRemplissage());
		}
		el.setRempli(this.getPanneauDessin().getModeRemplissage());
		return new VueEllipse(el);
	}
}
