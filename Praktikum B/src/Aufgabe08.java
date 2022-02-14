package src;

import java.io.*;
import java.util.Scanner;

public class Aufgabe08 {
    public static String decode(String text, int offset) {
        char[] zeichen = text.toCharArray();

        for (int i = 0; i < zeichen.length; i++) {
            zeichen[i] = (char)(zeichen[i] - offset);
        }

        return new String(zeichen);
    }

    public static void main(String[] args) {
        // zu lesende Datei
        String dateiIn = args[0];
        // zu speichernde Datei
        String dateiAus = args[1];

        // geheimer Schlüssel wird in eine Zahl umgewandelt
        // damit wir im ASCII-Satz bleiben
        int offset = Integer.parseInt(args[2]) % 256;

        try {
            // notwendige Programme zum Ein- und Auslesen
            Scanner scanner = new Scanner(new File(dateiIn));
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(dateiAus, false));

            while (scanner.hasNextLine()) {
                myWriter.write(decode(scanner.nextLine(), offset) + "\n");
            }

            myWriter.close();
            scanner.close();
        } catch (IOException eIO) {
            eIO.printStackTrace();
        }
    }
}