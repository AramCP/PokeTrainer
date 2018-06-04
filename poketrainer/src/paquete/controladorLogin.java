package paquete;

import java.awt.Desktop;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * La clase que se encarga de controlar la interfaz y la funcionalidad de la pantalla de Inicio de sesión.
 */
public class controladorLogin implements Initializable {

	/** Panel que sirve para minimizar, cerrar y mover el programa por la pantalla. */
	@FXML private AnchorPane anchorPane; 
	
	/** Panel principal del programa. */
	@FXML private AnchorPane anchorPaneMain; 
	
	@FXML private AnchorPane box;
	
	@FXML private JFXTextField campoUsuario;
	
	@FXML private JFXPasswordField campoPass;
	
	@FXML private Label dataError;
	
	@FXML private MediaView mv;
	
	@FXML private ImageView sound;

	
	private Stage stage;
	
	Boolean mute = false;
	
	private double x;
	
	private double y;
	
	public static String usuario;
	
	public static String contrasena;
	
	public static String md5pass;
	
	MediaPlayer player;
	
	MediaPlayer videoPlayer;
	
	/**
	 * Para silenciar el sonido.
	 */
	@FXML
	public void changeSound() {
		if(mute==false) {
			mute = true;
			sound.setImage(new Image ("images/mute.png"));
			player.setMute(true);
		}else {
			mute = false;
			sound.setImage(new Image ("images/unmute.png"));
			player.setMute(false);
		}
	}
	
	/**
	 * Encripta la contraseña en md5.
	 *
	 * @param input the input
	 * @return the md5
	 */
	public static String getMD5(String input) {
		 try {
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 byte[] messageDigest = md.digest(input.getBytes());
			 BigInteger number = new BigInteger(1, messageDigest);
			 String hashtext = number.toString(16);
		 while (hashtext.length() < 32) {
			 hashtext = "0" + hashtext;
		 }
		 	return hashtext;
		 }
		 catch (NoSuchAlgorithmException e) {
			 throw new RuntimeException(e);
		 }
	}
	
	/**
	 * Reproduce el sonido.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 */
	void playMedia() throws URISyntaxException {
		Media media = new Media(getClass().getResource("/sounds/music.mp3").toURI().toString());
	    player = new MediaPlayer(media); 
	    player.play();
    }
	
	/**
	 * Reproduce el vídeo de fondo.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 */
	void backgroundVideo() throws URISyntaxException {
		Media media = new Media(getClass().getResource("/sounds/video.mp4").toURI().toString());
		videoPlayer = new MediaPlayer(media);
		videoPlayer.play();
		mv.setMediaPlayer(videoPlayer);
	}
	
	/**
	 * Obtiene el usuario.
	 *
	 * @return the username
	 */
	public String getUsername() {
		usuario = campoUsuario.getText();
		return usuario;
	}
	
	/**
	 * Obtiene la contraseña.
	 *
	 * @return the pass
	 */
	public String getPass() {
		contrasena = campoPass.getText();
		md5pass = getMD5(contrasena);
		return md5pass;
	}
	
	/**
	 * Conexion.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void Conexion() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		getUsername();
		getPass();
		conexion.Login();
	}
	
	/**
	 * Función para arrastrar la ventana.
	 *
	 * @param event the event
	 */
	@FXML
	void drag(MouseEvent event) {
		stage.setX(event.getScreenX() - x);
		stage.setY(event.getScreenY() - y);
	}
	
	/**
	 * Pressed.
	 *
	 * @param event the event
	 */
	@FXML
	void pressed(MouseEvent event) {
		stage = (Stage) anchorPane.getScene().getWindow();
		
		x = event.getSceneX();
		y = event.getSceneY();
	}
	
	/**
	 * Cierra el programa.
	 *
	 * @param event the event
	 */
	@FXML
    void handleButtonAction(MouseEvent event) {
      System.exit(0);
    }
	
	/**
	 * Minimiza la ventana del programa.
	 *
	 * @param event the event
	 */
	//Minimiza la ventana
	@FXML
    void minimize(MouseEvent event) {
      stage.setIconified(true);
    }
	
	/**
	 * Cambia a la ventana siguiente en caso de inicio de sesión satisfactorio.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void loadSecond(ActionEvent event) throws IOException, SQLException {
		Conexion();
		dbQuerys conexion = new dbQuerys();
		if(conexion.Login()) {
			player.stop();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
			Parent pane = loader.load();
			box.getChildren().setAll(pane);
			controladorPrincipal controller = loader.<controladorPrincipal>getController();
			controller.getNombre();
			controller.mainScreen();
		}else {
			dataError.setText("Usuario o contraseña incorrectos");
		}
	}
	

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
