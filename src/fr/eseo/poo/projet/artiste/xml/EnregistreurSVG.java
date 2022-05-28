package fr.eseo.poo.projet.artiste.xml;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * L'enregistreur SVG est responsable de l'enregistrement d'un dessin au format
 * SVG (sous-ensemble du standard SVG).
 * 
 * Il utilise les classes java.io.FileWriter et java.io.Writer de l'API Java
 * standard qui permettent d'écrire très simplement dans un fichier texte.
 * 
 * Les méthodes ecrisXxxx devront être complétées.
 *
 */
public class EnregistreurSVG {

	/**
	 * Lance le test d'enregistrement (méthode teste) avec le fichier SVG
	 * d'entrée "Dessin-in.svg" et le fichier SVG de sortie "Dessin-out.svg".
	 * 
	 * Vérifier la conformité du fichier de sortie en l'affichant avec un
	 * navigateur Web et en comparant cet affichage avec celui fourni par la
	 * méthode LecteurSVG.main.
	 */
	public static void main(String[] args) throws IOException, XPathExpressionException {
		EnregistreurSVG enregistreur = new EnregistreurSVG();
		enregistreur.teste("Dessin-in.svg", "Dessin-out.svg");
	}

	/**
	 * Teste l'enregistrement du dessin dans un fichier SVG. Le fichier SVG
	 * d'entrée est préalablement lu, puis sauvagardé dans un fichier de sortie.
	 * Le fichier de sortie est ensuite chargé et visualisé par l'application.
	 * 
	 * @param nomFichierEntrée le nom du fichier SVG d'entrée lu
	 * @param nomFichierSortie le nom du fichier SVG de sortie écrit
	 * @throws FileNotFoundException si l'un des noms des fichiers n'est pas
	 *             valide
	 */
	public void teste(String nomFichierEntrée, String nomFichierSortie) throws IOException, XPathExpressionException {
		LecteurSVG lecteur = new LecteurSVG();
		List<VueForme> dessin = lecteur.lisDessin(nomFichierEntrée);
		enregistreDessin(nomFichierSortie, dessin);
		lecteur.teste(nomFichierSortie);
	}

	/**
	 * Enregistre le dessin donné dans un fichier.
	 * 
	 * @param nomFichier le nom du fichier de sauvegarde
	 * @param dessin le dessin formé de la liste des vues des formes
	 * @throws IOException si l'écriture échoue
	 */
	public void enregistreDessin(String nomFichier, List<VueForme> dessin) throws IOException {
		Writer redacteur = new FileWriter(nomFichier);
		redacteur.write("<?xml version='1.0' encoding='UTF-8' ?>\n");
		ecrisDessin(dessin, redacteur);
		redacteur.close();
	}

	/**
	 * Ecris chaque forme du dessin
	 * 
	 * @param dessin Le dessin à écrire
	 * @param redacteur Le rédacteur SVG
	 * @throws IOException si l'écriture échoue
	 */
	public void ecrisDessin(List<VueForme> dessin, Writer redacteur) throws IOException {
		redacteur.write("<svg xmlns='http://www.w3.org/2000/svg'>\n");
		for (VueForme vueForme : dessin) {
			ecrisForme(vueForme.getForme(), redacteur);
		}
		redacteur.write("</svg>");
	}

	/**
	 * Ecris la forme. Cette méthode invoque les méthodes ecris<Forme> en
	 * fonction du type de la forme.
	 * 
	 * @param dessin Le dessin à écrire
	 * @param redacteur Le rédacteur SVG
	 * @throws IOException si l'écriture échoue
	 */
	public void ecrisForme(Forme forme, Writer redacteur) throws IOException {
		String nom = forme.getClass().getSimpleName();
		switch (nom) {
			case "Ellipse":
				// TODO à modifier
				nom = "(à définir)";
				break;
			case "Cercle":
				// TODO à modifier
				nom = "(à définir)";
				break;
			case "Ligne":
				// TODO à modifier
				nom = "(à définir)";
				break;
			case "Trace":
				// TODO à modifier
				nom = "(à définir)";
				break;
		}
		redacteur.write("\t<" + nom + " ");
		switch (nom) {
			case "ellipse":
				ecrisEllipse((Ellipse) forme, redacteur);
				break;
			case "circle":
				ecrisCercle((Cercle) forme, redacteur);
				break;
			case "line":
				ecrisLigne((Ligne) forme, redacteur);
				break;
			case "polygon":
				ecrisEtoile((Etoile) forme, redacteur);
				break;
		}
		// définition de la couleur de la forme
		Color c = forme.getCouleur();
		// TODO initialiser correctement la variable qui suit
		String couleur = "black";
		redacteur.write("fill='none' stroke='" + couleur + "'");
		redacteur.write("/>\n");
	}

	/**
	 * Ecris l'ellispe.
	 * 
	 * @param forme la forme à écrire
	 * @param redacteur Le rédacteur SVG
	 * @throws IOException si l'écriture échoue
	 */
	public void ecrisEllipse(Ellipse forme, Writer redacteur) throws IOException {
		double rx = forme.getLargeur() / 2;
		double ry = forme.getHauteur() / 2;
		// TODO à compléter 
	}

	/**
	 * Ecris le cercle.
	 * 
	 * @param forme la forme à écrire
	 * @param redacteur Le rédacteur SVG
	 * @throws IOException si l'écriture échoue
	 */
	public static void ecrisCercle(Cercle forme, Writer redacteur) throws IOException {
		double r = forme.getLargeur() / 2;
		// TODO à compléter 
	}

	/**
	 * Ecris la ligne.
	 * 
	 * @param forme la forme à écrire
	 * @param redacteur Le rédacteur SVG
	 * @throws IOException si l'écriture échoue
	 */
	public static void ecrisLigne(Ligne forme, Writer redacteur) throws IOException {
		// TODO à compléter 
	}

	/**
	 * Ecris l'étoile.
	 * 
	 * @param forme la forme à écrire
	 * @param redacteur Le rédacteur SVG
	 * @throws IOException si l'écriture échoue
	 */
	public void ecrisEtoile(Etoile forme, Writer redacteur) throws IOException {
		// TODO à compléter 
		for (Coordonnees point : forme.getCoordonnees()) {
			// TODO à compléter 
		}
		// TODO à compléter 
	}

}
