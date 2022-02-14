# Aufgabe D02

`c = c++` gibt den Wert von c vor dem Inkrementieren ein, da der Postfix-Operator `++` erst am Ende des Code-Statements ausgeführt wird. TLDR Hat keine Auswirkung
`c = ++c` gibt `c + 1`, weil der Prefix-Operator `++` die Variable vor der Ausgabe inkrementiert.

```java
public class Aufgabe02 {
    public static void main(String[] args) {
        int c = 10, d = 10;

        for (int i = 0; i < 100000; i++) {
            c = c++;
            d = ++d;
            System.out.printf("c: %d , d: %d\n", c, d);
        }
    }
}
```
