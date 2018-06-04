package paquete;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * The Class controladorStats.
 */
public class controladorStats {
	
	/** The anchor pane content. */
	@FXML private AnchorPane anchorPaneContent;	//Donde va a ir cambiando el contenido de las ventanas.
	
	/** The anchor pane 2. */
	@FXML private AnchorPane anchorPane2; //Este panel está presente en todas las ventanas, es como el panel de fondo, y encima de el está el anchorPaneContent.	
	
	/** The Nombre. */
	@FXML private Label Nombre;
	
	/** The Dinero. */
	@FXML private Label Dinero;
	
	/** The Dinero usado. */
	@FXML private Label DineroUsado;
	
	/** The Dinero ganado. */
	@FXML private Label DineroGanado;
	
	/** The Pkmn vistos. */
	@FXML private Label PkmnVistos;
	
	/** The Pkmn capturados. */
	@FXML private Label PkmnCapturados;
	
	/** The lbltop 1. */
	@FXML private Label lbltop1;
	
	/** The lbltop 2. */
	@FXML private Label lbltop2;
	
	/** The lbltop 3. */
	@FXML private Label lbltop3;
	
	/** The lbltop 4. */
	@FXML private Label lbltop4;
	
	/** The lbltop 5. */
	@FXML private Label lbltop5;
	
	/** The lbltop 6. */
	@FXML private Label lbltop6;
	
	/** The lbltop 7. */
	@FXML private Label lbltop7;
	
	/** The top players. */
	String topPlayers[] = new String [7];
	
	/** The dinero. */
	int dinero;
	
	/** The dinero usado. */
	int dineroUsado;
	
	/** The dinero ganado. */
	int dineroGanado;
	
	/** The pkmn vistos. */
	int pkmnVistos;
	
	/** The pkmn capturados. */
	int pkmnCapturados;
	
	/** The nombre. */
	String nombre;
	
	/**
	 * Gets the stats.
	 *
	 * @return the stats
	 * @throws SQLException the SQL exception
	 */
	void getStats() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.getDinero();
		conexion.getStats();
		dinero = conexion.dinero;
		dineroUsado = conexion.dineroUsado;
		dineroGanado = conexion.dineroGanado;
		pkmnVistos = conexion.pkmnVistos;
		pkmnCapturados = conexion.pkmnCapturados;
		
		Dinero.setText(""+dinero+"$");
		DineroUsado.setText(""+dineroUsado+"$");
		DineroGanado.setText(""+dineroGanado+"$");
		PkmnVistos.setText(""+pkmnVistos);
		PkmnCapturados.setText(""+pkmnCapturados);
	}
	
	/**
	 * Top players.
	 *
	 * @throws SQLException the SQL exception
	 */
	void topPlayers() throws SQLException {
		dbQuerys conexion = new dbQuerys();
		conexion.getTopPlayers();
		topPlayers[0] = conexion.topUsers[0];
		topPlayers[1] = conexion.topUsers[1];
		topPlayers[2] = conexion.topUsers[2];
		topPlayers[3] = conexion.topUsers[3];
		topPlayers[4] = conexion.topUsers[4];
		topPlayers[5] = conexion.topUsers[5];
		topPlayers[6] = conexion.topUsers[6];
		
		lbltop1.setText(topPlayers[0]);
		lbltop2.setText(topPlayers[1]);
		lbltop3.setText(topPlayers[2]);
		lbltop4.setText(topPlayers[3]);
		lbltop5.setText(topPlayers[4]);
		lbltop6.setText(topPlayers[5]);
		lbltop7.setText(topPlayers[6]);
	}

}
