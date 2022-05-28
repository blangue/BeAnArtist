package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class OutilLigneTest {

	public OutilLigneTest(){
		testOutil();
	}


	private void testOutil(){
		JFrame frame = new JFrame("Blues du Businessman");
		PanneauDessin pan = new PanneauDessin();
		PanneauBarreOutils outil = new PanneauBarreOutils(pan);
		frame.getContentPane().add(pan,0);
		frame.add(outil,BorderLayout.EAST);
		System.out.println(pan.getComponentCount());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		pan.associerOutil(new OutilLigne());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilLigneTest();
			}
		});
	}
}