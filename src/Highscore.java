import java.util.ArrayList;

/* Highscore Liste
 * Ist als ArrayListe vom generischen Typ Score definiert bzw erweitert diese
 * Da Highscore Objekt nur einmal benötigt wird, als Singleton geschrieben
 */

@SuppressWarnings("serial")
public class Highscore extends ArrayList<Score>{
	
	static private Highscore instance = null;
	
	private Highscore() {
		
	}
	
	static public Highscore getInstance() {
		if (instance == null) {
			instance = new Highscore();
		}
		return instance;
	}
}
