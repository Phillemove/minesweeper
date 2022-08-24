import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/* Erstellt einen JDialog und fügt ihm eine JTable hinzu, die in Scoretable genauer definiert wird */

@SuppressWarnings("serial")
public class Scoredialog extends JDialog {
	
	public Scoredialog() {
		this.setSize(200, 200);
		this.setVisible(true);
		this.setTitle("Highscore");
		JTable scoretable = new JTable(new Scoretable());
		this.add(scoretable);
		this.add(new JScrollPane(scoretable));
	}
	
}