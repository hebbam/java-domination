package com.mendyarnoud.domination.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.mendyarnoud.domination.objet.Domino;

public class DominoView extends JPanel {

	private Domino domino;
	private boolean verso;
	private int height;
	private int width;

	public DominoView(Domino domino, boolean verso, int height, int width) {
		this.domino = domino;
		this.verso = verso;
		this.height = height;
		this.width = width;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paintComponent(graphics);
		System.out.println("print lopm");
		graphics.drawRect(0, 0, width, height);		
		if (verso) {
			if (domino.getTuile1().equals(domino.getTuile2())) {
				String color = DominoColor.findColor(domino.getTuile1().getType());
				graphics.setColor(Color.decode(color));
				graphics.fillRect(0, 0, width, height);
			}
			else {
				String color1 = DominoColor.findColor(domino.getTuile1().getType());
				graphics.setColor(Color.decode(color1));
				graphics.fillRect(0, 0, width / 2, height / 2);
				String color2 = DominoColor.findColor(domino.getTuile2().getType());
				graphics.setColor(Color.decode(color2));
				graphics.fillRect(width / 2, height / 2, width, height);
			}

		} else {
			graphics.setColor(Color.CYAN);
			graphics.drawString(String.valueOf(this.domino.getDominoNumber()), width/2, height/2);
		}

	}
}
