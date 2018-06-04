package paquete;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

// TODO: Auto-generated Javadoc
/**
 * La clase principal desde la que enciende todo el programa.
 */
public class interfaz extends Application{
	
	Label drag;

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		Parent pane = loader.load();
		controladorLogin controller = loader.<controladorLogin>getController();
		controller.playMedia();
		controller.backgroundVideo();
		Scene scene = new Scene(pane);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.show();	
		stage.setResizable(false);
		stage.setTitle("PokeTrainer");
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/appIcon.png")));
	}
	
	/**
	 * Método Main.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
