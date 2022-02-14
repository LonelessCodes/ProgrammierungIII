public class Aufgabe02 {
    public static void main(String[] args) {
        int c = 10, d = 10;

        for (int i = 0; i < 100000; i++) {
            c = c++;
            d = ++d;
            System.out.printf("c: %d , d: %d\n", c, d);
        }
    }
}
