package Aufgabe04.src;

public class Trainer extends Person {
	// Eigenschaften eines Trainers
	private byte erfahrung;      // von 1 (schlecht) bis 10 (weltklasse)

	public Trainer(String n, int a, int e) {
		super(n, a);
		erfahrung = (byte)e;
	}
	
	public String mannschaftsPosition() {
		return "Trainer";
	}
	   
	// get- und set-Methoden
	public byte getErfahrung() {
		return erfahrung;
	}

	public void setErfahrung(int e) {
		erfahrung = (byte)e;
	}
	
	@Override
   public boolean equals(Object obj) {
		if (obj instanceof Trainer) {
			Trainer t = (Trainer)obj;
			return (t.getAlter() == getAlter() &&
					t.getErfahrung() == getErfahrung() &&
					t.getName() == getName());
		}
		return false;
	}

	@Override
   public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Trainer: ");
		sb.append(getName() + " (");
		sb.append(getAlter() + " Jahre, Erfahrung ");
		sb.append(getErfahrung() + ")");
		return sb.toString();
	}
}

