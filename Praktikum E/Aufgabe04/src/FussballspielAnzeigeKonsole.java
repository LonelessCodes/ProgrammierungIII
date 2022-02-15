package Aufgabe04.src;

public class FussballspielAnzeigeKonsole implements FussballspielAnzeige {
	private FussballspielModell model;
	
	public FussballspielAnzeigeKonsole(FussballspielModell m) {
		model = m;
	}
	
	@Override
   public void zeigeIntro() {
		System.out.println("--------------------------------------------------");
		System.out.println("Freundschaftspiel startet zwischen: ");
		System.out.println(model.getNameHeim()+" und "+model.getNameGast());
		System.out.println("--------------------------------------------------");	
	}
	
	@Override
   public void zeigeMinute() {
		System.out.println(model.getAktZeit()+". Minute (Tendenz: "+model.getTendenz()+")");
	}
	
	@Override
   public void zeigeTorchance() {
		System.out.println();
		System.out.println(model.getAktZeit() + ". Minute (Tendenz: "+model.getTendenz()+"):");
		System.out.println("   Chance fuer " + model.getAktMannschaftName() + " ...");
		System.out.println("   " + model.getAktSpielerName() + " zieht ab");
	}
	
	@Override
   public void zeigeTor() {
		System.out.println("   TOR!!!     " + model.getToreHeim() + ":"
				+ model.getToreGast() + " " + model.getAktSpielerName() + "("
				+ model.getAktSpielerTore() + ")");
		System.out.println();
	}
	
	@Override
   public void zeigeParade() {
		System.out.println("   " + model.getAktTorwartName() + " pariert glanzvoll.");
		System.out.println();
	}
	
	@Override
   public void zeigeErgebnis() {
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println("Das Freundschaftsspiel endete:");
		System.out.println(model.getNameHeim()+" "+model.getToreHeim()+":"+model.getToreGast()+" "+model.getNameGast());
		System.out.println("--------------------------------------------------");
	}
}
