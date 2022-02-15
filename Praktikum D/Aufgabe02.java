public class Aufgabe02 {
    public static void main(String[] args) {
        int c = 10, d = 10;

        for (int i = 0; i < 100000; i++) {
            c = c++;
            // Java gibt falsche Warnung aus. Eigentlich ist c = c++; der
            // Ausdruck, der keine Wirkung hat und d = ++d; hat eine Wirkung.
            // Der Linter sagt aber, dass d = ++d; keine Wirkung hätte.
            d = ++d;
            System.out.printf("c: %d , d: %d\n", c, d);
        }
    }
}
