package model;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlaySong {
	public static MediaPlayer m;
	
	public static void play(String path) {
		try {
			SongCookies.newLink(path);
			Media media = new Media(new File(path).toURI().toString());
			m = new MediaPlayer(media);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
