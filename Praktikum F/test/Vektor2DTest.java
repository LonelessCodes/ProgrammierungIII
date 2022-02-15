package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.Vektor2D;

public class Vektor2DTest {
    @Test
    public void testLength() {
        Vektor2D vec = new Vektor2D(2.0, 0.0);
        assertEquals(2.0, vec.length(), 0.0);

        vec = new Vektor2D(-2.0, 0.0);
        assertEquals(2.0, vec.length(), 0.0);

        vec = new Vektor2D(0.0, 10.0);
        assertEquals(10.0, vec.length(), 0.0);

        vec = new Vektor2D(-5.0, 10.0);
        assertEquals(11.180339887498949, vec.length(), 0.0);
    }

    @Test
    public void testIsEqual() {
        Vektor2D a = new Vektor2D(2.0, 100.5);
        Vektor2D b = new Vektor2D(2.0, 100.5);

        assertTrue(a.isEqual(b));
        assertTrue(b.isEqual(a));

        b = new Vektor2D(2.0, 10013.5);

        assertFalse(a.isEqual(b));
        assertFalse(b.isEqual(a));
    }

    @Test
    public void testIsNullVektor() {
        Vektor2D a = new Vektor2D(0.0, 0.0);
        assertTrue(a.isNullVektor());

        Vektor2D b = new Vektor2D(2.0, 10013.5);
        assertFalse(b.isNullVektor());
    }
}
