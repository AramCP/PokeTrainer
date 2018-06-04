package paquete;

import java.awt.Desktop;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.json.JSONException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * El controlador principal del programa.
 */
public class controladorPrincipal implements Initializable {
	

	@FXML private AnchorPane anchorPaneContent;	//Donde va a ir cambiando el contenido de las ventanas.
	
	@FXML private AnchorPane anchorPane2; //Este panel está presente en todas las ventanas, es como el panel de fondo, y encima de el está el anchorPaneContent.	
	
	int dinero;
	
	int dineroUsado;
	
	int dineroGanado;
	
	int pkmnVistos;
	
	int pkmnCapturados;
	
	String nombre;
	
	@FXML private Label Nombre;
	
	@FXML private Label Dinero;
	
	@FXML private Label DineroUsado;
	
	@FXML private Label DineroGanado;
	
	@FXML private Label PkmnVistos;
	
	@FXML private Label PkmnCapturados;
	
	/**
	 * Ventana principal que muestra las estad�sticas del usuario.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void mainScreen() throws IOException, SQLException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("stats.fxml"));
		Parent pane = loader.load();
		anchorPaneContent.getChildren().setAll(pane);
		anchorPane2.setStyle("-fx-background-color: #3f3f3f;");
		controladorStats controller = loader.<controladorStats>getController();
		controller.getStats();
		controller.topPlayers();
	}
	
	/**
	 * Muestra el nick.
	 *
	 * @return the nombre
	 */
	void getNombre() {
		nombre = controladorLogin.usuario;
		Nombre.setText(nombre);
	}
	
	/**
	 * Pasa a la ventana de captura.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void captura (ActionEvent event) throws IOException {
		AnchorPane pane2 = FXMLLoader.load(getClass().getResource("captura.fxml"));
		anchorPaneContent.getChildren().setAll(pane2);
		anchorPane2.setStyle("-fx-background-color: #3f3f3f;");
	}
	
	/**
	 * Pasa a la ventana de mochila.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void mochila (ActionEvent event) throws IOException, SQLException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mochila.fxml"));
		Parent pane = loader.load();
		anchorPaneContent.getChildren().setAll(pane);
		anchorPane2.setStyle("-fx-background-color: #3f3f3f;");
		controladorMochila controller = loader.<controladorMochila>getController();
	    controller.getCantidad();
	}
	
	/**
	 * Pasa a la ventana de tienda.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void tienda (ActionEvent event) throws IOException {
		AnchorPane pane2 = FXMLLoader.load(getClass().getResource("tienda.fxml"));
		anchorPaneContent.getChildren().setAll(pane2);
		anchorPane2.setStyle("-fx-background-color: #42a6ff;");
	}
	
	/**
	 * Pasa a la ventana de pokedex.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQL exception
	 * @throws JSONException the JSON exception
	 */
	@FXML
	void pokedex (ActionEvent event) throws IOException, SQLException, JSONException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("pokedex.fxml"));
		Parent pane = loader.load();
		anchorPaneContent.getChildren().setAll(pane);
		anchorPane2.setStyle("-fx-background-color: #3f3f3f;");
		controladorPokedex controller = loader.<controladorPokedex>getController();
	    controller.setImages();
	    controller.apiConect();
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}

