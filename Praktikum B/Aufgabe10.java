public class Aufgabe10 {
    public static String auffuellen(String text, int key) {
        String textAufgefuellt = new String(text);
        int rest = text.length() % key;
        for (int i = 0; i < rest; i++) {
            textAufgefuellt += " ";
        }
        return textAufgefuellt;
    }

    public static String codiere(String text, int key) {
        String skytaleBand = "";
        for (int i = 0; i < key; i++) {
            for (int j = 0; i + j < text.length(); j += key) {
                skytaleBand += text.charAt(i + (j));
            }
        }

        return skytaleBand;
    }

    public static String decodiere(String text, int key) {
        int keyProTextAufgerundet = (int) (text.length() / (double) key + 0.5);

        String skytaleBand = "";
        for (int i = 0; i < keyProTextAufgerundet; i++)
            for (int j = 0; i + j < text.length(); j += keyProTextAufgerundet)
                skytaleBand += text.charAt(i + j);

        return skytaleBand;
    }

    public static void test(String text, int key) {
        System.out.println(text);

        String textAufgefuellt = auffuellen(text, key);

        String textCodiert = codiere(textAufgefuellt, key);
        System.out.println(textCodiert);

        String textDecodiert = decodiere(textCodiert, key);
        System.out.println(textDecodiert);
    }

    public static void main(String[] args) {
        int key = 3;
        String text = "Das vorliegende Buch ist ein Einsteigerbuch " +
                      "und f�r jeden geeignet, der das Programmieren mit " +
                      "der Sprache Java erlernen m�chte. Es ist Teil des " +
                      "didaktischen Konzepts, einige Hinweise doppelt oder " +
                      "sogar dreifach zu erw�hnen, wenn die Wiederholung " +
                      "dem besseren Verst�ndnis dient. Wir werden in vielen " +
                      "Programm�bungen gemeinsam Fehler machen und diese " +
                      "dann analysieren und korrigieren.";
        test(text, key);

        String text2 = "0123456789";
        test(text2, key);
    }
}
