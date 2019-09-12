package controller;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private ListView<String> list;

    @FXML
    void initialize() {
        assert volume != null : "fx:id=\"volume\" was not injected: check your FXML file 'View.fxml'.";
        assert playBtn != null : "fx:id=\"playBtn\" was not injected: check your FXML file 'View.fxml'.";
        assert pauseBtn == null : "fx:id=\"pauseBtn\" was not injected: check your FXML file 'View.fxml'.";
    }

    @FXML
    void next(ActionEvent event) {
    	Player.play();
    }

    @FXML
    void pause(ActionEvent event) {
    	Player.m.pause();
    }

    @FXML
    void play(ActionEvent event) {
    	try {Player.m.stop();}catch (Exception e) {}
    	Player.m.play();
    }

    @FXML
    void random(ActionEvent event) {
    	try {
    		Player.m.stop();
    	}catch (Exception e) {}
    	Random rnd = new Random();
    	Player.play(SongCookies.allSongs.get(rnd.nextInt(SongCookies.allSongs.size())));
    	Player.m.play();
    }
    
    public void rnd() {
		random(null);
	}
    
    public void updateList2() {
    	list.setItems(updateList());
    }
    
    public ObservableList<String> updateList() {
    	
    	ObservableList<String> ol = FXCollections.observableArrayList();
    	for (String s : Player.queue) {
    		ol.add(s);
    	}
		return ol;
	}
    
    public ListView<String> getListe() {
    	return list;
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
    		Player.play(list.get(0).getAbsolutePath());
    	}
    }
}
