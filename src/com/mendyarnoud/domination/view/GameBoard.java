package com.mendyarnoud.domination.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.mendyarnoud.domination.game.Game;
import com.mendyarnoud.domination.game.GameManager;
import com.mendyarnoud.domination.objet.Player;

public class GameBoard extends JFrame implements ActionListener {

	private JButton gameState;
	private JButton pick;
	private Game game;
	private GameFieldView gameFieldView;
	private GameManager gameManager;
	
	
	public GameBoard(Game game) {
		super("game");
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.game = game;
		this.gameManager = new GameManager(game);
		this.gameFieldView = new GameFieldView(game);
		setLayout(null);
		setBounds(new Rectangle(80, 80, 800, 800));
		gameFieldView.setBounds(120, 60, 500, 500);
		add(gameFieldView);
		gameFieldView.setHeightX(500);
		gameFieldView.setWidthY(500);
		gameState = new JButton("Démarrer");
		gameState.setBounds(10, 20, 100, 40);
		gameState.addActionListener(this);
		add(gameState);
		pick = new JButton("Pioche");
		pick.setBounds(670, 20, 100, 40);
		pick.addActionListener(this);
		add(pick);
		List<Player> players = game.getPlayers();
			JButton player1 = new JButton(game.getPlayers().get(0).getName());
			player1.setBounds(350, 10, 100, 40);
			JButton player2 = new JButton(game.getPlayers().get(1).getName());
			player2.setBounds(350, 600, 100, 40);
			add(player1);
			add(player2);
		if (players.size() > 2) {
			JButton player3 = new JButton(game.getPlayers().get(2).getName());
			player3.setBounds(10, 300, 100, 40);
			add(player3);
		}
		if (players.size() == 4) {
			JButton player4 = new JButton(game.getPlayers().get(3).getName());
			player4.setBounds(650, 300, 100, 40);
			add(player4);
		}
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == gameState) {
			this.game.start();
			gameState.setText("Stop");
		}
		
		if(e.getSource() == pick) {
			this.gameManager.pick();
			

		}
	}

}
