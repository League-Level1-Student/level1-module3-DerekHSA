package _03_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/*   If you don't have javazoom.jar in your project, you can download it from here: http://bit.ly/javazoom
 *   Right click your project and add it as a JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
	String Giorno = "JoJo's Bizarre Adventure_Golden Wind OST_ _Giorno's Theme_ Il vento d'oro (Main Theme) (192  kbps).mp3";
	String Josuke = "Yugo_Kanno_-_Josuke_Theme_(mp3.pm).mp3";
	String jotaro = "Jotaro.mp3";
	Song Josuk = new Song(Josuke);
	Song Giorn = new Song(Giorno);
	JFrame songs = new JFrame();
	JPanel panel = new JPanel();
	JButton play = new JButton();
	JButton huh = new JButton();
	JLabel josuke = new JLabel();
	JLabel cs = new JLabel();
	JButton Jota = new JButton();
	JLabel Jotar = new JLabel();
	Song Jotaro = new Song(jotaro);
	JButton STOP = new JButton();
	JLabel Stop = new JLabel();
	Song no = new Song("None.mp3");
	Song BMS = new Song("BreakMyStride.mp3");
	JLabel BMSlabel = new JLabel();
	JButton BMSbutton = new JButton();
    public void run() {
// 1. Find an mp3 on your computer or on the Internet.
		// 2. Create a Song object for that mp3


		// 3. Play the Song

    songs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	songs.setResizable(false);
	songs.add(panel);
	songs.pack();
	
	panel.add(Jota);
	panel.add(huh);
	panel.add(play);
	panel.add(BMSbutton);
	panel.add(STOP);
	
	BMSlabel=loadImage("Break my stride.PNG");
	Jotar=loadImage("Jotaro.jpg");
	josuke=loadImage("josuke.jpg");
	Stop=loadImage("stop.PNG");
	cs=loadImage("7309292d750c3ced5e63874eb60158aa.jpg");
	huh.add(josuke);
	huh.addActionListener(this);
	songs.setVisible(true);
	STOP.add(Stop);
	songs.pack();
	Stop=loadImage("stop.PNG");
	Jota.add(Jotar);
	Jota.addActionListener(this);
	songs.pack();
	STOP.addActionListener(this);
	BMSbutton.add(BMSlabel);
	BMSbutton.addActionListener(this);
	play.addActionListener(this);
    play.add(cs);
	
	
	
	songs.pack();
		/*
		 * 4. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
    }
    
    
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}


	

 class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}




@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton buttonPressed = (JButton) e.getSource();
	if (buttonPressed.equals(huh)){
		Josuk.play();
		Giorn.stop();
		Jotaro.stop();
		BMS.stop();
	}else if(buttonPressed.equals(play)) {
		Giorn.play();
		Josuk.stop();
		Jotaro.stop();
		BMS.stop();
	}else if (buttonPressed.equals(STOP)) {
		no.play();
		Giorn.stop();
		Jotaro.stop();
		Josuk.stop();
		BMS.stop();
	}else if (buttonPressed.equals(Jota)) {
		Giorn.stop();
		Jotaro.play();
		Josuk.stop();
		BMS.stop();
	}else if (buttonPressed.equals(BMSbutton)) {
		Giorn.stop();
		Jotaro.stop();
		Josuk.stop();
		BMS.play();
	}
}











}


