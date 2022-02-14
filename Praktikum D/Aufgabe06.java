public class Aufgabe06 {
    public static double piMadhavaLeibniz(int maxIterationen) {
        double piViertel = 0;
        int vorzeichen = 1;
        for (int i = 1; i <= maxIterationen * 2; i += 2) {
            piViertel += vorzeichen * ((double)1 / i);
            vorzeichen *= -1;
        }
        return 4 * piViertel;
    }

    public static void main(String[] args) {
        int[] durchlauf = { 5, 50, 5000, 50000, 500000, 5000000,
                50000000, 500000000 };
        char[] pi_leibniz, pi_biblio;

        for (int j = 0; j < durchlauf.length; j++) {
            long startZeit = System.currentTimeMillis();
            double piLeibniz = piMadhavaLeibniz(durchlauf[j]);
            long stopZeit = System.currentTimeMillis();

            // Umwandlung der double Werte in char-Arrays
            pi_leibniz = (Double.toString(piLeibniz)).toCharArray();
            pi_biblio = (Double.toString(Math.PI)).toCharArray();

            // Vergleich der beiden Listen und Speichern der Uebereinstimmungen in s
            // s darf nicht ueber das letzte Index in leibniz bzw. biblio uebertreten
            int s = 0;
            int min_length = Math.min(pi_leibniz.length, pi_biblio.length);
            while (s < min_length && pi_leibniz[s] == pi_biblio[s])
                s++;

            // Ausgabe der Iterationsanzahl und benötigter Zeit
            System.out.println("Iterationen: " + durchlauf[j] + " (" + (stopZeit - startZeit) + ") ms");

            // Ausgabe des gemeinsamen Teils
            System.out.println("Genauigkeit: " + (String) (Double.toString(Math.PI)).subSequence(0, s));
            System.out.println();
        }
    }
}
