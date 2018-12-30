package com.mendyarnoud.domination.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mendyarnoud.domination.objet.Domino;
import com.mendyarnoud.domination.objet.Tuile;

public class CsvReader {

	public static List<Domino> readCsvFile(String path) throws IOException {

		BufferedReader br = null;
		String line = "";
		List<Domino> dominos = new ArrayList<>();
		try {

			int index = 0;
			br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				if (index != 0) {
					String[] items = line.split(",");
					
					//Creation de la premiere Tuile
					int crowned1 = Integer.parseInt(items[0]);
					String type1 = items[1];
					Tuile tuile1 = new Tuile(crowned1,type1);
					
					//Creation de la deuxieme Tuile
					int crowned2 = Integer.parseInt(items[2]);
					String type2 = items[3];
					Tuile tuile2 = new Tuile(crowned2,type2);
					
					//Recuperation du numero du domino
					int dominoNumber = Integer.parseInt(items[4]);
					
					//Integration des tuiles et du numero pour former un domino
					Domino domino=new Domino(tuile1,tuile2,dominoNumber);
					dominos.add(domino);
				}
				index++;
			}
				br.close();
		} catch (Exception e) {
			
			System.out.println("Erreur : les dominos ont pas été correctement chargés");
			
		} 
		return dominos;
	}

}
