/**
 * Game of Life ohne Rand
 */

public class Aufgabe08 {
	// global definierte Konstanten fUer die Dimensionen
	final static int DIMENSION_X = 10;
	final static int DIMENSION_Y = 10;

	// liefert eine zufUellig initialisierte Welt
	public static boolean[][] initWelt() {
		boolean[][] welt = new boolean[DIMENSION_Y][DIMENSION_X];

		// Variante 1: Wir wollen alle EintrUege der Matrix
		// mit true oder false beschreiben
		for (int y = 0; y < DIMENSION_Y; y++) {
			for (int x = 0; x < DIMENSION_X; x++) {
				welt[x][y] = Math.random() > 0.5; // 50% lebendig
			}
		}

		return welt;
	}

	// gibt die aktuelle Welt aus
	public static void zeigeWelt(boolean[][] welt) {
		for (int y = 0; y < DIMENSION_Y; y++) {
			for (int x = 0; x < DIMENSION_X; x++) {
				System.out.print(welt[x][y] ? "X" : " ");
			}
			System.out.println();
		}
	}

	// wir zUehlen die Anzahl der Nachbarn von Zelle[x][y] in der Welt
	public static int anzNachbarn(boolean[][] welt, int x, int y) {
		int ret = 0;
		for (int i = (x - 1); i <= (x + 1); i++) {
			if (i < 0 || i >= DIMENSION_X) {
				continue;
			}

			for (int j = (y - 1); j <= (y + 1); j++) {
				if (j < 0 || j >= DIMENSION_Y) {
					continue;
				}
				ret += welt[i][j] ? 1 : 0;
			}
		}

		// einen zuviel mitgezaehlt?
		if (welt[x][y]) {
			ret -= 1;
		}

		return ret;
	}

	// wendet die 4 Regeln an und gibt die
	// Folgegeneration wieder zurUeck
	public static boolean[][] wendeRegelnAn(boolean[][] welt) {
		boolean[][] weltNeu = new boolean[DIMENSION_Y][DIMENSION_X];
		int nachbarn;

		// Damit mUessen wir jetzt nur noch die lebendigen Zellen
		// bestimmen:
		for (int y = 0; y < DIMENSION_Y; y++) {
			for (int x = 0; x < DIMENSION_X; x++) {
				nachbarn = anzNachbarn(welt, x, y);
				weltNeu[x][y] = (welt[x][y] && (nachbarn == 2)) || (nachbarn == 3);
			}
		}

		return weltNeu;
	}

	public static void main(String[] args) {
		boolean[][] welt = initWelt();

		System.out.println("Startkonstellation");
		zeigeWelt(welt);

		for (int i = 1; i <= 20; i++) {
			welt = wendeRegelnAn(welt);
			System.out.println("Generation " + i);
			zeigeWelt(welt);
		}
	}
}
