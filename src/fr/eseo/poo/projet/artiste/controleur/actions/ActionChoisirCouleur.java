package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class ActionChoisirCouleur extends AbstractAction {
	public static final String NOM_ACTION = "Choisir Couleur";
	private final PanneauDessin panneauDessin;

	public ActionChoisirCouleur(PanneauDessin panneauDessin){
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panneauDessin.setCouleurCourante(javax.swing.JColorChooser.showDialog
				(panneauDessin,NOM_ACTION,panneauDessin.getCouleurCourante()));
	}
}
