package paquete;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * Controlador de la clase captura.
 */
public class controladorCaptura implements Initializable{
	
	@FXML private AnchorPane anchorPaneContent;	

	@FXML private AnchorPane anchorPane2;
	
	/**
	 * Pasa a la siguiente ventana de captura.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void captura2 (MouseEvent event) throws IOException, SQLException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("captura2.fxml"));
		Parent pane = loader.load();
		anchorPaneContent.getChildren().setAll(pane);
		controladorCaptura2 controller = loader.<controladorCaptura2>getController();
	    controller.Precio();
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
