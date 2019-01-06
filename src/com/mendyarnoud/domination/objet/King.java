package com.mendyarnoud.domination.objet;

import java.awt.Color;

public class King {
	private String color;
	//Défintion des couleurs
	public static final String COLOR_RED = "FF0000";
	public static final String COLOR_BLUE = "0000FF";
	public static final String COLOR_GREEN = "00FF00";
	public static final String COLOR_ORANGE = "FFA500";
	
	public King(String	color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return color;
	}
}
