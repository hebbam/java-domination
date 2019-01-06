package com.mendyarnoud.domination.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.mendyarnoud.domination.objet.Player;


public class Subscription extends JFrame implements ActionListener {

	private JTextField nameTextField1;
	private JTextField nameTextField2;
	private JTextField nameTextField3;
	private JTextField nameTextField4;
	private List<Player> players = new ArrayList<>();
	private int numberOfPlayers;
	private PassingDataListener passingDataListener;

	public Subscription(int numberOfPlayers) throws HeadlessException {
		super("player subscription");
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		this.numberOfPlayers = numberOfPlayers;
		setBounds(new Rectangle(80, 80, 500, 800));
		JLabel text1 = new JLabel("Entrez le nom du joueur 1");
		text1.setBounds(new Rectangle(50, 50, 400, 50));
		nameTextField1 = new JTextField();
		nameTextField1.setBounds(new Rectangle(50, 110, 400, 50));
		JLabel text2 = new JLabel("Entrez le nom du joueur 2");
		text2.setBounds(new Rectangle(50, 170, 400, 50));
		nameTextField2 = new JTextField();
		nameTextField2.setBounds(new Rectangle(50, 230, 400, 50));
		JLabel text3 = new JLabel("Entrez le nom du joueur 3");
		text3.setBounds(new Rectangle(50, 290, 400, 50));
		nameTextField3 = new JTextField();
		nameTextField3.setBounds(new Rectangle(50, 350, 400, 50));
		JLabel text4 = new JLabel("Entrez le nom du joueur 4");
		text4.setBounds(new Rectangle(50, 410, 400, 50));
		nameTextField4 = new JTextField();
		nameTextField4.setBounds(new Rectangle(50, 470, 400, 50));
		JButton validation = new JButton("Valider");
		validation.setBounds(new Rectangle(50, 570, 400, 50));
		add(text1);
		add(nameTextField1);
		add(text2);
		add(nameTextField2);
		if (numberOfPlayers > 2) {
			add(text3);
			add(nameTextField3);
		}
		if (numberOfPlayers == 4) {
			add(text4);
			add(nameTextField4);
		}
		add(validation);
		validation.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String pseudo1 = nameTextField1.getText();
		String pseudo2 = nameTextField2.getText();
		String pseudo3 = nameTextField3.getText();
		String pseudo4 = nameTextField4.getText();
		Player player1 = new Player(pseudo1);
		players.add(player1);
		Player player2 = new Player(pseudo2);
		players.add(player2);
		if (numberOfPlayers > 2) {
			Player player3 = new Player(pseudo3);
			players.add(player3);
		}
		
		if(numberOfPlayers == 4) {
			Player player4 = new Player(pseudo4);
			players.add(player4);
		}
		passingDataListener.onPlayerReceiving(players);
		setVisible(false);
	}

	public void setPassingDataListener(PassingDataListener passingDataListener) {
		this.passingDataListener = passingDataListener;
	}

}
