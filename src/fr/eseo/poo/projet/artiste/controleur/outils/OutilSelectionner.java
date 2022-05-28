package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;

import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;


public class OutilSelectionner extends Outil{

	@Override
	public void mouseClicked(MouseEvent event) {
			Forme forme = null;
		for(int i = 0; i<this.getPanneauDessin().getVueFormes().size();i++){
			if(this.getPanneauDessin().getVueFormes().get(i).getForme().contient
					(new Coordonnees(event.getX(),event.getY()))){
				forme = this.getPanneauDessin().getVueFormes().get(i).getForme();
			}
		}
		System.out.println(event.getX()+""+event.getY());
		if (forme!=null) {
			javax.swing.JOptionPane.showMessageDialog(this.getPanneauDessin(), forme.toString(),
					ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
