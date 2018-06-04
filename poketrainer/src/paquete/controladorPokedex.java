package paquete;


import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Group;
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
 * The Class controladorPokedex.
 */
public class controladorPokedex {	
	
	/** The page. */
	@FXML Label page;
	
	/** The type 1. */
	@FXML Label type1;
	
	/** The pkmn img 1. */
	@FXML private ImageView pkmnImg1;
	
	/** The pkmn img 2. */
	@FXML private ImageView pkmnImg2;
	
	/** The pkmn img 3. */
	@FXML private ImageView pkmnImg3;
	
	/** The pkmn img 4. */
	@FXML private ImageView pkmnImg4;
	
	/** The pkmn img 5. */
	@FXML private ImageView pkmnImg5;
	
	/** The pkmn img 6. */
	@FXML private ImageView pkmnImg6;
	
	/** The big img. */
	@FXML private ImageView bigImg;
	
	/** The pkmn name 1. */
	@FXML private Label pkmnName1;
	
	/** The pkmn name 2. */
	@FXML private Label pkmnName2;
	
	/** The pkmn name 3. */
	@FXML private Label pkmnName3;
	
	/** The pkmn name 4. */
	@FXML private Label pkmnName4;
	
	/** The pkmn name 5. */
	@FXML private Label pkmnName5;
	
	/** The pkmn name 6. */
	@FXML private Label pkmnName6;
	
	/** The big name. */
	@FXML private Label bigName;
	
	
	/** The image source 1. */
	String imageSource1;
	
	/** The image source 2. */
	String imageSource2;
	
	/** The image source 3. */
	String imageSource3;
	
	/** The image source 4. */
	String imageSource4;
	
	/** The image source 5. */
	String imageSource5;
	
	/** The image source 6. */
	String imageSource6;
	
	/** The image 1. */
	Image image1;
	
	/** The image 2. */
	Image image2;
	
	/** The image 3. */
	Image image3;
	
	/** The image 4. */
	Image image4;
	
	/** The image 5. */
	Image image5;
	
	/** The image 6. */
	Image image6;
	
	/** The page counter. */
	int pageCounter = 0;
	
	/** The pkmn 1. */
	int pkmn1 = 1;
	
	/** The pkmn 2. */
	int pkmn2 = 2;
	
	/** The pkmn 3. */
	int pkmn3 = 3;
	
	/** The pkmn 4. */
	int pkmn4 = 4;
	
	/** The pkmn 5. */
	int pkmn5 = 5;
	
	/** The pkmn 6. */
	int pkmn6 = 6;
	
	/** The typestr 1 1. */
	String typestr1_1 = "";
	
	/** The typestr 1 2. */
	String typestr1_2 = "";
	
	/** The typestr 1 3. */
	String typestr1_3 = "";
	
	/** The typestr 1 4. */
	String typestr1_4 = "";
	
	/** The typestr 1 5. */
	String typestr1_5 = "";
	
	/** The typestr 1 6. */
	String typestr1_6 = "";
	
	/**
	 * Api conect.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the JSON exception
	 */
	void apiConect() throws IOException, JSONException {
		
		URL url1 = new URL("https://pokeapi.co/api/v2/pokemon/1/");
		HttpURLConnection urlConn1 = (HttpURLConnection) url1.openConnection();
		urlConn1.addRequestProperty("User-Agent", "Mozilla/4.76");
		URL url2 = new URL("https://pokeapi.co/api/v2/pokemon/2/");
		HttpURLConnection urlConn2 = (HttpURLConnection) url2.openConnection();
		urlConn2.addRequestProperty("User-Agent", "Mozilla/4.76");
		URL url3 = new URL("https://pokeapi.co/api/v2/pokemon/3/");
		HttpURLConnection urlConn3 = (HttpURLConnection) url3.openConnection();
		urlConn3.addRequestProperty("User-Agent", "Mozilla/4.76");
		URL url4 = new URL("https://pokeapi.co/api/v2/pokemon/4/");
		HttpURLConnection urlConn4 = (HttpURLConnection) url4.openConnection();
		urlConn4.addRequestProperty("User-Agent", "Mozilla/4.76");
		URL url5 = new URL("https://pokeapi.co/api/v2/pokemon/5/");
		HttpURLConnection urlConn5 = (HttpURLConnection) url5.openConnection();
		urlConn5.addRequestProperty("User-Agent", "Mozilla/4.76");
		URL url6 = new URL("https://pokeapi.co/api/v2/pokemon/6/");
		HttpURLConnection urlConn6 = (HttpURLConnection) url6.openConnection();
		urlConn6.addRequestProperty("User-Agent", "Mozilla/4.76");

		InputStreamReader isr1 = new InputStreamReader(urlConn1.getInputStream());
		BufferedReader br1 = new BufferedReader(isr1);
		InputStreamReader isr2 = new InputStreamReader(urlConn2.getInputStream());
		BufferedReader br2 = new BufferedReader(isr2);
		InputStreamReader isr3 = new InputStreamReader(urlConn3.getInputStream());
		BufferedReader br3 = new BufferedReader(isr3);
		InputStreamReader isr4 = new InputStreamReader(urlConn4.getInputStream());
		BufferedReader br4 = new BufferedReader(isr4);
		InputStreamReader isr5 = new InputStreamReader(urlConn5.getInputStream());
		BufferedReader br5 = new BufferedReader(isr5);
		InputStreamReader isr6 = new InputStreamReader(urlConn6.getInputStream());
		BufferedReader br6 = new BufferedReader(isr6);

		String txt  = br1.readLine();
		String txt1 = br2.readLine();
		String txt2 = br3.readLine();
		String txt3 = br4.readLine();
		String txt4 = br5.readLine();
		String txt5 = br6.readLine();
			
		JSONObject obj = new JSONObject(txt);
		JSONArray forms = obj.getJSONArray("forms");
		JSONObject formObj = forms.getJSONObject(0);
		String name = formObj.getString("name");
		
		JSONArray types = obj.getJSONArray("types");
		JSONObject typeObj1 = types.getJSONObject(0);
		JSONObject type1 = typeObj1.getJSONObject("type");
		typestr1_1 = type1.getString("name");

		
		JSONObject obj1 = new JSONObject(txt1);
		JSONArray forms1 = obj1.getJSONArray("forms");
		JSONObject formObj1 = forms1.getJSONObject(0);
		String name1 = formObj1.getString("name");
		
		JSONArray types2 = obj1.getJSONArray("types");
		JSONObject typeObj1_2 = types2.getJSONObject(0);
		JSONObject type1_2 = typeObj1_2.getJSONObject("type");
		typestr1_2 = type1_2.getString("name");

		JSONObject obj2 = new JSONObject(txt2);
		JSONArray forms2 = obj2.getJSONArray("forms");
		JSONObject formObj2 = forms2.getJSONObject(0);
		String name2 = formObj2.getString("name");
		
		JSONArray types3 = obj2.getJSONArray("types");
		JSONObject typeObj1_3 = types3.getJSONObject(0);
		JSONObject type1_3 = typeObj1_3.getJSONObject("type");
		typestr1_3 = type1_3.getString("name");
		
		JSONObject obj3 = new JSONObject(txt3);
		JSONArray forms3 = obj3.getJSONArray("forms");
		JSONObject formObj3 = forms3.getJSONObject(0);
		String name3 = formObj3.getString("name");
		
		JSONArray types4 = obj3.getJSONArray("types");
		JSONObject typeObj1_4 = types4.getJSONObject(0);
		JSONObject type1_4 = typeObj1_4.getJSONObject("type");
		typestr1_4 = type1_4.getString("name");
		
		JSONObject obj4 = new JSONObject(txt4);
		JSONArray forms4 = obj4.getJSONArray("forms");
		JSONObject formObj4 = forms4.getJSONObject(0);
		String name4 = formObj4.getString("name");
		
		JSONArray types5 = obj4.getJSONArray("types");
		JSONObject typeObj1_5 = types5.getJSONObject(0);
		JSONObject type1_5 = typeObj1_5.getJSONObject("type");
		typestr1_5 = type1_5.getString("name");
		
		JSONObject obj5 = new JSONObject(txt5);
		JSONArray forms5 = obj5.getJSONArray("forms");
		JSONObject formObj5 = forms5.getJSONObject(0);
		String name5 = formObj5.getString("name");
		
		JSONArray types6 = obj5.getJSONArray("types");
		JSONObject typeObj1_6 = types6.getJSONObject(0);
		JSONObject type1_6 = typeObj1_6.getJSONObject("type");
		typestr1_6 = type1_6.getString("name");

		br1.close();
		isr1.close();
		br2.close();
		isr2.close();
		br3.close();
		isr3.close();
		br4.close();
		isr4.close();
		br5.close();
		isr5.close();
		br6.close();
		isr6.close();
		
		pkmnName1.setText(name);
		pkmnName2.setText(name1);
		pkmnName3.setText(name2);
		pkmnName4.setText(name3);
		pkmnName5.setText(name4);
		pkmnName6.setText(name5);
		
	}
	
	/**
	 * Sets the images.
	 */
	void setImages() {	
		imageSource1 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+pkmn1+".png?raw=true";
		imageSource2 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+pkmn2+".png?raw=true";
		imageSource3 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+pkmn3+".png?raw=true";
		imageSource4 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+pkmn4+".png?raw=true";
		imageSource5 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+pkmn5+".png?raw=true";
		imageSource6 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+pkmn6+".png?raw=true";
		
		image1 = new Image(imageSource1);
		image2 = new Image(imageSource2);
		image3 = new Image(imageSource3);
		image4 = new Image(imageSource4);
		image5 = new Image(imageSource5);
		image6 = new Image(imageSource6);
		
		pkmnImg1.setImage(image1);
		pkmnImg2.setImage(image2);
		pkmnImg3.setImage(image3);
		pkmnImg4.setImage(image4);
		pkmnImg5.setImage(image5);
		pkmnImg6.setImage(image6);
		
	}
	
	/**
	 * Sets the big img 1.
	 *
	 * @param event the new big img 1
	 */
	@FXML
	void setBigImg1(MouseEvent event) {
		bigImg.setImage(image1);
		String name = pkmnName1.getText();
		bigName.setText(name);
		if(typestr1_1.equals("poison")) {
			type1.setText("Veneno");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_1.equals("grass")) {
			type1.setText("Planta");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_1.equals("fire")) {
			type1.setText("Fuego");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_1.equals("water")) {
			type1.setText("Agua");
			type1.setStyle("-fx-background-color: blue;");
		}
		if(typestr1_1.equals("bug")) {
			type1.setText("Bicho");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_1.equals("electric")) {
			type1.setText("Electrico");
			type1.setStyle("-fx-background-color: yellow;");
		}
		if(typestr1_1.equals("normal")) {
			type1.setText("Normal");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_1.equals("rock")) {
			type1.setText("Roca");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_1.equals("dark")) {
			type1.setText("Siniestro");
			type1.setStyle("-fx-background-color: black;");
		}
		if(typestr1_1.equals("flying")) {
			type1.setText("Volador");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_1.equals("ground")) {
			type1.setText("Tierra");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_1.equals("steel")) {
			type1.setText("Acero");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_1.equals("dragon")) {
			type1.setText("Dragon");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_1.equals("fighting")) {
			type1.setText("Lucha");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_1.equals("ghost")) {
			type1.setText("Fantasma");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_1.equals("ice")) {
			type1.setText("Hielo");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_1.equals("psychic")) {
			type1.setText("Psiquico");
			type1.setStyle("-fx-background-color: pink;");
		}
	}
	
	/**
	 * Sets the big img 2.
	 *
	 * @param event the new big img 2
	 */
	@FXML
	void setBigImg2(MouseEvent event) {
		bigImg.setImage(image2);
		String name = pkmnName2.getText();
		bigName.setText(name);
		if(typestr1_2.equals("poison")) {
			type1.setText("Veneno");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_2.equals("grass")) {
			type1.setText("Planta");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_2.equals("fire")) {
			type1.setText("Fuego");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_2.equals("water")) {
			type1.setText("Agua");
			type1.setStyle("-fx-background-color: blue;");
		}
		if(typestr1_2.equals("bug")) {
			type1.setText("Bicho");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_2.equals("electric")) {
			type1.setText("Electrico");
			type1.setStyle("-fx-background-color: yellow;");
		}
		if(typestr1_2.equals("normal")) {
			type1.setText("Normal");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_2.equals("rock")) {
			type1.setText("Roca");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_2.equals("dark")) {
			type1.setText("Siniestro");
			type1.setStyle("-fx-background-color: black;");
		}
		if(typestr1_2.equals("flying")) {
			type1.setText("Volador");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_2.equals("ground")) {
			type1.setText("Tierra");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_2.equals("steel")) {
			type1.setText("Acero");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_2.equals("dragon")) {
			type1.setText("Dragon");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_2.equals("fighting")) {
			type1.setText("Lucha");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_2.equals("ghost")) {
			type1.setText("Fantasma");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_2.equals("ice")) {
			type1.setText("Hielo");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_2.equals("psychic")) {
			type1.setText("Psiquico");
			type1.setStyle("-fx-background-color: pink;");
		}
	}
	
	/**
	 * Sets the big img 3.
	 *
	 * @param event the new big img 3
	 */
	@FXML
	void setBigImg3(MouseEvent event) {
		bigImg.setImage(image3);
		String name = pkmnName3.getText();
		bigName.setText(name);
		if(typestr1_3.equals("poison")) {
			type1.setText("Veneno");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_3.equals("grass")) {
			type1.setText("Planta");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_3.equals("fire")) {
			type1.setText("Fuego");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_3.equals("water")) {
			type1.setText("Agua");
			type1.setStyle("-fx-background-color: blue;");
		}
		if(typestr1_3.equals("bug")) {
			type1.setText("Bicho");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_3.equals("electric")) {
			type1.setText("Electrico");
			type1.setStyle("-fx-background-color: yellow;");
		}
		if(typestr1_3.equals("normal")) {
			type1.setText("Normal");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_3.equals("rock")) {
			type1.setText("Roca");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_3.equals("dark")) {
			type1.setText("Siniestro");
			type1.setStyle("-fx-background-color: black;");
		}
		if(typestr1_3.equals("flying")) {
			type1.setText("Volador");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_3.equals("ground")) {
			type1.setText("Tierra");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_3.equals("steel")) {
			type1.setText("Acero");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_3.equals("dragon")) {
			type1.setText("Dragon");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_3.equals("fighting")) {
			type1.setText("Lucha");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_3.equals("ghost")) {
			type1.setText("Fantasma");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_3.equals("ice")) {
			type1.setText("Hielo");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_3.equals("psychic")) {
			type1.setText("Psiquico");
			type1.setStyle("-fx-background-color: pink;");
		}
	}
	
	/**
	 * Sets the big img 4.
	 *
	 * @param event the new big img 4
	 */
	@FXML
	void setBigImg4(MouseEvent event) {
		bigImg.setImage(image4);
		String name = pkmnName4.getText();
		bigName.setText(name);
		
		if(typestr1_4.equals("poison")) {
			type1.setText("Veneno");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_4.equals("grass")) {
			type1.setText("Planta");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_4.equals("fire")) {
			type1.setText("Fuego");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_4.equals("water")) {
			type1.setText("Agua");
			type1.setStyle("-fx-background-color: blue;");
		}
		if(typestr1_4.equals("bug")) {
			type1.setText("Bicho");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_4.equals("electric")) {
			type1.setText("Electrico");
			type1.setStyle("-fx-background-color: yellow;");
		}
		if(typestr1_4.equals("normal")) {
			type1.setText("Normal");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_4.equals("rock")) {
			type1.setText("Roca");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_4.equals("dark")) {
			type1.setText("Siniestro");
			type1.setStyle("-fx-background-color: black;");
		}
		if(typestr1_4.equals("flying")) {
			type1.setText("Volador");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_4.equals("ground")) {
			type1.setText("Tierra");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_4.equals("steel")) {
			type1.setText("Acero");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_4.equals("dragon")) {
			type1.setText("Dragon");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_4.equals("fighting")) {
			type1.setText("Lucha");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_4.equals("ghost")) {
			type1.setText("Fantasma");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_4.equals("ice")) {
			type1.setText("Hielo");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_4.equals("psychic")) {
			type1.setText("Psiquico");
			type1.setStyle("-fx-background-color: pink;");
		}
	}
	
	/**
	 * Sets the big img 5.
	 *
	 * @param event the new big img 5
	 */
	@FXML
	void setBigImg5(MouseEvent event) {
		bigImg.setImage(image5);
		String name = pkmnName5.getText();
		bigName.setText(name);
		
		if(typestr1_5.equals("poison")) {
			type1.setText("Veneno");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_5.equals("grass")) {
			type1.setText("Planta");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_5.equals("fire")) {
			type1.setText("Fuego");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_5.equals("water")) {
			type1.setText("Agua");
			type1.setStyle("-fx-background-color: blue;");
		}
		if(typestr1_5.equals("bug")) {
			type1.setText("Bicho");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_5.equals("electric")) {
			type1.setText("Electrico");
			type1.setStyle("-fx-background-color: yellow;");
		}
		if(typestr1_5.equals("normal")) {
			type1.setText("Normal");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_5.equals("rock")) {
			type1.setText("Roca");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_5.equals("dark")) {
			type1.setText("Siniestro");
			type1.setStyle("-fx-background-color: black;");
		}
		if(typestr1_5.equals("flying")) {
			type1.setText("Volador");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_5.equals("ground")) {
			type1.setText("Tierra");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_5.equals("steel")) {
			type1.setText("Acero");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_5.equals("dragon")) {
			type1.setText("Dragon");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_5.equals("fighting")) {
			type1.setText("Lucha");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_5.equals("ghost")) {
			type1.setText("Fantasma");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_5.equals("ice")) {
			type1.setText("Hielo");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_5.equals("psychic")) {
			type1.setText("Psiquico");
			type1.setStyle("-fx-background-color: pink;");
		}
	}
	
	/**
	 * Sets the big img 6.
	 *
	 * @param event the new big img 6
	 */
	@FXML
	void setBigImg6(MouseEvent event) {
		bigImg.setImage(image6);
		String name = pkmnName6.getText();
		bigName.setText(name);
		if(typestr1_6.equals("poison")) {
			type1.setText("Veneno");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_6.equals("grass")) {
			type1.setText("Planta");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_6.equals("fire")) {
			type1.setText("Fuego");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_6.equals("water")) {
			type1.setText("Agua");
			type1.setStyle("-fx-background-color: blue;");
		}
		if(typestr1_6.equals("bug")) {
			type1.setText("Bicho");
			type1.setStyle("-fx-background-color: green;");
		}
		if(typestr1_6.equals("electric")) {
			type1.setText("Electrico");
			type1.setStyle("-fx-background-color: yellow;");
		}
		if(typestr1_6.equals("normal")) {
			type1.setText("Normal");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_6.equals("rock")) {
			type1.setText("Roca");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_6.equals("dark")) {
			type1.setText("Siniestro");
			type1.setStyle("-fx-background-color: black;");
		}
		if(typestr1_6.equals("flying")) {
			type1.setText("Volador");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_6.equals("ground")) {
			type1.setText("Tierra");
			type1.setStyle("-fx-background-color: brown;");
		}
		if(typestr1_6.equals("steel")) {
			type1.setText("Acero");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_6.equals("dragon")) {
			type1.setText("Dragon");
			type1.setStyle("-fx-background-color: purple;");
		}
		if(typestr1_6.equals("fighting")) {
			type1.setText("Lucha");
			type1.setStyle("-fx-background-color: red;");
		}
		if(typestr1_6.equals("ghost")) {
			type1.setText("Fantasma");
			type1.setStyle("-fx-background-color: grey;");
		}
		if(typestr1_6.equals("ice")) {
			type1.setText("Hielo");
			type1.setStyle("-fx-background-color: cyan;");
		}
		if(typestr1_6.equals("psychic")) {
			type1.setText("Psiquico");
			type1.setStyle("-fx-background-color: pink;");
		}
	}
	
	
	/**
	 * Page next.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the JSON exception
	 */
	@FXML
	void pageNext(MouseEvent event) throws IOException, JSONException {
		int plus = 6;
		imageSource1 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn1+plus)+".png?raw=true";
		imageSource2 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn2+plus)+".png?raw=true";
		imageSource3 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn3+plus)+".png?raw=true";
		imageSource4 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn4+plus)+".png?raw=true";
		imageSource5 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn5+plus)+".png?raw=true";
		imageSource6 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn6+plus)+".png?raw=true";
		
		image1 = new Image(imageSource1);
		image2 = new Image(imageSource2);
		image3 = new Image(imageSource3);
		image4 = new Image(imageSource4);
		image5 = new Image(imageSource5);
		image6 = new Image(imageSource6);
		
		pkmnImg1.setImage(image1);
		pkmnImg2.setImage(image2);
		pkmnImg3.setImage(image3);
		pkmnImg4.setImage(image4);
		pkmnImg5.setImage(image5);
		pkmnImg6.setImage(image6);
		
		URL url1 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn1+plus));
		HttpURLConnection urlConn1 = (HttpURLConnection) url1.openConnection();
		urlConn1.addRequestProperty("User-Agent", "Mozilla/4.76");
		URL url2 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn2+plus));
		HttpURLConnection urlConn2 = (HttpURLConnection) url2.openConnection();
		urlConn2.addRequestProperty("User-Agent", "Mozilla/4.76");
		URL url3 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn3+plus));
		HttpURLConnection urlConn3 = (HttpURLConnection) url3.openConnection();
		urlConn3.addRequestProperty("User-Agent", "Mozilla/4.76");
		URL url4 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn4+plus));
		HttpURLConnection urlConn4 = (HttpURLConnection) url4.openConnection();
		urlConn4.addRequestProperty("User-Agent", "Mozilla/4.76");
		URL url5 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn5+plus));
		HttpURLConnection urlConn5 = (HttpURLConnection) url5.openConnection();
		urlConn5.addRequestProperty("User-Agent", "Mozilla/4.76");
		URL url6 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn6+plus));
		HttpURLConnection urlConn6 = (HttpURLConnection) url6.openConnection();
		urlConn6.addRequestProperty("User-Agent", "Mozilla/4.76");
		
		InputStreamReader isr1 = new InputStreamReader(urlConn1.getInputStream());
		BufferedReader br1 = new BufferedReader(isr1);
		InputStreamReader isr2 = new InputStreamReader(urlConn2.getInputStream());
		BufferedReader br2 = new BufferedReader(isr2);
		InputStreamReader isr3 = new InputStreamReader(urlConn3.getInputStream());
		BufferedReader br3 = new BufferedReader(isr3);
		InputStreamReader isr4 = new InputStreamReader(urlConn4.getInputStream());
		BufferedReader br4 = new BufferedReader(isr4);
		InputStreamReader isr5 = new InputStreamReader(urlConn5.getInputStream());
		BufferedReader br5 = new BufferedReader(isr5);
		InputStreamReader isr6 = new InputStreamReader(urlConn6.getInputStream());
		BufferedReader br6 = new BufferedReader(isr6);

		String txt  = br1.readLine();
		String txt1 = br2.readLine();
		String txt2 = br3.readLine();
		String txt3 = br4.readLine();
		String txt4 = br5.readLine();
		String txt5 = br6.readLine();
			
		JSONObject obj = new JSONObject(txt);
		JSONArray forms = obj.getJSONArray("forms");
		JSONObject formObj = forms.getJSONObject(0);
		String name = formObj.getString("name");
		
		JSONArray types = obj.getJSONArray("types");
		JSONObject typeObj1 = types.getJSONObject(0);
		JSONObject type1 = typeObj1.getJSONObject("type");
		typestr1_1 = type1.getString("name");

		
		JSONObject obj1 = new JSONObject(txt1);
		JSONArray forms1 = obj1.getJSONArray("forms");
		JSONObject formObj1 = forms1.getJSONObject(0);
		String name1 = formObj1.getString("name");
		
		JSONArray types2 = obj1.getJSONArray("types");
		JSONObject typeObj1_2 = types2.getJSONObject(0);
		JSONObject type1_2 = typeObj1_2.getJSONObject("type");
		typestr1_2 = type1_2.getString("name");

		JSONObject obj2 = new JSONObject(txt2);
		JSONArray forms2 = obj2.getJSONArray("forms");
		JSONObject formObj2 = forms2.getJSONObject(0);
		String name2 = formObj2.getString("name");
		
		JSONArray types3 = obj2.getJSONArray("types");
		JSONObject typeObj1_3 = types3.getJSONObject(0);
		JSONObject type1_3 = typeObj1_3.getJSONObject("type");
		typestr1_3 = type1_3.getString("name");
		
		JSONObject obj3 = new JSONObject(txt3);
		JSONArray forms3 = obj3.getJSONArray("forms");
		JSONObject formObj3 = forms3.getJSONObject(0);
		String name3 = formObj3.getString("name");
		
		JSONArray types4 = obj3.getJSONArray("types");
		JSONObject typeObj1_4 = types4.getJSONObject(0);
		JSONObject type1_4 = typeObj1_4.getJSONObject("type");
		typestr1_4 = type1_4.getString("name");
		System.out.println(typestr1_4);
		
		JSONObject obj4 = new JSONObject(txt4);
		JSONArray forms4 = obj4.getJSONArray("forms");
		JSONObject formObj4 = forms4.getJSONObject(0);
		String name4 = formObj4.getString("name");
		
		JSONArray types5 = obj4.getJSONArray("types");
		JSONObject typeObj1_5 = types5.getJSONObject(0);
		JSONObject type1_5 = typeObj1_5.getJSONObject("type");
		typestr1_5 = type1_5.getString("name");
		
		JSONObject obj5 = new JSONObject(txt5);
		JSONArray forms5 = obj5.getJSONArray("forms");
		JSONObject formObj5 = forms5.getJSONObject(0);
		String name5 = formObj5.getString("name");
		
		JSONArray types6 = obj5.getJSONArray("types");
		JSONObject typeObj1_6 = types6.getJSONObject(0);
		JSONObject type1_6 = typeObj1_6.getJSONObject("type");
		typestr1_6 = type1_6.getString("name");

		br1.close();
		isr1.close();
		br2.close();
		isr2.close();
		br3.close();
		isr3.close();
		br4.close();
		isr4.close();
		br5.close();
		isr5.close();
		br6.close();
		isr6.close();
		
		pkmnName1.setText(name);
		pkmnName2.setText(name1);
		pkmnName3.setText(name2);
		pkmnName4.setText(name3);
		pkmnName5.setText(name4);
		pkmnName6.setText(name5);
		
		pkmn1 = pkmn1+plus;
		pkmn2 = pkmn2+plus;
		pkmn3 = pkmn3+plus;
		pkmn4 = pkmn4+plus;
		pkmn5 = pkmn5+plus;
		pkmn6 = pkmn6+plus;
		
		pageCounter++;
		page.setText(Integer.toString(pageCounter));
	}
	
	/**
	 * Page back.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the JSON exception
	 */
	@FXML
	void pageBack(MouseEvent event) throws IOException, JSONException {
		int minus = 6;
		if(pageCounter<=0) {
			page.setText("0");
		}else {
			imageSource1 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn1-minus)+".png?raw=true";
			imageSource2 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn2-minus)+".png?raw=true";
			imageSource3 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn3-minus)+".png?raw=true";
			imageSource4 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn4-minus)+".png?raw=true";
			imageSource5 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn5-minus)+".png?raw=true";
			imageSource6 = "https://github.com/PokeAPI/sprites/blob/master/sprites/pokemon/"+(pkmn6-minus)+".png?raw=true";
			
			image1 = new Image(imageSource1);
			image2 = new Image(imageSource2);
			image3 = new Image(imageSource3);
			image4 = new Image(imageSource4);
			image5 = new Image(imageSource5);
			image6 = new Image(imageSource6);
			
			pkmnImg1.setImage(image1);
			pkmnImg2.setImage(image2);
			pkmnImg3.setImage(image3);
			pkmnImg4.setImage(image4);
			pkmnImg5.setImage(image5);
			pkmnImg6.setImage(image6);
			
			URL url1 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn1-minus));
			HttpURLConnection urlConn1 = (HttpURLConnection) url1.openConnection();
			urlConn1.addRequestProperty("User-Agent", "Mozilla/4.76");
			URL url2 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn2-minus));
			HttpURLConnection urlConn2 = (HttpURLConnection) url2.openConnection();
			urlConn2.addRequestProperty("User-Agent", "Mozilla/4.76");
			URL url3 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn3-minus));
			HttpURLConnection urlConn3 = (HttpURLConnection) url3.openConnection();
			urlConn3.addRequestProperty("User-Agent", "Mozilla/4.76");
			URL url4 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn4-minus));
			HttpURLConnection urlConn4 = (HttpURLConnection) url4.openConnection();
			urlConn4.addRequestProperty("User-Agent", "Mozilla/4.76");
			URL url5 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn5-minus));
			HttpURLConnection urlConn5 = (HttpURLConnection) url5.openConnection();
			urlConn5.addRequestProperty("User-Agent", "Mozilla/4.76");
			URL url6 = new URL("https://pokeapi.co/api/v2/pokemon/"+(pkmn6-minus));
			HttpURLConnection urlConn6 = (HttpURLConnection) url6.openConnection();
			urlConn6.addRequestProperty("User-Agent", "Mozilla/4.76");
			
			InputStreamReader isr1 = new InputStreamReader(urlConn1.getInputStream());
			BufferedReader br1 = new BufferedReader(isr1);
			InputStreamReader isr2 = new InputStreamReader(urlConn2.getInputStream());
			BufferedReader br2 = new BufferedReader(isr2);
			InputStreamReader isr3 = new InputStreamReader(urlConn3.getInputStream());
			BufferedReader br3 = new BufferedReader(isr3);
			InputStreamReader isr4 = new InputStreamReader(urlConn4.getInputStream());
			BufferedReader br4 = new BufferedReader(isr4);
			InputStreamReader isr5 = new InputStreamReader(urlConn5.getInputStream());
			BufferedReader br5 = new BufferedReader(isr5);
			InputStreamReader isr6 = new InputStreamReader(urlConn6.getInputStream());
			BufferedReader br6 = new BufferedReader(isr6);

			String txt  = br1.readLine();
			String txt1 = br2.readLine();
			String txt2 = br3.readLine();
			String txt3 = br4.readLine();
			String txt4 = br5.readLine();
			String txt5 = br6.readLine();
				
			JSONObject obj = new JSONObject(txt);
			JSONArray forms = obj.getJSONArray("forms");
			JSONObject formObj = forms.getJSONObject(0);
			String name = formObj.getString("name");
			
			JSONObject obj1 = new JSONObject(txt1);
			JSONArray forms1 = obj1.getJSONArray("forms");
			JSONObject formObj1 = forms1.getJSONObject(0);
			String name1 = formObj1.getString("name");
			
			JSONObject obj2 = new JSONObject(txt2);
			JSONArray forms2 = obj2.getJSONArray("forms");
			JSONObject formObj2 = forms2.getJSONObject(0);
			String name2 = formObj2.getString("name");
			
			JSONObject obj3 = new JSONObject(txt3);
			JSONArray forms3 = obj3.getJSONArray("forms");
			JSONObject formObj3 = forms3.getJSONObject(0);
			String name3 = formObj3.getString("name");
			
			JSONObject obj4 = new JSONObject(txt4);
			JSONArray forms4 = obj4.getJSONArray("forms");
			JSONObject formObj4 = forms4.getJSONObject(0);
			String name4 = formObj4.getString("name");
			
			JSONObject obj5 = new JSONObject(txt5);
			JSONArray forms5 = obj5.getJSONArray("forms");
			JSONObject formObj5 = forms5.getJSONObject(0);
			String name5 = formObj5.getString("name");

			br1.close();
			isr1.close();
			br2.close();
			isr2.close();
			br3.close();
			isr3.close();
			br4.close();
			isr4.close();
			br5.close();
			isr5.close();
			br6.close();
			isr6.close();
			
			pkmnName1.setText(name);
			pkmnName2.setText(name1);
			pkmnName3.setText(name2);
			pkmnName4.setText(name3);
			pkmnName5.setText(name4);
			pkmnName6.setText(name5);
			
			pkmn1 = pkmn1-minus;
			pkmn2 = pkmn2-minus;
			pkmn3 = pkmn3-minus;
			pkmn4 = pkmn4-minus;
			pkmn5 = pkmn5-minus;
			pkmn6 = pkmn6-minus;
			pageCounter--;
			page.setText(Integer.toString(pageCounter));
		}
	}
}
