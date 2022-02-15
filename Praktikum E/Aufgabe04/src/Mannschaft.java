package Aufgabe04.src;

public class Mannschaft {
	private String    name;
	private Trainer   trainer;
	private Torwart   torwart;
	private Spieler[] feldspieler;

	public Mannschaft(String name, Trainer trainer, Torwart torwart, Spieler[] feldspieler) {
	   setName(name);
	   setTrainer(trainer);
	   setTorwart(torwart);
	   setFeldspieler(feldspieler);
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer t) {
		trainer = t;
	}

	public Torwart getTorwart() {
		return torwart;
	}

	public void setTorwart(Torwart tw) {
		torwart = tw;
	}

	public Spieler[] getFeldspieler() {
		return feldspieler;
	}

	public void setFeldspieler(Spieler[] s) {
		feldspieler = s;
	}

	// liefert die durchschnittliche Mannschaftsstaerke
	public double getStaerke() {
		int summ = torwart.getStaerke();
		for (Spieler s : feldspieler)
			summ += s.getStaerke();
		return summ / 11.0;
	}

	// liefert die durchschnittliche Mannschaftsmotivation
	public double getMotivation() {
		int summ = torwart.getMotivation();
		for (Spieler s : feldspieler)
			summ += s.getMotivation();
		return summ / 11.0;
	}
}
