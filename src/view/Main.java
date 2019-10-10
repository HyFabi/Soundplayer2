package view;
	
import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Player;
import model.songthings.AllSongs;
import model.songthings.Playlist;
import model.songthings.SongCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static Stage s;
	public static Controller c;
	public static Player p;
	public static AllSongs as;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			as = new AllSongs();
			s = new Stage();
			c = new Controller();
			p =  new Player();
			Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			s.setTitle("HyFabi´s Musicplayer");
			s.setScene(scene);
			s.show();
			p.queue();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
