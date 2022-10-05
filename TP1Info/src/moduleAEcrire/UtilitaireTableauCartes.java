
public class UtilitaireTableauCartes {
/**
 * 
 */
	public static Carte [] melanger(Carte [ ] tableau,int nbSignificative ) {
	
	int	rotation =UtilitaireFonction.alea(int 1, int 10);
	int	nbDeCarte =UtilitaireFonction.alea(int 3, int 10);	
	while (rotation >0) {
		for(int i=0;i<nbDeCarte;i++){
			int i2;
			int finTableau= tableau[tableau.length-1];
			
			
			for(i2=tableau.length-1;i2>0;i2--){
			tableau[i2]=tableau[i2-1];
			
		}
		tableau[0]=finTableau;
		}
		rotation--;
}
	 for(int i = 0; i< tableau.length; i++){    
            System.out.print(tableau[i] + " ");    
        } 
	 
	 
	 public static Carte [] separer(Carte [ ] tableau,int nbSignificative ) {
		 
		int moitier=nbSignificative/2;
		Carte[] 1tableau=new 1tableau[moitier];
		Carte[] 2tableau=new 2tableau[moitier];
		
		for(int i = 0; i< moitier; i++){
			1tableau[i]= tableau[i];
			
			
	 }
		for(int i = moitier; i< tableau.length-1; i++){
			2tableau[i-moitier]= tableau[i];
		}
			
			
			
	 }
}