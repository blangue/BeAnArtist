package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.CoordonneesTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.awt.Color;
import java.util.Locale;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CercleTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void testCercleCoordonnees() {
		Cercle cer = new Cercle(new Coordonnees(1,5));
		assertTrue("Test constructeur Coord position", cer.getPosition().equals(new Coordonnees(1,5)));
		assertEquals("Test constructeur Coord largeur", 20, cer.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test constructeur Coord hauteur", 20, cer.getHauteur(), CoordonneesTest.DELTA);
	}

	@Test
	public void testCoordDiametre() {
		Cercle cer = new Cercle(new Coordonnees(1,5),12);
		assertTrue("Test constructeur diametre position", cer.getPosition().equals(new Coordonnees(1,5)));
		assertEquals("Test constructeur diametre largeur", 12, cer.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test constructeur diametre hauteur", 12, cer.getHauteur(), CoordonneesTest.DELTA);
	}
	@Test
	public void testCoordDiametre2() {
		exception.expectMessage("Merci d'entrer une hauteur et une largeur positives");
		new Cercle(new Coordonnees(1,5),-12);
	}

	@Test
	public void testDiametre() {
		Cercle cer = new Cercle(new Coordonnees(1,5),12);
		assertTrue("Test constructeur diametre position", cer.getPosition().equals(new Coordonnees(1,5)));
		assertEquals("Test constructeur diametre largeur", 12, cer.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test constructeur diametre hauteur", 12, cer.getHauteur(), CoordonneesTest.DELTA);
		exception.expectMessage("Merci d'entrer une hauteur et une largeur positives");
		new Cercle(-1);

	}
	@Test
	public void getR() {
		Cercle cer = new Cercle(10);
		assertEquals("test getR", cer.r, cer.getR(), CoordonneesTest.DELTA);
	}

	@Test
	public void setR() {
		Cercle cer = new Cercle();
		cer.setR(57);
		assertEquals("test getR", 57, cer.getR(), CoordonneesTest.DELTA);
	}

	@Test
	public void perimetre() {
		Cercle cer = new Cercle();
		assertEquals("test perimetre", 2*Math.PI*cer.getR(), cer.perimetre(), CoordonneesTest.DELTA);
	}

	@Test
	public void testContient() {
		Cercle cer = new Cercle(10);
		assertTrue("Test contient true", cer.contient(new Coordonnees(5,5)));
		assertFalse("Test contient false", cer.contient(new Coordonnees(1,1)));
	}

	@Test
	public void setHauteur() {
		Cercle cer = new Cercle();
		cer.setHauteur(456);
		assertEquals("test setHauteur", 456, cer.getHauteur(), CoordonneesTest.DELTA);
	}

	@Test
	public void setLargeur() {
		Cercle cer = new Cercle();
		cer.setLargeur(456);
		assertEquals("test setLargeur", 456, cer.getLargeur(), CoordonneesTest.DELTA);
	}

	@Test
	public void testToString() {
		Cercle cer = new Cercle(new Coordonnees(1,1),10);
		Locale.setDefault(Locale.FRENCH);
		assertEquals("Test to String FR",cer.toString(),"[Cercle] : pos (1,0 , 1,0) dim 10,0 x 10,0 périmètre : 31,42" +
				" aire : 78,54 couleur = R51,V51,B51");
		cer.setRempli(true);
		assertEquals("Test to String FR Rempli",cer.toString(),"[Cercle-Rempli] : pos (1,0 , 1,0) dim 10,0 x 10,0 " +
				"périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51");
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("Test to String FR Rempli",cer.toString(),"[Cercle-Rempli] : pos (1.0 , 1.0) dim 10.0 x 10.0 " +
				"périmètre : 31.42 aire : 78.54 couleur = R51,G51,B51");
	}

	@Test
	public void testSetCouleur() {
		Cercle cer = new Cercle();
		cer.setCouleur(Color.BLUE);
		assertEquals("Test setCouleur", Color.BLUE, cer.getCouleur());
	}
}