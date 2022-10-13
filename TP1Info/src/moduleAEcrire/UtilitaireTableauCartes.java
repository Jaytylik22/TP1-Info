package moduleAEcrire;
import source.UtilitaireFonction;
import source.Constantes;
import source.Carte;
/**
 * 
 * @author eleve
 *
 */

public class UtilitaireTableauCartes {
	/**
	 * 
	 * @param nbPaquets
	 * @return
	 */
	//je cree un tableau 2D vide faite de cartes
	public static Carte[][] initTableau2D(int nbPaquets){
		Carte[][]tableau2D =new Carte [nbPaquets][];
		return tableau2D;
	}
		 
	
/**
 * 
 * @param tableau
 */
	//je melange les carte en les deplacent 
	public static void melanger(Carte [ ] tableau ) {
	//je cree l'aleatoir avec le nombre de deplacement et la quatiter de cartes
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
	  * @return tableau2D
	  */
	//je cree deux autre paquet a partire d'un seul paquer. Je le retourne sous
	//la forme d'une table 2D
	 public static Carte [][] separer(Carte [ ] tableau) {
		int nombreDePaquet=2;
		int moitier=Constantes.NB_CARTES/nombreDePaquet;
		Carte []tableauun=new Carte [moitier];
		Carte []tableaudeux=new Carte [moitier];
		Carte[][]tableau2D=initTableau2D(nombreDePaquet);
		//je met la moitier dans le premier tableau
		for(int i = 0; i< moitier; i++){
			tableauun[i]= tableau[i];
			
			
	 }
		//je met la 2e moiter dans le 2 tableau
		for(int i = moitier; i< tableau.length-1; i++){
			tableaudeux[i-moitier]= tableau[i];
		}
		tableau2D[0]=tableauun;
		tableau2D[1]=tableaudeux;
		return tableau2D;
	 }
	/**
	 * 
	 * @param tableau
	 */
	 //fusionne les paquet 
		public static void fusion(Carte [ ] tableau ) {
			
			Carte[][]tableau2D=separer(tableau);
			Carte []tableauun=tableau2D[0];
			Carte []tableaudeux=tableau2D[1];
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
		
	}
		/**
		 * 
		 * @param tableau
		 * @return tableau
		 */
		//Je fait plusieur paquer ou je distribu les carte et je redistribu entre
		//les parquet jusqu'a il en reste qu'un seul 
		public static void MéthodeParPaquets(Carte [ ] tableau) {
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
			 // retourne tout dans le tableau de basse  
			 System.arraycopy(tableau2D[0], 0, tableau, 0, nbcarte);
			
		}
		/**
		 * 
		 * @param tableau
		 */
		public static void MéthodeParPositionAléatoire (Carte [] tableau) {
			int nbcarte=52;
			int incrementateur=0;
			boolean boucle=false;
			boolean carteDispo=false;
			Carte [] reference= new Carte[nbcarte];
			do  {
				boucle=false;
				//verifi si il manque des carte non melanger 
				for( Carte i : reference) {
					if(i==null) {
						boucle= true;
						int	carteAlea =UtilitaireFonction.alea( 0,51 );
						//verifi si la carte n'est pas deja utiliser (verif carte)
						while (carteDispo!=true)
							if(tableau[carteAlea]==null) {
								carteAlea =UtilitaireFonction.alea( 0,51 );
							}
							else {
								carteDispo=true;
							}
						// fin verif carte)
						
						reference[carteAlea]=tableau[incrementateur];
						tableau[incrementateur]=null;
						
						incrementateur++;
					}
					
				} 
				
			} while (boucle!=false);
			
			//remet toutes les cartes melanger dans le tableau
			System.arraycopy(reference, 0, tableau, 0, nbcarte);
			
		}
	

}