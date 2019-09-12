package view;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.PlaySong;
import model.SongCookies;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static PlaySong p =  new PlaySong();
	public static Stage s;
	public static SongCookies sc;
	
	@Override
	public void start(Stage primaryStage) {
		sc = new SongCookies();
		try {
			s = new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("View.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			s.setTitle("Fabian´s Musikspieler");
			s.setScene(scene);
			s.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
