import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* Es wird ein Frame erzeugt für die Gui.
 * Die Klasse ist eine erweiterung der Klasse JFrame.
 * Ein Objekt der Klasse MinePanel wird erzeugt.
 * Inhalt des JFrames wird in Klasse MinePanel definiert und erzeugt.
 * actionListener für Menue um Spiel neu zu starten oder zu beenden.
 * actionListener für neustart wird dabei an MinePanel übergeben.
 */

@SuppressWarnings("serial")
public class MineFrame extends JFrame {


	public MineFrame() {
		MinePanel minePanel = new MinePanel();
		//Menuebar erstellen
		JMenuBar menue = new JMenuBar();
		setJMenuBar(menue);
		JMenu spiel = new JMenu("Spiel");
		menue.add(spiel);
		JMenuItem newgame = new JMenuItem("Neues Spiel");
		JMenuItem score = new JMenuItem("Score");
		JMenuItem quit = new JMenuItem("Beenden");
		spiel.add(score);
		spiel.add(newgame);
		spiel.add(quit);
		newgame.addActionListener(minePanel);
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		score.addActionListener(new ActionListener(){
		    
			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
                Scoredialog scoreboard = new Scoredialog();
			}
			
		});
		//Header
		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());
		header.setBackground(Color.lightGray);
		JLabel überschrift = new JLabel("<html><b>Minesweeper</b></html>");
		überschrift.setForeground(Color.black);
		überschrift.setHorizontalAlignment(JLabel.CENTER);
		MineTimer.getInstance().setHorizontalAlignment(JLabel.CENTER);
		header.add(BorderLayout.NORTH, überschrift);
		header.add(BorderLayout.SOUTH, MineTimer.getInstance());
		//Restliches Frame
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH, header);
		this.add(BorderLayout.CENTER, minePanel);
		this.setSize(300, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

	public static void main(String[] args) {
		@SuppressWarnings("unused")
        MineFrame mineframe = new MineFrame();
		MineTimer.getInstance().start();
	}

}