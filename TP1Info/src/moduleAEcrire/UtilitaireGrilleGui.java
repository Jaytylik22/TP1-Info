package moduleAEcrire;

import source.Carte;
import source.GrilleGui;

public class UtilitaireGrilleGui {
	
	private int compteur;
	
	public void afficherCarteGui(Carte[] jeuNeuf, GrilleGui gui) {
	
		
		for(int rows = 0; rows < 4; rows++) {
			for(int columns = 0; columns < 13; columns++ ) {
				
					gui.setImage(rows, columns, jeuNeuf[compteur].image);
					jeuNeuf[compteur].visible = true;
				}	
				compteur++;
			}
		}
	
	public void cacherCarteGui(Carte[] jeuNeuf, GrilleGui gui) {
	
		
		for(int rows = 0; rows < 4; rows++) {
			for(int columns = 0; columns < 13; columns++ ) {
				
					gui.setImage(rows, columns, null);
					jeuNeuf[compteur].visible = false;
				}	
				compteur++;
			}
		}
	}
	
