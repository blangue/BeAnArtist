package fr.eseo.poo.projet.artiste.vue.formes;


import fr.eseo.poo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class VueEtoileTest {
	public VueEtoileTest(){
		testEtoile();
	}


	private void testEtoile() {
		JFrame frame = new JFrame("Blues du Businessman");
		PanneauDessin pan = new PanneauDessin();
		PanneauBarreOutils outil = new PanneauBarreOutils(pan);
		frame.getContentPane().add(pan, 0);
		frame.add(outil, BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		pan.associerOutil(new OutilEtoile(outil));
		Etoile etoile = new Etoile(new Coordonnees(1, 1), 400, 6, -Math.PI/2, 0.5);
		Coordonnees pointPrecedent = etoile.getCoordonnees().get(0);
		double abscisse;
		double ordonnee;
		for (int i = 1; i < etoile.getCoordonnees().size(); i++) {
			abscisse = etoile.getCoordonnees().get(i).getAbscisse() - pointPrecedent.getAbscisse();
			ordonnee = etoile.getCoordonnees().get(i).getOrdonnee() - pointPrecedent.getOrdonnee();
			pan.ajouterVueForme(new VueLigne(new Ligne(pointPrecedent, abscisse, ordonnee)));
			pointPrecedent = etoile.getCoordonnees().get(i);
			if (i == etoile.getCoordonnees().size()-1) {
				abscisse = etoile.getCoordonnees().get(0).getAbscisse() - pointPrecedent.getAbscisse();
				ordonnee = etoile.getCoordonnees().get(0).getOrdonnee() - pointPrecedent.getOrdonnee();
				pan.ajouterVueForme(new VueLigne(new Ligne(pointPrecedent, abscisse, ordonnee)));
			}
		}
	}
	public static void main (String[]args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEtoileTest();
			}
		});
	}
}