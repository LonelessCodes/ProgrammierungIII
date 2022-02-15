package Aufgabe04.src;

import java.io.FileNotFoundException;

public class Fussballspiel {
	private FussballspielModell   modell  = null;
	private FussballspielAnzeige  anzeige = null;
	private enum Anzeige {KONSOLE, FENSTER};
	
	public Fussballspiel(Anzeige v) {
		modell = new FussballspielModell();
		switch (v) {
			case KONSOLE:
				anzeige  = new FussballspielAnzeigeKonsole(modell);
				break;
			case FENSTER:
				anzeige  = new FussballspielAnzeigeFenster(modell);
				break;
			default:
				System.exit(0);
		}
	}
	
	public static void warte(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void starteSpiel(String m1, String m2) throws FileNotFoundException {
		modell.initSpiel(m1, m2);
		anzeige.zeigeIntro();
		warte(1000);
		
		while (modell.getSpielLaeuft()) {
			if (modell.aktTendenz()) {
				anzeige.zeigeTorchance();
				warte(1500);
				if (modell.torschussErfolgreich())
					anzeige.zeigeTor();
				else 
					anzeige.zeigeParade();
				warte(1500);
				modell.resetTendenz();
			} else 
				anzeige.zeigeMinute();
			warte(800);
		}
		warte(1500);
		modell.resetTendenz();
		anzeige.zeigeErgebnis();
	}
	
	public static void main(String[] args) {
		Fussballspiel fc = new Fussballspiel(Anzeige.KONSOLE);

		try {
			fc.starteSpiel("Aufgabe04/teams/wm_2006_deutschland.txt", "Aufgabe04/teams/wm_2006_brasilien.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
