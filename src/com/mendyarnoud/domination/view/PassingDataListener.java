package com.mendyarnoud.domination.view;

import java.util.List;

import com.mendyarnoud.domination.objet.Player;

public interface PassingDataListener {
	void onDataReceiving(int numberOfPlayers);
	void onPlayerReceiving(List<Player> players);
}
