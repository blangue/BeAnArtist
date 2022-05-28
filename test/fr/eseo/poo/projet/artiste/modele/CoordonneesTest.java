
package fr.eseo.poo.projet.artiste.modele;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CoordonneesTest {
	public static final double DELTA = 0.1;
	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#Coordonnees()}.
	 */
	@Test
	public void testCoordonnees() {
		Coordonnees coord = new Coordonnees();
		assertEquals("Constructeur vide fonctionnel absc", Coordonnees.ABSCISSE_PAR_DEFAUT
				, coord.getAbscisse(), DELTA);
		assertEquals("Constructeur vide fonctionnel ordo", Coordonnees.ORDONNEE_PAR_DEFAUT
				, coord.getOrdonnee(), DELTA);
	}

	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#Coordonnees(double, double)}.
	 */
	@Test
	public void testCoordonneesDoubleDouble() {
		Coordonnees coord = new Coordonnees(8.9,7.6);
		assertEquals("Constructeur vide fonctionnel absc", 8.9, coord.getAbscisse(), DELTA);
		assertEquals("Constructeur vide fonctionnel ordo", 7.6, coord.getOrdonnee(), DELTA);
	}

	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#getAbscisse()}.
	 */
	@Test
	public void testGetAbscisse() {
		Coordonnees coord = new Coordonnees(6.7,0.0);
		assertEquals("test GetAbscisse absc", coord.abscisse, coord.getAbscisse(), DELTA);
	}

	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#setAbscisse(double)}.
	 */
	@Test
	public void testSetAbscisse() {
		Coordonnees coord = new Coordonnees();
		coord.setAbscisse(0.4);
		assertEquals("test setAbscisse", coord.getAbscisse(), 0.4, DELTA);
	}

	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#getOrdonnee()}.
	 */
	@Test
	public void testGetOrdonnee() {
		Coordonnees coord = new Coordonnees(6.7,4.5);
		assertEquals("test GetAbscisse absc", coord.ordonnee, coord.getOrdonnee(), DELTA);
	}

	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#setOrdonnee(double)}.
	 */
	@Test
	public void testSetOrdonnee() {
		Coordonnees coord = new Coordonnees();
		coord.setOrdonnee(0.4);
		assertEquals("test setOrdonnee", coord.getOrdonnee(), 0.4, DELTA);
	}

	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#deplacerVers(double, double)}.
	 */
	@Test
	public void testDeplacerVersDoubleDouble() {
		Coordonnees coord = new Coordonnees(1,2);
		coord.deplacerVers(6,3);
		Coordonnees coord2 = new Coordonnees(6,3);
		assertTrue("Test deplacerVers", coord.equals(coord2));
	}

	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#deplacerDe(double, double)}.
	 */
	@Test
	public void testDeplacerDeDoubleDouble() {
		Coordonnees coord = new Coordonnees(1,2);
		coord.deplacerDe(6,-3);
		Coordonnees coord2 = new Coordonnees(7,-1);
		assertTrue("Test deplacerDe", coord.equals(coord2));
	}

	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#distanceVers(double, double)}.
	 */
	@Test
	public void testDistanceVersDoubleDouble() {
		Coordonnees coord = new Coordonnees();
		double dist = coord.distanceVers(Math.sqrt(3)/2,0.5);
		assertEquals("Test distance vers Double Double", dist, 1, DELTA);
	}

	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#distanceVers(fr.eseo.poo.projet.artiste.modele.Coordonnees)}.
	 */
	@Test
	public void testDistanceVersCoordonnees() {
		Coordonnees coord = new Coordonnees();
		Coordonnees coord2 = new Coordonnees(1,2);
		assertEquals("Test distance vers Coordonnees", coord.distanceVers(coord2), coord.distanceVers(1,2), DELTA);
	}

	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#angleVers(fr.eseo.poo.projet.artiste.modele.Coordonnees)}.
	 */
	@Test
	public void testAngleVers() {
		Coordonnees coord = new Coordonnees();
		Coordonnees coord2 = new Coordonnees(1,1);
		assertEquals("Test angleVers", coord.angleVers(coord2),Math.PI/4, DELTA);
		Coordonnees coord3 = new Coordonnees(1,0);
		assertEquals("Test angleVers2", coord2.angleVers(coord3),-Math.PI/2, DELTA);
	}


	/**
	 * Test method for {@link fr.eseo.poo.projet.artiste.modele.Coordonnees#toString()}.
	 */
	@Test
	public void testToString() {
		Coordonnees coord = new Coordonnees(1,2);
		assertEquals("Test toString",coord.toString(),"(1,0 , 2,0)");
	}

	@Test
	public void testEquals() {
		Coordonnees coord = new Coordonnees(1,2);
		assertFalse("test pas equals", coord.equals(new Coordonnees(1,1)));
		assertFalse("test pas equals2", coord.equals(new Coordonnees(2,1)));
		assertFalse("test pas equals3", coord.equals(new Coordonnees(5,2)));
	}
}
