package com.mendyarnoud.domination.view;

import java.awt.Color;

import javax.swing.JPanel;

import com.mendyarnoud.domination.game.Game;
import com.mendyarnoud.domination.objet.Domino;

public class GameFieldView extends JPanel {
	private int heightX;
	private int widthY;

	public GameFieldView(Game game) {
		super();
		setLayout(null);
		setBackground(Color.decode("B55400"));

	}


	public void setHeightX(int heightX) {
		this.heightX = heightX;
	}


	public void setWidthY(int widthY) {
		this.widthY = widthY;
	}


}
