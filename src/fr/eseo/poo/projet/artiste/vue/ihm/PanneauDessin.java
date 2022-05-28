package fr.eseo.poo.projet.artiste.vue.ihm;


import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class PanneauDessin extends javax.swing.JPanel{
	public static final int LARGEUR_PAR_DEFAUT = 700;
	public static final int HAUTEUR_PAR_DEFAUT = 500;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.LIGHT_GRAY;
	private final List<VueForme> vueFormes = new ArrayList<VueForme>();
	private Outil outilCourant = null;
	private Color couleurCourante = Forme.COULEUR_PAR_DEFAUT;
	private boolean modeRemplissage = false;


	public PanneauDessin() {
		this.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		this.setBackground(COULEUR_FOND_PAR_DEFAUT);
	}
	public PanneauDessin(int largeur, int hauteur, java.awt.Color fond){
		this.setPreferredSize(new Dimension(largeur,hauteur));
		this.setBackground(fond);
	}

	public List<VueForme> getVueFormes() {
		return vueFormes;
	}

	public void  ajouterVueForme(VueForme vueForme){
		this.vueFormes.add(vueForme);
		this.repaint();
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		for (VueForme vueForme : vueFormes) {
			vueForme.affiche(g2d);
		}
		g2d.dispose();
	}

	public Outil getOutilCourant() {
		return outilCourant;
	}

	private void setOutilCourant(Outil outilCourant) {
		this.outilCourant = outilCourant;
	}

	public void associerOutil(Outil outil){
		if (outil!=null) {
			dissocierOutil();
			this.addMouseListener(outil);
			this.addMouseMotionListener(outil);
			setOutilCourant(outil);
			outil.setPanneauDessin(this);
			this.repaint();
		}
	}

	private void dissocierOutil(){
		if (outilCourant!=null) {
			outilCourant.setPanneauDessin(null);
			this.removeMouseListener(this.outilCourant);
			this.removeMouseMotionListener(this.outilCourant);
			this.setOutilCourant(null);
		}
	}

	public Color getCouleurCourante() {
		return couleurCourante;
	}

	public void setCouleurCourante(Color couleurCourante) {
		this.couleurCourante = couleurCourante;
	}

	public boolean getModeRemplissage() {
		return modeRemplissage;
	}

	public void setModeRemplissage(boolean modeRemplissage) {
		this.modeRemplissage = modeRemplissage;
	}
}
