/**
 * java -ea Aufgabe03
 */

public class Aufgabe03 {
    public static int[] addVektoren(int[] a, int[] b) throws IllegalArgumentException {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Beide Vektoren müssen den vom gleichen Grad sein.");
        }

        int[] z = a.clone();
        for (int i = 0; i < b.length; i++) {
            z[i] += b[i];
        }

        return z;
    }

    public static void zeigeVektor(int[] a) throws IllegalArgumentException {
        assert a != null: "Vektor darf nicht null sein.";

        System.out.print("{ ");
        for (int elem : a) {
            System.out.print(elem + " ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };  // funktionierendes Beispiel
        int[] b = { 4, 5, 6 };
        zeigeVektor(a);
        zeigeVektor(b);
        int[] c = addVektoren(a, b);
        zeigeVektor(c);

        int[] d = { 1, 2 };     // fehlerhaftes Beispiel
        int[] e = { 4, 5, 6 };
        zeigeVektor(d);
        zeigeVektor(e);
        int[] f = addVektoren(d, e);
        zeigeVektor(f);
    }
}
