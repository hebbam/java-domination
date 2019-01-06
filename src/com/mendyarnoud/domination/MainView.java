package com.mendyarnoud.domination;

import java.io.IOException;
import java.util.List;

import com.mendyarnoud.domination.game.Game;
import com.mendyarnoud.domination.objet.Domino;
import com.mendyarnoud.domination.objet.Player;
import com.mendyarnoud.domination.utils.CsvReader;
import com.mendyarnoud.domination.view.GameBoard;
import com.mendyarnoud.domination.view.PassingDataListener;
import com.mendyarnoud.domination.view.SetupView;
import com.mendyarnoud.domination.view.Subscription;



public class MainView implements PassingDataListener {
	private static List<Domino> dominos;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dominos = CsvReader.readCsvFile("dominos.csv");
		SetupView setupview = new SetupView();
		setupview.setVisible(true);
		setupview.setPassingDataListener(new MainView());

	}

	@Override
	public void onDataReceiving(int numberOfPlayers) {
		// TODO Auto-generated method stub
		Subscription subscription = new Subscription(numberOfPlayers);
		subscription.setVisible(true);
		subscription.setPassingDataListener(this);
	}

	@Override
	public void onPlayerReceiving(List<Player> players) {
		// TODO Auto-generated method stub
		Game game = Game.getGame(dominos, players);
		// game.start();
		GameBoard gameBoard = new GameBoard(game);
		gameBoard.setVisible(true);
	}

}
