package fr.eseo.poo.projet.artiste.vue.ihm;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Color;

public class PanneauDessinTest {

	public PanneauDessinTest(){
		testConstructeur();
		testConstructeurParDefaut();
		testPaint();
	}

	private void testConstructeurParDefaut() {
		PanneauDessin fen = new PanneauDessin();
		JFrame frame2 = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin(200,200, Color.blue);
		frame2.getContentPane().add(panneau);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
		frame2.pack();
		frame2.setLocationRelativeTo(null);

	}

	private void testConstructeur() {
		JFrame frame = new JFrame("Blues du Businessman");
		PanneauDessin pan = new PanneauDessin();
	}

	private void testPaint(){
		JFrame frame = new JFrame("Blues du Businessman");
		PanneauDessin pan = new PanneauDessin();
		PanneauBarreOutils outil = new PanneauBarreOutils(pan);
		frame.getContentPane().add(pan);
		frame.getContentPane().add(outil);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);

		Ligne ligne = new Ligne(new Coordonnees(50,50),200,70);
		VueLigne vueLigne=new VueLigne(ligne);
		pan.ajouterVueForme(vueLigne);
		Ligne ligne2 = new Ligne(ligne.getC2(),-200,70);
		VueLigne vueLigne2=new VueLigne(ligne2);
		pan.ajouterVueForme(vueLigne2);
		Ellipse el = new Ellipse(new Coordonnees(10,50),70,140);
		VueEllipse vueEllipse = new VueEllipse(el);
		pan.ajouterVueForme(vueEllipse);
		Coordonnees pos = new Coordonnees(ligne.getC2().getAbscisse(), ligne.getC2().getOrdonnee());
		pos.deplacerDe(0,-10);
		Cercle cercle = new Cercle(pos, 20);
		VueCercle vueCercle = new VueCercle(cercle);
		pan.ajouterVueForme(vueCercle);
		Graphics g = pan.getGraphics();
		pan.paintComponent(g);
		pan.update(g);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauDessinTest();
			}
		});
	}
}