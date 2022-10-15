package moduleAEcrire;

import source.Stats;
import javax.swing.JOptionPane;

/*
 * Réprésente les fonctions utilisé afin de faire marcher les stats
 * 
 * Auteur: Jérome Bouchard
 * Version : copyright A2022
 */

public class UtilitaireStats {

	public static void montrerStats(
			Stats stats){

		JOptionPane.showMessageDialog(null,"Nombre d'essai(s) actuel: " +
				stats.grandeSequence+"carte(s) \n" +
				"La plus grande séquence : "+stats.nbReussites+"carte(s) \n" 
				+"Nombre de réussites : "+stats.nbEssaieActuel + 
				"partie(s) consécutive(s) \n"
				+"Nombre d'essais(s) en moyenne par parties: "+
				stats.nbEssaiesTotal ); 
	}
	
	public static void ajusterStatsNouvellePartie(Stats stats) {
		
	}

}