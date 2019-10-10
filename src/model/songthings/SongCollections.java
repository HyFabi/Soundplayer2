package model.songthings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongCollections {
	public ArrayList<String> songs;
	
	public SongCollections(String path) {
		songs = read(path);
	}
	
	private ArrayList<String> read(String path){
		Scanner s;
		try {
			s = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht vorhanden");
			return new ArrayList<>();
		}
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.nextLine());
		}
		s.close();
		return list;
	}
	
	public void newLink(List<File> o) {
		for(File x : o){
			for(String s : songs) {
				if(s.equals(x.getAbsolutePath())) {
					break;
				}
			}
			songs.add(x.getAbsolutePath());
		}
		save();
	}
	
	public void newLink(String x) {
		for(String s : songs) {
			if(s.equals(x)) {
				return;
			}
		}
		songs.add(x);
		save();
	}
	
	public void save(){
	    PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("songs.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    for (String s : songs) {
	        pw.println(s);
	    }
	    pw.close();
	}
	
	public void check() {
		for(String s : songs){
			File f = new File(s);
			if(!f.exists()) {
				songs.remove(s);
				System.out.println("Eine Datei wurde gelöscht!");
			}
		}
		save();
	}
}
