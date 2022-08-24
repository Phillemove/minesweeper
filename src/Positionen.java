/* Legt die Anzahl der Mienen fest und lässt eine dementsprechende Anzahl erstellen, mit hilfe der Klasse Mine
 * und weißt ihr zufällige Koordinaten, in Abhängigkeit der Spielfeld Größe zu.
 * Die Spielfeldgröße ist aus der Klasse Anzeige zu entnehmen.
 * Die Methode istHierMiene, prüft, ob an den übergebenen Koordinaten eine Miene liegt und gibt dann True zurück. Andernfalls false.
 */

public class Positionen {
	java.util.Random zufall = new java.util.Random();

	static final int MIENEN = 12;

	Mine mine[];

	public Positionen() {
		mine = new Mine[MIENEN];
		for (int i = 0; i < mine.length; i++) {
			mine[i] = new Mine(zufall.nextInt(Anzeige.X), zufall.nextInt(Anzeige.Y));
			for (int j = 0; j < i; j++) {
				if (mine[i].istAnPosition(mine[j]) == true) {
					i--;
				}
			}
		}
	}

	public boolean istHierMiene(int x, int y) {
		boolean b = false;
		for (int i = 0; i < MIENEN; i++) {
			if (mine[i].getX() == x && mine[i].getY() == y) {
				b = true;
			}
		}
		return b;
	}

}