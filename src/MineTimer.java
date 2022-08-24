import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

/* Timer
 * Als Singleton ausgelegt. Erweitert ein JLabel und implementiert einen Actionlistener
 * timer lässt als ActionEvent in der Methode actionPerformed einen Counter jede Sekunde hochzählen
 * Start startet das ganze und setzt den counter auf 0, Stop stopt den timer
 * Methode getTime liefert mir den wert von counter zurück.
 */

@SuppressWarnings("serial")
public class MineTimer extends JLabel implements ActionListener{
	
	static private MineTimer instance = null;
	Timer timer = new Timer(1000, this);
	private int counter = 0;
	
	private MineTimer() {
		this.setText("Zeit: " + String.valueOf(counter) + " sec");
	}
	
	static public MineTimer getInstance() {
		if (instance == null) {
			instance = new MineTimer();
		}
		return instance;
	}
	
	public void start() {
		counter = 0;
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public int getTime() {
		return counter;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		counter +=1;
		this.setText("Zeit: " + String.valueOf(counter) + " sec");
	}
	
}