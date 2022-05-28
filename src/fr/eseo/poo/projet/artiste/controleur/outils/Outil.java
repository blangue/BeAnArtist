package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public abstract class Outil implements MouseInputListener {

	private Coordonnees debut = new Coordonnees(0,0);
	private Coordonnees fin = new Coordonnees(0,0);
	private PanneauDessin panneauDessin;

	public Coordonnees getDebut() {
		return debut;
	}

	public void setDebut(Coordonnees debut) {
		this.debut = debut;
	}

	public Coordonnees getFin() {
		return fin;
	}

	public void setFin(Coordonnees fin) {
		this.fin = fin;
	}

	public PanneauDessin getPanneauDessin(){
		return this.panneauDessin;
	}
	public void setPanneauDessin(PanneauDessin panneau){
		this.panneauDessin =panneau;
	}

	public void mouseClicked(MouseEvent event){

	}
	public void mouseDragged(MouseEvent event){
		fin = new Coordonnees(event.getX(), event.getY());
	}
	public void mouseEntered(MouseEvent event){

	}
	public void mouseExited(MouseEvent event){

	}
	public void mouseMoved(MouseEvent event){

	}
	public void mousePressed(MouseEvent event){
		debut = new Coordonnees(event.getX(), event.getY());
	}
	public void mouseReleased(MouseEvent event){
		fin = new Coordonnees(event.getX(), event.getY());
	}

}
