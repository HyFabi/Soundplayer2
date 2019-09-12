package view;
	
import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Player;
import model.SongCookies;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static Stage s;
	public static SongCookies sc = new SongCookies();;
	public static Controller c = new Controller();
	public static Player p =  new Player();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			s = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			s.setTitle("HyFabi´s Musicplayer");
			s.setScene(scene);
			s.show();
			Player.queue();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
