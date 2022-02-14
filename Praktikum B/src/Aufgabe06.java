package src;

public class Aufgabe06 {
    public static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static char toLowerCase(char ch) {
        if (ch < 'A' || ch > 'Z') return ch;

        return (char) (ch + ('a' - 'A'));
    }

    public static void main(String[] args) {
        for (int i = 33; i < 127; i++) {
            for (int j = 33; j < 127; j++) {
                char symbol1 = (char)i;
                char symbol2 = (char)j;

                if (isUpperCase(symbol1) && (symbol2 == toLowerCase(symbol1))) {
                    System.out.println(
                        "Symbol " + symbol1 + " [" + i +
                        "] und Symbol " + symbol2 + " [" + j +
                        "] sind ein Paar."
                    );
                }
            }
        }

        // Überprüfung
        for (int i = 1; i < 127; i++) {
            char symbol = (char)i;
            if (Character.isUpperCase(symbol) != isUpperCase(symbol)) {
                System.out.println(
                    i + ": Funktionen sind nicht gleich. Character.isUpperCase(ch) = " +
                    Character.isUpperCase(symbol) + " ; isUpperCase(ch) = " + isUpperCase(symbol)
                );
            }
        }
    }
}
