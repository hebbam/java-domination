package com.mendyarnoud.domination.view;

public enum DominoColor {
	CHAMPS("#f1c40f"),
	MER("#3498db"),
	MONTAGNE("#d35400"),
	PRAIRIE("#f39c12"),
	FORET("#27ae60"),
	MINE("#7f8c8d");

	public String color;

	 DominoColor(String color) {
		this.color = color;	
	}

	 public static String findColor(String type) {
		 if(type.equalsIgnoreCase(CHAMPS.name())) {
			 return CHAMPS.color;
		 }
		 if(type.equalsIgnoreCase(MER.name())) {
			 return MER.color;
		 }
		 if(type.equalsIgnoreCase(MONTAGNE.name())) {
			 return MONTAGNE.color;
		 }
		 if(type.equalsIgnoreCase(PRAIRIE.name())) {
			 return PRAIRIE.color;
		 }
		 if(type.equalsIgnoreCase(FORET.name())) {
			 return FORET.color;
		 }
		 return MINE.color;
	 }
}
