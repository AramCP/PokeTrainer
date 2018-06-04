package paquete;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class dbQuerys.
 */
public class dbQuerys {
	
	/** The login. */
	controladorLogin login = new controladorLogin();
	
	/** The conexion. */
	MyDataAcces conexion = new MyDataAcces();
	
	/** The resultado. */
	ResultSet resultado;
	
	/** The resultado 2. */
	ResultSet resultado2;
	
	/** The resultado 3. */
	ResultSet resultado3;
	
	/** The resultado 4. */
	ResultSet resultado4;
	
	/** The algo. */
	int algo;
	
	/** The algo 2. */
	int algo2;
	
	/** The algo 3. */
	int algo3;
	
	/** The pokeball. */
	int pokeball;
	
	/** The superball. */
	int superball;
	
	/** The ultraball. */
	int ultraball;
	
	/** The masterball. */
	int masterball;
	
	/** The cebo. */
	int cebo;
	
	/** The key. */
	int key;
	
	/** The somnifero. */
	int somnifero;
	
	/** The dinero. */
	int dinero;
	
	/** The username. */
	String username;
	
	/** The password. */
	String password;
	
	/** The password 2. */
	String password2;
	
	/** The id. */
	int id;
	
	/** The lvl. */
	int lvl;
	
	/** The name. */
	String name;
	
	/** The dinero usado. */
	int dineroUsado;
	
	/** The dinero ganado. */
	int dineroGanado;
	
	/** The pkmn vistos. */
	int pkmnVistos;
	
	/** The pkmn capturados. */
	int pkmnCapturados;
	
	/** The top user. */
	String topUser;
	
	/** The datos. */
	controladorPrincipal datos = new controladorPrincipal();
	
	/**
	 * Instantiates a new db querys.
	 *
	 * @throws SQLException the SQL exception
	 */
	public dbQuerys() throws SQLException{
		
	}
	
	/**
	 * Bag.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void bag()throws SQLException {
		username = controladorLogin.usuario;
		resultado = conexion.getQuery("SELECT * FROM items WHERE username = '"+username+"'");
		while(resultado.next()){
			pokeball = resultado.getInt("pokeball");
			superball = resultado.getInt("superball");
			ultraball = resultado.getInt("ultraball");
			masterball = resultado.getInt("masterball");
			key = resultado.getInt("masterkey");
			cebo = resultado.getInt("cebo");
			somnifero = resultado.getInt("somnifero");
		}
	}
	
	/**
	 * Login.
	 *
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean Login() throws SQLException {
		username = controladorLogin.usuario;
		password2 = controladorLogin.md5pass;
		resultado = conexion.getQuery("SELECT * FROM users WHERE username = '"+username+"'");
		
		resultado2 = conexion.getQuery("SELECT password FROM users WHERE username = '"+username+"'");
		while(resultado2.next()){
			password = resultado2.getString("password");
		}
		
		if(password2.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Pokeball catch.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void pokeballCatch() throws SQLException {
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("UPDATE items SET pokeball = pokeball - 1 WHERE username = '"+username+"'");
	}
	
	/**
	 * Superball catch.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void superballCatch() throws SQLException {
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("UPDATE items SET superball = superball - 1 WHERE username = '"+username+"'");
	}
	
	/**
	 * Ultraball catch.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void ultraballCatch() throws SQLException {
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("UPDATE items SET ultraball = ultraball - 1 WHERE username = '"+username+"'");
	}
	
	/**
	 * Masterball catch.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void masterballCatch() throws SQLException {
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("UPDATE items SET masterball = masterball - 1 WHERE username = '"+username+"'");
	}
	
	/**
	 * Adds the item 1.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addItem1()throws SQLException {
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("UPDATE items SET pokeball = pokeball + 1 WHERE username = '"+username+"'");
		algo2 = conexion.updateQuery("UPDATE items SET dinero = dinero - 200 WHERE username = '"+username+"'");
		algo3 = conexion.updateQuery("UPDATE items SET dineroUsado = dineroUsado + 200 WHERE username = '"+username+"'");
	}
	
	/**
	 * Adds the item 2.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addItem2()throws SQLException {
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("UPDATE items SET superball = superball + 1 WHERE username = '"+username+"'");
		algo2 = conexion.updateQuery("UPDATE items SET dinero = dinero - 350 WHERE username = '"+username+"'");
		algo3 = conexion.updateQuery("UPDATE items SET dineroUsado = dineroUsado + 350 WHERE username = '"+username+"'");
	}
	
	/**
	 * Adds the item 3.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addItem3()throws SQLException {
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("UPDATE items SET ultraball = ultraball + 1 WHERE username = '"+username+"'");
		algo2 = conexion.updateQuery("UPDATE items SET dinero = dinero - 500 WHERE username = '"+username+"'");
		algo3 = conexion.updateQuery("UPDATE items SET dineroUsado = dineroUsado + 500 WHERE username = '"+username+"'");
	}
	
	/**
	 * Adds the item 4.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addItem4()throws SQLException {
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("UPDATE items SET masterkey = masterkey + 1 WHERE username = '"+username+"'");
		algo2 = conexion.updateQuery("UPDATE items SET dinero = dinero - 100000 WHERE username = '"+username+"'");
		algo3 = conexion.updateQuery("UPDATE items SET dineroUsado = dineroUsado + 100000 WHERE username = '"+username+"'");
	}
	
	/**
	 * Gets the dinero.
	 *
	 * @return the dinero
	 * @throws SQLException the SQL exception
	 */
	public void getDinero()throws SQLException {
		username = controladorLogin.usuario;
		resultado = conexion.getQuery("SELECT dinero FROM items WHERE username = '"+username+"'");
		while(resultado.next()){
			dinero = resultado.getInt("dinero");
		}
	}
	
	/**
	 * Precio prado.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void precioPrado()throws SQLException {
		username = controladorLogin.usuario;
		algo2 = conexion.updateQuery("UPDATE items SET dinero = dinero - 100 WHERE username = '"+username+"'");
		algo3 = conexion.updateQuery("UPDATE items SET dineroUsado = dineroUsado + 100 WHERE username = '"+username+"'");
	}
	
	/**
	 * Pkmn visto.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void pkmnVisto()throws SQLException {
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("UPDATE items SET pkmnVistos = pkmnVistos + 1 WHERE username = '"+username+"'");
	}
	
	/**
	 * Pkmn capturado.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void pkmnCapturado()throws SQLException {
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("UPDATE items SET pkmnCapturados = pkmnCapturados + 1 WHERE username = '"+username+"'");
	}
	
	/**
	 * Save pkmn.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void savePkmn()throws SQLException {
		id = controladorCaptura3.pkmnId;
		name = controladorCaptura3.pkmnname;
		lvl = controladorCaptura3.pkmnLvl;
		username = controladorLogin.usuario;
		algo = conexion.updateQuery("INSERT INTO pokemon " + " VALUES ('"+username+"','"+name+"','"+lvl+"','"+id+"')");
	}
	
	/**
	 * Gets the stats.
	 *
	 * @return the stats
	 * @throws SQLException the SQL exception
	 */
	public void getStats()throws SQLException {
		username = controladorLogin.usuario;
		resultado = conexion.getQuery("SELECT dineroUsado FROM items WHERE username = '"+username+"'");
		while(resultado.next()){
			dineroUsado = resultado.getInt("dineroUsado");
		}
		resultado2 = conexion.getQuery("SELECT dineroGanado FROM items WHERE username = '"+username+"'");
		while(resultado2.next()){
			dineroGanado = resultado2.getInt("dineroGanado");
		}
		resultado3 = conexion.getQuery("SELECT pkmnVistos FROM items WHERE username = '"+username+"'");
		while(resultado3.next()){
			pkmnVistos = resultado3.getInt("pkmnVistos");
		}
		resultado4 = conexion.getQuery("SELECT pkmnCapturados FROM items WHERE username = '"+username+"'");
		while(resultado4.next()){
			pkmnCapturados = resultado4.getInt("pkmnCapturados");
		}
	}
	
	/** The top users. */
	String topUsers[] = new String [7];
	
	/** The i. */
	int i = 0;
	
	/**
	 * Gets the top players.
	 *
	 * @return the top players
	 * @throws SQLException the SQL exception
	 */
	public void getTopPlayers() throws SQLException {
		username = controladorLogin.usuario;
		resultado = conexion.getQuery("SELECT username FROM items ORDER BY pkmnVistos DESC");
		while(resultado.next()){
			topUsers[i] = resultado.getString("username");
			i++;
		}
	}

}


