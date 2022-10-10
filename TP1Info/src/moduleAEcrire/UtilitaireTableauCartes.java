package moduleAEcrire;
import source.UtilitaireFonction;
import source.Carte;
/**
 * 
 * @author eleve
 *
 */
public class UtilitaireTableauCartes {
	public static Carte[][] initTableau2D(int nbPaquets){
		Carte[][]tableau2D =new Carte [nbPaquets][];
		return tableau2D;
	}
		 
	
/**
 * 
 * @param tableau
 * @param nbSignificative
 * @return
 */
	public static void melanger(Carte [ ] tableau,int nbSignificative ) {
	
	int	rotation =UtilitaireFonction.alea( 1, 10);
	int	nbDeCarte =UtilitaireFonction.alea(3, 10);	
	while (rotation >0) {
		for(int i=0;i<nbDeCarte;i++){
			int i2;
			Carte finTableau= tableau[tableau.length-1];
			
			
			for(i2=tableau.length-1;i2>0;i2--){
			tableau[i2]=tableau[i2-1];
			
		}
		tableau[0]=finTableau;
		}
		rotation--;
	}
} 
	 
	 /**
	  * 
	  * @param tableau
	  * @param tableauun
	  * @param tableaudeux
	  * @param nbSignificative
	  * @return
	  */
	 public static void separer(Carte [ ] tableau,Carte [ ] tableauun,Carte
			 [ ] tableaudeux,int nbSignificative ) {
		 
		int moitier=nbSignificative/2;
		
		for(int i = 0; i< moitier; i++){
			tableauun[i]= tableau[i];
			
			
	 }
		for(int i = moitier; i< tableau.length-1; i++){
			tableaudeux[i-moitier]= tableau[i];
		}
	 }
		public static Carte [] fusion(Carte [ ] tableau,Carte [ ] tableauun,Carte
				 [ ] tableaudeux,int nbSignificative ) {	
			separer(tableau,tableauun,tableaudeux,nbSignificative);
			int tab1nb=tableauun.length-1;
			int tab2nb=tableaudeux.length-1;
			int iterateurcarte=0;
			int iterateurtable=0;
			while (iterateurtable<tab1nb&&iterateurtable<tab2nb) {
				
			if (iterateurcarte%2==0) {
				
			
			for(int i = iterateurcarte; i< i+1 ; i++){
				tableau[iterateurtable]=tableauun[i] ;
				iterateurtable ++;
				
				}
	
	
			}
			else
			{
				for(int i = iterateurcarte; i< i+1 ; i++){
					tableau[iterateurtable]=tableaudeux[i] ;
					iterateurtable ++;
			}
			}
			iterateurcarte++;
			}
			return tableau;
	}
		/**
		 * 
		 * @param tableau
		 * @return
		 */
		public static Carte [] MéthodeParPaquets(Carte [ ] tableau) {
			int	nbTotalPaquet =UtilitaireFonction.alea( 6,8 );
			int nbcarte=52;
			int increnbpaquet=0;
			int carteParpaquet=0;
			Carte [] reference= new Carte[nbcarte];
			System.arraycopy(tableau, 0, reference, 0, nbcarte);
			 Carte [][] tableau2D=initTableau2D(nbTotalPaquet);
			 while (nbTotalPaquet!=1) {
			 int paquetcible=UtilitaireFonction.alea( 1,nbTotalPaquet-1);	 
			 
			 for(int i=0;i>nbcarte-1;i++) {
				 if (increnbpaquet>nbTotalPaquet) {
					 increnbpaquet=0;
					 carteParpaquet++;
				 }
				 tableau2D[increnbpaquet][carteParpaquet]=reference[i];
				 increnbpaquet++;
			 }
			 
			 nbTotalPaquet--;
			 
			 System.arraycopy(tableau2D[paquetcible], 0, reference, 0, carteParpaquet);
			 }
			return tableau2D[0];
		}
		
		public static Carte [] MéthodeParPositionAléatoire (Carte [ ] tableau) {
			
		}
		

}