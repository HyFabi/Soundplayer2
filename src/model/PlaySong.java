package model;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import view.Main;

public class PlaySong{
	public static MediaPlayer m;
	
	public static void play(String path) {
		try {PlaySong.m.stop();}catch (Exception e) {}
		try {
			SongCookies.newLink(path);
			Media media = new Media(new File(path).toURI().toString());
			m = new MediaPlayer(media);
			m.setOnEndOfMedia(() -> Main.c.rnd());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
