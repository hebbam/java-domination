package com.mendyarnoud.domination.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class SetupView extends JFrame implements ActionListener{

	private JButton button2Players;
	private JButton button3Players;
	private JButton button4Players;
	private int numberOfPlayers;
	private PassingDataListener passingDataListener;
	



	public SetupView() {
		super("selection number of players");
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(new Rectangle(80, 80, 500, 800));
		JLabel text1 = new JLabel("Sélectionner le nombre de joueurs");
		text1.setBounds(new Rectangle(50, 50, 400, 50));
		button2Players = new JButton("2 players");
		button2Players.addActionListener(this);
		button3Players = new JButton("3 players");
		button3Players.addActionListener(this);
		button4Players = new JButton("4 players");
		button4Players.addActionListener(this);
		button2Players.setBounds(new Rectangle(50, 170, 400, 50));
		button3Players.setBounds(new Rectangle(50, 270, 400, 50));
		button4Players.setBounds(new Rectangle(50, 370, 400, 50));
		add(text1);
		add(button2Players);
		add(button3Players);
		add(button4Players);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button2Players) {
			numberOfPlayers = 2;
			setVisible(false);	
		}
		if(e.getSource() == button3Players) {
			numberOfPlayers = 3;
			setVisible(false);
		}
		if(e.getSource() == button4Players) {
			numberOfPlayers = 4;
			setVisible(false);
		}
		passingDataListener.onDataReceiving(numberOfPlayers);
	}
	
	public void setPassingDataListener(PassingDataListener passingDataListener) {
		this.passingDataListener = passingDataListener;
	}

}
