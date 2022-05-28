package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

import java.awt.event.MouseEvent;

public abstract class OutilForme extends Outil{

	@Override
	public void mouseReleased(MouseEvent event) {
			super.mouseReleased(event);
		if (!this.getDebut().equals(this.getFin())) {
			this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			this.getPanneauDessin().repaint();
		}
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		super.mouseDragged(event);
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount()==2) {
			this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			this.getPanneauDessin().repaint();
		}
	}

	protected abstract VueForme creerVueForme();
}
