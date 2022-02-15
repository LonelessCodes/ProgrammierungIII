package Aufgabe03;

/**
 * Game of Life ohne Rand
 */

public class GameOfLife {
	// global definierte Konstanten fUer die Dimensionen
	final static int DIMENSION_X = 10;
	final static int DIMENSION_Y = 10;

	public static void main(String[] args) {
		Petrischale petri = new Petrischale(DIMENSION_Y, DIMENSION_X, 0.3f);

		System.out.println("Startkonstellation");
		System.out.println(petri.toString());

		for (int i = 1; i <= 20; i++) {
			petri.neueGeneration();
			System.out.println("Generation " + i);
			System.out.println(petri.toString());
		}
	}
}
