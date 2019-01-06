package com.mendyarnoud.domination.objet;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

public class Player {

	private String name;
	private int id;
	private List<King> kings = new ArrayList<>();
	private List <Domino> selectedDominos = new ArrayList<>();
	private static int counter;
	private Playground playground;

	
	public Player(String name) {
		this.name = name;
		this.id = ++counter;
	}

	
	public List<King> getKings() {
		return kings;
	}

	public void addKing(King king) {
		kings.add(king);
	}
	

	public void play() {

	}



	@Override
	public String toString() {
		return "Player [name=" + name + ", id=" + id + ", kings=" + kings + ", selectedDominos=" + selectedDominos
				+ "]";
	}


	public String getName() {
		
		return this.name + "#" + this.id;
	}

	public Playground getPlayground() {
		return playground;
	}

	public void setPlayground(Playground playground) {
		this.playground = playground;
	}

	public void setKings(List<King> kings) {
		this.kings = kings;
	}


	public List<Domino> getSelectedDominos() {
		return selectedDominos;
	}


	public void setSelectedDominos(List<Domino> selectedDominos) {
		this.selectedDominos = selectedDominos;
	}
	
	

}