package model.songthings;

import java.io.File;
import java.util.ArrayList;

public class AllSongs extends SongCollections {
	ArrayList<Playlist> playlists;

	public AllSongs() {
		super("songs.txt");
		playlists = new ArrayList<>();
		loadAllPlaylists();
	}

	private void loadAllPlaylists() {
		File f = new File(System.getProperty("user.dir") + "//playlist//");
		if (!f.exists()) {
			new File(f.getAbsolutePath()).mkdir();
		}
		for(File x: f.listFiles()) {
			System.out.println(x.getName() + " " + x.getAbsolutePath());
			playlists.add(new Playlist(x.getName(), x.getAbsolutePath()));
		}
			
	}
}
