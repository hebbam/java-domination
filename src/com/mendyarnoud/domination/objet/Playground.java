package com.mendyarnoud.domination.objet;

public class Playground {
	
	private Tuile[][] playground= new Tuile[8][8];
	
	//Orientation
	private static final int BAS = 0;
	private static final int HAUT = 1;
	private static final int GAUCHE = 2;
	private static final int DROITE = 3;
	
	//Type terrain
	private static final int PRAIRIE=1;
	private static final int FORET=2;
	private static final int CHAMPS=3;
	private static final int MER=4;
	private static final int MONTAGNE=5;
	private static final int MINE=6;
	private static final int CHATEAU=0;
	
	
	public Playground() {
		
		//On place une tuile chateau au centre du tableau 2D
		
		Tuile tuileChateau = new Tuile(0,"chateau");
		playground[4][4]=tuileChateau;
	}
	
	
	
	
	
	//Test si la position donn�e est vide et qu'il n'y a pas deja une tuile sur la position TRUE = CASE TERRAIN DE JEU VIDE 
	public boolean isEmpty(int posX, int posY){
		if(playground[posX][posY]==null) {
			return true;
		}else
			return false;
	}
	
	//On test si le domino ne se superpose pas a un autre dans le plateau de jeu en prenant compte de l'ensemble du domino TRUE = AUCUN CHEVAUCHEMENT
	public boolean AucunChevauchement(int posX, int posY, int orientation) {
		
		boolean chevauchement=false;
		//On test la premiere tuile
		if(isEmpty(posX,posY)) {
		// Si la premiere tuile a pas de chevauchement on test la seconde suivant l'orientation
		switch (orientation) {
				
				case BAS:
					if(isEmpty(posX,posY-1))
						chevauchement=true;
					
					break;
					
				case HAUT:
					if(isEmpty(posX,posY+1))
						chevauchement=true;
					
					break;
					
				case DROITE:
					if(isEmpty(posX+1,posY))
						chevauchement=true;
					
					break;
				
				case GAUCHE:
					if(isEmpty(posX-1,posY))
						chevauchement=true;
			
				
					break;
					
				
				
					
				}
		}
		
		return chevauchement;
		

	}
	
	//Determine si la longueur du terrain est valide suivant l'orientation (moins ou egale a 5x5)  -- TRUE = PAS DE DEPASSEMENT DE TERRAIN
	public boolean longueurDuTerrainValid(int posX, int posY, int orientation) {
		int longueurX=0;
		int longueurY=0;
		
		// Determine la longueur du terrain de jeux en X et Y
		for(int i=0;i<8;i++) {
			if(playground[i][posY]!=null)
			longueurX+=1;
		}
		for(int i=0;i<8;i++) {
			if(playground[posX][i]!=null)
				longueurY+=1;
		}
		// test suivant l'orientation si la longueur du terrain va depass� de la limite 5x5
		if(orientation==BAS||orientation==HAUT) {
			if(longueurX+1<=5&&longueurY+1<=5) {
				return true;
			}else
				return false;
		}
		else if(orientation==DROITE||orientation==GAUCHE) {
			if(longueurX+2<=5) {
				return true;
			}else
				return false;
		}else
			return false;
	}
	
	//Test si la tuile d'un domino et de meme type que une tuile present sur le terrain ( gestion de la tuile de depart)
	public boolean isSameType(int posX, int posY, Tuile tuile) {
		if(!isEmpty(posX,posY)) {
		if (playground[posX][posY].getType().equals(tuile.getType())||playground[posX][posY].getType().equals("chateau"))
			return true;
		else
			return false;
	}else
		return false;
	}
	
	//Test si au moins une tuile est adjacent et du meme type que le dominos TRUE = MEME TYPE
	public boolean isAdjacentAndSameType(int posX,int posY, int orientation,Domino domino) {
		
		boolean isSameType=false;
		
		switch (orientation) {
		
		case BAS:
			if (isSameType(posX-1,posY,domino.getTuile1())||isSameType(posX+1,posY,domino.getTuile1())||isSameType(posX,posY+1,domino.getTuile1()))
				if (isSameType(posX-1,posY,domino.getTuile2())||isSameType(posX+1,posY,domino.getTuile2())||isSameType(posX,posY-1,domino.getTuile2()))
					isSameType=true;
			break;
			
		case HAUT:
			if (isSameType(posX-1,posY,domino.getTuile1())||isSameType(posX+1,posY,domino.getTuile1())||isSameType(posX,posY-1,domino.getTuile1()))
				if (isSameType(posX-1,posY,domino.getTuile2())||isSameType(posX+1,posY,domino.getTuile2())||isSameType(posX,posY+1,domino.getTuile2()))
					isSameType=true;
			
			break;
			
		case DROITE:
			if (isSameType(posX-1,posY,domino.getTuile1())||isSameType(posX,posY+1,domino.getTuile1())||isSameType(posX,posY-1,domino.getTuile1()))
				if (isSameType(posX,posY+1,domino.getTuile2())||isSameType(posX+1,posY,domino.getTuile2())||isSameType(posX,posY-1,domino.getTuile2()))
					isSameType=true;
			
			break;
		
		case GAUCHE:
			
			if (isSameType(posX+1,posY,domino.getTuile1())||isSameType(posX,posY+1,domino.getTuile1())||isSameType(posX,posY-1,domino.getTuile1()))
				if (isSameType(posX,posY+1,domino.getTuile2())||isSameType(posX-1,posY,domino.getTuile2())||isSameType(posX,posY-1,domino.getTuile2()))
					isSameType=true;
			
			break;
			
		
		
			
		}
		return isSameType;
	
}
	
	//Verifie toutes les conditions et place le domino sur le terrain (TRUE domino bien plac� car toutes les conditions sont vrai)
	public boolean PlacerDomino(int posX,int posY,int orientation, Domino domino) {
		boolean dominoPlacer=false;
		if(longueurDuTerrainValid(posX,posY,orientation)&&isAdjacentAndSameType(posX, posY,orientation, domino)&&AucunChevauchement(posX,posY,orientation)) {
		switch (orientation) {
				
				case BAS:
					playground[posX][posY]=domino.getTuile1();
					playground[posX][posY-1]=domino.getTuile2();
					
					break;
					
				case HAUT:
					
					playground[posX][posY]=domino.getTuile1();
					playground[posX][posY+1]=domino.getTuile2();
					
					break;
					
				case DROITE:
					
					playground[posX][posY]=domino.getTuile1();
					playground[posX+1][posY]=domino.getTuile2();
					
					break;
				
				case GAUCHE:
					
					playground[posX][posY]=domino.getTuile1();
					playground[posX-1][posY]=domino.getTuile2();
		
					break;
					
				
		
			
				}
		dominoPlacer=true;
		
		}
		return dominoPlacer;
		
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 RESTE A FAIRE :
	 - REGARDER POUR CHAQUE TUILE S IL Y A DES TUILES EN CONTACT 
	    - POUR CHAQUE TUILE EN CONTACT : REGARDER SI LA TUILE EN CONTACT EST DU MEME TYPE QUE LA TUILE A TESTER
	    - POUR UN DOMINO AYANT 2 TUILES / IL Y A PART TUILE 3 POSITION DE CONTACT POSSIBLE -- DONC 6 PAR DOMINOS
	- RASSEMBLER TOUT LES BOOLEAN POUR VERIFIER TOUTE LES CONDITIONS / SI TOUTE LES CONDITIONS SONT VRAIS ALORS ON PEUT PLACER LE DOMINO :-D !!
	- ET POUR FINIR : IL FAUT REALISER L IA QUI CALCUL LES SCORE SI TOUT LES TERRAIN SONT REMPLI OU QU IL Y A PLUS DE DOMINO
	
	ATTENTION : c'est normal que le projet se compile pas / je n'ai pas modifier le main et je n'ai encore RIEN tester. DONC IL FAUT TESTER AU DEBBUG CHAQUE METHODE 
	 */
	
}




