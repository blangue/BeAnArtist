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

public class EtoileTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testConstruct() {
		Etoile et = new Etoile(new Coordonnees(1,1));
		assertTrue("Test Position Etoile", et.getPosition().equals(new Coordonnees(1,1)));
		assertEquals("Test nbBr Etoile", Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, et.getNombreBranches());
		assertEquals("Test angle Etoile", Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, et.getAnglePremiereBranche(), CoordonneesTest.DELTA);
		assertEquals("Test longueur Etoile", Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, et.getLongueurBranche(), CoordonneesTest.DELTA);

		et = new Etoile(52);
		assertTrue("Test Position Etoile constructeur 2", et.getPosition().equals(new Coordonnees()));
		assertEquals("Test nbBr Etoile constructeur 2", Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, et.getNombreBranches());
		assertEquals("Test angle Etoile constructeur 2", Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				et.getAnglePremiereBranche(), CoordonneesTest.DELTA);
		assertEquals("Test longueur Etoile constructeur 2", Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, et.getLongueurBranche(),
				CoordonneesTest.DELTA);
		assertEquals("Test taille Etoile constructeur 2", 52, et.getLargeur(), CoordonneesTest.DELTA);

		et = new Etoile(new Coordonnees(1,1), 52);
		assertTrue("Test Position Etoile constructeur 3", et.getPosition().equals(new Coordonnees(1,1)));
		assertEquals("Test nbBr Etoile constructeur 3", Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, et.getNombreBranches());
		assertEquals("Test angle Etoile constructeur 3", Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				et.getAnglePremiereBranche(), CoordonneesTest.DELTA);
		assertEquals("Test longueur Etoile constructeur 3", Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
				et.getLongueurBranche(), CoordonneesTest.DELTA);
		assertEquals("Test taille Etoile constructeur 3", 52, et.getLargeur(), CoordonneesTest.DELTA);

		et = new Etoile(new Coordonnees(1,1), 50,4,0.17,0.58);
		assertTrue("Test Position Etoile contructeur 4", et.getPosition().equals(new Coordonnees(1,1)));
		assertEquals("Test nbBr Etoile contructeur 4", 4, et.getNombreBranches());
		assertEquals("Test angle Etoile contructeur 4", 0.17, et.getAnglePremiereBranche(), CoordonneesTest.DELTA);
		assertEquals("Test longueur Etoile contructeur 4", 0.58, et.getLongueurBranche(), CoordonneesTest.DELTA);
		assertEquals("Test taille Etoile contructeur 4", 50, et.getLargeur(), CoordonneesTest.DELTA);

		exception.expectMessage("Merci d'entrer une taille positive");
		new Etoile(-10);
	}

	@Test
	public void testContructErreur11() {
		exception.expectMessage("Merci d'entrer une taille positive");
		new Etoile(new Coordonnees(1,1), -50,4,0.17,0.58);
	}
	@Test
	public void testContructErreur12() {
		exception.expectMessage("Merci d'entrer une taille positive");
		new Etoile(new Coordonnees(1,1), -50);
	}
	@Test
	public void testContructErreur21() {
		exception.expectMessage("Merci d'entrer une angle entre -pi et +pi");
		new Etoile(new Coordonnees(1,1), 50,4,-4,0.58);
	}
	@Test
	public void testContructErreur22() {
		exception.expectMessage("Merci d'entrer une angle entre -pi et +pi");
		new Etoile(new Coordonnees(1,1), 50,4,4,0.58);
	}

	@Test
	public void testContructErreur31() {
		exception.expectMessage("Merci d'entrer un nombre de branches de 3 à 15");
		new Etoile(new Coordonnees(1,1), 50,2,-0.17,0.58);
	}
	@Test
	public void testContructErreur32() {
		exception.expectMessage("Merci d'entrer un nombre de branches de 3 à 15");
		new Etoile(new Coordonnees(1,1), 50,16,-0.17,0.58);
	}

	@Test
	public void testContructErreur41() {
		exception.expectMessage("Merci d'entrer une longueur de branche entre 0 et 1");
		new Etoile(new Coordonnees(1,1), 50,4,-0.17,-1.2);
	}
	@Test
	public void testContructErreur42() {
		exception.expectMessage("Merci d'entrer une longueur de branche entre 0 et 1");
		new Etoile(new Coordonnees(1,1), 50,4,-0.17,4);
	}

	@Test
	public void aire() {
		Etoile et = new Etoile();
		assertEquals("Test aire Etoile", 146.9, et.aire(), CoordonneesTest.DELTA);
	}

	@Test
	public void perimetre() {
		Etoile et = new Etoile();
		assertEquals("Test perimetre Etoile", 66.4, et.perimetre(), CoordonneesTest.DELTA);
	}

	@Test
	public void contient() {
		Etoile et = new Etoile();
		assertTrue("Test contient true", et.contient(new Coordonnees(10,10)));
		assertFalse("Test contient false", et.contient(new Coordonnees(1,1)));
		assertTrue("Test contient true bordure", et.contient(new Coordonnees(10.0 , 20.0)));
	}

	@Test
	public void estRempli() {
		Etoile et = new Etoile();
		assertEquals("Test estRempli", et.remplissage, et.estRempli());
		et.remplissage=true;
		assertEquals("Test estRempli", et.remplissage, et.estRempli());
	}

	@Test
	public void setRempli() {
		Etoile et = new Etoile();
		assertFalse("Test estRempli false", et.estRempli());
		et.setRempli(true);
		assertTrue("Test estRempli true", et.estRempli());
	}

	@Test
	public void setHauteur() {
		Etoile et = new Etoile();
		et.setHauteur(53);
		assertEquals("Test setLargeur", 53,et.getHauteur(), CoordonneesTest.DELTA);
		exception.expectMessage("Merci d'entrer une taille positive");
		et.setHauteur(-4);
	}

	@Test
	public void setLargeur() {
		Etoile et = new Etoile();
		et.setLargeur(53);
		assertEquals("Test setLargeur", 53,et.getLargeur(), CoordonneesTest.DELTA);
		exception.expectMessage("Merci d'entrer une taille positive");
		et.setLargeur(-4);
	}

	@Test
	public void getCoordonnees() {
		Etoile et = new Etoile();
		boolean identique = true;
		for (int i = 0; i<et.getCoordonnees().size();i++){
			identique &= et.getCoordonnees().get(i).equals(et.listeDeCoordonnees().get(i));
		}
		assertTrue("Test getCoordonnees", identique);
}


	@Test
	public void getNombreBranches() {
		Etoile et = new Etoile();
		assertEquals("Test setNbBr avant chgmt", et.nombreBranches, et.getNombreBranches());
	}
	@Test
	public void setNombreBranches() {
		Etoile et = new Etoile();
		assertEquals("Test setNbBr avant chgmt", 5, et.nombreBranches);
		et.setNombreBranches(8);
		assertEquals("Test setNbBr après chgmt", 8, et.nombreBranches);
		exception.expectMessage("Merci d'entrer un nombre de branches de 3 à 15");
		et.setNombreBranches(16);
	}

	@Test
	public void setNombreBranches2() {
		Etoile et = new Etoile();
		exception.expectMessage("Merci d'entrer un nombre de branches de 3 à 15");
		et.setNombreBranches(1);
	}

	@Test
	public void getAnglePremiereBranche() {
		Etoile et = new Etoile();
		assertEquals("Test getAngle", et.anglePremiereBranche, et.getAnglePremiereBranche(), CoordonneesTest.DELTA);
	}

	@Test
	public void setAnglePremiereBranche() {
		Etoile et = new Etoile();
		et.setAnglePremiereBranche(2);
		assertEquals("Test setAngle", 2, et.getAnglePremiereBranche(), CoordonneesTest.DELTA);
		exception.expectMessage("Merci d'entrer une angle entre -pi et +pi");
		et.setAnglePremiereBranche(-4);
	}
	@Test
	public void setAnglePremiereBranche2() {
		Etoile et = new Etoile();
		exception.expectMessage("Merci d'entrer une angle entre -pi et +pi");
		et.setAnglePremiereBranche(4);
	}
	@Test
	public void getLongueurBranche() {
		Etoile et = new Etoile();
		assertEquals("Test getAngle", et.longueurBranche, et.getLongueurBranche(), CoordonneesTest.DELTA);
	}

	@Test
	public void setLongueurBranche() {
		Etoile et = new Etoile();
		et.setLongueurBranche(0.4);
		assertEquals("Test setLongueur", 0.4, et.getLongueurBranche(), CoordonneesTest.DELTA);
		exception.expectMessage("Merci d'entrer une longueur de branche entre 0 et 1");
		et.setLongueurBranche(-4);
	}
	@Test
	public void setLongueurBranche2() {
		Etoile et = new Etoile();
		exception.expectMessage("Merci d'entrer une longueur de branche entre 0 et 1");
		et.setLongueurBranche(5);
	}

	@Test
	public void testToString() {
		Etoile et = new Etoile(new Coordonnees(1,1),10,6,0.15,0.5);
		Locale.setDefault(Locale.FRENCH);
		assertEquals("Test to String FR","[Etoile] : pos (1,0 , 1,0) dim 10,0 x 10,0 périmètre : 37,18 aire : 37,5 " +
				"couleur = R51,V51,B51",et.toString());
		et.setRempli(true);
		assertEquals("Test to String FR Rempli","[Etoile-Rempli] : pos (1,0 , 1,0) dim 10,0 x 10,0 périmètre : 37,18 " +
				"aire : 37,5 couleur = R51,V51,B51",et.toString());
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("Test to String FR Rempli","[Etoile-Rempli] : pos (1.0 , 1.0) dim 10.0 x 10.0 périmètre : 37.18 " +
				"aire : 37.5 couleur = R51,G51,B51",et.toString());
	}
}