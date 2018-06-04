package paquete;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * The Class controladorMochila.
 */
public class controladorMochila implements Initializable {
	
	/** The objeto. */
	items objeto = new items();
	
	 /** The pokeballcount. */
 	int pokeballcount;
	 
 	/** The superballcount. */
 	int superballcount;
	 
 	/** The ultraballcount. */
 	int ultraballcount;
	 
 	/** The masterballcount. */
 	int masterballcount;
	 
 	/** The somniferocount. */
 	int somniferocount;
	 
 	/** The cebocount. */
 	int cebocount;
	 
 	/** The keycount. */
 	int keycount;
	
	/** The item info. */
	@FXML private Label itemInfo;	
	
	/** The anchor pane desc. */
	@FXML private AnchorPane anchorPaneDesc;
	
	/** The item img. */
	@FXML private ImageView itemImg;
	
	/** The item desc label. */
	@FXML private Label itemDescLabel;	
	
	/** The lblpokeball count. */
	@FXML private Label lblpokeballCount;
	
	/** The lblsuperball count. */
	@FXML private Label lblsuperballCount;
	
	/** The lblultraball count. */
	@FXML private Label lblultraballCount;
	
	/** The lblmasterball count. */
	@FXML private Label lblmasterballCount;
	
	/** The lblsomniferocount. */
	@FXML private Label lblsomniferocount;
	
	/** The lblcebocount. */
	@FXML private Label lblcebocount;
	
	/** The lblkeycount. */
	@FXML private Label lblkeycount;
	
	/**
	 * Conexion.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void Conexion() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.bag();
		pokeballcount = conexion.pokeball;
		superballcount = conexion.superball;
		ultraballcount = conexion.ultraball;
		masterballcount = conexion.masterball;
		somniferocount = conexion.somnifero;
		cebocount = conexion.cebo;
		keycount = conexion.key;
	}
	
	/**
	 * Gets the cantidad.
	 *
	 * @return the cantidad
	 * @throws SQLException the SQL exception
	 */
	public void getCantidad() throws SQLException {
		Conexion();
		lblpokeballCount.setText("Cantidad: "+pokeballcount);
		lblsuperballCount.setText("Cantidad: "+superballcount);
		lblultraballCount.setText("Cantidad: "+ultraballcount);
		lblmasterballCount.setText("Cantidad: "+masterballcount);
		lblsomniferocount.setText("Cantidad: "+somniferocount);
		lblcebocount.setText("Cantidad: "+cebocount);
		lblkeycount.setText("Cantidad: "+keycount);
	}
	
	/**
	 * Item click pokeball.
	 *
	 * @param event the event
	 */
	@FXML
	void itemClickPokeball(MouseEvent event){	
		itemDescLabel.setText("Pokeball");
		itemDescLabel.setStyle("-fx-background-color: red; -fx-font-weight: bold;");
		anchorPaneDesc.setStyle("-fx-background-color: #191919;");
		itemInfo.setText(objeto.Pokeball);
		itemImg.setImage(new Image ("images/pokeballIcon.png"));
	}
	
	/**
	 * Item click superball.
	 *
	 * @param event the event
	 */
	@FXML
	void itemClickSuperball(MouseEvent event) {
		itemInfo.setText(objeto.Superball);
		itemDescLabel.setText("Superball");
		itemDescLabel.setStyle("-fx-background-color: #1a5ead; -fx-font-weight: bold;");
		anchorPaneDesc.setStyle("-fx-background-color: #191919;");
		itemImg.setImage(new Image ("images/superballIcon.png"));
	}
	
	/**
	 * Item click ultraball.
	 *
	 * @param event the event
	 */
	@FXML
	void itemClickUltraball(MouseEvent event) {
		itemInfo.setText(objeto.Ultraball);
		itemDescLabel.setText("Ultraball");
		itemDescLabel.setStyle("-fx-background-color: orange; -fx-font-weight: bold;");
		anchorPaneDesc.setStyle("-fx-background-color: #191919;");
		itemImg.setImage(new Image ("images/ultraballIcon.png"));
	}
	
	/**
	 * Item click poke cebo.
	 *
	 * @param event the event
	 */
	@FXML
	void itemClickPokeCebo(MouseEvent event) {
		itemInfo.setText(objeto.Pokecebo);
		itemDescLabel.setText("Pokecebo");
		itemDescLabel.setStyle("-fx-background-color: brown; -fx-font-weight: bold;");
		anchorPaneDesc.setStyle("-fx-background-color: #191919;");
		itemImg.setImage(new Image ("images/ceboIcon.png"));
	}
	
	/**
	 * Item click somnifero.
	 *
	 * @param event the event
	 */
	@FXML
	void itemClickSomnifero(MouseEvent event) {
		itemInfo.setText(objeto.Somnifero);
		itemDescLabel.setText("Somnifero");
		itemDescLabel.setStyle("-fx-background-color: green; -fx-font-weight: bold;");
		anchorPaneDesc.setStyle("-fx-background-color: #191919;");
		itemImg.setImage(new Image ("images/somniferoIcon.png"));
	}
	
	/**
	 * Item click masterball.
	 *
	 * @param event the event
	 */
	@FXML
	void itemClickMasterball(MouseEvent event) {
		itemInfo.setText(objeto.Masterball);
		itemDescLabel.setText("Masterball");
		itemDescLabel.setStyle("-fx-background-color: purple; -fx-font-weight: bold;");
		anchorPaneDesc.setStyle("-fx-background-color: #191919;");
		itemImg.setImage(new Image ("images/masterballIcon.png"));
	}
	
	/**
	 * Item click llave.
	 *
	 * @param event the event
	 */
	@FXML
	void itemClickLlave(MouseEvent event) {
		itemInfo.setText(objeto.Llave);
		itemDescLabel.setText("Llave Maestra");
		itemDescLabel.setStyle("-fx-background-color: #fffa00; -fx-font-weight: bold; -fx-text-fill: black;");
		anchorPaneDesc.setStyle("-fx-background-color: #191919;");
		itemImg.setImage(new Image ("images/llaveIcon.png"));
	}
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
	}

}
