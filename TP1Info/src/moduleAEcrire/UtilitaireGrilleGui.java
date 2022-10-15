package moduleAEcrire;

import source.Carte;
import source.GrilleGui;

/*
 * Réprésente les fonctions utilisé afin de faire marcher le gui
 * 
 * Auteur: Jérome Bouchard
 * Version : copyright A2022
 */

public class UtilitaireGrilleGui {
	
	private int compteur;
	
	public void afficherCarteGui(Carte[] jeuNeuf, GrilleGui gui) {
	
		compteur = 0;
		
		for(int rows = 0; rows < 4; rows++) {
			for(int columns = 0; columns < 13; columns++ ) {
				
					gui.setImage(rows, columns, jeuNeuf[compteur].image);
					jeuNeuf[compteur].visible = true;
					compteur++;
				}	
			}
		}
	
	public void cacherCarteGui(Carte[] jeuNeuf, GrilleGui gui) {
	
		compteur = 0;
		
		for(int rows = 0; rows < 4; rows++) {
			for(int columns = 0; columns < 13; columns++ ) {
				
					gui.setImageNull(rows, columns);
					jeuNeuf[compteur].visible = false;
					compteur++;
				}	
			}
		}
	

	public void afficherUneCarteGui(Carte[] jeuNeuf, GrilleGui gui, int rows,
			int columns, int co1d) {
		
					gui.setImage(rows, columns, jeuNeuf[co1d].image);
					jeuNeuf[co1d].visible = true;
				}	
			
	
	public void cacherUneCarteGui(Carte[] jeuNeuf, GrilleGui gui, int rows,
			int columns, int co1d) {
	
				gui.setImageNull(rows, columns);
				jeuNeuf[co1d].visible = false;
			}	
		}
	
		
	
