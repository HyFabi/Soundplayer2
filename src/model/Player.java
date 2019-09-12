package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import view.Main;

public class Player{
	public static MediaPlayer m;
	private static int id;
	public static ArrayList<String> queue = new ArrayList<>();
	
	public static void queue() {
		@SuppressWarnings("unchecked")
		ArrayList<String> temp = (ArrayList<String>) SongCookies.allSongs.clone();
		Random rnd = new Random();
		for(int i = temp.size(); i > 0; i--){
			queue.add(temp.remove(rnd.nextInt(i)));
		}
	}
	
	public static void play(String path) {
		try {Player.m.stop();}catch (Exception e) {}
		try {
			SongCookies.newLink(path);
			Media media = new Media(new File(path).toURI().toString());
			m = new MediaPlayer(media);
			m.setOnEndOfMedia(() -> Main.c.rnd());
		}catch (Exception e) {e.printStackTrace();}
	}
	
	public static void play() {
		try {Player.m.stop();}catch (Exception e) {}
		try {
			Media media = new Media(new File(queue.get(id)).toURI().toString());
			m = new MediaPlayer(media);
			m.setOnEndOfMedia(() -> play());
		}catch (Exception e) {e.printStackTrace();}
	}
}
