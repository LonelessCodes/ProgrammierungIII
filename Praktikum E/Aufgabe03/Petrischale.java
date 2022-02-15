package Aufgabe03;

public class Petrischale {
    private int dim_y;
    private int dim_x;

    private Zelle[][] welt;

    public Petrischale(int dim_y, int dim_x, float lebendigkeitswahrscheinlichkeit) {
        this.dim_y = dim_y;
        this.dim_x = dim_x;

        this.welt = new Zelle[dim_y][dim_x];
        for (int y = 0; y < dim_y; y++) {
            for (int x = 0; x < dim_x; x++) {
                this.welt[y][x] = new Zelle(Math.random() < lebendigkeitswahrscheinlichkeit);
            }
        }
    }

    public int getDimY() {
        return dim_y;
    }
    public int getDimX() {
        return dim_x;
    }

	// wir zUehlen die Anzahl der Nachbarn von Zelle[x][y] in der Welt
	public int anzNachbarn(int pos_x, int pos_y) {
		int ret = 0;
		for (int i = (pos_x - 1); i <= (pos_x + 1); i++) {
			if (i < 0 || i >= dim_x) {
				continue;
			}

			for (int j = (pos_y - 1); j <= (pos_y + 1); j++) {
				if (j < 0 || j >= dim_y) {
					continue;
				}
				ret += welt[i][j].lebendig ? 1 : 0;
			}
		}

		// einen zuviel mitgezaehlt?
		if (welt[pos_x][pos_y].lebendig) {
			ret -= 1;
		}

		return ret;
	}

	// wendet die 4 Regeln an und gibt die
	// Folgegeneration wieder zurUeck
    public void neueGeneration() {
		Zelle[][] weltNeu = new Zelle[dim_y][dim_x];
		int nachbarn;

		// Damit mUessen wir jetzt nur noch die lebendigen Zellen
		// bestimmen:
		for (int y = 0; y < dim_y; y++) {
			for (int x = 0; x < dim_x; x++) {
				nachbarn = anzNachbarn(x, y);
				weltNeu[x][y] = new Zelle((welt[x][y].lebendig && (nachbarn == 2)) || (nachbarn == 3));
			}
		}

        welt = weltNeu;
    }

	// gibt die aktuelle Welt aus
    public String toString() {
        StringBuffer strings = new StringBuffer();
		for (int y = 0; y < dim_y; y++) {
			for (int x = 0; x < dim_x; x++) {
				strings.append(welt[x][y].lebendig ? "O " : "  ");
			}
            // Gib am Ende der letzten Zeile kein \n aus
			if (y < dim_y - 1) strings.append("\n");
		}
        return strings.toString();
    }
}
