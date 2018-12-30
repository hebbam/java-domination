package com.mendyarnoud.domination.objet;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private List<King> kings = new ArrayList<>();
	private Playground playground;
	

	public Player(String name,List<King> kings, Playground playground) {
		this.name = name;
		this.kings=kings;
		this.playground=playground;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addKing(King king) {
		kings.add(king);
	}

	public void play() {

	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", kings=" + kings + "]";
	}

}
