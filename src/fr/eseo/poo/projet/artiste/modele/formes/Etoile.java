package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

import java.awt.Polygon;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Etoile extends Forme implements Remplissable {
	public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;
	public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = Math.PI/2;
	public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.5;

	public int nombreBranches;
	public double anglePremiereBranche;
	public double longueurBranche;
	private List<Coordonnees> coordonnees;
	{this.listeDeCoordonnees();}

	boolean remplissage = false;


	public Etoile() {
		this.nombreBranches = NOMBRE_BRANCHES_PAR_DEFAUT;
		this.anglePremiereBranche = ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT;
		this.longueurBranche = LONGUEUR_BRANCHE_PAR_DEFAUT;
		this.coordonnees = this.listeDeCoordonnees();
	}

	public Etoile(Coordonnees position) {
		super(position,Forme.LARGEUR_PAR_DEFAUT,Forme.LARGEUR_PAR_DEFAUT);
		this.nombreBranches = NOMBRE_BRANCHES_PAR_DEFAUT;
		this.anglePremiereBranche = ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT;
		this.longueurBranche = LONGUEUR_BRANCHE_PAR_DEFAUT;
		this.coordonnees = this.listeDeCoordonnees();
	}

	public Etoile(double taille) {
		super(taille, taille);
		if (taille<0) throw new IllegalArgumentException("Merci d'entrer une taille positive");
		this.nombreBranches = NOMBRE_BRANCHES_PAR_DEFAUT;
		this.anglePremiereBranche = ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT;
		this.longueurBranche = LONGUEUR_BRANCHE_PAR_DEFAUT;
		this.coordonnees = this.listeDeCoordonnees();
	}

	public Etoile(Coordonnees position,double taille) {
		super(position,taille,taille);
		if (taille<0) throw new IllegalArgumentException("Merci d'entrer une taille positive");
		this.nombreBranches = NOMBRE_BRANCHES_PAR_DEFAUT;
		this.anglePremiereBranche = ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT;
		this.longueurBranche = LONGUEUR_BRANCHE_PAR_DEFAUT;
		this.coordonnees = this.listeDeCoordonnees();
	}

	public Etoile(Coordonnees position, double taille, int nbBr, double anglePremiereBr, double longueurBr) {
		super(position, taille, taille);
		this.setHauteur(taille);
		if (anglePremiereBr<=-Math.PI || anglePremiereBr>Math.PI)
			throw new IllegalArgumentException("Merci d'entrer une angle entre -pi et +pi");
		else if (nbBr<3 || nbBr>15)
			throw new IllegalArgumentException("Merci d'entrer un nombre de branches de 3 à 15");
		else if (longueurBr<=0.0 || longueurBr>1.0)
			throw new IllegalArgumentException("Merci d'entrer une longueur de branche entre 0 et 1");
		this.nombreBranches = nbBr;
		this.anglePremiereBranche = anglePremiereBr;
		this.longueurBranche = longueurBr;
		this.coordonnees = this.listeDeCoordonnees();
	}

	@Override
	public double aire() {
		double base = this.getHauteur()/2;
		double a = (1-this.longueurBranche)*base;
		double angleEntreBranches = 2*Math.PI / nombreBranches;
		double hauteur = a*Math.sin(angleEntreBranches/2);
		return nombreBranches*base*hauteur;
	}

	@Override
	public double perimetre() {
		double angleEntreBranches = 2*Math.PI / nombreBranches;
		double miniBranche = (1-longueurBranche)*this.getHauteur()/2;
		double b = miniBranche*Math.cos(angleEntreBranches/2);
		double hauteurBranche = this.getHauteur()/2-b;
		double a = (1-longueurBranche)*this.getHauteur()/2 * Math.sin(angleEntreBranches/2);
		double cote = Math.sqrt(Math.pow(a,2)+Math.pow(hauteurBranche,2));
		return 2*nombreBranches*cote;
	}

	@Override
	public boolean contient(Coordonnees point) {
		Polygon etoile = new Polygon();
		for (Coordonnees coord:
		     this.listeDeCoordonnees()) {
			etoile.addPoint((int) Math.round(coord.getAbscisse()),(int) Math.round(coord.getOrdonnee()));
		}
		etoile.addPoint((int) Math.round(coordonnees.get(0).getAbscisse()),
				(int) Math.round(coordonnees.get(0).getOrdonnee()));
		return etoile.contains((int) Math.round(point.getAbscisse()),(int) Math.round(point.getOrdonnee()));
	}

	@Override
	public boolean estRempli() {
		return this.remplissage;
	}

	@Override
	public void setRempli(boolean val) {
		this.remplissage = val;
	}

	@Override
	public void setHauteur(double hauteur) {
		if (hauteur<0.0) throw new IllegalArgumentException("Merci d'entrer une taille positive");
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
		this.coordonnees = this.listeDeCoordonnees();
	}

	@Override
	public void setLargeur(double largeur) {
		if (largeur<0.0) throw new IllegalArgumentException("Merci d'entrer une taille positive");
		super.setLargeur(largeur);
		super.setHauteur(largeur);
		this.coordonnees = this.listeDeCoordonnees();
	}

	public List<Coordonnees> getCoordonnees(){
		return this.coordonnees;
	}

	public List<Coordonnees> listeDeCoordonnees(){
		List<Coordonnees> ret = new ArrayList<>();
//      Définition du centre
		Coordonnees centre = new Coordonnees(this.getPosition().getAbscisse()+this.getHauteur()/2,
				this.getPosition().getOrdonnee()+this.getHauteur()/2);

		double x ;
		double y ;

		double angleEntreBr = 2*Math.PI / nombreBranches;
//		Définition des points
		int i=0;
		for (double angle = anglePremiereBranche; angle<anglePremiereBranche+2*Math.PI; angle += angleEntreBr/2){
//			i pair:     point extérieur
//			i impair:   point intérieur
			x = i%2==0?this.getHauteur()/2*Math.cos(angle)+centre.getAbscisse():
					(1-longueurBranche)*this.getHauteur()/2*Math.cos(angle)+centre.getAbscisse();
			y = i%2==0?this.getHauteur()/2*Math.sin(angle)+centre.getOrdonnee():
					(1-longueurBranche)*this.getHauteur()/2*Math.sin(angle)+centre.getOrdonnee();
			ret.add(new Coordonnees(x,y));
			i++;
		}
		return ret;
	}

	public int getNombreBranches() {
		return nombreBranches;
	}

	public void setNombreBranches(int nombreBranches) {
		if (nombreBranches<3 || nombreBranches>15)
			throw new IllegalArgumentException("Merci d'entrer un nombre de branches de 3 à 15");
		this.nombreBranches = nombreBranches;
		this.coordonnees = this.listeDeCoordonnees();
	}

	public double getAnglePremiereBranche() {
		return anglePremiereBranche;
	}

	public void setAnglePremiereBranche(double anglePremiereBranche) {
		if (anglePremiereBranche<=-Math.PI || anglePremiereBranche>Math.PI)
			throw new IllegalArgumentException("Merci d'entrer une angle entre -pi et +pi");
		this.anglePremiereBranche = anglePremiereBranche;
		this.coordonnees = this.listeDeCoordonnees();
	}

	public double getLongueurBranche() {
		this.coordonnees = this.listeDeCoordonnees();
		return longueurBranche;
	}

	public void setLongueurBranche(double longueurBranche) {
		if (longueurBranche<=0.0 || longueurBranche>1.0)
			throw new IllegalArgumentException("Merci d'entrer une longueur de branche entre 0 et 1");
		this.longueurBranche = longueurBranche;
		this.coordonnees = this.listeDeCoordonnees();
	}

	@Override
	public String toString() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
		DecimalFormat df = new DecimalFormat("0.0#", symbols);
		String verifRempli = this.estRempli()? "[Etoile-Rempli]":"[Etoile]";
		String ret = verifRempli+" : pos (" + df.format(this.getPosition().getAbscisse()) + " , " +
				df.format(this.getPosition().getOrdonnee())+ ") dim " + df.format(this.getLargeur())
				+ " x " + df.format(this.getHauteur())+ " périmètre : " + df.format(this.perimetre()) + " aire : "
				+ df.format(this.aire());
		char[] lang;
		if ("fr".equals(Locale.getDefault().getLanguage())) {
			lang = new char[]{'R', 'V', 'B'};
		} else {
			lang = new char[]{'R', 'G', 'B'};
		}
		return ret +" couleur = " + lang[0] + this.getCouleur().getRed() + "," + lang[1] + this.getCouleur().getGreen()
				+ ","+ lang[2] + this.getCouleur().getBlue();
	}
}
