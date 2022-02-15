package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.LineareAlgebra;
import src.Vektor2D;

public class LineareAlgebraTest {
    @Test
    public void testIsEqual() {
        Vektor2D a = new Vektor2D(2.0, 100.5);
        Vektor2D b = new Vektor2D(2.0, 100.5);

        assertTrue(LineareAlgebra.isEqual(a, b));
        assertTrue(LineareAlgebra.isEqual(b, a));

        b = new Vektor2D(2.0, 10013.5);

        assertFalse(LineareAlgebra.isEqual(a, b));
        assertFalse(LineareAlgebra.isEqual(b, a));
    }

    @Test
    public void testLength() {
        Vektor2D vec = new Vektor2D(2.0, 0.0);
        assertEquals(2.0, LineareAlgebra.length(vec), 0.0);

        vec = new Vektor2D(-2.0, 0.0);
        assertEquals(2.0, LineareAlgebra.length(vec), 0.0);

        vec = new Vektor2D(0.0, 10.0);
        assertEquals(10.0, LineareAlgebra.length(vec), 0.0);

        vec = new Vektor2D(-5.0, 10.0);
        assertEquals(11.180339887498949, LineareAlgebra.length(vec), 0.0);
    }

    // ....
}
