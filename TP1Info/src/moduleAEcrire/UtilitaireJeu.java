package moduleAEcrire;

import source.Coordonnee;
import source.Carte;
import source.GrilleGui;
import source.EtatJeu;
import source.Stats;
import javax.swing.JOptionPane;
import source.Constantes;
/*
 * Réprésente les fonctions utilisé afin de faire marcher le jeu
 * 
 * Auteur: Jérome Bouchard
 * Version : copyright A2022
 */


public class UtilitaireJeu {

	static Constantes constante = new Constantes();
	static Stats stats = new Stats();
	static UtilitaireGrilleGui utilitaireGrilleGui = new UtilitaireGrilleGui();
	static UtilitaireTableauCartes utilitaireTableauCartes = 
			new UtilitaireTableauCartes();
	
	public static void initialiserJeu(Carte[] jeuNeuf,Carte[] 
			cartesAffichees,GrilleGui gui,EtatJeu etatJeu) {
		
		//Initialiser
		etatJeu.longueurSequence = 0;
		etatJeu.nbIndices = constante.NB_INDICE_DEPART;
		
		
		//Afficher le nouveau paquet
		utilitaireGrilleGui.afficherCarteGui(jeuNeuf, gui);
		
		//Afficher un message 'pret ?' a l'utilisateur
		JOptionPane.showMessageDialog(null,"Etes-vous pret ?" ); 
		
		
		//Cacher les cartes
		utilitaireGrilleGui.cacherCarteGui(jeuNeuf, gui);
		gui.pause(constante.TEMPS_VISIONNEMENT);
		
		//Brasser les cartes avec la méthode
		utilitaireTableauCartes.MéthodeParPositionAléatoire(cartesAffichees);
		
		//Copier le jeu de carte dans un tableau temporaire
		// paquet2 paquet1.clone(); 
		utilitaireGrilleGui.afficherCarteGui(cartesAffichees, gui);
		
		//Faire une pause en secondes
		gui.pause(constante.TEMPS_VISIONNEMENT);
		
		//Cacher les cartes
		utilitaireGrilleGui.cacherCarteGui(cartesAffichees, gui);
			
	}
	
	public static void effectuerTour(Carte[] cartes, GrilleGui gui, 
			Stats stats, EtatJeu etatJeu) {
		
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
			stats.nbEssaieActuel = stats.nbEssaieActuel + 1;
		}
		
		
		//Afficher les cartes
		utilitaireGrilleGui.afficherUneCarteGui(cartes, gui, dernierClic.ligne,
				dernierClic.colonne, co1d);
		
		//Gerer la situation de séquence(2.2)
		if(etatJeu.longueurSequence == 0) {
			etatJeu.longueurSequence++;
		}
		else {
			if(cartes[co1d].numero - 1 == cartes
					[etatJeu.tabSequence
					 [etatJeu.longueurSequence - 1]]
							 .numero && cartes[co1d].couleur
							 == cartes[etatJeu.tabSequence[etatJeu.
							            longueurSequence - 1]].couleur) {
				etatJeu.ilYaSequence = true;
				etatJeu.longueurSequence++;
			}
			else{
				JOptionPane.showMessageDialog(null,"Bris de sequence" );
				utilitaireGrilleGui.cacherUneCarteGui(cartes, gui, 
						dernierClic.ligne, dernierClic.colonne, co1d);
				
				//Cacher 1ere si juste séquence de 2
				if( etatJeu.longueurSequence == 1) {
					int rows = 0;
					
					for(int i = 1; etatJeu.tabSequence
							[etatJeu.longueurSequence - 1] > 13; i++) {
						rows = i;
						etatJeu.tabSequence[etatJeu.longueurSequence - 1] 
								= etatJeu.tabSequence
								[etatJeu.longueurSequence - 1] - 13;
					}
					utilitaireGrilleGui.cacherUneCarteGui(cartes, gui, rows,
							etatJeu.tabSequence[etatJeu.longueurSequence - 1],
							etatJeu.tabSequence[etatJeu.longueurSequence - 1]);
					
					
				}
				etatJeu.longueurSequence = 0;
			}
		}
		//Mettre record de sequence si plus gros que l'ancien
		if(stats.grandeSequence < etatJeu.longueurSequence){
			stats.grandeSequence = etatJeu.longueurSequence;
		}
		
	}
	
	public static void montrerLesCartes(Carte[] cartes,GrilleGui gui,
			EtatJeu etatJeu) {
		
	}
	
	public static void montrerIndices(Carte[] cartes,GrilleGui gui,
			EtatJeu etatJeu) {
		if(etatJeu.nbIndices != 0) {
			if(etatJeu.longueurSequence != 0) {
				
				final Coordonnee dernierClic;
				int co1d;
				dernierClic = gui.getPosition();
				co1d = dernierClic.ligne * 13 + dernierClic.colonne;
				
				int columns = 0;
				int rows = 0;
				int prochaineSequence = 0;
				for(int i = 0; i < cartes.length; i++) {
					if(cartes[i].numero - 1 == cartes[co1d].numero && cartes[i]
							.couleur == cartes[co1d].couleur) {
						prochaineSequence = i;
					}
				}
				
				columns = prochaineSequence;
				for(int i = 1; columns > 13; i++) {
					rows = i;
					columns = columns - 13;
				}
				utilitaireGrilleGui.afficherUneCarteGui(cartes, gui, rows, 
						columns, prochaineSequence);
				gui.pause(constante.TEMPS_VISIONNEMENT);
				utilitaireGrilleGui.cacherUneCarteGui(cartes, gui, rows, 
						columns, prochaineSequence);
			
				
			}
			else {
				int plusPetite = 0;
				int rows = 0;
				int columns = 0;
				for(int i = 0; i < cartes.length; i++) {
					if(cartes[i].numero < cartes[plusPetite].numero) {
						plusPetite = i;
					}
				}
				
				columns = plusPetite;
				for(int i = 1; columns > 13; i++) {
					rows = i;
					columns = columns - 13;
				}
				utilitaireGrilleGui.afficherUneCarteGui(cartes, gui, rows,
						columns, plusPetite);
				gui.pause(constante.TEMPS_VISIONNEMENT);
				utilitaireGrilleGui.cacherUneCarteGui(cartes, gui, rows,
						columns, plusPetite);
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"Aucun indice restant" );
		}
	}
}