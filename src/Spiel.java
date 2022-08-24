/* Spielsteuerungsklasse. Ist Subklasse von der Klasse Anzeige.
 * Es wird ein Objekt der Klasse Positionen und Anzeige im Konstruktor erzeugt.
 * Die Methode Suche sucht mit hilfe der Methode istHierMiene,
 * ob an der Stelle x und y eine Miene liegt und trägt dann in das Anzeige Array den wert von MIENE ein,
 * andernfalls werden die Nachbarfälder mittels zaehleNachbarn geprüft.
 * Dies jedoch nur, wenn gewünscht. Wenn nicht, werden nur die Mienen gesucht.
 * zaehleNachbnarn prüft die 8 Felder um das gewünschrte Feld x,y nach Mienen ab mittels istHierMiene und zählt einen Counter hoch,
 * der dann in das Feld x,y geschrieben wird.
 * Wenn der gezählte Wert 0 entspricht, wird für alle Felder drum herum, die noch mit LEER befüllt sind, wieder suche aufgerufen.
 * => Automation für 0 Felder, da um dieser herum gefahrlos die weiteren Felder angeklickt werden können.
 * Methode Gewinnt prüft, ob gewinn vorliegt und gibt wenn ja True zurück. Dabei wird Wert von Variable gewinn geprüft, der bei Aufruf der Methode Suche
 * um eins verringert wird. gewinn entspricht zu beginn der Anzahl aller Felder des Spiels. Wenn gewinn = der Anzahl meiner Mienen, liegt ein gewinn vor.
 * wenn bei suche eine Miene festgestellt wird, wird Wert von gewinn um eins erhöht wieder und die variable loose wird auf true gesetzt.
 */

public class Spiel extends Anzeige {

	Anzeige anzeige;
	Positionen position;

	private int gewinn = X * Y;
	public boolean loose = false;

	public Spiel() {
		anzeige = new Anzeige();
		position = new Positionen();
	}

	public void suche(int x, int y, boolean ohnenachbarn) {
		if (x >= 0 && x < X && y >= 0 && y < Y) {
			gewinn--;
			if (position.istHierMiene(x, y) == true) {
				anzeige.anzeige[x][y] = MIENE;
				this.loose = true;
				gewinn++;
			} else {
				if (ohnenachbarn == false) {
					zaehleNachbarn(x, y);

				}
			}
		}
	}

	private void zaehleNachbarn(int x, int y) {
		int n = '0';
		for (int nx = x - 1; nx <= x + 1; nx++) {
			for (int ny = y - 1; ny <= y + 1; ny++) {
				if (position.istHierMiene(nx, ny) == true) {
					n += 1;
				}
			}
		}
		anzeige.anzeige[x][y] = (char) n;
		if (n == '0') {
			for (int nx = x - 1; nx <= x + 1; nx++) {
				for (int ny = y - 1; ny <= y + 1; ny++) {
					if (anzeige.get(nx, ny).equals(String.valueOf(Spiel.LEER))) {
						suche(nx, ny, false);
					}
				}
			}
		}
	}

	public boolean gewonnen() {
		boolean win = false;
		if (this.gewinn == Positionen.MIENEN) {
			win = true;
		}
		return win;
	}

}