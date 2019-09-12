package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.PlaySong;
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
    private Label playingNow;

    @FXML
    private TextField input;
    
    @FXML
    private Button playBtn;

    @FXML
    private Button pauseBtn;

    @FXML
    void initialize() {
        assert volume != null : "fx:id=\"volume\" was not injected: check your FXML file 'View.fxml'.";
        assert playingNow != null : "fx:id=\"playingNow\" was not injected: check your FXML file 'View.fxml'.";
        assert playBtn != null : "fx:id=\"playBtn\" was not injected: check your FXML file 'View.fxml'.";
        assert pauseBtn == null : "fx:id=\"pauseBtn\" was not injected: check your FXML file 'View.fxml'.";
    }

    @FXML
    void next(ActionEvent event) {

    }

    @FXML
    void pause(ActionEvent event) {
    	PlaySong.m.pause();
    }

    @FXML
    void play(ActionEvent event) {
    	PlaySong.m.stop();
    	PlaySong.m.play();
    }

    @FXML
    void resume(ActionEvent event) {
    	PlaySong.m.play();
    }

    @FXML
    void setVolume(MouseEvent event) {
    	PlaySong.m.setVolume(volume.getValue()/100);
    }

    @FXML
    void stop(ActionEvent event) {
    	PlaySong.m.stop();
    }
    
    @FXML
    void select(ActionEvent event) {
    	FileChooser f = new FileChooser();
    	f.setTitle("Open Sound File");
    	f.getExtensionFilters().add(new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
    	File file = f.showOpenDialog(Main.s);
    	if (file != null) {
    		PlaySong.play(file.getAbsolutePath());
    	}
    }
}
