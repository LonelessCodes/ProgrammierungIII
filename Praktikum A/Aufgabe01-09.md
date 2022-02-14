# Aufgabe 01

    a) 2F + A2 = 31 + A0 = D0 = (13 * 2)10 = (208)10
    b) 07 + FF = 106 = (262)10
    c) FE - A4 = FA - A0 = 5A = (90)10

# Aufgabe 02

Lass ich mal aus

# Aufgabe 03

* gültig: erne$sto, blablubs, Class
* ungültig: $eins, _abc123, #hallihallo, const, int, 1a, k_l-e_i-n, %nummer, klasse !wahr, final

# Aufgabe 04

a=b ist eine Zuweisung von b auf a und a==b vergleicht die beiden Werten in a und b.

# Aufgabe 05

    a) byte
    b) char
    c) boolean oder ENUM
    d) double (wird nur unpräzise in den Milliarden)
    e) int
    f) double

# Aufgabe 06

```java
boolean b1 = false, b2 = false;
boolean c = (b1 && b2) || !b2;
```

## Korrektur:

```java
boolean cFunction(boolean b1, boolean b2) {
    return (b1 && b2) || !b2;
}
```

# Aufgabe 07

```java
c = true
d = false
e = false
f = true
g = false
```

# Aufgabe 08

Bei Typumwandlungen kann es zu Datenverlust kommen, wenn der ursprungsdatentyp kleiner ist als der Zieldatentyp. Implizite Typumwandlungen geschehen automatisch, ohne Zutuen des Programmierenden, explizite werden direkt/explizit vom Programmierenden angewiesen (in Java mit `(typ)` vor dem Wert).

# Aufgabe 09

* while: Wollen Sie eine Schleife so lange ausführen, wie ein bestimmter Ausdruck oder Wert `true` ist, nehmen Sie die `while`-Schleife.

    ```java
    // gib bei jeder Eingabe "Hello World" aus, bis das Programm mit "q" beendet wird
    while ((char) System.in.read() != 'q') {
        System.out.println("Hello World");
    }
    ```

* do while: Wollen Sie eine Schleife, die immer einmal ausgeführt wird und danach erst die Schleifenbedingung vor jeder Iteration evaluiert wird, nehmen Sie die `do while`-Schleife.

    ```java
    char ch;
    do {
        // Muss immer mindestens einmal ausgeführt werden, um den Nutzer aufzufordern Input einzugeben
        System.out.println("Willst du weiter nichts tun? (y/n)");
        ch = (char) System.in.read();
    } while (ch != 'n');
    System.out.println("Dann ran an die Übungsaufgaben!");
    ```

* for: Wenn Sie eine bestimmte Anzahl an Iterationen ausführen wollen und alles Notwendige dafür in einer Zeile zusammengefasst haben wollen, ist die `for`-Schleife das Beste für Sie! Im Schleifenkopf lassen sich Variablen erstellen, die nur für den Schleifenkörper gültig sind, Schleifenbedingungen festlegen, sowie Ausdrücke, die nach jeder Iteration evaluiert werden.

    ```java
    // Gib das Quadrat aller Zahlen bis 10 aus
    for (int x = 0; x <= 10; x++) {
        System.out.println("x = %d, x^2 = %d", x, x * x);
    }
    ```

* for each: Müssen Sie über alle Elemente in einer Array iterieren? Probieren Sie die `for each`-Schleife!

    ```java
    String array[] = { "Ron", "Harry", "Hermoine" }; 

    // enhanced for loop 
    for (String x : array) { 
        System.out.println(x); 
    }
    ```
