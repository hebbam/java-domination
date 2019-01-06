package com.mendyarnoud.domination.objet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Playground {

	private Tuile[][] playground = new Tuile[9][9];
	private int minPosX=4;
	private int maxPosX=4;
	private int minPosY=4;
	private int maxPosY=4;

	// Orientation
	private static final int BAS = 0;
	private static final int HAUT = 1;
	private static final int GAUCHE = 2;
	private static final int DROITE = 3;

	// Type terrain
	private static final int PRAIRIE = 1;
	private static final int FORET = 2;
	private static final int CHAMPS = 3;
	private static final int MER = 4;
	private static final int MONTAGNE = 5;
	private static final int MINE = 6;
	private static final int CHATEAU = 0;

	public Playground() {

		// On place une tuile chateau au centre du tableau 2D

		Tuile tuileChateau = new Tuile(0, "chateau");
		playground[4][4] = tuileChateau;

	}

	// Test si la position donnée est vide et qu'il n'y a pas deja une tuile sur la
	// position TRUE = CASE TERRAIN DE JEU VIDE
	private boolean isEmpty(int posX, int posY) {
		if (posX < 9 && posX >= 0 && posY < 9 && posY >= 0) {
			if (playground[posX][posY] == null) {
				return true;
			} else {
				return false;
			}

		}
		return true;
	}

	// On test si le domino ne se superpose pas a un autre dans le plateau de jeu en
	// prenant compte de l'ensemble du domino TRUE = AUCUN CHEVAUCHEMENT
	private boolean AucunChevauchement(int posX, int posY, int orientation) {

		boolean chevauchement = false;
		// On test la premiere tuile
		if (isEmpty(posX, posY)) {
			// Si la premiere tuile a pas de chevauchement on test la seconde suivant
			// l'orientation
			switch (orientation) {

			case BAS:
				if (isEmpty(posX, posY - 1))
					chevauchement = true;

				break;

			case HAUT:
				if (isEmpty(posX, posY + 1))
					chevauchement = true;

				break;

			case DROITE:
				if (isEmpty(posX + 1, posY))
					chevauchement = true;

				break;

			case GAUCHE:
				if (isEmpty(posX - 1, posY))
					chevauchement = true;

				break;

			}
		}

		return chevauchement;

	}

	public void updateSizePlayground() {

		int currentMaxPosX = 0;
		int currentMinPosX = 0;
		int currentMaxPosY = 0;
		int currentMinPosY = 0;
		boolean setMinPosX = false;
		boolean setMaxPosX = false;
		boolean setMinPosY = false;
		boolean setMaxPosY = false;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// update pour axe x
				if (playground[j][i] != null && !setMinPosX) {
					currentMinPosX = j;
					setMinPosX = true;
				}
				if (playground[j][i] != null && setMinPosX) {
					currentMaxPosX = j;
					setMaxPosX = true;
				}

				// update pour axe y

				if (playground[i][j] != null && !setMinPosY) {
					currentMinPosY = j;
					setMinPosY = true;
				}
				if (playground[i][j] != null && setMinPosY) {
					currentMaxPosY = j;
					setMaxPosY = true;
				}

			}
			// en Y
			if (setMinPosY && currentMinPosY < minPosY)
				minPosY = currentMinPosY;
			if (setMaxPosY && currentMaxPosY > maxPosY)
				maxPosY = currentMaxPosY;

			// en X
			if (setMinPosX && currentMinPosX < minPosX)
				minPosX = currentMinPosX;
			if (setMaxPosX && currentMaxPosX > maxPosX)
				maxPosX = currentMaxPosX;
			setMinPosX = false;
			setMaxPosX = false;
			setMinPosY = false;
			setMaxPosY = false;

		}
		System.out.println("minPosX "+minPosX+"maxPosX "+maxPosX);
		System.out.println("minPosY "+minPosY+"maxPosY "+maxPosY);
	}

	// A REVOIIIR
	// Determine si la longueur du terrain est valide suivant l'orientation (moins
	// ou egale a 5x5) -- TRUE = PAS DE DEPASSEMENT DE TERRAIN
	private boolean longueurDuTerrainValid(int posX, int posY, int orientation) {
		
		// Determine la longueur du terrain de jeux en X et Y
		updateSizePlayground();
		int sizePosX = maxPosX-minPosX;
		int sizePosY = maxPosY-minPosY;
		
		// test suivant l'orientation si la longueur du terrain va depassé de la limite
		// 5x5
		switch (orientation) {

		case BAS:
			if (sizePosY + 2 <= 5 && sizePosX + 1 <= 5||posX>=minPosX&&posX<=maxPosX&&posY-1>=minPosY&&posY<=maxPosY) {
				return true;
			}

			break;

		case HAUT:
			if (sizePosY + 2 <= 5 && sizePosX + 1 <= 5||posX>=minPosX&&posX<=maxPosX&&posY>=minPosY&&posY+1<=maxPosY) {
				return true;
			}
			
			break;

		case DROITE:
			if (sizePosY + 1 <= 5 && sizePosX + 2 <= 5||posX>=minPosX&&posX+1<=maxPosX&&posY>=minPosY&&posY<=maxPosY) {
				return true;
			}
			

			break;

		case GAUCHE:
			if (sizePosY + 1 <= 5 && sizePosX + 2 <= 5||posX-1>=minPosX&&posX<=maxPosX&&posY>=minPosY&&posY<=maxPosY) {
				return true;
			}
			

			break;

		}
		
		return false;
		
	}

	// Test si la tuile d'un domino et de meme type que une tuile present sur le
	// terrain ( gestion de la tuile de depart)
	private boolean isSameType(int posX, int posY, Tuile tuile) {
		if (!isEmpty(posX, posY)) {
			if (playground[posX][posY].getType().equals(tuile.getType())
					|| playground[posX][posY].getType().equals("chateau"))
				return true;
			else
				return false;
		} else
			return false;
	}

	// Test si au moins une tuile est adjacent et du meme type que le dominos TRUE =
	// MEME TYPE
	private boolean isAdjacentAndSameType(int posX, int posY, int orientation, Domino domino) {

		boolean isSameType = false;

		switch (orientation) {

		// Les if de chaque case sont trop long pour etre sur une ligne donc j'ai fais
		// deux if ...
		case BAS:
			if (isSameType(posX - 1, posY, domino.getTuile1()) || isSameType(posX + 1, posY, domino.getTuile1())
					|| isSameType(posX, posY + 1, domino.getTuile1()))
				isSameType = true;
			if (isSameType(posX - 1, posY - 1, domino.getTuile2()) || isSameType(posX + 1, posY - 1, domino.getTuile2())
					|| isSameType(posX, posY - 2, domino.getTuile2()))
				isSameType = true;
			break;

		case HAUT:
			if (isSameType(posX - 1, posY, domino.getTuile1()) || isSameType(posX + 1, posY, domino.getTuile1())
					|| isSameType(posX, posY - 1, domino.getTuile1()))
				isSameType = true;
			if (isSameType(posX - 1, posY + 1, domino.getTuile2()) || isSameType(posX + 1, posY + 1, domino.getTuile2())
					|| isSameType(posX, posY + 2, domino.getTuile2()))
				isSameType = true;

			break;

		case DROITE:
			if (isSameType(posX - 1, posY, domino.getTuile1()) || isSameType(posX, posY + 1, domino.getTuile1())
					|| isSameType(posX, posY - 1, domino.getTuile1()))
				isSameType = true;
			if (isSameType(posX + 1, posY + 1, domino.getTuile2()) || isSameType(posX + 2, posY, domino.getTuile2())
					|| isSameType(posX + 1, posY - 1, domino.getTuile2()))
				isSameType = true;

			break;

		case GAUCHE:

			if (isSameType(posX + 1, posY, domino.getTuile1()) || isSameType(posX, posY + 1, domino.getTuile1())
					|| isSameType(posX, posY - 1, domino.getTuile1()))
				isSameType = true;
			if (isSameType(posX - 1, posY + 1, domino.getTuile2()) || isSameType(posX - 2, posY, domino.getTuile2())
					|| isSameType(posX - 1, posY - 1, domino.getTuile2()))
				isSameType = true;

			break;

		}
		return isSameType;

	}

	// Verifie toutes les conditions et place le domino sur le terrain (TRUE domino
	// bien placé car toutes les conditions sont vrai)
	public boolean placerDomino(int posX, int posY, int orientation, Domino domino) {
		boolean dominoPlacer = false;
		if (longueurDuTerrainValid(posX, posY, orientation) && isAdjacentAndSameType(posX, posY, orientation, domino)
				&& AucunChevauchement(posX, posY, orientation)) {
			switch (orientation) {

			case BAS:
				playground[posX][posY] = domino.getTuile1();
				playground[posX][posY - 1] = domino.getTuile2();

				break;

			case HAUT:

				playground[posX][posY] = domino.getTuile1();
				playground[posX][posY + 1] = domino.getTuile2();

				break;

			case DROITE:

				playground[posX][posY] = domino.getTuile1();
				playground[posX + 1][posY] = domino.getTuile2();

				break;

			case GAUCHE:

				playground[posX][posY] = domino.getTuile1();
				playground[posX - 1][posY] = domino.getTuile2();

				break;

			}
			dominoPlacer = true;

		}
		return dominoPlacer;

	}

	@Override
	public String toString() {
		String dominoVide = "|            |"; // 13
		String plateau = "";

		for (int i = 8; i >= 0; i--) {

			plateau = plateau + "\n" + i; // Affichage cordonnée + retour ligne

			for (int j = 0; j < 9; j++) {
				if (isEmpty(j, i)) {
					plateau += dominoVide;
				} else {
					String domino = "| " + playground[j][i].getType() + " " + playground[j][i].getCrown();
					// Permet de faire des colonne et ligne rectiligne, il y a toujours 13 caractere
					// dans chaque colonne
					while (domino.length() < 13) {
						domino += " ";
					}
					plateau += domino + "|";

				}

			}
		}
		plateau += "\n |     0      ||     1      ||     2      ||     3      ||     4      ||     5      ||     6      ||     7      ||      8     |"; // axe
																																						// des
																																						// abscisses
		return plateau;

	}

	/*
	 * RESTE A FAIRE : - REGARDER POUR CHAQUE TUILE S IL Y A DES TUILES EN CONTACT -
	 * POUR CHAQUE TUILE EN CONTACT : REGARDER SI LA TUILE EN CONTACT EST DU MEME
	 * TYPE QUE LA TUILE A TESTER - POUR UN DOMINO AYANT 2 TUILES / IL Y A PART
	 * TUILE 3 POSITION DE CONTACT POSSIBLE -- DONC 6 PAR DOMINOS - RASSEMBLER TOUT
	 * LES BOOLEAN POUR VERIFIER TOUTE LES CONDITIONS / SI TOUTE LES CONDITIONS SONT
	 * VRAIS ALORS ON PEUT PLACER LE DOMINO :-D !! - ET POUR FINIR : IL FAUT
	 * REALISER L IA QUI CALCUL LES SCORE SI TOUT LES TERRAIN SONT REMPLI OU QU IL Y
	 * A PLUS DE DOMINO
	 * 
	 * ATTENTION : c'est normal que le projet se compile pas / je n'ai pas modifier
	 * le main et je n'ai encore RIEN tester. DONC IL FAUT TESTER AU DEBBUG CHAQUE
	 * METHODE
	 */

	// *******Calcul score terrain*******//

	// Compare si le type de la tuile en argument et celle en pos x et y du plateau
	// de jeu est de meme type
	private boolean isSameTypeInPos(Tuile tuile, int posX, int posY) {
		boolean isSameType = false;

		if (!isEmpty(posX, posY)) {
			if (tuile != null) {
				if (playground[posX][posY].getType().equals(tuile.getType()))
					isSameType = true;
			}
		}
		return isSameType;
	}

	// Recupere la liste des tuiles adjacente et de meme type que la tuile de
	// terrain analysee
	private List<Tuile> adjacentAndSameType(Tuile tuileTerrainAnalysee, int posX, int posY) {
		List<Tuile> tuileAdjacentAndSameType = new ArrayList<>();
		if(tuileTerrainAnalysee!=null) {
		tuileAdjacentAndSameType.add(tuileTerrainAnalysee);
		}
		if (isSameTypeInPos(tuileTerrainAnalysee, posX + 1, posY))
			tuileAdjacentAndSameType.add(playground[posX + 1][posY]);

		if (isSameTypeInPos(tuileTerrainAnalysee, posX - 1, posY))
			tuileAdjacentAndSameType.add(playground[posX - 1][posY]);

		if (isSameTypeInPos(tuileTerrainAnalysee, posX, posY + 1))
			tuileAdjacentAndSameType.add(playground[posX][posY + 1]);

		if (isSameTypeInPos(tuileTerrainAnalysee, posX, posY - 1))
			tuileAdjacentAndSameType.add(playground[posX][posY - 1]);

		return tuileAdjacentAndSameType;
	}

	private List<Tuile> determineDomaine(Tuile tuileTerrainAnalysee) {
		List<Tuile> listSameTuileType=new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(playground[i][j]!=null&&tuileTerrainAnalysee!=null) {
				if(tuileTerrainAnalysee.equals(playground[i][j])) {
					listSameTuileType=adjacentAndSameType(tuileTerrainAnalysee,i,j);
				}
				}
			}
			}
		return listSameTuileType;
			}




	public int  CalculPoint() {
		
		int pointTotal = 0;
		List<Tuile> tuilesOfDomaine=new ArrayList<>();
		List<Tuile> tuileAlreadyAnalysed=new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				List<Tuile> sameTuileType=new ArrayList<>();
				sameTuileType=adjacentAndSameType(playground[i][j], i, j);
				if(sameTuileType.size()!=0) {
					
					for(int t=0;t<sameTuileType.size();t++) {
						tuilesOfDomaine=determineDomaine(sameTuileType.get(t));
						
					}
					
				}
				if(tuilesOfDomaine.size()>0)
				if(!tuileAlreadyAnalysed.contains(tuilesOfDomaine.get(0)))
				pointTotal+=calculPointDomaine(tuilesOfDomaine);
				for(int n=0;n<tuilesOfDomaine.size();n++) {
				if(!tuileAlreadyAnalysed.contains(tuilesOfDomaine.get(n))) {
					
					tuileAlreadyAnalysed.add(tuilesOfDomaine.get(n));
				}
				}
				
			}
		}
		return pointTotal;
	
	}

	// Calcul les points d'un domaine avec les tuiles qui compose ce domaine
	private int calculPointDomaine(List<Tuile> tuilesOfDomaine) {
		int nbCrown = 0;
		for (int i = 0; i < tuilesOfDomaine.size(); i++) {
				nbCrown += tuilesOfDomaine.get(i).getCrown();
		}
		return nbCrown * tuilesOfDomaine.size();
	}

}