package com.mendyarnoud.domination.objet;

public class Domino implements Comparable<Domino> {

	private int crowned1;
	private String type1;
	private int crowned2;
	private String type2;
	private int number;

	public int getCrowned1() {
		return crowned1;
	}

	public void setCrowned1(int crowned1) {
		this.crowned1 = crowned1;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public int getCrowned2() {
		return crowned2;
	}

	public void setCrowned2(int crowned2) {
		this.crowned2 = crowned2;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public int getDominoNumber() {
		return number;
	}

	public void setDominoNumber(int dominoNumber) {
		this.number = dominoNumber;
	}

	@Override
	public String toString() {
		return "Domino [couronne1=" + crowned1 + ", type1=" + type1 + ", couronne2=" + crowned2 + ", type2=" + type2
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
