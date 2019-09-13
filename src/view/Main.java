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
	public static SongCookies sc;
	public static Controller c;
	public static Player p;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			s = new Stage();
			sc = new SongCookies();
			c = new Controller();
			p =  new Player();
			Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			s.setTitle("HyFabi´s Musicplayer");
			s.setScene(scene);
			s.show();
			p.queue();
			sc.check();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
