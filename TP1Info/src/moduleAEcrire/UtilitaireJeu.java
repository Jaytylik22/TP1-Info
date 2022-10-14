package moduleAEcrire;

import source.Coordonnee;
import source.Carte;
import source.GrilleGui;
import source.EtatJeu;
import source.Stats;
import javax.swing.JOptionPane;


public class UtilitaireJeu {

	static UtilitaireGrilleGui utilitaireGrilleGui = new UtilitaireGrilleGui();
	
	public static void initialiserJeu(Carte[] jeuNeuf,Carte[] cartesAffichees,GrilleGui gui,EtatJeu etatJeu) {
		
		
		
		//Brasser les cartes avec la méthode
		
		
		//Afficher le nouveau paquet
		utilitaireGrilleGui.afficherCarteGui(jeuNeuf, gui);
		
		//Afficher un message 'pret ?' a l'utilisateur
		JOptionPane.showMessageDialog(null,"Etes-vous pret ?" ); 
		
		
		//Cacher les cartes
		utilitaireGrilleGui.cacherCarteGui(jeuNeuf, gui);
		
		//Copier le jeu de carte dans un tableau temporaire et afficher la copie du tableau ???
		// paquet2 paquet1.clone(); 
		utilitaireGrilleGui.afficherCarteGui(cartesAffichees, gui);
		
		//Faire une pause en secondes
		gui.pause(1);
		
		//Cacher les cartes
		utilitaireGrilleGui.cacherCarteGui(jeuNeuf, gui);
			
	}
	
	public static void effectuerTour(Carte[] cartes, GrilleGui gui, Stats stats, EtatJeu etatJeu) {
		
		final Coordonnee dernierClic;
		
		
		//obtenir la position du clic
		dernierClic = gui.getPosition();
		
		
		//Convertir la position de 2D a 1D(rows * nmb columns + columns)
		
		
		
		
		//Valider clic de la carte(2.1)
		
		
		//Afficher les cartes
		utilitaireGrilleGui.afficherCarteGui(cartes, gui);
		
		//Gerer la situation de séquence(2.2)
		
		
		//Afficher les cartes
		
	}
	
	public static void montrerLesCartes(Carte[] cartes,GrilleGui gui,EtatJeu etatJeu) {
		
	}
	
	public static void montrerIndices(Carte[] cartes,GrilleGui gui,EtatJeu etatJeu) {
		
	}
}