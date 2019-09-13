package controller;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Player;
import model.SongCookies;
import view.Main;

public class Controller {
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider volume;
    
    @FXML
    private TextField input;
    
    @FXML
    private Button playBtn;

    @FXML
    private Button pauseBtn;
    
    @FXML
    private VBox vbox;
    
    @FXML
    void initialize() {}

    @FXML
    void next(ActionEvent event) {
    	Main.p.next();
    	updateList();
    }

    @FXML
    void pause(ActionEvent event) {
    	Player.m.pause();
    }

    @FXML
    public void debug(ActionEvent event) {
    	updateList();
    }
    
    @FXML
    void play(ActionEvent event) {
    	try {Player.m.stop();}catch (Exception e) {}
    	Main.p.queue();
    	Main.p.play();
    	updateList();
    }

    @FXML
    void random(ActionEvent event) {
    	try {Player.m.stop();}catch (Exception e) {}
    	Random rnd = new Random();
    	Main.p.play(SongCookies.allSongs.get(rnd.nextInt(SongCookies.allSongs.size())));
    	Player.m.play();
    	updateList();
    }
    
    public void rnd() {
		random(null);
		updateList();
	}

    public void updateList() {
    	if(vbox == null) {
    		vbox = new VBox();
    	}else {
    		vbox.getChildren().clear();
    	}
    	for (String s : Player.queue) {
    		vbox.getChildren().add(new Label(s.substring(s.lastIndexOf("\\")+1, s.lastIndexOf("."))));
    	}
	}

    @FXML
    void setVolume(MouseEvent event) {
    	try {
    		Player.m.setVolume(volume.getValue()/100);
    	}catch (Exception e) {}
    	
    }

    @FXML
    void stop(ActionEvent event) {
    	Player.m.stop();
    	updateList();
    }
    
    @FXML
    void select(ActionEvent event) {
    	FileChooser f = new FileChooser();
    	f.setTitle("Open Sound File");
    	f.getExtensionFilters().add(new ExtensionFilter("Audio Files", "*.wav", "*.mp3"));
    	List<File> list = f.showOpenMultipleDialog(Main.s);
    	if (list != null) {
			SongCookies.newLink(list);
    	}
    	if(list.size() == 1) {
    		Main.p.play(list.get(0).getAbsolutePath());
    	}
    	updateList();
    }
}
