package src;

import java.io.*;
import java.util.Scanner;

public class Aufgabe09 {
    public static char haeufigstesSymbol(String text) {
        char[] zeichen = text.toCharArray();
        int[] haeufigste = new int[128]; // Index ist Charaktercode

        char maxSymbol = 0;

        for (int i = 0; i < zeichen.length; i++) {
            haeufigste[zeichen[i]]++;
            if (haeufigste[zeichen[i]] > haeufigste[maxSymbol]) maxSymbol = zeichen[i];
        }

        return maxSymbol;
    }

    public static String readFile(String filepath) throws IOException {
        // notwendige Programme zum Ein- und Auslesen
        StringBuilder resultStringBuilder = new StringBuilder();

        Scanner scanner = new Scanner(new File(filepath));
        while (scanner.hasNextLine()) {
            resultStringBuilder.append(scanner.nextLine()).append("\n");
        }
        scanner.close();

        return resultStringBuilder.toString();
    }

    public static void main(String[] args) {
        // zu lesende Datei
        String dateiIn = args[0];

        try {
            char maxSymbol = haeufigstesSymbol(readFile(dateiIn));
            System.out.println("Haeufigstes Symbol ist >" + maxSymbol + "<");
        } catch (IOException eIO) {
            eIO.printStackTrace();
        }
    }
}
