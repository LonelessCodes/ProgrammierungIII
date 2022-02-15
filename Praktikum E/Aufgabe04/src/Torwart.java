package Aufgabe04.src;

public class Torwart extends Spieler {
	private byte reaktion;        // von 1 (schlecht) bis 10 (weltklasse)

	// Konstruktor
	public Torwart(String name, int alter, int staerke, int torschuss, int motivation, int reaktion) {
		super(name, alter, staerke, torschuss, motivation);
		setReaktion(reaktion);
	}
	
	@Override
   public String mannschaftsPosition() {
		return "Torwart";
	}

	// get- und set-Methoden
	public byte getReaktion() {
		return reaktion;
	}

	public void setReaktion(int r) {
		reaktion = (byte)r;
	}

	// Torwartfunktionen

	// Als Parameter erh�lt der Torwart die Torschussst�rke des 
	// abgegebenen Schusses und nun muss in Abh�ngigkeit des
	// Reaktionsverm�gens (und einer kleinen Varianz von [+1,0,-1]
	// entschieden werden, ob der Torwart den Ball h�lt. Der Schuss
	// gilt als gehalten, wenn die aktuelle Reaktion mindestens
	// so gut wie der Schuss ist
	public boolean pariertTorschuss(int aktSchuss) {
		int varianz     = (int)(Math.random()*3) - 1; // [+1,0,-1]
		int aktReaktion = reaktion + varianz;

		return (aktReaktion >= aktSchuss);
		
		// oder als Einzeiler
		// return (reaktion + (int)(Math.random()*3) - 1 >= aktSchuss);
	}
}
