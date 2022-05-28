package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.CoordonneesTest;
import org.junit.Test;

import java.awt.Color;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LigneTest {

	private  final Coordonnees position = new Coordonnees();
	private final Ligne ligne = new Ligne(position);

	@Test
	public void testAire() {
		assertEquals("test aire", ligne.aire(), 0, CoordonneesTest.DELTA);
	}

	@Test
	public void testPerimetre() {
		Ligne ligne2 = new Ligne(1,1);
		assertEquals("test perimetre",Math.sqrt(2), ligne2.perimetre(), CoordonneesTest.DELTA);
	}

	@Test
	public void testLigne() {
		Ligne ligne2 = new Ligne();
		assertTrue("test Constructeur Ligne position", ligne2.getPosition().equals(new Coordonnees()));
		assertEquals("test Constructeur Ligne hauteur", ligne2.getHauteur(), 20, CoordonneesTest.DELTA);
		assertEquals("test Constructeur Ligne largeur", ligne2.getLargeur(), 20, CoordonneesTest.DELTA);
	}

	@Test
	public void testLigneCoordonnees() {
		assertTrue("Test Constructeur LigneCoordonnees position", ligne.getPosition().equals(new Coordonnees()));
	}

	@Test
	public void testLigneDoubleDouble() {
		Ligne ligne2 = new Ligne(5.4,6.5);
		assertTrue("test Constructeur Ligne position", ligne2.getPosition().equals(new Coordonnees(0,0)));
		assertEquals("test Constructeur Ligne hauteur", ligne2.getHauteur(), 6.5, CoordonneesTest.DELTA);
		assertEquals("test Constructeur Ligne largeur", ligne2.getLargeur(), 5.4, CoordonneesTest.DELTA);
		assertTrue("test Constructeur Ligne c2",ligne2.getC2().equals(new Coordonnees(5.4,6.5)));

	}

	@Test
	public void testLigneCoordonneesDoubleDouble() {
		Ligne ligne2 = new Ligne(new Coordonnees(4,5),5.4,6.5);
		assertTrue("test Constructeur Ligne position", ligne2.getPosition().equals(new Coordonnees(4,5)));
		assertEquals("test Constructeur Ligne hauteur", ligne2.getHauteur(), 6.5, CoordonneesTest.DELTA);
		assertEquals("test Constructeur Ligne largeur", ligne2.getLargeur(), 5.4, CoordonneesTest.DELTA);
	}

	@Test
	public void testGetC1() {
		Ligne ligne2 = new Ligne(new Coordonnees(1,5), 12,10);
		assertTrue("Test getC1 position", ligne2.getC1().equals(new Coordonnees(1,5)));
	}

	@Test
	public void testSetC1() {
		Ligne ligne2 = new Ligne(new Coordonnees(1,5), 10,15);
		ligne2.setC1(new Coordonnees(3,7));
		assertTrue("Test setC1 C1",ligne2.getC1().equals(new Coordonnees(3,7)));
		assertTrue("Test setC1 position",ligne2.getPosition().equals(new Coordonnees(3,7)));
		assertEquals("Test setC1 hauteur", 13, ligne2.getHauteur(), CoordonneesTest.DELTA);
		assertEquals("Test setC1 largeur", 8, ligne2.getLargeur(), CoordonneesTest.DELTA);
	}

	@Test
	public void testGetC2() {
		Ligne ligne2 = new Ligne(new Coordonnees(1,5), 12,10);
		assertTrue("Test getC2 position", ligne2.getC2().equals(new Coordonnees(13,15)));
	}

	@Test
	public void testSetC2() {
		Ligne ligne2 = new Ligne(new Coordonnees(1,5), 12,10);
		ligne2.setC2(new Coordonnees(3,8));
		assertTrue("Test setC2 C2",ligne2.getC2().equals(new Coordonnees(3,8)));
		assertEquals("Test setC2 hauteur", 3, ligne2.getHauteur(), CoordonneesTest.DELTA);
		assertEquals("Test setC2 largeur", 2, ligne2.getLargeur(), CoordonneesTest.DELTA);
	}

	@Test
	public void testToString() {
		Ligne ligne2 = new Ligne(new Coordonnees(1,5), 12,10);
		ligne2.setCouleur(new Color(208, 33, 33));
		assertEquals("Test toString FR","[Ligne] c1 : (1,0 , 5,0) c2 : (13,0 , 15,0) longueur : 15,62 angle : 39,81° " +
				"couleur = R208,V33,B33",ligne2.toString());
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("Test toString EN","[Ligne] c1 : (1.0 , 5.0) c2 : (13.0 , 15.0) longueur : 15.62 angle : 39.81° " +
				"couleur = R208,G33,B33",ligne2.toString());
		Locale.setDefault(Locale.CHINESE);
		assertEquals("Test toString EN", "[Ligne] c1 : (1.0 , 5.0) c2 : (13.0 , 15.0) longueur : 15.62 angle : 39.81°" +
				" couleur = R208,G33,B33",ligne2.toString());

		ligne2.setC2(new Coordonnees(1,4));
		assertEquals("Test toString EN angle nega", "[Ligne] c1 : (1.0 , 5.0) c2 : (1.0 , 4.0) longueur : 1.0 angle :" +
				" 270.0° couleur = R208,G33,B33",ligne2.toString());
	}

	@Test
	public void testContient() {
		Ligne ligne2 = new Ligne(new Coordonnees(1,1), 3,3);
		assertTrue(ligne2.contient(new Coordonnees(2,2)));
		assertTrue(ligne2.contient(new Coordonnees(3,3)));
		assertFalse(ligne2.contient(new Coordonnees(2,3)));
	}

	@Test
	public void testSetPosition() {
		Ligne ligne2 = new Ligne(new Coordonnees(1,5), 12,10);
		ligne2.setPosition(new Coordonnees(1,6));
		assertTrue(ligne2.getPosition().equals(new Coordonnees(1,6)));
		assertTrue(ligne2.getC2().equals(new Coordonnees(13,16)));
	}

	@Test
	public void testGetCadre() {
		Ligne ligne2 = new Ligne(new Coordonnees(100,200), 10,-100);
		assertEquals("Test MinX", 100, ligne2.getCadreMinX(), CoordonneesTest.DELTA);
		assertEquals("Test MaxY", 200, ligne2.getCadreMaxY(), CoordonneesTest.DELTA);
		assertEquals("Test MaxX", 110, ligne2.getCadreMaxX(), CoordonneesTest.DELTA);
		assertEquals("Test MinY", 100, ligne2.getCadreMinY(), CoordonneesTest.DELTA);
		ligne2.deplacerDe(1,1);
		assertEquals("Test MinX", 101, ligne2.getCadreMinX(), CoordonneesTest.DELTA);
		assertEquals("Test MaxY", 201, ligne2.getCadreMaxY(), CoordonneesTest.DELTA);
		assertEquals("Test MaxX", 111, ligne2.getCadreMaxX(), CoordonneesTest.DELTA);
		assertEquals("Test MinY", 101, ligne2.getCadreMinY(), CoordonneesTest.DELTA);
		ligne2.setLargeur(100);
		assertEquals("Test MinX", 101, ligne2.getCadreMinX(), CoordonneesTest.DELTA);
		assertEquals("Test MaxY", 201, ligne2.getCadreMaxY(), CoordonneesTest.DELTA);
		assertEquals("Test MaxX", 201, ligne2.getCadreMaxX(), CoordonneesTest.DELTA);
		assertEquals("Test MinY", 101, ligne2.getCadreMinY(), CoordonneesTest.DELTA);
		Ligne ligne3 = new Ligne(new Coordonnees(1,4),3,-2);
		assertEquals("Test MinX Hauteur negative", 1, ligne3.getCadreMinX(), CoordonneesTest.DELTA);
		assertEquals("Test MaxY Hauteur negative", 4, ligne3.getCadreMaxY(), CoordonneesTest.DELTA);
		assertEquals("Test MaxX Hauteur negative", 4, ligne3.getCadreMaxX(), CoordonneesTest.DELTA);
		assertEquals("Test MinY Hauteur negative", 2, ligne3.getCadreMinY(), CoordonneesTest.DELTA);
		Ligne ligne4 = new Ligne(new Coordonnees(-2,-1),-1,-3);
		assertEquals("Test MinX Largeur hauteur negatives", -3, ligne4.getCadreMinX(), CoordonneesTest.DELTA);
		assertEquals("Test MaxY Largeur hauteur negatives", -1, ligne4.getCadreMaxY(), CoordonneesTest.DELTA);
		assertEquals("Test MaxX Largeur hauteur negatives", -2, ligne4.getCadreMaxX(), CoordonneesTest.DELTA);
		assertEquals("Test MinY Largeur hauteur negatives", -4, ligne4.getCadreMinY(), CoordonneesTest.DELTA);
	}

	@Test
	public void testDeplacerVers() {
		Ligne ligne2 = new Ligne(new Coordonnees(1,4),3,-2);
		ligne2.deplacerVers(2,5);
		assertTrue(ligne2.getC2().equals(new Coordonnees(5,3)));
		assertTrue(ligne2.getPosition().equals(new Coordonnees(2,5)));

	}
}
