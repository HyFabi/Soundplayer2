package model.songthings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Playlist extends SongCollections{
	String name;
	ArrayList<String> songs;
	
	public Playlist(String name, String path) {
		super(path);
		songs = new ArrayList<>();
		this.name = name;
		path = (System.getProperty("user.dir")+ "//playlist//");
//		checkExistence();
	}
	
//	public boolean checkExistence() {
//		File f = new File(path + name + ".txt");
//		System.out.println(f.getAbsolutePath());
//		if(!f.exists()) {
//			try {
//				f.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//				createMissingDirectory();
//			}
//		}
//		return false;
//	}
//	
//	private void createMissingDirectory() {
//		new File(path).mkdir();
//		checkExistence();
//	}
}
