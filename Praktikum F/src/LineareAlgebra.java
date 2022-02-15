package src;

public class LineareAlgebra {
    private LineareAlgebra() {}

    // Getters
    static public double length(Vektor2D vec) {
        double x = vec.getX();
        double y = vec.getY();
        return Math.sqrt(x * x + y * y);
    }
    static public Vektor2D normalize(Vektor2D vec) {
        double x = vec.getX();
        double y = vec.getY();
        if (x > y) {
            return new Vektor2D(1.0, y / x);
        } else {
            return new Vektor2D(x / y, 1.0);
        }
    }

    // Arithmetic
    static public Vektor2D add(Vektor2D a, Vektor2D b) {
        return new Vektor2D(a.getX() + b.getX(), a.getY() + b.getY());
    }
    static public Vektor2D sub(Vektor2D a, Vektor2D b) {
        return new Vektor2D(a.getX() - b.getX(), a.getY() - b.getY());
    }
    static public Vektor2D mult(Vektor2D a, Vektor2D b) {
        return new Vektor2D(a.getX() * b.getX(), a.getY() * b.getY());
    }
    static public Vektor2D div(Vektor2D a, Vektor2D b) {
        return new Vektor2D(a.getX() / b.getX(), a.getY() / b.getY());
    }

    // Compare
    static public boolean isEqual(Vektor2D a, Vektor2D b) {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }
    static public boolean isNotEqual(Vektor2D a, Vektor2D b) {
        return !a.isEqual(b);
    }

    // Show
    static public void show(Vektor2D vec) {
        System.out.println("Vektor2D { " + vec.getX() + " , " + vec.getY() + " }");
    }
}
