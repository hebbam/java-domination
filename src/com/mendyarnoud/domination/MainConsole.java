package com.mendyarnoud.domination;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mendyarnoud.domination.game.Game;
import com.mendyarnoud.domination.game.GameManager;
import com.mendyarnoud.domination.objet.Domino;
import com.mendyarnoud.domination.objet.King;
import com.mendyarnoud.domination.objet.Player;
import com.mendyarnoud.domination.objet.Playground;
import com.mendyarnoud.domination.utils.CsvReader;

public class MainConsole {

	private static final int BAS = 0;
	private static final int HAUT = 1;
	private static final int GAUCHE = 2;
	private static final int DROITE = 3;

	public static void main(String[] args) throws IOException {
		List<Domino> dominos = CsvReader.readCsvFile("dominos.csv");
		List<Player> players = new ArrayList<>();
		Player player1 = new Player("laurent");
		Player player2 = new Player("jean");
		players.add(player1);
		players.add(player2);
		Game game = Game.getGame(dominos, players);
		GameManager gameManager = new GameManager(game);
		System.out.println("Le jeu ");
		//System.out.println(game);
		System.out.println("=======================Pick======================");
		gameManager.pick();
		//System.out.println(game);
		System.out.println("=======================Turn======================");
		Player currentPlayer = gameManager.turn();
		Domino domino = game.getPickedDominos().get(0);
		gameManager.selectDomino(currentPlayer, domino);
		//System.out.println(game);
		System.out.println("=======================Placer======================");
		gameManager.placeDomino(3, 4, GAUCHE, domino);
		currentPlayer = gameManager.turn();
		domino = game.getPickedDominos().get(0);
		gameManager.selectDomino(currentPlayer, domino);
		gameManager.placeDomino(4, 3, BAS, domino);
		currentPlayer = gameManager.turn();
		domino = game.getPickedDominos().get(0);
		gameManager.selectDomino(currentPlayer, domino);
		gameManager.placeDomino(4, 5, GAUCHE, domino);
		currentPlayer = gameManager.turn();
		domino = game.getPickedDominos().get(0);
		gameManager.selectDomino(currentPlayer, domino);
		gameManager.placeDomino(5, 5, DROITE, domino);
		System.out.println("=======================MainTurn======================");
		System.out.println(game);
		currentPlayer = gameManager.mainTurn();
		System.out.println(currentPlayer);
		currentPlayer = gameManager.mainTurn();
		System.out.println(currentPlayer);
		
		/*		domino = game.getPickedDominos().get(0);
		gameManager.selectDomino(currentPlayer, domino);
		gameManager.placeDomino(3, 4, BAS, domino);*/
		//gameManager.showBoard();
		//System.out.println(game);
	}

}
