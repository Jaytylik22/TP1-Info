import javax.swing.Icon;

/*
 * Représente une carte à jouer.
 * 
 * Spécial : Contient l'image correspondante à afficher.
 * 
 * Auteur: Pierre Bélisle
 * Version : copyright A2022
 */
public class Carte {
	
	// Le numéro de carte de Constantes.AS à Constantes.ROI.
	public int numero;  
	
	// COEUR à PIQUE.
	public Constantes.Sorte couleur;  
	
	// L'image de la carte à montrer.
	public Icon image; 
	
	// Vrai si la carte est tournée vers le haut.
	public boolean visible = true; 

	// Sert principalement au DEBUG.
	public String toString() {
		
		return numero + image.toString() + couleur.toString();
	}
}
