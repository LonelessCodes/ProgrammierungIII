# Aufgabe D01

```java
public static double sum1() {
    int i, startwert = 1;
    double d, h;
    for (i=--startwert; i>100; i++)
        System.out.println(d);
        {h=(i*i*i)/2;
        d=d+h;
    }
    return d;
}
```

In der Schleife wird nur `System.out.println(d);` ausgeführt, da man sich mit dem Code-Block vertippt hat. Zudem wird der Wert von d gelesen, bevor d mit einem Wert initialisiert wird. Das gibt möglicherweise unerwartetes Verhalten und einen Compiler-Fehler.