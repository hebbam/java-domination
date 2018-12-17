package com.mendyarnoud.domination.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mendyarnoud.domination.objet.Domino;
import com.mendyarnoud.domination.objet.Player;

public class Game {

	private List<Player> players;
	private List<Domino> dominos = new ArrayList<>();
	private List<Domino> deck= new ArrayList<Domino>();
	private static final int NUMBER_DOMINOS_2_PLAYERS=24;
	private static final int NUMBER_DOMINOS_3_PLAYERS=36;
	Scanner scan = new Scanner(System.in);
	
public Game(List<Domino> dominos, List<Player> players) {
		this.players=players;
		this.dominos=dominos;
		Collections.shuffle(dominos);
		if(players.size()==2) {
			this.dominos = dominos.subList(0, NUMBER_DOMINOS_2_PLAYERS);
		}else if(players.size()==3) {
		this.dominos = dominos.subList(0, NUMBER_DOMINOS_3_PLAYERS);
		}
		
	}

	

	public void start() {
		System.out.println("Le jeu est commencÃ©:");
		System.out.println("Voici la liste des joueurs: " + players.size());
		for(int i=0; i<players.size();i++)
			System.out.println(players.get(i));
		System.out.println("Voici la liste des dominos: " + dominos.size());
		for (Domino domino : dominos) {
			System.out.println(domino);
		}

	}

	public void playerTurnInit() {
		deck=dominos;
		int size=dominos.size();
		if(players.size()==3) {
			deck=dominos.subList(0, 3);
			dominos=dominos.subList(3, dominos.size());
		}else {
			deck=dominos.subList(0, 4);
			dominos=dominos.subList(4, dominos.size());
		}
		
		Collections.sort(deck);
	}
	
	public void PlayerTurn(Player player) {
		
	//Affichage des dominos a gerer
		
		
		boolean isPlayed=false;
		
		while(!isPlayed) {
			System.out.println("Au tour de"+player.getName()+"de jouer/n"
					+ "Quel domino souhaitez-vous prendre ?");
			
			int choix = 0;
			try {
				choix = scan.nextInt();
				//Peut etre traduit en catch si deck.size depasse 
				if((choix<=deck.size()+1)&&choix>=1) {
					//fonction placer sur le plateau
					deck.remove(choix-1);
					isPlayed=true;
				}
				
				
			}catch(InputMismatchException e) {
				System.out.println("Erreur : veuillez saisir la position d'un domino valide !");
				scan.nextLine();
			}
		
		
		
	}
	}
	
	
	public void PlayerPlaceSonDomino(Player player,Domino domino) {
		
		
		
		boolean isLineValide=false;
		boolean isColumValide=false;
		int ligneChoisi=0;
		int colonneChoisi=0;
		while(!isLineValide&&!isColumValide) {
			while(!isLineValide) {
				//Affichage du plateau du joueur en question a gerer
			System.out.println(player.getName()+" : Ou souhaitez vous placer l'extremité de votre domino sur votre plateau de jeu ?/n"
					+ "Entrez le numero de la ligne ?");
			
			int choix = 0;
			try {
				choix = scan.nextInt();
				if(choix<=8&&choix>=1) {
					ligneChoisi=choix;
					isLineValide=true;
				}
				
				
			}catch(InputMismatchException e) {
				System.out.println("Erreur : veuillez saisir une ligne valide !");
				scan.nextLine();
			}
		
		
		
	}
			while(!isColumValide) {
				//Affichage du plateau du joueur en question a gerer
				System.out.println(player.getName()+" : Ou souhaitez vous placer l'extremité de votre domino sur votre plateau de jeu ?/n"
						+ "Entrez le numero de la colonne ?");
				
				int choix = 0;
				try {
					choix = scan.nextInt();
					if(choix<=8&&choix>=1) {
						colonneChoisi=choix;
						isColumValide=true;
					}
					
					
				}catch(InputMismatchException e) {
					System.out.println("Erreur : veuillez saisir une colonne valide !");
					scan.nextLine();
				}
				
			}
			//Affichage du plateau du joueur en question a gerer
			System.out.println(player.getName()+" : Vous avez choisi les cordonnées suivant : ("+ ligneChoisi+" ; "+ colonneChoisi+")"
					+ "Choisir l'orientation du dominos ?");
	}
		//Finir l'orientation
	}
	

	public void resume() {
		System.out.println("Les premiers dominos :\n");
		for(int i=0; i<deck.size();i++) {
			System.out.println(deck.get(i));
		}
		System.out.println("Les dominos restant:"+dominos.size()+"\n");
		for(int i=0; i<dominos.size();i++) {
			System.out.println(dominos.get(i));
		}
		
			
	}

	public void stop() {

	}
}
