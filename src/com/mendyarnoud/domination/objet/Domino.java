package com.mendyarnoud.domination.objet;

public class Domino implements Comparable<Domino> {

	private Tuile tuile1;
	private Tuile tuile2;
	
	private int number;
	
	
	public Domino(Tuile tuile1,Tuile tuile2,int number ) {
	this.tuile1=tuile1;
	this.tuile2=tuile2;
	this.number = number;
	}
	
	
	public Tuile getTuile1() {
		return tuile1;
	}
	
	public Tuile getTuile2() {
		return tuile2;
	}


	public int getDominoNumber() {
		return number;
	}


	@Override
	public String toString() {
		return "Domino [couronne1=" + tuile1.getCrown() + ", type1=" + tuile1.getType() + ", couronne2=" + tuile2.getCrown() + ", type2=" + tuile2.getType()
				+ ", number=" + number + "]";
	}

	@Override
	public int compareTo(Domino domino) {
		if (this.number > domino.number) {
			return 1;
		}
		if (this.number < domino.number) {
			return -1;
		}
		return 0;
	}
}
