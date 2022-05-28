package fr.eseo.poo.projet.artiste;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class EtreUnArtiste {

	public EtreUnArtiste(){
		artiste();
	}


	private void artiste() {
		JFrame frame = new JFrame("Etre Un Artiste");
		PanneauDessin pan = new PanneauDessin();
		PanneauBarreOutils outil = new PanneauBarreOutils(pan);
		frame.getContentPane().add(pan, 0);
		frame.add(outil, BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	public static void main (String[]args){
		SwingUtilities.invokeLater(EtreUnArtiste::new);
	}
}
