package paquete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

// TODO: Auto-generated Javadoc
/**
 * La clase que controla la captura del pokémon.
 */
public class controladorCaptura3 implements Initializable{
	

	@FXML private AnchorPane anchorPaneContent;
	
	@FXML private AnchorPane anchorPane2;
	
	@FXML private Label combatText;
	
	@FXML private Label pkmnName;
	
	@FXML private Label pkmnlvl;
	
	@FXML private Label lblpokeball;
	
	@FXML private Label lblsuperball;
	
	@FXML private Label lblultraball;
	
	@FXML private Label lblmasterball;
	
	@FXML private ImageView pkmnImg;
	
	@FXML private ImageView pokeballImg;
	
	@FXML private JFXButton exitBtn;
	
	@FXML private JFXButton catchBtn;
	
	@FXML private JFXButton stoneBtn;
	
	@FXML private JFXButton sleepBtn;
	
	@FXML private JFXButton foodBtn;
	
	MediaPlayer player;
	
	String imageSource1;
	
	String name;
	
	Image image;
	
	int pokemon [] = new int [6];
	
	int wildpkmn;
	
	Random r = new Random();
	
	int Low = 1;
	
	int High = 6;
	
	Random lvl = new Random();
	
	int min = 5;
	
	int max = 20;
	
	int nivel;
	
	Random catchRate = new Random();
	
	int min2 = 1;
	
	int max2 = 100;
	
	int catchRate2;
	
	Timer timer = new Timer();
	
	int pokeballcount;
	
	int superballcount;
	
	int ultraballcount;
	
	int masterballcount;
	
	public static int pkmnId;
	
	public static int pkmnLvl;
	
	public static String pkmnname;
	
	int catchRateIncrease = 0;
	
	Boolean dormido = false;
	
	/**
	 * Piedra que se le tira al pokémon (No al maltrato animal).
	 */
	@FXML
	void piedra() {
		combatText.setText("¡Has lanzado una piedra! "+name+" se siente más débil...");
		Random escapeRate = new Random();
		int min = 1;
		int max = 100;
		int escapeRate2 = catchRate.nextInt(max-min) + min;
		timer.schedule(new TimerTask(){
	        public void run() {
	        	Platform.runLater(() -> {
	        		if(escapeRate2>=60) {
	        			combatText.setText(name+" ha salido corriendo!");
	        			exitBtn.setVisible(true);
		        		catchBtn.setVisible(false);
		        		foodBtn.setVisible(false);
		        		sleepBtn.setVisible(false);
		        		stoneBtn.setVisible(false);
		        		pkmnImg.setVisible(false);
	        			
	        		} else {
	        			combatText.setText(name+" te observa fijamente...");
	        			catchRateIncrease = catchRateIncrease + 10;
	        		}
	        	});
	        }
	    }, 1000*2);
	}
	
	/**
	 * Cebo que se le lanza al pokémon.
	 */
	@FXML
	void cebo() {
		combatText.setText("Le has dado de comer a "+name);
		Random escapeRate = new Random();
		int min = 1;
		int max = 100;
		int escapeRate2 = catchRate.nextInt(max-min) + min;
		timer.schedule(new TimerTask(){
	        public void run() {
	        	Platform.runLater(() -> {
	        		if(escapeRate2>=80) {
	        			combatText.setText(name+" ha salido corriendo con la comida!");
	        			exitBtn.setVisible(true);
		        		catchBtn.setVisible(false);
		        		foodBtn.setVisible(false);
		        		sleepBtn.setVisible(false);
		        		stoneBtn.setVisible(false);
		        		pkmnImg.setVisible(false);
	        			
	        		} else {
	        			combatText.setText(name+" está comiendo...");
	        			catchRateIncrease = catchRateIncrease + 10;
	        			timer.schedule(new TimerTask(){
	        		        public void run() {
	        		        	Platform.runLater(() -> {
	        		        		combatText.setText(name+" te observa fijamente...");
	        		        	});
	        		        }
	        		    }, 1000*2);
	        		}
	        	});
	        }
	    }, 1000*2);
	}	
	
	/**
	 * Somnifero que se le lanza al pokémon.
	 */
	@FXML
	void somnifero() {
		combatText.setText("Le has dado un somnífero a "+name);
		Random escapeRate = new Random();
		int min = 1;
		int max = 100;
		int escapeRate2 = catchRate.nextInt(max-min) + min;
		timer.schedule(new TimerTask(){
	        public void run() {
	        	Platform.runLater(() -> {
	        		combatText.setText(name+" se ha dormido!");
	        		if(dormido) {
	        			combatText.setText(name+" ya estaba dormido!");
	        		}
	        		catchRateIncrease = catchRateIncrease + 30;
	        		dormido = true;

	        	});
	        }
	    }, 1000*2);
	}
	
	/**
	 * Sonido de fondo de batalla.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 */
	void playMedia() throws URISyntaxException {
		Media media = new Media(getClass().getResource("/sounds/bgsong.mp3").toURI().toString());
	    player = new MediaPlayer(media); 
	    player.play();
    }
	
	/**
	 * Vuelve a la ventana anterior al darle a salir.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQL exception
	 * @throws JSONException the JSON exception
	 */
	@FXML
	void captura2 (ActionEvent event) throws IOException, SQLException, JSONException {
		player.stop();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("captura2.fxml"));
		Parent pane = loader.load();
		anchorPaneContent.getChildren().setAll(pane);
		controladorCaptura2 controller = loader.<controladorCaptura2>getController();
		controller.Precio();

	}
	
	/**
	 * Para seleccionar que pokeball usar.
	 */
	@FXML
	void selectPokeball() {
		combatText.setText("¿Qué pokeball quieres usar?");
		lblpokeball.setVisible(true);
		lblsuperball.setVisible(true);
		lblultraball.setVisible(true);
		lblmasterball.setVisible(true);
	}
	
	/**
	 * Pokeball.
	 *
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void Pokeball() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.bag();
		pokeballcount = conexion.pokeball;
		if(pokeballcount>=1) {
			pkmnImg.setVisible(false);
			pokeballImg.setImage(new Image ("images/pokeballIcon.png"));
			pokeballImg.setVisible(true);
			combatText.setText("¡Has usado una Pokeball!");
			
			timer.schedule(new TimerTask(){
		        public void run() {
		        	Platform.runLater(() -> {
		        		try {
							PokeballCatch();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	});
		        }
		    }, 1000*2);
			
			lblpokeball.setVisible(false);
			lblsuperball.setVisible(false);
			lblultraball.setVisible(false);
			lblmasterball.setVisible(false);
		}else {
			combatText.setText("No tienes suficientes Pokeball");
			lblpokeball.setVisible(false);
			lblsuperball.setVisible(false);
			lblultraball.setVisible(false);
			lblmasterball.setVisible(false);
		}	
	}
	
	/**
	 * Superball.
	 *
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void Superball() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.bag();
		superballcount = conexion.superball;
		if(superballcount>=1) {
			pkmnImg.setVisible(false);
			pokeballImg.setImage(new Image ("images/superballIcon.png"));
			pokeballImg.setVisible(true);
			combatText.setText("¡Has usado una Superball!");
			
			timer.schedule(new TimerTask(){
		        public void run() {
		        	Platform.runLater(() -> {
		        		try {
							SuperballCatch();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	});
		        }
		    }, 1000*2);
			
			lblpokeball.setVisible(false);
			lblsuperball.setVisible(false);
			lblultraball.setVisible(false);
			lblmasterball.setVisible(false);
		}else {
			combatText.setText("No tienes suficientes Superball");
			lblpokeball.setVisible(false);
			lblsuperball.setVisible(false);
			lblultraball.setVisible(false);
			lblmasterball.setVisible(false);
		}	
	}
	
	/**
	 * Ultraball.
	 *
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void Ultraball() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.bag();
		ultraballcount = conexion.ultraball;
		if(ultraballcount>=1) {
			pkmnImg.setVisible(false);
			pokeballImg.setImage(new Image ("images/ultraballIcon.png"));
			pokeballImg.setVisible(true);
			combatText.setText("¡Has usado una Ultraball!");
			
			timer.schedule(new TimerTask(){
		        public void run() {
		        	Platform.runLater(() -> {
		        		try {
							UltraballCatch();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	});
		        }
		    }, 1000*2);
			
			lblpokeball.setVisible(false);
			lblsuperball.setVisible(false);
			lblultraball.setVisible(false);
			lblmasterball.setVisible(false);
		}else {
			combatText.setText("No tienes suficientes Ultraball");
			lblpokeball.setVisible(false);
			lblsuperball.setVisible(false);
			lblultraball.setVisible(false);
			lblmasterball.setVisible(false);
		}	
	}
	
	/**
	 * Masterball.
	 *
	 * @throws SQLException the SQL exception
	 */
	@FXML
	void Masterball() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.bag();
		masterballcount = conexion.masterball;
		if(masterballcount>=1) {
			pkmnImg.setVisible(false);
			pokeballImg.setImage(new Image ("images/masterballIcon.png"));
			pokeballImg.setVisible(true);
			combatText.setText("¡Has usado una Masterball!");
			
			timer.schedule(new TimerTask(){
		        public void run() {
		        	Platform.runLater(() -> {
		        		try {
							MasterballCatch();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	});
		        }
		    }, 1000*2);
			
			lblpokeball.setVisible(false);
			lblsuperball.setVisible(false);
			lblultraball.setVisible(false);
			lblmasterball.setVisible(false);
		}else {
			combatText.setText("No tienes suficientes Masterball");
			lblpokeball.setVisible(false);
			lblsuperball.setVisible(false);
			lblultraball.setVisible(false);
			lblmasterball.setVisible(false);
		}	
	}
	
	/**
	 * Pokeball catch.
	 *
	 * @throws SQLException the SQL exception
	 */
	void PokeballCatch() throws SQLException {
		catchRate2 = catchRate.nextInt(max2-min2) + min2;
		dbQuerys conexion = new dbQuerys();
		conexion.pokeballCatch();
		if(catchRate2>=1 && catchRate2<=40+catchRateIncrease) {
			combatText.setText("¡"+name+" ha sido capturado con éxito!");
			conexion.savePkmn();
			conexion.pkmnCapturado();
			timer.schedule(new TimerTask(){
		        public void run() {
		        	Platform.runLater(() -> {
		        		exitBtn.setVisible(true);
		        		catchBtn.setVisible(false);
		        		foodBtn.setVisible(false);
		        		sleepBtn.setVisible(false);
		        		stoneBtn.setVisible(false);
		        	});
		        }
		    }, 1000*2);
			
		}else {
			pkmnImg.setVisible(true);
			pokeballImg.setVisible(false);
			combatText.setText("¡"+name+" se ha escapado de la Pokeball!");
		}
	}
	
	/**
	 * Superball catch.
	 *
	 * @throws SQLException the SQL exception
	 */
	void SuperballCatch() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.superballCatch();
		catchRate2 = catchRate.nextInt(max2-min2) + min2;
		if(catchRate2>=1 && catchRate2<=60) {
			combatText.setText("¡"+name+" ha sido capturado con éxito!");
			conexion.savePkmn();
			conexion.pkmnCapturado();
			timer.schedule(new TimerTask(){
		        public void run() {
		        	Platform.runLater(() -> {
		        		exitBtn.setVisible(true);
		        		catchBtn.setVisible(false);
		        		foodBtn.setVisible(false);
		        		sleepBtn.setVisible(false);
		        		stoneBtn.setVisible(false);
		        	});
		        }
		    }, 1000*2);
			
		}else {
			pkmnImg.setVisible(true);
			pokeballImg.setVisible(false);
			combatText.setText("¡"+name+" se ha escapado de la Superball!");
		}
	}
	
	/**
	 * Ultraball catch.
	 *
	 * @throws SQLException the SQL exception
	 */
	void UltraballCatch() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.ultraballCatch();
		catchRate2 = catchRate.nextInt(max2-min2) + min2;
		if(catchRate2>=1 && catchRate2<=75) {
			combatText.setText("¡"+name+" ha sido capturado con éxito!");
			conexion.savePkmn();
			conexion.pkmnCapturado();
			timer.schedule(new TimerTask(){
		        public void run() {
		        	Platform.runLater(() -> {
		        		exitBtn.setVisible(true);
		        		catchBtn.setVisible(false);
		        		foodBtn.setVisible(false);
		        		sleepBtn.setVisible(false);
		        		stoneBtn.setVisible(false);
		        	});
		        }
		    }, 1000*2);
			
		}else {
			pkmnImg.setVisible(true);
			pokeballImg.setVisible(false);
			combatText.setText("¡"+name+" se ha escapado de la Ultraball!");
		}
	}
	
	/**
	 * Masterball catch.
	 *
	 * @throws SQLException the SQL exception
	 */
	void MasterballCatch() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.masterballCatch();
		catchRate2 = catchRate.nextInt(max2-min2) + min2;
		if(catchRate2>=1 && catchRate2<=100) {
			combatText.setText("¡"+name+" ha sido capturado con éxito!");
			conexion.savePkmn();
			conexion.pkmnCapturado();
			timer.schedule(new TimerTask(){
		        public void run() {
		        	Platform.runLater(() -> {
		        		exitBtn.setVisible(true);
		        		catchBtn.setVisible(false);
		        		foodBtn.setVisible(false);
		        		sleepBtn.setVisible(false);
		        		stoneBtn.setVisible(false);
		        	});
		        }
		    }, 1000*2);
			
		}else {
			pkmnImg.setVisible(true);
			pokeballImg.setVisible(false);
			combatText.setText("¡"+name+" se ha escapado de la Masterball!");
		}
	}
	
	
	/**
	 * Pokemon.
	 */
	void Pokemon() {
		pokemon [0] = 1;
		pokemon [1] = 25;
		pokemon [2] = 16;
		pokemon [3] = 19;
		pokemon [4] = 23;
		pokemon [5] = 29;
		
		int result = r.nextInt(High-Low) + Low;
		nivel = lvl.nextInt(max-min) + min;
		if(result == 1) {
			wildpkmn = pokemon [0];
		}
		if(result == 2) {
			wildpkmn = pokemon [1];
		}
		if(result == 3) {
			wildpkmn = pokemon [2];
		}
		if(result == 4) {
			wildpkmn = pokemon [3];
		}
		if(result == 5) {
			wildpkmn = pokemon [4];
		}
		if(result == 5) {
			wildpkmn = pokemon [5];
		}
		
		pkmnId = wildpkmn;
		pkmnLvl = nivel;
	}
	
	/**
	 * Random pokemon.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the JSON exception
	 * @throws SQLException the SQL exception
	 */
	void randomPokemon() throws IOException, JSONException, SQLException {
		
		Pokemon();
		dbQuerys conexion = new dbQuerys();
		conexion.pkmnVisto();
		URL url = new URL("https://pokeapi.co/api/v2/pokemon/"+wildpkmn+"/");
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		urlConn.addRequestProperty("User-Agent", "Mozilla/4.76");
		
		InputStreamReader isr = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		
		String txt  = br.readLine();
		
		JSONObject obj = new JSONObject(txt);
		JSONArray forms = obj.getJSONArray("forms");
		JSONObject formObj = forms.getJSONObject(0);
		name = formObj.getString("name");
		
		pkmnname = name;
		
		imageSource1 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+wildpkmn+".png?raw=true";
		image = new Image(imageSource1);
		pkmnImg.setImage(image);
		combatText.setText("¡Un "+name+" salvaje ha aparecido!");
		pkmnName.setText(name);
		pkmnlvl.setText("lvl"+nivel);
		
		pokeballImg.setVisible(false);
		lblpokeball.setVisible(false);
		lblsuperball.setVisible(false);
		lblultraball.setVisible(false);
		lblmasterball.setVisible(false);
		exitBtn.setVisible(false);
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}





