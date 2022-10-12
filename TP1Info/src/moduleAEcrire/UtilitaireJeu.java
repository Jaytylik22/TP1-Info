public class UtilitaireJeu {

	
	public void initialiserJeu(Carte[] jeuNeuf,Carte[] cartesAffichees,Grillegui gui,EtatJeu etatJeu) {
	
		
		//Initialiser la longueur de séquence
		
		
		//Brasser les cartes avec la méthode
		
		
		
		//Afficher le nouveau paquet
		
		afficherCarteGui(jeuNeuf, gui);
		
		
		//Afficher un message 'pret ?' a l'utilisateur
		JoptionPane.showMessageDialog(null,"Etes-vous pret ?" ); 
		
		
		//Cacher les cartes
		cacherCarteGui(jeuNeuf, gui);
		
		//Copier le jeu de carte dans un tableau temporaire et afficher la copie du tableau ???
		// paquet2 paquet1.clone(); 
		afficherCarteGui(cartesAffichees, gui);
		
		//Faire une pause en secondes
		gui.pause(1);
		
		//Cacher les cartes
		cacherCarteGui(jeuNeuf, gui);
		
		
		
	}
	
	private static void tournerPaquet (Carte[] paquet) {
		
		for(int i; i < paquet.length; i++) {
			
			if( paquet[i].visible = true) {
				paquet[i].visible = false;
			}
			else {
				paquet[i].visible = true;
			}
			
		}
		
	}
	
	private static void tournerCarte (Carte[] paquet, int idCarte) {
		
		if( paquet[idCarte].visible = true) {
			paquet[idCarte].visible = false;
		}
		else {
			paquet[idCarte].visible = true;
		}
		
	}
	
	private static void copiePaquet(Carte[] paquet){
		
	}

}