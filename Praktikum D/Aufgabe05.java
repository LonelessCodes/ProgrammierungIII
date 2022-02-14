public class Aufgabe05 {
    public static double wallisProdukt(int iterations) {
        double pi = 2.0f;

        for (int i = 1; i < iterations; i++) {
            System.out.println(i + " \t" + pi);
            pi *= (double)(4 * i * i) / ((2 * i - 1) * (2 * i + 1));
        }

        return pi;
    }

    public static double newtonSumme(int iterations) {
        double pi = 0;
        int vorzeichen = 1;

        for (int i = 1; i < iterations * 2; i += 2) {
            System.out.printf("%d \t%2d  %f\n", i, vorzeichen, pi);

            pi += (double)vorzeichen * ((double)1.0f / i);

            if (i % 4 == 3) vorzeichen *= -1; // Wechsle jede zwei Iterationen das Vorzeichen
        }

        return pi * 2 * Math.sqrt(2);
    }

    public static double eulerSumme(int iterations) {
        double pi = 0;
        int vorzeichen = 1;

        for (int i = 1; i < iterations * 1.5; i++) {
            for (int j = 0; j < 2; j++, i++) {
                System.out.printf("%d \t%2d  %f\n", i, vorzeichen, pi);

                pi += (double)vorzeichen * ((double)1.0f / i);
                vorzeichen *= -1; // Wechsle jede Iteration das Vorzeichen
            }
        }

        return pi * 3 * Math.sqrt(3);
    }

    public static void main(String[] args) {
        int iterations = 10000;

        double wallisPi = wallisProdukt(iterations);
        double newtonPi = newtonSumme(iterations);
        double eulerPi = eulerSumme(iterations);

        System.out.println("Wallis-Produkt: \tPi ist ~ " + wallisPi);
        System.out.println("Newton:         \tPi ist ~ " + newtonPi);
        System.out.println("Euler:          \tPi ist ~ " + eulerPi);
        
    }
}
