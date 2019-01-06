package com.mendyarnoud.domination.utils;



import java.util.List;

import com.mendyarnoud.domination.objet.Domino;


public class DominoUtil {

public static String display(List<Domino> dominos) {
	StringBuilder stringBuilder = new StringBuilder();
	for(Domino domino : dominos) {
		stringBuilder.append(domino.toString() + "\n");
	}
	return stringBuilder.toString();
}
}


