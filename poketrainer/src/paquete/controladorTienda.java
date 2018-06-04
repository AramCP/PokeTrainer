package paquete;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

// TODO: Auto-generated Javadoc
/**
 * The Class controladorTienda.
 */
public class controladorTienda implements Initializable{
	
	/** The objeto. */
	items objeto = new items();
	
	/** The code. */
	int code;
	
	/** The anchor pane desc 2. */
	@FXML private AnchorPane anchorPaneDesc2;	
	
	/** The item img. */
	@FXML private ImageView itemImg;
	
	/** The item desc label 2. */
	@FXML private Label itemDescLabel2;	
	
	/** The buy btn. */
	@FXML private JFXButton buyBtn;		
	
	/** The anchor pane shop info. */
	@FXML private AnchorPane anchorPaneShopInfo;	
	
	/** The item info. */
	@FXML private Label itemInfo;	
	
	/** The lbldinero. */
	@FXML private Label lbldinero;	
	
	/** The dinero. */
	int dinero;
	
	/**
	 * Conexion.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void Conexion() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.getDinero();
		dinero = conexion.dinero;
	}
	
	/**
	 * Dinero.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void Dinero() throws SQLException {
		Conexion();
		lbldinero.setText("$"+dinero);
	}
	
	/**
	 * Pokeball.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void Pokeball() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.addItem1();
	}
	
	/**
	 * Superball.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void Superball() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.addItem2();
	}
	
	/**
	 * Ultraball.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void Ultraball() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.addItem3();
	}
	
	/**
	 * Llave.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void Llave() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.addItem4();
	}
	
	/**
	 * Item click pokeball 2.
	 *
	 * @param event the event
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void itemClickPokeball2(MouseEvent event) throws SQLException {	
		Dinero();
		code=1;
		itemDescLabel2.setText("Pokéball");
		buyBtn.setText("Comprar");
		itemDescLabel2.setStyle("-fx-background-color: #004f91; -fx-font-weight: bold;");
		anchorPaneDesc2.setStyle("-fx-background-color: #1570c1");
		anchorPaneShopInfo.setStyle("-fx-background-color: #1570c1");
		buyBtn.setStyle("-fx-background-color: #004f91");
		itemInfo.setText(objeto.Pokeball);
		itemImg.setImage(new Image ("images/pokeballIcon.png"));
	}
	
	/**
	 * Item click superball 2.
	 *
	 * @param event the event
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void itemClickSuperball2(MouseEvent event) throws SQLException {
		Dinero();
		code=2;
		itemInfo.setText(objeto.Superball);
		itemDescLabel2.setText("Superball");
		buyBtn.setText("Comprar");
		itemDescLabel2.setStyle("-fx-background-color: #004f91; -fx-font-weight: bold;");
		anchorPaneDesc2.setStyle("-fx-background-color: #1570c1");
		anchorPaneShopInfo.setStyle("-fx-background-color: #1570c1");
		buyBtn.setStyle("-fx-background-color: #004f91");
		itemImg.setImage(new Image ("images/superballIcon.png"));
	}
	
	/**
	 * Item click ultraball 2.
	 *
	 * @param event the event
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void itemClickUltraball2(MouseEvent event) throws SQLException {
		Dinero();
		code=3;
		itemInfo.setText(objeto.Ultraball);
		itemDescLabel2.setText("Ultraball");
		buyBtn.setText("Comprar");
		itemDescLabel2.setStyle("-fx-background-color: #004f91; -fx-font-weight: bold;");
		anchorPaneDesc2.setStyle("-fx-background-color: #1570c1");
		anchorPaneShopInfo.setStyle("-fx-background-color: #1570c1");
		buyBtn.setStyle("-fx-background-color: #004f91");
		itemImg.setImage(new Image ("images/ultraballIcon.png"));
	}
	
	/**
	 * Item click llave 2.
	 *
	 * @param event the event
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void itemClickLlave2(MouseEvent event) throws SQLException {
		Dinero();
		code=4;
		itemInfo.setText(objeto.Llave);
		itemDescLabel2.setText("Llave Maestra");
		buyBtn.setText("Comprar");
		itemDescLabel2.setStyle("-fx-background-color: #004f91; -fx-font-weight: bold;");
		anchorPaneDesc2.setStyle("-fx-background-color: #1570c1");
		anchorPaneShopInfo.setStyle("-fx-background-color: #1570c1");
		buyBtn.setStyle("-fx-background-color: #004f91");
		itemImg.setImage(new Image ("images/llaveIcon.png"));
	}
	
	/**
	 * Item click polvo.
	 *
	 * @param event the event
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void itemClickPolvo(MouseEvent event) throws SQLException {
		Dinero();
		itemInfo.setText(objeto.Polvo);
		itemDescLabel2.setText("Polvo Brillante");
		buyBtn.setText("Comprar");
		itemDescLabel2.setStyle("-fx-background-color: #004f91; -fx-font-weight: bold;");
		anchorPaneDesc2.setStyle("-fx-background-color: #1570c1");
		anchorPaneShopInfo.setStyle("-fx-background-color: #1570c1");
		buyBtn.setStyle("-fx-background-color: #004f91");
		itemImg.setImage(new Image ("images/polvoItem.png"));
	}
	
	/**
	 * Buy.
	 *
	 * @param event the event
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void buy(MouseEvent event) throws SQLException, IOException {
		if(code==1) {
			if(dinero>=200) {
				Pokeball();
			}else {
				lbldinero.setTextFill(Color.web("red"));
			}
		}
		if(code==2) {
			if(dinero>=350) {
				Superball();
			}else {
				lbldinero.setTextFill(Color.web("red"));
			}
		}
		if(code==3) {
			if(dinero>=500) {
				Ultraball();
			}else {
				lbldinero.setTextFill(Color.web("red"));
			}
		}
		if(code==4) {
			if(dinero>=1000) {
				Llave();
			}else {
				lbldinero.setTextFill(Color.web("red"));
			}
		}
		Dinero();
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
