/* Konstruiert ein Spielfeld mit vorgegebener Größe X un Y als zweidimensionales Char Array.
 * Jedes Element im Array wird mit dem Wert von LEER befüllt.
 * Die Methode get zeigt den Wert im Array an übergebener Stelle x,y an und gibt diesen als String zurück, sofern x und y innerhalb des Arrays liegen.
 * Wenn x und y außerhalb des Arrays liegen, wird ERROR zurück gegeben.
 */

public class Anzeige {

	char anzeige[][];
	static final int X = 12;
	static final int Y = 16;
	static final char LEER = '.';
	static final char MIENE = '#';
	static final char MARKED = '!';
	static final char ERROR = 'E';

	public Anzeige() {
		anzeige = new char[X][Y];
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				anzeige[i][j] = LEER;
			}
		}
	}

	public String get(int x, int y) {
		if (x >= 0 && x < X && y >= 0 && y < Y) {
			return String.valueOf(anzeige[x][y]);
		}
		else {
			return String.valueOf(ERROR);
		}
	}

}