package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class ActionEffacer extends AbstractAction {
	public static final String NOM_ACTION = "Effacer tout";
	private final PanneauDessin panneauDessin;

	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		int reponse = JOptionPane.showConfirmDialog(panneauDessin,
				"Etes-vous certain de vouloir tout effacer ?",NOM_ACTION,
				JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		if (reponse == 0){
			this.panneauDessin.getVueFormes().clear();
			this.panneauDessin.repaint();
		}
	}

}
