# Aufgabe E06

```java
int[][] a = {{2,4,6,8}, {1,2,3,}, {3,4,5}};
int[][] b = a;
int[][] c = (int[][]) a.clone();

c[2]    = a[1];
c[2][1] = 6;
b[2][2] = 7;

for (int i = 0; i < a.length; i++)
    a[i][i]++;
```

Ausführen im Kopf:
```java
int[][] a = {{3,4,6,8}, {1,7,3}, {3,4,8}};
int[][] b = a;
int[][] c = {a[0], a[1], a[1]};
```

Lösung:
```java
a[1] == c[1]
 => true

b[2] == c[2]
 => false

a == c
 => false

b[2][2]
 => 8

c[1][1]
 => 7
 
c[2][2]
 => 3
```