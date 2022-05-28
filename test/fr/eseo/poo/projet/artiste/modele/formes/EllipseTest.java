package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.CoordonneesTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.util.Locale;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EllipseTest {

	@Test
	public void testEllipse() {
		Ellipse el1 = new Ellipse();
		assertTrue("Test Ellipse position", el1.getPosition().equals(new Coordonnees(0,0)));
		assertEquals("Test Ellipse hauteur", 20, el1.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test Ellipse largeur", 20, el1.getHauteur(), CoordonneesTest.DELTA);
	}

	@Test
	public void testEllipseCoordonnees() {
		Ellipse el1 = new Ellipse(new Coordonnees(8,9));
		assertTrue("Test EllipseCoordonnees position", el1.getPosition().equals(new Coordonnees(8,9)));
		assertEquals("Test EllipseCoordonnees largeur", 20, el1.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test EllipseCoordonnees hauteur", 20, el1.getHauteur(), CoordonneesTest.DELTA);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void testEllipseDoubleDouble() {
		Ellipse el1 = new Ellipse(8,6);
		assertTrue("Test EllipseDoubleDouble position", el1.getPosition().equals(new Coordonnees(0,0)));
		assertEquals("Test EllipseDoubleDouble largeur", 8, el1.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test EllipseDoubleDouble hauteur", 6, el1.getHauteur(), CoordonneesTest.DELTA);
		exception.expectMessage("Merci d'entrer une hauteur et une largeur positives");
		Ellipse el2 = new Ellipse(-5,-9);
	}

	@Test
	public void testEllipseDoubleDouble2() {
		exception.expectMessage("Merci d'entrer une hauteur et une largeur positives");
		Ellipse el = new Ellipse(-5, 6);
	}

	@Test
	public void testEllipseCoordonneesDoubleDouble() {
		exception.expectMessage("Merci d'entrer une hauteur et une largeur positives");
		Ellipse el = new Ellipse(new Coordonnees(0,1),5,9);
		Ellipse el2 = new Ellipse(new Coordonnees(0,1),-5,-9);
	}

	@Test
	public void testEllipseCoordonneesDoubleDouble2() {
		exception.expectMessage("Merci d'entrer une hauteur et une largeur positives");
		Ellipse el = new Ellipse(new Coordonnees(0,1),-5,6);
	}

	@Test
	public void testDeplacerDeDoubleDouble() {
		double a=3;
		double b=2;
		Ellipse el1 = new Ellipse(new Coordonnees(a,b),2,3);
			el1.deplacerDe(-5,-5);
		assertFalse("Test position Ellipse sans deplacement", el1.getPosition().equals(new Coordonnees(a,b)));
		assertTrue("Test position Ellipse sans deplacement", el1.getPosition().equals(new Coordonnees(-2,-3)));
		assertEquals("Test largeur Ellipse sans deplacement", 2, el1.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test hauteur Ellipse sans deplacement", 3, el1.getHauteur(), CoordonneesTest.DELTA);
	}
	@Test
	public void testDeplacerVersDoubleDouble() {
		Ellipse el1 = new Ellipse(new Coordonnees(3,2),2,3);
		assertTrue("Test position Ellipse sans deplacement", el1.getPosition().equals(new Coordonnees(3,2)));
		assertEquals("Test largeur Ellipse sans deplacement", 2, el1.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test hauteur Ellipse sans deplacement", 3, el1.getHauteur(), CoordonneesTest.DELTA);
		el1.deplacerVers(1,5);
		assertTrue("Test position Ellipse sans deplacement", el1.getPosition().equals(new Coordonnees(1,5)));
		assertEquals("Test largeur Ellipse sans deplacement", 2, el1.getLargeur(), CoordonneesTest.DELTA);
		assertEquals("Test hauteur Ellipse sans deplacement", 3, el1.getHauteur(), CoordonneesTest.DELTA);
	}

	@Test
	public void getAGetB() {
		Ellipse el = new Ellipse(1,2);
		assertEquals("test getA",0.5,el.getA(),CoordonneesTest.DELTA);
		assertEquals("test getB", 1,el.getB(),CoordonneesTest.DELTA);
	}

	@Test
	public void setASetB() {
		Ellipse el = new Ellipse(1,2);
		el.setA(1);
		el.setB(1.5);
		assertEquals("test setA",1,el.getA(),CoordonneesTest.DELTA);
		assertEquals("test setB", 1.5,el.getB(),CoordonneesTest.DELTA);
	}

	@Test
	public void setPosition() {
		Ellipse el1 = new Ellipse();
		el1.setPosition(new Coordonnees(-4,-20));
		el1.setLargeur(40);
		assertEquals("Test largeur après deplacement", 40, el1.getLargeur(), CoordonneesTest.DELTA);
	}

	@Test
	public void aire() {
		Ellipse el1 = new Ellipse();
		el1.setA(5);
		el1.setB(3);
		assertEquals("Test aire", 47.1, el1.aire(), CoordonneesTest.DELTA);
	}

	@Test
	public void perimetre() {
		Ellipse el1 = new Ellipse();
		el1.setA(12);
		el1.setB(13);
		assertEquals("Test perimetre", 78.6, el1.perimetre(), CoordonneesTest.DELTA);
	}

	@Test
	public void testContient() {
		Ellipse el1 = new Ellipse(new Coordonnees(1,1),20,60);
		assertTrue("Test contient true",el1.contient(new Coordonnees(10,30)));
		assertFalse("Test contient false",el1.contient(new Coordonnees(2,2)));
	}

	@Test
	public void setHauteur() {
		Ellipse el1 = new Ellipse(new Coordonnees(3,2),2,3);
		el1.setHauteur(1);
		assertEquals("Test changement de hauteur", 1 , el1.getHauteur(),CoordonneesTest.DELTA);
		exception.expectMessage("Merci d'entrer une hauteur positive");
		el1.setHauteur(-3);
	}

	@Test
	public void setLargeur() {
		Ellipse el1 = new Ellipse(new Coordonnees(3,2),2,3);
		el1.setLargeur(4);
		el1.setHauteur(5);
		el1.setPosition(new Coordonnees(-1,-1));
		assertEquals("Test changement de largeur", 4 , el1.getLargeur(),CoordonneesTest.DELTA);
		assertTrue("Test bottom right",el1.getCadreMaxX()==3 && el1.getCadreMaxY()==4);
		assertTrue("Test top left",el1.getCadreMinX()==-1 && el1.getCadreMinY()==-1);
		exception.expectMessage("Merci d'entrer une hauteur positive");
		el1.setLargeur(-3);
	}

	@Test
	public void testToString() {
		Ellipse el1 = new Ellipse(new Coordonnees(3,2),2,3);
		Locale.setDefault(Locale.FRENCH);
		assertEquals("test string Ellipse", "[Ellipse] : pos (3,0 , 2,0) dim 2,0 x 3,0 " +
				"périmètre : 7,93 aire : 4,71 couleur = R51,V51,B51", el1.toString());
		el1.setRempli(true);
		Locale.setDefault(Locale.CHINESE);
		assertEquals("test string Ellipse","[Ellipse-Rempli] : pos (3.0 , 2.0) dim 2.0 x 3.0 " +
				"périmètre : 7.93 aire : 4.71 couleur = R51,G51,B51", el1.toString());
	}

	@Test
	public void testEstRempli() {
		Ellipse el1 = new Ellipse(new Coordonnees(3,2),2,3);
		assertFalse("test getEstRempli", el1.remplissage);
		el1.setRempli(true);
		assertTrue("Test setRempli", el1.remplissage);
	}
}