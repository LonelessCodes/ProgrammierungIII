# Aufgabe C05

```java
public static boolean[][] falsiere (boolean[][] l) {
    boolean[][] kopie = l.clone();
    for (boolean[] d1 : kopie)
        for (boolean d2 : d1)
            d2 = false;
    return kopie;
}

public static void main (String[] args) {
    boolean[][] a = {{true},{true,false},{false,false}};
    boolean[][] b = falsiere(a);
    boolean c = a == b;
    b[2][1] = true;
    b[1] = a[0];
    boolean d = a[0][0] == b[0][0];
    boolean e = a[2][1] != b[2][1];
    a[0][0] = true;
    boolean f = b[1][0] != b[2][0];
}
```

Belegungen:

```java
// falsiere() macht eigentlich gar nichts

boolean c = false;  // Da unterschiedliche Referenzen!
boolean d = true;   // Da a und b identisch und gleiche Indizes
boolean e = false;  // Da gleiche Indizes -> gleiche Werte
boolean f = true;   // Da Werte unterschiedlich
```
