/* Erstellt eine Miene und weißt ihr Parameter/Koordinaten x und y zu. 
 * Die beiden Methoden get liefern den jeweiligen Parameter als Rückgabe.
 * Die Methode istAnPosition, prüft ob an der Position der übergebenen Miene bereits eine Miene liegt.
 * Dazu wird mittels get die Koordinaten, der übergebenen Miene ausgelesen und damit dann verglichen.
 */

public class Mine {
	private int x, y;

	public Mine(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean istAnPosition(Mine mine) {
		boolean b = false;
		int x = mine.getX();
		int y = mine.getY();
		if (this.x == x && this.y == y) {
			b = true;
		}

		return b;
	}

}
