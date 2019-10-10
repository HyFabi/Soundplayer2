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
	
	//TODO Wenn Main.as.songs.clone(); leer ist
	public void queue() {
		queue.clear();
		ArrayList<String> temp = (ArrayList<String>) Main.as.songs.clone();
		Random rnd = new Random();
		for(int i = Main.as.songs.size()-1; i > 0; i--){
			int x = rnd.nextInt(i+1);
			queue.add(temp.remove(x));
		}
		queue.add(temp.remove(0));
		id = 0;
		Main.c.updateList();
	}
	
	public void play(String path) {
		try {Player.m.stop();}catch (Exception e) {}
		try {
			Main.as.newLink(path);
			Media media = new Media(new File(path).toURI().toString());
			m = new MediaPlayer(media);
			m.setOnEndOfMedia(() -> next());
		}catch (Exception e) {e.printStackTrace();}
		Main.c.debug(null);
	}
	
	public void play() {
		try {Player.m.stop();}catch (Exception e) {}
		try {
			Media media = new Media(new File(queue.get(id)).toURI().toString());
			m = new MediaPlayer(media);
			m.play();
//			System.out.println(Main.c.getRBtn1().selectedProperty().toString());
			m.setOnEndOfMedia(() -> next());
		}catch (Exception e) {e.printStackTrace();}
		Main.c.debug(null);
	}
	
	public void next() {
		if(queue.size() > 1) {
			queue.remove(id);
		}else {
			queue();
		}
		try {Player.m.stop();}catch (Exception e) {}
		try {
			Media media = new Media(new File(queue.get(id)).toURI().toString());
			m = new MediaPlayer(media);
			m.play();
			m.setOnEndOfMedia(() -> next());
		}catch (Exception e) {e.printStackTrace();}
		Main.c.debug(null);
	}
}
