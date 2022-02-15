package Aufgabe04.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FussballspielModell {
	private Mannschaft heim, gast;
	private byte toreHeim, torSchuesseHeim;
	private byte toreGast, torSchuesseGast;
    private byte spieldauer, aktZeit, tendenz;
    private final byte TENDENZ_MAX = 10;
    private boolean spielLaeuft;
    
    private Mannschaft aktMannschaft;
    private Spieler    aktSpieler;
    private Torwart    aktTorwart;
    
	public void initSpiel(String m1, String m2) throws FileNotFoundException {
		heim = liesMannschaftEin(m1);
		gast = liesMannschaftEin(m2);
		
		toreHeim 		= 0;
		toreGast 		= 0;
		torSchuesseHeim = 0;
		torSchuesseGast = 0;
		aktMannschaft 	= null;
		aktSpieler    	= null;
		aktTorwart    	= null;
		spielLaeuft   	= false;
		spieldauer    	= 0;
		tendenz       	= 0;
		
		spielLaeuft = true;
		spieldauer  = (byte)(90 + (byte)(Math.random()*5)); // Nachspielzeit m�glich
	}
	
	public String getNameHeim() {
		return heim.getName();
	}
	
	public String getNameGast() {
		return gast.getName();
	}
	
	public double getStaerkeHeim() {
		return heim.getStaerke();
	}
	
	public double getStaerkeGast() {
		return gast.getStaerke();
	}
	
	public double getMotivationHeim() {
		return heim.getMotivation();
	}
	
	public double getMotivationGast() {
		return gast.getMotivation();
	}
	
	public String getTrainerHeim() {
		return heim.getTrainer().getName();
	}
	
	public String getTrainerGast() {
		return gast.getTrainer().getName();
	}
	
	public int getToreHeim() {
		return toreHeim;
	}
	
	public int getToreGast() {
		return toreGast;
	}
	
	public int getTorschuesseHeim() {
		return torSchuesseHeim;
	}
	
	public int getTorschuesseGast() {
		return torSchuesseGast;
	}

	public String getAktSpielerName() {
		return aktSpieler.getName();
	}
	
	public int getAktSpielerTore() {
		return aktSpieler.getTore();
	}
	
	public String getAktTorwartName() {
		return aktTorwart.getName();
	}
	
	public String getAktMannschaftName() {
		return aktMannschaft.getName();
	}
	
	public byte getAktZeit() {
		return aktZeit;
	}
	
	public boolean getSpielLaeuft() {
		return spielLaeuft;
	}
	
	public byte getSpieldauer() {
		return spieldauer;
	}
	
	// Liefert tendenz prozentual mit Vorzeichen (-100 bis 100)
	public byte getTendenz() {
		byte val = (byte)(Math.min(TENDENZ_MAX, Math.max(-TENDENZ_MAX, tendenz)));
		return (byte)((val*100.0)/TENDENZ_MAX);
	}
	
	public void resetTendenz() {
		tendenz = 0;
	}
	
	private Mannschaft liesMannschaftEin(String dateiName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(dateiName));
		String zeile = null;
		int anzZeilen = 0;
		String name  = null;
		Trainer t    = null;
		Torwart tw   = null;
		Spieler[] sp = new Spieler[10];
		
		while (scanner.hasNextLine()) {
			zeile = scanner.nextLine();
			anzZeilen++;
			
			// Mannschaftsname auslesen
			if (anzZeilen == 1) {
				name = zeile;
				continue;
			}
			
			// Trainer, Torwart und Spieler auslesen
			String[] worte = zeile.split(", ");
			if (anzZeilen == 2) {
				// Trainer einlesen
				t = new Trainer(worte[0], 
						Integer.parseInt(worte[1]), 
						Integer.parseInt(worte[2]));
			} else if (anzZeilen == 3) {
				// Torwart einlesen
				tw = new Torwart(worte[0], 
						Integer.parseInt(worte[1]), 
						Integer.parseInt(worte[2]),
						Integer.parseInt(worte[3]),
						Integer.parseInt(worte[4]),
						Integer.parseInt(worte[5]));
			} else {
				// Spieler einlesen
				sp[anzZeilen-4] = new Spieler(worte[0], 
						Integer.parseInt(worte[1]), 
						Integer.parseInt(worte[2]),
						Integer.parseInt(worte[3]),
						Integer.parseInt(worte[4]));
			}
		}
		scanner.close();
		return new Mannschaft(name, t, tw, sp);
	}
	
	public boolean torschussErfolgreich() {
		if (!aktTorwart.pariertTorschuss(aktSpieler.schiesstAufsTor())) {
			aktSpieler.addTor();
			if (aktMannschaft == heim)
				toreHeim++;
			else
				toreGast++;
			aktZeit+=2;						
			return true;
		} 
		aktZeit++;
		return false;
	}
	
	public boolean aktTendenz() {
		aktZeit++;
		
		if (aktZeit >= spieldauer) {
			spielLaeuft = false;
			return false;
		}
			
		double m1 = 0.8  * heim.getStaerke()    + 
				    0.15 * heim.getMotivation() + 
				    0.05 * heim.getTrainer().getErfahrung();
		double m2 = 0.8  * gast.getStaerke()    + 
				    0.15 * gast.getMotivation() + 
				    0.05 * gast.getTrainer().getErfahrung();
		
		tendenz += (byte)(Math.random() * (m1+m2) - m1);
		
		if (tendenz<=-TENDENZ_MAX) {
			// Heimmannschaft erh�lt die Torschussm�glichkeit
			aktMannschaft = heim;
			aktSpieler    = heim.getFeldspieler()[(int)(Math.random()*10)];
			aktTorwart    = gast.getTorwart();
			torSchuesseHeim++;
			return true;
		} else if (tendenz>=TENDENZ_MAX){
			// Gastmannschaft erh�lt die Torschussm�glichkeit
			aktMannschaft = gast;
			aktSpieler    = gast.getFeldspieler()[(int)(Math.random()*10)];
			aktTorwart    = heim.getTorwart();
			torSchuesseGast++;
			return true;
		}
		return false;
	}
}