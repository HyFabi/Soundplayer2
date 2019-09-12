package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongCookies {
	public static ArrayList<String> allSongs = read();
	
	private static ArrayList<String> read(){
		Scanner s;
		try {
			s = new Scanner(new File("songs.txt"));
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
	
	public static void newLink(List<File> o) {
		for(File x : o){
			for(String s : allSongs) {
				if(s.equals(x.getAbsolutePath())) {
					break;
				}
			}
			allSongs.add(x.getAbsolutePath());
		}
		save();
	}
	
	public static void newLink(String x) {
		for(String s : allSongs) {
			if(s.equals(x)) {
				return;
			}
		}
		allSongs.add(x);
		save();
	}
	
	public static void save(){
	    PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("songs.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    for (String s : allSongs) {
	        pw.println(s);
	    }
	    pw.close();
	}
}
