package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.CoordonneesTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangleTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testConstructeur() {
		Rectangle rect = new Rectangle();
		assertTrue("test contructeur position", rect.getPosition().equals(new Coordonnees()));
		assertEquals("test contructeur Hauteur", rect.getHauteur(),20,CoordonneesTest.DELTA);
		assertEquals("test contructeur Largeur", rect.getLargeur(),20,CoordonneesTest.DELTA);

		rect = new Rectangle(new Coordonnees(1,2));
		assertTrue("test contructeurCoord position", rect.getPosition().equals(new Coordonnees(1,2)));
		assertEquals("test contructeurCoord Hauteur", rect.getHauteur(),20,CoordonneesTest.DELTA);
		assertEquals("test contructeurCoord Largeur", rect.getLargeur(),20,CoordonneesTest.DELTA);

		exception.expectMessage("Merci d'entrer une hauteur et une largeur positives");
		new Rectangle(10,-20);
	}

	@Test
	public void testConstructeur2() {
		exception.expectMessage("Merci d'entrer une hauteur et une largeur positives");
		new Rectangle(-10,-20);
	}

	@Test
	public void testConstructeur3() {
		exception.expectMessage("Merci d'entrer une hauteur et une largeur positives");
		new Rectangle(new Coordonnees(2,2), 10,-20);
	}

	@Test
	public void testConstructeur4() {
		exception.expectMessage("Merci d'entrer une hauteur et une largeur positives");
		new Rectangle(new Coordonnees(3,3), -10,30);
	}

	@Test
	public void testRemplissage() {
		Rectangle rect = new Rectangle(12,23);
		assertEquals("Test estRempli", rect.remplissage,rect.estRempli());
		rect.setRempli(true);
		assertTrue("Test setRempli", rect.estRempli());
		}

	@Test
	public void aire() {
		Rectangle rect = new Rectangle(12,23);
		assertEquals("test aire",rect.aire(),276, CoordonneesTest.DELTA);
	}

	@Test
	public void perimetre() {
		Rectangle rect = new Rectangle(12,23);
		assertEquals("test peri",rect.perimetre(),70, CoordonneesTest.DELTA);
	}

	@Test
	public void setHauteur() {
		new Rectangle().setHauteur(12);
		exception.expectMessage("Merci d'entrer une hauteur positive");
		new Rectangle().setHauteur(-12);
	}

	@Test
	public void setLargeur() {
		new Rectangle().setLargeur(12);
		exception.expectMessage("Merci d'entrer une largeur positive");
		new Rectangle().setLargeur(-12);
	}

	@Test
	public void contient() {
		Rectangle rect = new Rectangle(10,20);
//		ok
		assertTrue(rect.contient(new Coordonnees(6,13)));
//		X
		assertFalse(rect.contient(new Coordonnees(12,13)));
		assertFalse(rect.contient(new Coordonnees(-2,13)));
//		Y
		assertFalse(rect.contient(new Coordonnees(8,26)));
		assertFalse(rect.contient(new Coordonnees(6,-3)));
	}

	@Test
	public void testToString() {
		Rectangle rect = new Rectangle(new Coordonnees(3,2),2,3);
		Locale.setDefault(Locale.FRENCH);
		assertEquals("test string Rectangle", "[Rectangle] : pos (3,0 , 2,0) dim 2,0 x 3,0 " +
				"périmètre : 10,0 aire : 6,0 couleur = R51,V51,B51", rect.toString());
		rect.setRempli(true);
		Locale.setDefault(Locale.CHINESE);
		assertEquals("test string Rectangle","[Rectangle-Rempli] : pos (3.0 , 2.0) dim 2.0 x 3.0 " +
				"périmètre : 10.0 aire : 6.0 couleur = R51,G51,B51", rect.toString());
		Locale.setDefault(Locale.FRENCH);
	}
}