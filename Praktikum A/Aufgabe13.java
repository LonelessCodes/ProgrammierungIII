public class Aufgabe13 {
    public static long a() {
        long sum = 0;
        for (int i = 0; i <= 28; i++) {
            sum += Math.pow(i - 1, 2);
        }
        return sum;
    }

    public static double b() {
        double sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += (double)(i * (i + 1)) / 2;
        }
        return sum;
    }

    public static double c() {
        double sum = 0;
        for (int i = 1; i <= 25; i++) {
            sum += (double)(i + 1) / i;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("a() = " + a());
        System.out.println("b() = " + b());
        System.out.println("c() = " + c());
    }
}
