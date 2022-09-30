import javax.swing.JOptionPane;

/*
 * Classe qui contient les SP pour gérer les boutons d'options
 * de menu montrés dans le GUI.
 * 
 * S'il y a ajout de bouton dans le module Constantes, il faut modifier cette 
 * classe et y ajouter le comportement désiré.
 * 
 * Auteur: Pierre Bélisle
 * Version : Copyright A2022
 */
public class UtilitaireMenu {
	
	
	/*
	 * Vérifie quelle option de menu a été choisie et démarre la bonne
	 * fonctionnalité.
	 * 
	 * @param jeuNeuf Un jeu pas brasssé
	 * @param cartes  Le jeu de cartes affichées
	 * @param gui La fenêtre qui  montre les cartes et les boutons
	 * @param stats Les statistiqwues à maintenir
	 * @param etatJeu Les détails sur le jeu.
	 * @return true si l'utilisateur a cliqué sur le bouton pour quitter.
	 */
	public static boolean gererMenu(Carte[] jeuNeuf, 
			Carte[] cartes, 
			GrilleGui gui, 
			Stats stats,
			EtatJeu etatJeu){

		/*
		 * Stratégie : Agit simplement comme distributeur de tâche selon 
		 *             l'option du menu choisie par l'utlisateur dand le gui.
		 *                  
		 *             On a créé un sous-programme pour chaque situation
		 *             même si c'était possible de réutiliser en une seule ligne
		 *             de code (voir: montrer_stats).
		 *                  
		 *             Doit être modifié si on ajoute des options de menu dans 
		 *             le tableau-constante TAB_OPTIONS_MENU.
		 */
		
		boolean partieTerminee = false;
		
		String reponse = gui.getOptionMenuClique();
		
		// Selon les versions de Java, switch-case sur des String ne 
		// fonctionne pas toujours.
		if (reponse. equals(Constantes.TAB_OPTIONS_MENU[Constantes.NOUVELLE_PARTIE])) {

			UtilitaireJeu.initialiserJeu(jeuNeuf, cartes,gui, etatJeu);
		}
		
		else if(reponse.equals(Constantes.TAB_OPTIONS_MENU[Constantes.CARTE])) {

			UtilitaireJeu.montrerLesCartes(cartes, gui, etatJeu);
				
		}

		else if(reponse.equals(Constantes.TAB_OPTIONS_MENU[Constantes.INDICE])) {

				
			UtilitaireJeu.montrerIndices(cartes, gui, etatJeu);
		}

		else if(reponse.equals(Constantes.TAB_OPTIONS_MENU[Constantes.STATS])) {

			UtilitaireStats.montrerStats(stats);
		}
		
		else if(reponse.equals(Constantes.TAB_OPTIONS_MENU[Constantes.QUITTER])) {

			partieTerminee = true;
		}
		
		return partieTerminee;
	}
}