package fr.eseo.poo.projet.artiste.xml;

import java.awt.Color;

import javax.swing.JFrame;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Permet de tester le résultat du calcul de l'étoile à partir des coordonnées
 * (i.e. l'implémentation de la méthode LecteurSVG.calculeEtoile) en comparant
 * visuellement l'étoile 1 construite à partir des données géométriques
 * (position, taille, angle, etc.) et l'étoile 2 reconstruite à partir de la
 * liste des différents points de l'étoile 1.
 */
public class EssaiCalculEtoile {

	// Trois exemples d'étoile. Proposer vos propres exemples !
	static final Etoile ETOILE_A = new Etoile(new Coordonnees(50, 70), 200, 3, 30. * Math.PI / 180., 0.75);
	static final Etoile ETOILE_B = new Etoile(new Coordonnees(100, 100), 200, 4, 0, 0.65);
	static final Etoile ETOILE_C = new Etoile(new Coordonnees(100, 100), 200, 5, 30. * Math.PI / 180., 0.75);

	public static void main(String[] args) {
		// Etoile(Coordonnees coordonnee, double taille, int nombreBranches, double anglePremiereBranche, double longuerBranche)
		// Deux étoiles sont créées : elles doivent être identiques
		Etoile etoile1 = ETOILE_A; // Essayez avec ETOILE_B et ETOILE_C
		Etoile etoile2 = new LecteurSVG().calculeEtoile(etoile1.getCoordonnees());
		// Vérification de l'égalité des coordonnées dans la console
		System.out.println(etoile1.getCoordonnees());
		System.out.println(etoile2.getCoordonnees());
		// Vérification graphique : les 2 étoiles doivent être superposées.
		etoile1.setCouleur(Color.RED);
		etoile2.setCouleur(Color.BLUE);
		JFrame fenetre = new JFrame("Etoile");
		PanneauDessin panneauDessin = new PanneauDessin(960, 720, new Color(255, 255, 255));
		fenetre.add(panneauDessin);
		fenetre.pack();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		panneauDessin.ajouterVueForme(new VueEtoile(etoile1));
		panneauDessin.ajouterVueForme(new VueEtoile(etoile2));
		fenetre.setVisible(true);
	}

}
