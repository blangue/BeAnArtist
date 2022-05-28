package fr.eseo.poo.projet.artiste.vue.ihm;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;

public class PanneauBarreOutils extends JPanel {
	private PanneauDessin panneauDessin;
	public static final String BRANCHE_SPINNER_NOM = "Branche Spinner";
	public static final String LONGUEUR_SPINNER_NOM = "Longueur Spinner";
	JSpinner spinnerBranches;
	JSpinner spinnerLongueur;

	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.initComponents();
	}


	public void initComponents(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		this.add(Box.createVerticalStrut(10));

		JButton effacer = new JButton(new ActionEffacer(panneauDessin));
		effacer.setText(ActionEffacer.NOM_ACTION);
		effacer.setName(ActionEffacer.NOM_ACTION);
		this.add(effacer);

		this.add(Box.createVerticalStrut(10));

		ButtonGroup group = new ButtonGroup();
//		Toggle bouton Ligne
		ActionChoisirForme actionCreerLigne = new ActionChoisirForme
				(this.panneauDessin,this, ActionChoisirForme.NOM_ACTION_LIGNE);
		JToggleButton ligne = new JToggleButton(actionCreerLigne);
		ligne.setText(ActionChoisirForme.NOM_ACTION_LIGNE);
		ligne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
//		Toggle bouton Ellipse
		ActionChoisirForme actionCreerEllipse = new ActionChoisirForme
				(this.panneauDessin,this,ActionChoisirForme.NOM_ACTION_ELLIPSE);
		JToggleButton ellipse = new JToggleButton(actionCreerEllipse);
		ellipse.setText(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		ellipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
//		Toggle bouton Cercle
		ActionChoisirForme actionCreerCercle = new ActionChoisirForme
				(this.panneauDessin,this, ActionChoisirForme.NOM_ACTION_CERCLE);
		JToggleButton cercle = new JToggleButton(actionCreerCercle);
		cercle.setText(ActionChoisirForme.NOM_ACTION_CERCLE);
		cercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
//		Toggle bouton Etoile
		ActionChoisirForme actionCreerEtoile = new ActionChoisirForme
				(this.panneauDessin,this,ActionChoisirForme.NOM_ACTION_ETOILE);
		JToggleButton etoile = new JToggleButton(actionCreerEtoile);
		etoile.setText(ActionChoisirForme.NOM_ACTION_ETOILE);
		etoile.setName(ActionChoisirForme.NOM_ACTION_ETOILE);
//		Toggle bouton Rectangle
		ActionChoisirForme actionCreerRectangle = new ActionChoisirForme(this.panneauDessin,this,
				ActionChoisirForme.NOM_ACTION_RECTANGLE);
		JToggleButton rect = new JToggleButton(actionCreerRectangle);
		rect.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);
		rect.setText(ActionChoisirForme.NOM_ACTION_RECTANGLE);
//		Toggle bouton Carre
		ActionChoisirForme actionCreerCarre = new ActionChoisirForme(this.panneauDessin,this,
				ActionChoisirForme.NOM_ACTION_CARRE);
		JToggleButton carre = new JToggleButton(actionCreerCarre);
		carre.setName(ActionChoisirForme.NOM_ACTION_CARRE);
		carre.setText(ActionChoisirForme.NOM_ACTION_CARRE);

		group.add(ligne);
		group.add(ellipse);
		group.add(cercle);
		group.add(etoile);
		group.add(rect);
		group.add(carre);
		this.add(ligne);
		this.add(Box.createVerticalStrut(10));
		this.add(ellipse);
		this.add(Box.createVerticalStrut(10));
		this.add(cercle);
		this.add(Box.createVerticalStrut(10));
		this.add(etoile);
		this.add(Box.createVerticalStrut(10));
		this.add(rect);
		this.add(Box.createVerticalStrut(10));
		this.add(carre);
		this.add(Box.createVerticalStrut(10));

		ActionSelectionner actionSelectionner = new ActionSelectionner(this.panneauDessin);
		JToggleButton select = new JToggleButton(actionSelectionner);
		select.setText(ActionSelectionner.NOM_ACTION);
		select.setName(ActionSelectionner.NOM_ACTION);

		group.add(select);
		this.add(select);

		this.add(Box.createVerticalStrut(10));

		JButton couleur = new JButton(new ActionChoisirCouleur(this.panneauDessin));
		couleur.setName(ActionChoisirCouleur.NOM_ACTION);
		couleur.setText(ActionChoisirCouleur.NOM_ACTION);

		this.add(couleur);

		this.add(Box.createVerticalStrut(10));

		JCheckBox remplissage = new JCheckBox(new ActionChoisirRemplissage(panneauDessin));
		remplissage.setText(ActionChoisirRemplissage.NOM_ACTION);
		remplissage.setName(ActionChoisirRemplissage.NOM_ACTION);
		this.add(remplissage);

		this.add(Box.createVerticalStrut(10));
		spinnerBranches = new JSpinner(new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,3,15,1));
		JLabel nomSpinnerBranches = new JLabel(BRANCHE_SPINNER_NOM);
		spinnerBranches.setName(BRANCHE_SPINNER_NOM);
		spinnerBranches.setMaximumSize(new Dimension(70,25));
		this.add(spinnerBranches);
		this.add(nomSpinnerBranches);

		this.add(Box.createVerticalStrut(10));

		spinnerLongueur = new JSpinner(new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0.0, 1.0, 0.01));
		JLabel nomSpinnerLongueur = new JLabel(LONGUEUR_SPINNER_NOM);
		spinnerLongueur.setName(LONGUEUR_SPINNER_NOM);
		spinnerLongueur.setMaximumSize(new Dimension(70,25));
		this.add(spinnerLongueur);
		this.add(nomSpinnerLongueur);
	}
	public int getNbBranches(){
		return (int) spinnerBranches.getValue();
	}
	public double getLongueurBranche(){
		return (Double) this.spinnerLongueur.getValue();
	}
}
