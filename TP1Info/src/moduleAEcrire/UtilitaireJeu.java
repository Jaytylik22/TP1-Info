package moduleAEcrire;

import source.Coordonnee;
import source.Carte;
import source.GrilleGui;
import source.EtatJeu;
import source.Stats;
import javax.swing.JOptionPane;


public class UtilitaireJeu {

	static UtilitaireGrilleGui utilitaireGrilleGui = new UtilitaireGrilleGui();
	static UtilitaireTableauCartes utilitaireTableauCartes = new UtilitaireTableauCartes();
	
	public static void initialiserJeu(Carte[] jeuNeuf,Carte[] cartesAffichees,GrilleGui gui,EtatJeu etatJeu) {
		
		//Afficher le nouveau paquet
		utilitaireGrilleGui.afficherCarteGui(jeuNeuf, gui);
		
		//Afficher un message 'pret ?' a l'utilisateur
		JOptionPane.showMessageDialog(null,"Etes-vous pret ?" ); 
		
		
		//Cacher les cartes
		utilitaireGrilleGui.cacherCarteGui(jeuNeuf, gui);
		JOptionPane.showMessageDialog(null,"Etes-vous pret2 ?" );
		
		//Brasser les cartes avec la méthode
		cartesAffichees = utilitaireTableauCartes.melanger(cartesAffichees);
		
		//Copier le jeu de carte dans un tableau temporaire et afficher la copie du tableau ???
		// paquet2 paquet1.clone(); 
		utilitaireGrilleGui.afficherCarteGui(cartesAffichees, gui);
		JOptionPane.showMessageDialog(null,"Etes-vous pret3 ?" );
		
		//Faire une pause en secondes
		gui.pause(1);
		
		//Cacher les cartes
		utilitaireGrilleGui.cacherCarteGui(cartesAffichees, gui);
		JOptionPane.showMessageDialog(null,"Etes-vous pret4 ?" );
			
	}
	
	public static void effectuerTour(Carte[] cartes, GrilleGui gui, Stats stats, EtatJeu etatJeu) {
		
		final Coordonnee dernierClic;
		int co1d;
		
		
		//obtenir la position du clic
		dernierClic = gui.getPosition();
		
		
		//Convertir la position de 2D a 1D(rows * nmb columns + columns)
		co1d = dernierClic.ligne * 13 + dernierClic.colonne;
		
		
		
		//Valider clic de la carte(2.1)
		if(cartes[co1d].visible == true) {
			JOptionPane.showMessageDialog(null,"Votre coups est perdu" );
			
		}
		else {
			etatJeu.tabSequence[etatJeu.longueurSequence] = co1d;
			cartes[co1d].visible = true;
			//+1 essai
		}
		
		
		//Afficher les cartes
		utilitaireGrilleGui.afficherUneCarteGui(cartes, gui, dernierClic.ligne, dernierClic.colonne, co1d);
		
		//Gerer la situation de séquence(2.2)
		if(etatJeu.longueurSequence == 0) {
			etatJeu.longueurSequence++;
		}
		else {
			if(cartes[co1d].numero - 1 == cartes[etatJeu.tabSequence[etatJeu.longueurSequence - 1]].numero/* && cartes[co1d].couleur == cartes[etatJeu.tabSequence[etatJeu.longueurSequence - 1]].couleur*/) {
				etatJeu.ilYaSequence = true;
				etatJeu.longueurSequence++;
			}
			else{
				JOptionPane.showMessageDialog(null,"Bris de sequence" );
				utilitaireGrilleGui.cacherUneCarteGui(cartes, gui, dernierClic.ligne, dernierClic.colonne, co1d);
				if(etatJeu.longueurSequence == 1) {
					cartes[etatJeu.tabSequence[etatJeu.longueurSequence - 1]].visible = false;
				}
				etatJeu.longueurSequence = 0;
			}
		}
		//Mettre record de sequence si plus gros que l'ancien
		
		//Afficher les cartes
		
	}
	
	public static void montrerLesCartes(Carte[] cartes,GrilleGui gui,EtatJeu etatJeu) {
		
	}
	
	public static void montrerIndices(Carte[] cartes,GrilleGui gui,EtatJeu etatJeu) {
		
	}
}