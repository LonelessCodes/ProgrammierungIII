public class Aufgabe11 {
    public static double a(double x) {
        return x;
    }

    public static double b(double x) {
        return ((double)x * x / 2) + (17 * 2);
    }

    public static double c(double x) {
        return (Math.pow(x - 1, 3) - 14) / 2;
    }

    public static void main(String[] args) throws Exception {
        double x = Math.random() * 100;

        System.out.println("f1(" + x + ") = " + a(x));
        System.out.println("f2(" + x + ") = " + b(x));
        System.out.println("f3(" + x + ") = " + c(x));
    }
}
