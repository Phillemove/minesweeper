import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* Die Klasse erzeugt ein JPanel und ist erweiterung der Klasse JPanel. Sie implementiert außerdem das Interface MouseListener und ActionListener
 * Der Konstruktor erzeugt den MouseListener und das Objekt vom typ Spiel
 * Die Methode Paint wird überschrieben.
 * In Abhängigkeit von der in MineFrame festgelegten Fenstergröße und der Anzahl der benötigten Spielfelder X und Y, erhalten aus der Klasse Spiel,
 * wird hier ein Spielfeld in das JPanel gezeichnet.
 * Methode actionPerformed ist für den Neustart des Spiels. Sie erzeugt ein neues Spiel objekt und fordert repaint an. Ebenfalls wird der Timer neu gesartet.
 * Das Event mouseClicked, Speichert die x und y Koodrinate der "angeklickten" Stelle im jpanel.
 * Sofern der Wert des "angeklickten" Feldes noch Leer entspricht, wird das "angeklickte" Feld entweder aufgedeckt, sofern hier noch die Methode
 * gewinn der Klasse Spiel false ergibt und die Variable loose ebenfalls false ist, d.H. der im Array anzeige gespeicherte Wert wird in das Feld gezeichnet,
 * oder bei einem Rechtsklick wird ein oval und ! in das angeklickte Feld gezeichnet.
 * Gewinnsituationsermittlung:
 * Wenn eine MIENE angeklickt wird, werden alle anderen Mienen angezeigt und der Hintergrund Rot gemalt.
 * Wenn methode gewinn der Klasse Spiel true zurück gibt, wird der Hintergrund grün gemalt.
 * In Mehtode mouseClicked wird, sofern die Variable loose der Klasse Spiel false ist,
 * der Timer gestoppt, über ein JOptionPane, via Eingabe vom Spieler ein Name als String eingelesen.
 * Wenn der Wert des Strings nicht null ist, wird ein neues Score Objekt erzeugt,
 * mit dem Namen und die Sekunden, die via der Methode getTime von MineTimer geholt werden und an der ArrayList angefügt.
 * Das Erzeugen eines doalog Objekts zeigt dann einen JDialog an, in dem der Score angezeigt wird.
 */

@SuppressWarnings("serial")
public class MinePanel extends JPanel implements MouseListener, ActionListener {

	private Spiel spiel;

	private int posx;
	private int posy;
	private int klick;

	public MinePanel() {
		this.addMouseListener(this);
		spiel = new Spiel();
	}

	@Override
	public void paint(Graphics mi) {
		super.paint(mi);
		mi.setColor(Color.black);
		this.setBackground(Color.lightGray);
		int x = getWidth() / Spiel.X;
		int y = getHeight() / Spiel.Y;
		for (int i = 0; i < Spiel.X; i++) {
			for (int j = 0; j < Spiel.Y; j++) {
				mi.drawRect(0 + (i * x), 0 + (j * y), x, y);
				if (spiel.anzeige.get(i, j).equals(String.valueOf(Spiel.LEER))) {

				} else if (spiel.anzeige.get(i, j).equals(String.valueOf(Spiel.MIENE))) {
					for (int k = 0; k < Spiel.X; k++) {
						for (int l = 0; l < Spiel.Y; l++) {
							spiel.suche(k, l, true);
							this.setBackground(Color.red);
							MineTimer.getInstance().stop();
							for (int q = 0; q < Positionen.MIENEN; q++) {
								mi.fillOval(0 + (spiel.position.mine[q].getX() * x),
										0 + (spiel.position.mine[q].getY() * y), x, y);
							}
						}
					}
				} else if (spiel.anzeige.get(i, j).equals(String.valueOf(Spiel.MARKED))) {
					mi.setColor(Color.blue);
					mi.fillOval(0 + (i * x), 0 + (j * y), x, y);
					mi.setColor(Color.white);
					mi.drawString(String.valueOf(Spiel.MARKED), (Spiel.X + (i * x)), (Spiel.Y + (j * y)));
					mi.setColor(Color.black);
				} else if (spiel.anzeige.get(i, j).equals("0")) {
					mi.setColor(Color.white);
					mi.fillRect(0 + (i * x), 0 + (j * y), x, y);
					mi.setColor(Color.black);
					mi.drawRect(0 + (i * x), 0 + (j * y), x, y);
				} else {
					mi.setColor(Color.white);
					mi.fillRect(0 + (i * x), 0 + (j * y), x, y);
					mi.setColor(Color.black);
					mi.drawString(spiel.anzeige.get(i, j), (Spiel.X + (i * x)), (Spiel.Y + (j * y)));
					mi.drawRect(0 + (i * x), 0 + (j * y), x, y);
					if (spiel.gewonnen() == true) {
						this.setBackground(Color.green);
					}
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.spiel = new Spiel();
		MineTimer.getInstance().start();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int fieldX = getWidth() / Spiel.X;
		int fieldY = getHeight() / Spiel.Y;
		this.klick = e.getButton();
		this.posx = e.getX() / fieldX;
		this.posy = e.getY() / fieldY;
		if (spiel.anzeige.get(posx, posy).equals(String.valueOf(Spiel.LEER))) {
			if (klick == 3 && spiel.gewonnen() == false && spiel.loose == false) {
				spiel.anzeige.anzeige[posx][posy] = Spiel.MARKED;
			} else if (spiel.gewonnen() == false && spiel.loose == false) {
				spiel.suche(posx, posy, false);
				if (spiel.gewonnen() == true && spiel.loose == false) {
					MineTimer.getInstance().stop();
					String name = JOptionPane.showInputDialog(this, "Name");
					if (name != null) {
						Highscore.getInstance().add(new Score(name, MineTimer.getInstance().getTime()));
						@SuppressWarnings("unused")
                        Scoredialog dialog = new Scoredialog();
					}
				}
			}
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}