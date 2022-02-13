public class Aufgabe12 {
    public static void main(String[] args) throws Exception {
        int n = 20;
        long fac = 1;
        // starte von i = 2, denn 1! ist schon in long fac = 1; gesetzt
        for (int i = 2; i <= n; i++) {
            fac *= i;
        }

        System.out.println("fakultaet(" + n + ") = " + fac);
    }
}
