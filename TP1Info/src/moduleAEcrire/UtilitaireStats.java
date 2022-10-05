/**
 * @author adam
 */
public class UtilitaireStats {
/**
 * 
 */
	public static void montrerStats(
			Stats stats){

		JoptionPane.showMessageDialog(null,"Nombre d'essai(s) actuel: " +
				Stats.grandeSequence+"carte(s)" + \n +
				"La plus grande séquence : "+Stats.nbReussites+"carte(s)" + \n 
				+"Nombre de réussites : "+Stats.nbEssaieActuel + 
				"partie(s) consécutive(s)"+ \n
				+"Nombre d'essais(s) en moyenne par parties: "+
				Stats.nbEssaiesTotal ); 
	}

}