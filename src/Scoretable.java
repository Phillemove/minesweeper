import javax.swing.table.AbstractTableModel;

/* Rahmenkonstrukt für JTable
 * JTable wird hier genauer spezifiziert.
 * Inhalt der JTable wird aus Highscore entnommen.
 * Elemente von Arraylist Highscore wird auf Spalten in JTable aufgeteilt.
 * Datentyp in jeweiliger Spalte wird mit getColumnClass generisch bestimmt.
 */

@SuppressWarnings("serial")
public class Scoretable extends AbstractTableModel{

	@SuppressWarnings("rawtypes")
    private Class[] spaltenKlasse = {String.class, Integer.class};

	@Override
	public int getRowCount() {
		return Highscore.getInstance().size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) return Highscore.getInstance().get(rowIndex).getName();
		if (columnIndex == 1) return Highscore.getInstance().get(rowIndex).getSec();
		return null;
	}
	
	@Override
	public Class<?>getColumnClass(int col){
		return spaltenKlasse[col];
	}
	
	@Override
	public String getColumnName(int index) {
		return index == 0 ? "Name" : "Sekunden";
	}
	
	public void setValueAt() {
		Highscore.getInstance();
	}
	
}