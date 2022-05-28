package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

import java.awt.event.MouseEvent;

public class OutilEtoile extends OutilForme{
	PanneauBarreOutils panneauBarreOutils;
	public OutilEtoile(PanneauBarreOutils panneauBarreOutils) {
		this.panneauBarreOutils = panneauBarreOutils;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
	}
	@Override
	protected VueForme creerVueForme(){
		Etoile etoile;
		if (this.getDebut().equals(this.getFin())) {
			etoile = new Etoile(this.getDebut());
		}
		else {
			double angle = this.getFin().angleVers(this.getDebut());
			double taille = 2*this.getDebut().distanceVers(this.getFin());
			Coordonnees pos = new Coordonnees(this.getFin().getAbscisse()-taille/2,this.getFin().getOrdonnee()-taille/2);
			etoile= new Etoile(pos,taille,this.panneauBarreOutils.getNbBranches(),
					angle,this.panneauBarreOutils.getLongueurBranche());
			etoile.setCouleur(this.getPanneauDessin().getCouleurCourante());
		}
		etoile.setRempli(this.getPanneauDessin().getModeRemplissage());
		return new VueEtoile(etoile);
	}
}
