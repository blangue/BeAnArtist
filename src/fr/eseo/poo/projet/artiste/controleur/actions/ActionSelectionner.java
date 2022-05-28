package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class ActionSelectionner extends AbstractAction {
	public static final String NOM_ACTION = "Selectionner";
	private final PanneauDessin panneauDessin;

	public ActionSelectionner(PanneauDessin panneauDessin){
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.panneauDessin.associerOutil(new OutilSelectionner());
	}
}
