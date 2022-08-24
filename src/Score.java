/* Erzeugt Object Score
 * Die beiden Mehtoden liefern Attribute von Score zurück.
 */
public class Score {
	
	private String name;
	private int sec;
	
	public Score(String name, int sec) {
		this.name = name;
		this.sec = sec;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSec() {
		return sec;
	}

}
