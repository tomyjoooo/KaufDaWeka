package weka;
import java.util.ArrayList;

public class Daten implements Comparable<Daten>{
	private int wert;
	private String inhalt;
	//private ArrayList<Daten> infos;
	
	
	public Daten(String i, int w) {
		//infos = new ArrayList();
		
		inhalt = i;
		wert = w;
	}
	
	public int compareTo(Daten other) {
	       if(wert < other.wert) return -1;
	       if(wert > other.wert) return 1;
	       return 0;
	}
	
	public int getWert() {
		return wert;
	}
	public void setWert(int wert) {
		this.wert = wert;
	}
	public String getInhalt() {
		return inhalt;
	}
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	
	/*public void addToInfo(Daten data) {
		infos.add(data);
	}*/
	
}
