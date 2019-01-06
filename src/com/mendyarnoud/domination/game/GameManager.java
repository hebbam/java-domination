package com.mendyarnoud.domination.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mendyarnoud.domination.objet.Domino;
import com.mendyarnoud.domination.objet.King;
import com.mendyarnoud.domination.objet.Player;
import com.mendyarnoud.domination.objet.Playground;

public class GameManager {

	private Game game;
	private Playground playground;

	public GameManager(Game game) {
		this.game = game;
		this.playground = new Playground();
	}

	public void pick() { // dominos pick en fonction du nombre de rois
		System.out.println("public void pick()");
		List<Player> players = game.getPlayers();
		int numberOfKings = 0;
		for (Player player : players) {
			numberOfKings = numberOfKings + player.getKings().size();
		}
		System.out.println("public void pick(): " + numberOfKings);
		if ((game.getDominosBank().size() >= numberOfKings)) {
			List<Domino> dominosToDraw = game.getDominosBank().subList(0, numberOfKings);
			List <Domino> dominosTemp = new ArrayList<>(dominosToDraw); //intermédiaire car confrontation entre remove et add a cause du sublist
			Collections.sort(dominosTemp);
			game.getDominosBank().removeAll(dominosTemp);
			game.getPickedDominos().addAll(dominosTemp);
		} else {
			System.out.println("Il n'y a plus de dominos");
		}

	}

	public Player turn() { // Premier Tour l appeler initializeGame
		// ou fait-on appel à pick? il faut bien appeler pick sans cette fonction
		System.out.println("public void placeKing()");
		// Tant qu'il a des rois et queles domininosToDraw n ont pas été tous sélect ->
		// while(numberOfKings)!=0
		// Récupération des joueurs
		List<Player> players = game.getPlayers();
		List<King> kings = new ArrayList<>();
		for (Player player : players) {
			// récup kings de tous les joueurs
			kings.addAll(player.getKings());
		}
		Collections.shuffle(kings);
		King king = kings.get(0);
		String kingColor = king.getColor();
		for (Player player : players) {
			// récup kings de tous les joueurs
			if (kingColor.equals(player.getKings().get(0).getColor())) {
				player.getKings().remove(king);
				return player;
				// garder en mémoire les dominosToDraw choisis de chaque joueur
			}
		}
		return null;
	}

	public void selectDomino(Player player, Domino domino) {
		game.getPlayedDominos().add(domino);
		game.getPickedDominos().remove(domino);
		player.getSelectedDominos().add(domino);
	}

	public void placeDomino(int x, int y, int orientation, Domino domino) {
		System.out.println("Placement des dominos");
		playground.placerDomino(x, y, orientation, domino);
		playground.updateSizePlayground();

	}
	
	public void showBoard() {
		System.out.println("Affichage du plateau");
		System.out.println(playground.toString());
		System.out.println(game);
		System.out.println("Nombre de points = " + playground.CalculPoint());
	}

	// le joueur place son domino = méthode placerDomino();
	public void mainTurn() {
		// while il y a de dominos en jeu
		// recupere les dominos placés de chaque joueur
		// pick();
		// le joueur qui a choisi le domino avec le plus petit numéro commence le tour
		// dominoToDrawPick();
		// le joueur place son Domino : placerDomino();
	}
}
