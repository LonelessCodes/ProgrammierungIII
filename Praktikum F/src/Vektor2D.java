package src;

public class Vektor2D {
    private double[] arr;

    // Create
    public Vektor2D(double x, double y) {
        arr = new double[]{x, y};
    }
    public Vektor2D(Vektor2D vec) {
        arr = new double[]{vec.getX(), vec.getY()};
    }

    // Get
    public double getX() {
        return arr[0];
    }
    public double getY() {
        return arr[1];
    }
    public double length() {
        double x = this.getX();
        double y = this.getY();
        return Math.sqrt(x * x + y * y);
    }
    public Vektor2D normalize() {
        double x = this.getX();
        double y = this.getY();
        if (x > y) {
            return new Vektor2D(1.0, y / x);
        } else {
            return new Vektor2D(x / y, 1.0);
        }
    }
    public boolean isNullVektor() {
        return arr[0] == (double)0 && arr[1] == (double)0;
    }

    // Arithmetic
    public Vektor2D add(Vektor2D a, Vektor2D b) {
        return new Vektor2D(a.getX() + b.getX(), a.getY() + b.getY());
    }
    public Vektor2D sub(Vektor2D a, Vektor2D b) {
        return new Vektor2D(a.getX() - b.getX(), a.getY() - b.getY());
    }
    public Vektor2D mult(Vektor2D a, Vektor2D b) {
        return new Vektor2D(a.getX() * b.getX(), a.getY() * b.getY());
    }

    // Compare
    public boolean isEqual(Vektor2D vec) {
        return this.getX() == vec.getX() && this.getY() == vec.getY();
    }
    public boolean isNotEqual(Vektor2D vec) {
        return !this.isEqual(vec);
    }

    // Show
    public void show() {
        System.out.println("Vektor2D { " + this.getX() + " , " + this.getY() + " }");
    }
}
