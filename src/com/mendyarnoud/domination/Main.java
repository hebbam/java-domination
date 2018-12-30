package com.mendyarnoud.domination;


import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mendyarnoud.domination.game.Game;
import com.mendyarnoud.domination.objet.Domino;
import com.mendyarnoud.domination.objet.King;
import com.mendyarnoud.domination.objet.Player;
import com.mendyarnoud.domination.objet.Playground;
import com.mendyarnoud.domination.utils.CsvReader;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Domino> dominos = CsvReader.readCsvFile("dominos.csv");
		List<Player> players = new ArrayList<>();
		/*
		Player player1=new Player("Hebba");
		Player player2=new Player("Matt");
		Player player3=new Player("Matto");
		Player player4=new Player("Mattiooo");
		players.add(player1);
		players.add(player2);
		//players.add(player3);
		//players.add(player4);
		King king1 = new King("Bleu");
		King king2 = new King("Bleu");
		players.get(0).addKing(king1);
		players.get(0).addKing(king2);
		King king3 = new King("Green");
		King king4 = new King("Green");
		players.get(1).addKing(king3);
		players.get(1).addKing(king4);*/
		Playground playground= new Playground();
		
		Game game = new Game(dominos, players);
		
		game.start();
		game.playerTurnInit();
		game.resume();
		System.out.println(playground.toString());
		
	}

}
