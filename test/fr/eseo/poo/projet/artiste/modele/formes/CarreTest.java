package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.CoordonneesTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarreTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testConstructeurs1() {
		Carre carre = new Carre();
		assertTrue("Test Contructeur position", carre.getPosition().equals(new Coordonnees()));
		assertEquals("Test Contructeur Largeur", 20, carre.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test Contructeur Hauteur", 20, carre.getHauteur(), CoordonneesTest.DELTA);

		carre = new Carre(new Coordonnees(1,1));
		assertTrue("Test Contructeur position", carre.getPosition().equals(new Coordonnees(1,1)));
		assertEquals("Test Contructeur Largeur", 20, carre.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test Contructeur Hauteur", 20, carre.getHauteur(), CoordonneesTest.DELTA);

		carre = new Carre(new Coordonnees(1,1),14);
		assertTrue("Test Contructeur position", carre.getPosition().equals(new Coordonnees(1,1)));
		assertEquals("Test Contructeur Largeur", 14, carre.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test Contructeur Hauteur", 14, carre.getHauteur(), CoordonneesTest.DELTA);

		carre = new Carre(15);
		assertTrue("Test Contructeur position", carre.getPosition().equals(new Coordonnees()));
		assertEquals("Test Contructeur Largeur", 15, carre.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test Contructeur Hauteur", 15, carre.getHauteur(), CoordonneesTest.DELTA);
	}

	@Test
	public void setHauteur() {
		new Carre().setHauteur(12);
		exception.expectMessage("Merci d'entrer une hauteur positive");
		new Carre().setHauteur(-12);
	}

	@Test
	public void setLargeur() {
		new Carre().setLargeur(12);
		exception.expectMessage("Merci d'entrer une largeur positive");
		new Carre().setLargeur(-12);
	}

	@Test
	public void testToString() {
		Carre carre = new Carre();
		Locale.setDefault(Locale.FRENCH);
		assertEquals("Test toString","[Carre] : pos (0,0 , 0,0) dim 20,0 x 20,0 périmètre : 80,0 aire : 400,0 couleur" +
				" = R51,V51,B51",carre.toString());
		carre.setRempli(true);
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("Test toString","[Carre-Rempli] : pos (0.0 , 0.0) dim 20.0 x 20.0 périmètre : 80.0 aire : 400.0 " +
				"couleur = R51,G51,B51",carre.toString());
		Locale.setDefault(Locale.FRENCH);
	}
}