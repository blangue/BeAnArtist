package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme{
	@Override
	protected VueForme creerVueForme() {
		VueForme vueLigne;
		if(this.getDebut().equals(this.getFin())) {
			Ligne ligne = new Ligne(this.getDebut());
			vueLigne = new VueLigne(ligne);
		}
		else {
			Ligne ligne= new Ligne(this.getDebut(), this.getFin().getAbscisse()-this.getDebut().getAbscisse(),
					this.getFin().getOrdonnee()-this.getDebut().getOrdonnee());
			ligne.setCouleur(this.getPanneauDessin().getCouleurCourante());
			vueLigne = new VueLigne(ligne);
		}
		return vueLigne;
	}

}
