package com.mendyarnoud.domination.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mendyarnoud.domination.objet.Domino;
import com.mendyarnoud.domination.objet.King;
import com.mendyarnoud.domination.objet.Player;
import com.mendyarnoud.domination.utils.DominoUtil;

public class Game {

	private List<Player> players;
	private List<Domino> dominosBank = new ArrayList<>();
	private List<Domino> prewiewDominosTurn = new ArrayList<>(); 
	private List<Domino> pickedDominos = new ArrayList<>();
	private List<Domino> placedDominos = new ArrayList<>();

	private List<Domino> deck = new ArrayList<Domino>();
	private static final int NUMBER_DOMINOS_2_PLAYERS = 24;
	private static final int NUMBER_DOMINOS_3_PLAYERS = 36;


	private Game(List<Domino> dominos, List<Player> players) {
		this.players = players;
		this.dominosBank = dominos;
		Collections.shuffle(dominos);
		if (players.size() == 2) {
			this.dominosBank = dominos.subList(0, NUMBER_DOMINOS_2_PLAYERS);
		} else if (players.size() == 3) {
			this.dominosBank = dominos.subList(0, NUMBER_DOMINOS_3_PLAYERS);
		}

	}

	public static Game getGame(List<Domino> dominos, List<Player> players) {
		List<Domino> dominosResult = dominos;
		Collections.shuffle(dominos);
		if (players.size() == 2) {
			dominosResult = dominos.subList(0, NUMBER_DOMINOS_2_PLAYERS);
			King king1 = new King(King.COLOR_BLUE);
			King king2 = new King(King.COLOR_BLUE);
			players.get(0).addKing(king1);
			players.get(0).addKing(king2);
			King king3 = new King(King.COLOR_GREEN);
			King king4 = new King(King.COLOR_GREEN);
			players.get(1).addKing(king3);
			players.get(1).addKing(king4);
			return new Game(dominosResult, players);
		}
		if (players.size() == 3) {
			dominosResult = dominos.subList(0, NUMBER_DOMINOS_3_PLAYERS);
			King king1 = new King(King.COLOR_BLUE);
			players.get(0).addKing(king1);
			King king2 = new King(King.COLOR_GREEN);
			players.get(1).addKing(king2);
			King king3 = new King(King.COLOR_RED);
			players.get(2).addKing(king3);
			return new Game(dominosResult, players);
		}
		King king1 = new King(King.COLOR_BLUE);
		players.get(0).addKing(king1);
		King king2 = new King(King.COLOR_GREEN);
		players.get(1).addKing(king2);
		King king3 = new King(King.COLOR_RED);
		players.get(2).addKing(king3);
		King king4 = new King(King.COLOR_ORANGE);
		players.get(3).addKing(king4);
		return new Game(dominosResult, players);
	}

	public void start() {
		System.out.println("Le jeu est commencé:");
		System.out.println("Voici la liste des joueurs: " + players.size());
		for (int i = 0; i < players.size(); i++)
			System.out.println(players.get(i));
		System.out.println("Voici la liste des dominos: " + dominosBank.size());
		for (Domino domino : dominosBank) {
			System.out.println(domino);
		}

	}

	public void playerTurnInit() {
		deck = dominosBank;
		int size = dominosBank.size();
		if (players.size() == 3) {
			deck = dominosBank.subList(0, 3);
			dominosBank = dominosBank.subList(3, dominosBank.size());
		} else {
			deck = dominosBank.subList(0, 4);
			dominosBank = dominosBank.subList(4, dominosBank.size());
		}

		Collections.sort(deck);
	}

	/*
	 * public void PlayerTurn(Player player) {
	 * 
	 * // Affichage des dominos a gerer
	 * 
	 * boolean isPlayed = false;
	 * 
	 * while (!isPlayed) { System.out.println("Au tour de" + player.getName() +
	 * "de jouer/n" + "Quel domino souhaitez-vous prendre ?");
	 * 
	 * int choix = 0; try { choix = scan.nextInt(); choix += 1; // Peut etre traduit
	 * en catch si deck.size depasse // fonction placer sur le plateau Domino
	 * dominoChoisi; dominoChoisi = deck.get(choix); PlayerPlaceSonDomino(player,
	 * dominoChoisi); deck.remove(choix - 1); isPlayed = true; }
	 * 
	 * catch (InputMismatchException e) { System.out.
	 * println("Erreur : veuillez saisir la position d'un domino valide !");
	 * scan.nextLine(); }
	 * 
	 * } }
	 */

	public void resume() {
		System.out.println("Les premiers dominos :\n");
		for (int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i));
		}
		System.out.println("Les dominos restant:" + dominosBank.size() + "\n");
		for (int i = 0; i < dominosBank.size(); i++) {
			System.out.println(dominosBank.get(i));
		}

	}

	public void stop() {

	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Domino> getDominosBank() {
		return dominosBank;
	}

	public void setDominosBank(List<Domino> dominos) {
		this.dominosBank = dominos;
	}

	public List<Domino> getPickedDominos() {
		return pickedDominos;
	}

	public void setPickedDominos(List<Domino> pickedDominos) {
		this.pickedDominos = pickedDominos;
	}


	public List<Domino> getPrewiewDominosTurn() {
		return prewiewDominosTurn;
	}

	public List<Domino> getPlacedDominos() {
		return placedDominos;
	}

	@Override
	public String toString() {
		String result = "La structure du jeu est : \n";
		String players = "Players = " + this.players + "\nNombre de joueurs = " + this.players.size() + "\n";
		String dominosBank = "Banque = " + DominoUtil.display(this.dominosBank) + "\nDominos restants = " + this.dominosBank.size() + "\n";
		String prewiewDominosTurn = "Dominos du tour précédent " + DominoUtil.display(this.prewiewDominosTurn) + "\nNombre de dominos du tour précédent = "
				+ this.prewiewDominosTurn.size() + "\n";
		String placedDominosOnBoard = "Dominos joués = " + DominoUtil.display(this.placedDominos) + "\nNombre de dominos sur le plateau = "
				+ this.placedDominos.size() + "\n";
		String pickedDominos = "Dominos piochés = " + DominoUtil.display(this.pickedDominos) + "\nNombre de dominos piochés restants = "
				+ this.pickedDominos.size() + "\n";
		return result + players + dominosBank + pickedDominos + prewiewDominosTurn + placedDominosOnBoard;
	}

}
