package source;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Grille de jeu rectangulaire qui permet d'obtenir s'il y  eu un clic, 
 * la position du clic et modifier l'image d'une case.
 * 
 * Cette classe est compl�te et fourni aux �tudiants.  Elles n'a pas � �tre 
 * �tudi� mais plut�t � �tre utilis�.  Dans un autre contexte, ce serait con�u
 * bien diff�remment.
 * 
 * Les m�thodes publiques :
 * 
 * 							pause(int)
 * 							setImage(int, int, Icon)
 * 							getPosition()
 * 							optionMenuEstCliquee()
 * 							getOptionMenuClique()
 * 							getNbLignes()
 * 							getNbColonnes()
 * 
 *  
 * 
 * author Pierre B�lisle
 * Version : copyright H2018
 */
public class GrilleGui  implements Runnable{

	/*
	 * STRAT�GIE : On met des boutons dans un panneau mais on les retient aussi 
	 *                        dans une grille.  Une classe interne MonJButton 
	 *                        h�rite de JButton � laquelle on ajoute des 
	 *                        attributs pour retenir la position du bouton dans
	 *                         la grille.  Tout cela pour �viter la recherche du 
	 *                        bouton lors d'un clic (deux boucles en moins).
	 *                        
	 *                        Un bool�en permet de retenir si un bouton a �t� 
	 *                        cliqu� et il est remis � faux apr�s une lecture 
	 *                        de la position par son accesseur.
	 */

	 // On compose dans un cadre.
	private JFrame cadre = new JFrame();

	// La grille qui sera affich�e (classse interne d�crite � la fin).
	private MonJButton [][] grille;

	// La position en y,x du dernier clic.
	private Coordonnee dernierClic;

	// Mis � vrai lors d'un clic et � faux dans getPosition().
	private boolean estClique;
		
	
	private JPanel panneauPrincipal ;

	// La taille de l'�cran.
	private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	// Retenir le tableau des options de menus.
	private String [] tabMenus;
	
	// Pour les options de meus du panneau du bas.
	private boolean estBoutonMenu;
	
	// Vaudra le bouton cliqu� s'il y a eu un clic sur un des boutons de menu
	// et il est mis � null apr�s getOptionMenu().
	private String optionClique;
	
	// Retenir le mode de fermeture d�sir�e.
	private int modeFermeture;
	/**
	/**
	 * Cr�e une grille selon les dimensions re�ues.
	 * 
	 * @param nbLignes L'axe des Y
	 * @param nbColonnes L'axe des X
	 * @param couleurTexte
	 * @param couleurFond
	 * @param tabMenus Les options du menu du bas
	 */
	public GrilleGui(int nbLignes, int nbColonnes) {
		

		// On retient les options du menu.
		this.tabMenus = Constantes.TAB_OPTIONS_MENU;
	
		// On cr�e le tableau 2D (vide).
		grille = new MonJButton[nbLignes][nbColonnes];

		// Rien de cliqu� � date.
		estClique = false;
		estBoutonMenu = false;

		// On cr�e le panneau du bas avec les boutons de menu.

		// On affiche le cadre dans un thread.
		Thread t = new Thread(this);
		t.start();

	}

	/**
	 * Effectue une pause �cran pous laisser le temps � l'utilisateur
	 * de cliquer sur les boutons ou sur le X.
	 * 
	 * @param temps 
	 */
	public void pause(int temps) {
		
		try {
			Thread.sleep(temps);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Modifie l'image d'une case.  Si image est � null, la case est bleue.
	 * 
	 * @param ligne, colonne La coordonn�e de la case
	 * @param image L'image � y mettre.
	 */
	public void setImage(int ligne, int colonne, Icon image) {
		
		grille[ligne][colonne].setIcon(image);
		
	}
	
	public void setImageNull(int ligne, int colonne) {
		
		grille[ligne][colonne].setIcon(null);
		
	}
		
	/**
	 * Accesseur de la position du dernier clic.  Ne tient pas compte s'il y a
	 * eu un clic ou non.
	 * 
	 * Remet l'�tat de la fen�tre comme non cliqu� (caseEstCliquee() == false).
	 * 
	 * @return S'il y a eu un clic.
	 */
	public Coordonnee getPosition(){

		estClique = false;
		return dernierClic;		
	}

	/**
	 * Retourne si vrai si un des boutons de menu a �t� cliqu�.
	 * 
	 * @return Si un des boutons de menu a �t� cliqu�.
	 */
	public boolean optionMenuEstCliquee(){
		return estBoutonMenu;
	}
	
	/**
	 * Retourne la derni�re option cliqu�e et null autrement.
	 * 
	 * @return Le texte dans le bouton cliqu� s'il y a lieu.
	 */
	public String getOptionMenuClique(){
		
		if(estBoutonMenu)
		    estBoutonMenu = false;
		else
			optionClique = null;
		
		return optionClique;
	}
	
	
	/**
	 * Accesseur du nombre de lignes.
	 * 
	 * @return Le nombre de lignes de la grille.
	 */
	public int getNbLignes() {
		return grille.length;
	}

	/**
	 * Accesseur du nombre de colonnes.
	 * 
	 * @return Le nombre de colonnes de la grille.
	 */
	public int getNbColonnes() {
		return grille[0].length;
	}
	
	
	/**
	 * Retourne si un des boutons a �t� cliqu� depuis le dernier appel �
	 * l'accesseur de position.
	 * 
	 * @return Si un des boutons a �t� s�lectionn�.
	 */
	public boolean caseEstCliquee(){		
		return estClique;
	}

	@Override
	public void run() {

		initComposants();
	}

	/*
	 * Initialise tous les composants mais ne restera
	 * que le cadre et le panneau principal publiques.
	 */
	private void initComposants() {

		// Plein �cran.
		cadre.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// On quitte sur X.
		cadre.setDefaultCloseOperation(modeFermeture);

		// Obtention de la r�f�rence sur le contentPane (�vite pls appels).
		panneauPrincipal = (JPanel) cadre.getContentPane();

		// Le panneau contenant la grille.
		JPanel panneauHaut = new JPanel();

		// Une disposition en grille pour celui du haut.
		panneauHaut.setLayout(new GridLayout(getNbLignes(), getNbColonnes()));

		// On ajoute les boutons vides.
		ajouterBoutons(panneauHaut);

		if(tabMenus != null){

			creerMenu(panneauHaut);	
		}

		else {
			
			// Le panneau du haut est plein �cran s'il n'y a pas de menu en bas.
			panneauPrincipal.add(panneauHaut);
		}


		cadre.setVisible(true);		

	}

	/**
	 * Cr�e le panneau du bas ety y ajkoute les boutons du menu. 
	 * Dimensionne les 2 panneaux (haut et bas) et les ajoute au 
	 * panneau principal.
	 * 
	 * @param panneauHaut Doit �tre ajhout� au panneau principal.
	 */
	private void creerMenu(JPanel panneauHaut) {

		// Les boutons de menu s'il y en a (FlowLayout par d�faut).
		JPanel panneauBas = new JPanel();		

		Dimension dh = new Dimension (d.width, (int)(d.height*.8));
		Dimension db = new Dimension (d.width, (int)(d.height*.1));

		// Les dimensions de panneau pour l'allure de la fen�tre.
		dimensionner(panneauHaut, dh);
		dimensionner(panneauBas, db);
		
		ajouterMenu(panneauBas);

		panneauPrincipal.add(panneauHaut, BorderLayout.PAGE_START);
		panneauPrincipal.add(panneauBas, BorderLayout.PAGE_END);			
	}

	/**
	 * Regroupe les instructions pour dimensionner un composant.
	 * 
	 * @param panneau Le panneau � dimensionner.
	 * @param dh La dimension voulue.
	 */
	private void dimensionner(JPanel panneau, Dimension dh) {
		
		panneau.setMinimumSize(dh);
		panneau.setMaximumSize(dh);
		panneau.setPreferredSize(dh);
		
	}

	
	/*
	 * Ajoute des boutons de menu (S'il y en a) au panneau. 
	 * 
	 * Si on est ici, on est certains qu'il y a des options de menu.
	 */
	private void ajouterMenu(JPanel panneau){

		JButton b;

		for(int i = 0; i < tabMenus.length; i++){

			b =new JButton(tabMenus[i]);

			// La dimension d'un bouton d�pend de la taille de l'�cran, 
			// on centre la grille.			
			b.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {

					estClique = false;
					optionClique = ((JButton)e.getSource()).getText();
					estBoutonMenu = true;
				}	
			});


			panneau.add(b);
		}

	}
	
	/*
	 * Ajoute les boutons dans la grille et dans le panneau.
	 * 
	 * Principalement pour la lisibilit� du code.
	 */
	private void ajouterBoutons(JPanel panneau){

		
		for(int i = 0; i < getNbLignes();i++) {
			
			for(int j = 0; j <getNbColonnes();j++){
				
				grille[i][j] =  new MonJButton(i,j, " ",  
						Color.BLACK, Color.BLUE, null);
				
				panneau.add(grille[i][j]);
			}	
		}
	}

	
	
	/**
	 * Classe interne qui ajoute � un JButton la position (x,y) o� il se trouve 
	 * dans la grille.
	 * 
	 * Cela �vite de chercher cette position lors d'un clic.
	 */
	private class MonJButton extends JButton{

		// Juste enlever le warning.
		private static final long serialVersionUID = 1L;
		
		// Coordonn�e ligne colonne du bouton dans le GUI.
		private int ligne;
		private int colonne;

		/**
		 * Constructeur avec la position du bouton et sa valeur.
		 * 
		 * @param y La position en ligne
		 * @param x La position en colonne
		 * @param valeur La valeur � afficher
		 * @param images 
		 */
		private MonJButton(int ligne, int colonne, String valeur,
				Color couleurTexte, 
				Color couleurFond, Icon image){

			// On passe le texte � la classe parent.
			super(image);

			this.ligne = ligne;
			this.colonne = colonne;

			setAlignmentX(JFrame.CENTER_ALIGNMENT);

			// La dimension d'un bouton d�pend de la taille de l'�cran, 
			// on centre la grille			
			addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {

					// On obtient la r�f�rence du bouton cliqu�.
					MonJButton b = (MonJButton) e.getSource();

					// On retient la position du clic.
					dernierClic =  new Coordonnee();
					dernierClic.ligne = b.ligne;
					dernierClic.colonne = b.colonne;
					
					estClique = true;		
					estBoutonMenu = false;
				}	
			});

		}
	}	
}