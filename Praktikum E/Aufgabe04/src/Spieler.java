package Aufgabe04.src;

public class Spieler extends Person {
	private byte staerke;    // von 1 (schlecht) bis 10 (weltklasse)
	private byte torschuss;  // von 1 (schlecht) bis 10 (weltklasse)
	private byte motivation; // von 1 (schlecht) bis 10 (weltklasse)
	private int  tore;
	
	// Konstruktor
	public Spieler(String n, int a, int s, int t, int m) {
		super(n, a);
		staerke    = (byte)s;
		torschuss  = (byte)t;
		motivation = (byte)m;
		tore       = 0;
	}
	
	public String mannschaftsPosition() {
		return "Feldspieler";
	}
	
	// get- und set-Methoden
	public byte getStaerke() {
		return staerke;
	}

	public void setStaerke(int s) {
		staerke = (byte)s;
	}
	
	public byte getTorschuss() {
		return torschuss;
	}

	public void setTorschuss(int t) {
		torschuss = (byte)t;
	}
	
	public byte getMotivation() {
		return motivation;
	}

	public void setMotivation(int m) {
		motivation = (byte)m;
	}
	
	public int getTore() {
		return tore;
	}
	
	// Spielerfunktionen
	public void addTor() {
		tore++;
	}

	// In Abh�ngigkeit zur Torschussqualit�t des Spielers wird 
	// mit einem kleinen Zufallswert (kann um [+1,0,-1,-2] abweichen)  
	// ein Schuss aus dem Intervall [1, 10] erzeugt
	public int schiesstAufsTor() {
		int varianz   = (int)(Math.random()*4) - 2; // [+1,0,-1,-2]
		int aktSchuss = torschuss + varianz;
		
		// anschlie�end m�ssen wir die Intervallr�nder 1 und 10 wieder 
		// �berpr�fen
		aktSchuss = Math.min(10, aktSchuss);  // oberer Bereich gepr�ft
		aktSchuss = Math.max( 1, aktSchuss);  // unterer Bereich gepr�ft
		
		return aktSchuss;
	}
}
