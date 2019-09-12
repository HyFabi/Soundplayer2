package model;

import java.util.Random;

public class Song {
	private String titel;
	private String interpret;
	private String file;
	private long duration;
	
	public Song(String titel, String interpret, String file, long duration) {
		setTitel(titel);
		setInterpret(interpret);
		setFile(file);
		setduration(duration);
	}
	
	public Song() {
		setTitel("7 Rings");
		setInterpret("lol xD");
		setFile("C:");
		setduration(429);
	}
	
	public Song(String titel, String interpret) {
		setTitel(titel);
		setInterpret(interpret);
		setduration(0);
		setFile("C:");
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		if(titel != null && !titel.isEmpty()) {
			this.titel = titel;
		}else {
			this.titel = "unkown";
		}
	}

	public String getInterpret() {
		return interpret;
	}
	
	public void setInterpret(String interpret) {
		String[] s= interpret.split(" ");
		if(s.length != 2) {
			this.interpret = "unkown";
			return;
		}
		setInterpret(s[0],s[1]);
	}
	
	private void setInterpret(String vorname, String nachname) {
		if(vorname != null && nachname != null) {
			this.interpret = vorname +" "+ nachname.toUpperCase();
		}else {
			this.interpret = "unkown";
		}
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		if(file != null) {
			this.file = file;
		}
	}

	public long getduration() {
		return duration;
	}

	public void setduration(long duration) {
		if(duration > 0) {
			this.duration = duration;
		}else {
			Random rnd = new Random();
			this.duration = rnd.nextInt(400)+101;
		}
	}

	@Override
	public String toString() {
		long m = duration/60;
		long s = duration% 60;
		if(s < 10) {
			return "\"" +this.titel+ "\" von " + this.interpret + " abgespeichert im \"" + file + "\" (Dauer: " + m + ":0"+ s + ")";
		}
		return "\"" +this.titel+ "\" von " + this.interpret + " abgespeichert im \"" + file + "\" (Dauer: " + m + ":"+ s + ")";
	}
	
	public void ausgeben() {
		System.out.println(toString());
	}
	
}
