package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCarre;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilRectangle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

import java.awt.event.ActionEvent;

public class ActionChoisirForme extends javax.swing.AbstractAction{
	public static final String NOM_ACTION_LIGNE = "Créer une ligne";
	public static final String NOM_ACTION_ELLIPSE = "Créer une ellipse";
	public static final String NOM_ACTION_CERCLE = "Créer un cercle";
	public static final String NOM_ACTION_ETOILE = "Créer une étoile";
	public static final String NOM_ACTION_RECTANGLE = "Créer un rectangle";
	public static final String NOM_ACTION_CARRE = "Créer un carré";
	PanneauDessin pan;
	PanneauBarreOutils barreOutils;


	public ActionChoisirForme(PanneauDessin pan, PanneauBarreOutils barreOutils,String action) {
		this.pan = pan;
		this.barreOutils = barreOutils;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
			case NOM_ACTION_LIGNE:
				this.pan.associerOutil(new OutilLigne());
				break;
			case NOM_ACTION_ELLIPSE:
				this.pan.associerOutil(new OutilEllipse());
				break;
			case NOM_ACTION_CERCLE:
				this.pan.associerOutil(new OutilCercle());
				break;
			case NOM_ACTION_ETOILE:
				this.pan.associerOutil(new OutilEtoile(barreOutils));
				break;
			case NOM_ACTION_RECTANGLE:
				this.pan.associerOutil(new OutilRectangle());
				break;
			case NOM_ACTION_CARRE:
				this.pan.associerOutil(new OutilCarre());
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + e.getActionCommand() + " expected: "+NOM_ACTION_ETOILE);
		}
	}
}
