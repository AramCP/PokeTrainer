package paquete;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.json.JSONException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * clase controladorCaptura2.
 */
public class controladorCaptura2 implements Initializable{
	
	@FXML private AnchorPane anchorPaneContent;
	
	@FXML private AnchorPane anchorPane2;
	
	@FXML private Label lbldinero;
	
	int dinero;
	
	/**
	 * Muestra el precio de entrada y tu dinero total.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void Precio() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.getDinero();
		dinero = conexion.dinero;
		lbldinero.setText(dinero+"$");
	}
	
	/**
	 * Te cobra el precio de entrada.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void Cobrar() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.precioPrado();
	}
	
	
	/**
	 * Pasa a la siguiente ventana de captura (El combate).
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQL exception
	 * @throws JSONException the JSON exception
	 * @throws URISyntaxException the URI syntax exception
	 */
	@FXML
	void captura3 (ActionEvent event) throws IOException, SQLException, JSONException, URISyntaxException {
		Cobrar();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("captura3.fxml"));
		Parent pane = loader.load();
		anchorPaneContent.getChildren().setAll(pane);
		controladorCaptura3 controller = loader.<controladorCaptura3>getController();
	    controller.randomPokemon();
	    controller.Pokemon();
	    controller.playMedia();
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}