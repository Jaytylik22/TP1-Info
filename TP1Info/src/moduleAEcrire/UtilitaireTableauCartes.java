package moduleAEcrire;
import source.UtilitaireFonction;
import source.Carte;
import source.Constantes;
/**
 * 
 * @author eleve
 *
 */
public class UtilitaireTableauCartes {
	
	public static Carte[][] initTableau2D(int nbPaquets){
		Carte[][]tableau2D =new Carte [nbPaquets][Constantes.NB_CARTES];
		return tableau2D;
	}
		 
	
/**
 * 
 * @param tableau
 * @param nbSignificative
 * @return
 */ 
	 
	public static Carte[] copieDuJeu(Carte[] jeuNeuf) {
		
		Carte[] cartes = new Carte[Constantes.NB_CARTES];
		
		cartes = jeuNeuf;
		
		return cartes;
		
	}
	
	public void méthodeParBrassage(Carte [ ] tableau ) {
		int incrementateur=0;
		Carte [ ] tableauFinal=new Carte[Constantes.NB_CARTES];
		int nbDeFoisMelanger=UtilitaireFonction.alea( 4, 10);
		while (incrementateur <nbDeFoisMelanger) {
			incrementateur++;
			melanger(tableau);
			tableauFinal=fusion(separer(tableau));
		}
		
		System.arraycopy(tableauFinal, 0, tableau, 0, Constantes.NB_CARTES);
		
	}
	public static void melanger(Carte [ ] tableau ) {
	
	int	rotation =UtilitaireFonction.alea( 1, 10);
	int	nbDeCarte =UtilitaireFonction.alea(2, 10);	
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
	  * @return tableau2D : un tableau contenant plusieur (2) autre tableau 
	  * (paquet) de carte 
	  */
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
		for(int i = moitier; i<= tableau.length-1; i++){
			tableaudeux[i-moitier]= tableau[i];
		}
		tableau2D[0]=tableauun;
		tableau2D[1]=tableaudeux;
		return tableau2D;
	 }
	/**
	 * 
	 * @param tableau
	 * @return tableaufinal : un tableau de carte melanger 
	 */
	 
	 
		public static Carte[] fusion(Carte [][] tableau ) {
			
			Carte []tableauun=tableau[0];
			Carte []tableaudeux=tableau[1];
			int iterateurcarte=0;
			int iterateurtable=0;
			int iterateurtable1=0;
			int iterateurtable2=0;
			Carte []tableaufinal=new Carte [Constantes.NB_CARTES];;
			while ( iterateurtable!=Constantes.NB_CARTES) {
				
			if (iterateurcarte%2==0) {
				
			
			
				tableaufinal[iterateurtable]=tableauun[iterateurtable1] ;
				iterateurtable ++;
				iterateurtable1++;
				
				
	
	
			}
			else
			{
				
				tableaufinal[iterateurtable]=tableaudeux[iterateurtable2] ;
					iterateurtable ++;
					iterateurtable2++;
			
			}
			iterateurcarte++;
			}
			
			return tableaufinal;
	}
		
		/**
		 * 
		 * @param tableau
		 */
		public static void MéthodeParPaquets(Carte [ ] tableau) {
			int	nbTotalPaquet =UtilitaireFonction.alea( 6,8 );
			int nbcarte=Constantes.NB_CARTES;
			int incrementateur=0;
			boolean casseTrouver=false;
			int incrementateurCase=0;
			int casseChoissi=0;
			Carte [][] tableau2D=initTableau2D(nbTotalPaquet+1);
			tableau2D[nbTotalPaquet]=tableau;
			
			//boucle pour voyager entre les paquet
			for(int i=nbTotalPaquet;i!=1;i--) {
				
				
					//boucles pour envoyer les carte dans les autre paquets
					while(incrementateur<nbcarte) {
						int paquetchoisi=UtilitaireFonction.alea( 0,i-1 );
						while(casseTrouver==false) {
							if(tableau2D[paquetchoisi][incrementateurCase]==null) {
								casseChoissi=incrementateurCase;
								casseTrouver=true;
							}
							else {
								incrementateurCase++;
							}
						}
						incrementateurCase=0;
						casseTrouver=false;
						tableau2D[paquetchoisi][casseChoissi]=tableau2D[i][incrementateur];
						incrementateur++;
						
					}
					incrementateur=0;
				
				
			}
			//boucle pour chercher le nombre de valeur dans l'avant dernier 
			//paquet 
			int incrementateurCasetab1=0;
			while(casseTrouver==false) {
				if(tableau2D[1][incrementateurCasetab1]==null) {
					casseTrouver=true;
				}
				else {
					incrementateurCasetab1++;
				}
			}
			//boucle qui envoie les carte de l'Avant dernier dans le dernier 
			casseTrouver=false;
			for(int i=0;i<incrementateurCasetab1;i++) {
				while(casseTrouver==false) {
					if(tableau2D[0][incrementateurCase]==null) {
						casseTrouver=true;
					}
					else {
						incrementateurCase++;
					}
				}
				tableau2D[0][incrementateurCase]=tableau2D[1][i];
				incrementateurCase++;
			}
			System.arraycopy(tableau2D[0], 0, tableau, 0, nbcarte);
			//tableau=tableau2D[0];
		}
			
		
	
		/**
		 * 
		 * @param tableau
		 */
		public static void MéthodeParPositionAléatoire (Carte [] tableau) {
			Carte [] reference= new Carte[52];
            boolean positionTrouver = false;

            for(int i = 0; i < tableau.length; i++) {
                positionTrouver = false;
                while(positionTrouver == false)
                {
                    int    positionAlea =UtilitaireFonction.alea( 0,51 );
                    if(reference[positionAlea] == null) {
                        reference[positionAlea] = tableau[i];
                        positionTrouver = true;
                    }
                }
            }
		}
		/**
		 * 
		 */
		public static boolean toutesLesCartesSontTournee(Carte[] 
				cartesAffichees) {
			
			boolean result = true;
			for(int i = 0; i < cartesAffichees.length; i++) {
				
				if(cartesAffichees[i].visible == false) {
					result = false;
				}
			}
			
			
			
			
			return result;
			
		}
	

}