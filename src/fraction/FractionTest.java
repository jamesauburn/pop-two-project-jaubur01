package fraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FractionTest {

    private Fraction f0;
    private Fraction f1;
    private Fraction f2;
    private Fraction f3;
    private Fraction f4;
    private Fraction f5;
    private Fraction f6;
    private Fraction f7;
    private Fraction f8;
    private Fraction f9;

    @BeforeAll
    void config(){
        f0 = new FractionImpl(0);
        f1 = new FractionImpl(1, 2);
        f2 = new FractionImpl(2, 4);
        f3 = new FractionImpl(-1, 3);
        f4 = new FractionImpl(2, 3);
        f5 = new FractionImpl(3, -3);
        f6 = new FractionImpl(5);
        f7 = new FractionImpl("4/7");
        f8 = new FractionImpl("    3/7");
        f9 = new FractionImpl("5/  10");
}

    @Test
    void testFraction() {
        assertEquals("3/5", new FractionImpl(3, 5).toString());
        assertEquals("1/2", new FractionImpl(5, 10).toString());
        assertEquals("4/3", new FractionImpl(4, 3).toString());
        assertEquals("7/3", new FractionImpl(7, 3).toString());
        assertEquals("4/3", new FractionImpl(12, 9).toString());

        assertEquals("1", new FractionImpl(1).toString());
        assertEquals("67", new FractionImpl(67).toString());
        assertEquals("0", new FractionImpl(0).toString());

        assertEquals("7", new FractionImpl("     7      ").toString());
        assertEquals("1/2", new FractionImpl("4/    8").toString());
        assertEquals("7/3", new FractionImpl("     7      /      3").toString());
        assertEquals("1/2", new FractionImpl("5/  10").toString());
    }

    @Test
    void testGcd() {
        assertEquals(4, ((FractionImpl)f0).gcd(8, 12));
        assertEquals(2, ((FractionImpl)f0).gcd(6, 40));
        assertEquals(1, ((FractionImpl)f0).gcd(1, 3));
        assertEquals(1, ((FractionImpl)f0).gcd(3, 4));
        assertEquals(32, ((FractionImpl)f0).gcd(32, 32));
        assertEquals(2, ((FractionImpl)f0).gcd(40, 2));
        assertEquals(5, ((FractionImpl)f0).gcd(40, 5));
        assertEquals(1, ((FractionImpl)f0).gcd(39, 1));
        assertEquals(2, ((FractionImpl)f0).gcd(2, 2));
        assertEquals(2, ((FractionImpl)f0).gcd(4, 14));
    }

    @Test
    void testNorm() {
        assertEquals(new FractionImpl(0), f0);
        assertEquals(new FractionImpl(1, 2), f1);
        assertEquals(new FractionImpl(1, 2), f2);
        assertEquals(new FractionImpl(-1, 3), f3);
        assertEquals(new FractionImpl(2, 3), f4);
        assertEquals(new FractionImpl(-1), f5);
        assertEquals(new FractionImpl(5), f6);
        assertEquals(new FractionImpl(4, 7), f7);
        assertEquals(new FractionImpl(3, 7), f8);
        assertEquals(new FractionImpl(1, 2), f9);
    }

    @Test
    void testAdd(){
        assertEquals(new FractionImpl(1, 2), f0.add(f1));
        assertEquals(new FractionImpl(1), f1.add(f2));
        assertEquals(new FractionImpl(1,6), f2.add(f3));
        assertEquals(new FractionImpl(1, 3), f3.add(f4));
        assertEquals(new FractionImpl(-1, 3), f4.add(f5));
        assertEquals(new FractionImpl(4), f5.add(f6));
        assertEquals(new FractionImpl(39, 7), f6.add(f7));
        assertEquals(new FractionImpl(1), f7.add(f8));
        assertEquals(new FractionImpl(13, 14), f8.add(f9));
    }

    @Test
    void testSubtract(){
        assertEquals(new FractionImpl(-1, 2), f0.subtract(f1));
        assertEquals(new FractionImpl(0), f1.subtract(f2));
        assertEquals(new FractionImpl(5, 6), f2.subtract(f3));
        assertEquals(new FractionImpl(-1), f3.subtract(f4));
        assertEquals(new FractionImpl(5,3), f4.subtract(f5));
        assertEquals(new FractionImpl(-6), f5.subtract(f6));
        assertEquals(new FractionImpl(31, 7), f6.subtract(f7));
        assertEquals(new FractionImpl(1,7), f7.subtract(f8));
        assertEquals(new FractionImpl(-1,14), f8.subtract(f9));
    }

    @Test
    void testMultipy(){
        assertEquals(new FractionImpl(0), f0.multiply(f1));
        assertEquals(new FractionImpl(1,4), f1.multiply(f2));
        assertEquals(new FractionImpl(-1,6), f2.multiply(f3));
        assertEquals(new FractionImpl(-2,9), f3.multiply(f4));
        assertEquals(new FractionImpl(-2,3), f4.multiply(f5));
        assertEquals(new FractionImpl(-5), f5.multiply(f6));
        assertEquals(new FractionImpl(20,7), f6.multiply(f7));
        assertEquals(new FractionImpl(12, 49), f7.multiply(f8));
        assertEquals(new FractionImpl(3,14), f8.multiply(f9));
    }

    @Test
    void testDivide(){
        assertEquals(new FractionImpl(0), f0.divide(f1));
        assertEquals(new FractionImpl(1), f1.divide(f2));
        assertEquals(new FractionImpl(-3,2), f2.divide(f3));
        assertEquals(new FractionImpl(-1,2), f3.divide(f4));
        assertEquals(new FractionImpl(-2,3), f4.divide(f5));
        assertEquals(new FractionImpl(-1,5), f5.divide(f6));
        assertEquals(new FractionImpl(35,4), f6.divide(f7));
        assertEquals(new FractionImpl(4,3), f7.divide(f8));
        assertEquals(new FractionImpl(6, 7), f8.divide(f9));
    }

    @Test
    void testAbs(){
        assertEquals(new FractionImpl(0), f0.abs());
        assertEquals(new FractionImpl(1, 2), f1.abs());
        assertEquals(new FractionImpl(1,2), f2.abs());
        assertEquals(new FractionImpl(1,3), f3.abs());
        assertEquals(new FractionImpl(2,3), f4.abs());
        assertEquals(new FractionImpl(1), f5.abs());
        assertEquals(new FractionImpl(5), f6.abs());
        assertEquals(new FractionImpl(4,7), f7.abs());
        assertEquals(new FractionImpl(3, 7), f8.abs());
        assertEquals(new FractionImpl(1, 2), f9.abs());
    }

    @Test
    void testNegate(){
        assertEquals(new FractionImpl(0), f0.negate());
        assertEquals(new FractionImpl(-1, 2), f1.negate());
        assertEquals(new FractionImpl(-1,2), f2.negate());
        assertEquals(new FractionImpl(1,3), f3.negate());
        assertEquals(new FractionImpl(-2,3), f4.negate());
        assertEquals(new FractionImpl(1), f5.negate());
        assertEquals(new FractionImpl(-5), f6.negate());
        assertEquals(new FractionImpl(-4,7), f7.negate());
        assertEquals(new FractionImpl(-3, 7), f8.negate());
        assertEquals(new FractionImpl(-1, 2), f9.negate());
    }

    @Test
    void testNEquals(){
        assertEquals(false, f0.equals(f1));
        assertEquals(true, f1.equals(f2));
        assertEquals(false, f2.equals(f3));
        assertEquals(false, f3.equals(f4));
        assertEquals(false, f4.equals(f5));
        assertEquals(false, f5.equals(f6));
        assertEquals(false, f6.equals(f7));
        assertEquals(false, f7.equals(f8));
        assertEquals(false, f8.equals(f9));
        assertEquals(true, f9.equals(f1));
        assertEquals(true, f9.equals(f2));
    }

    @Test
    void testInverse(){
        assertEquals(new FractionImpl(0), f0.inverse());
        assertEquals(new FractionImpl(2), f1.inverse());
        assertEquals(new FractionImpl(2), f2.inverse());
        assertEquals(new FractionImpl(-3), f3.inverse());
        assertEquals(new FractionImpl(3,2), f4.inverse());
        assertEquals(new FractionImpl(-1), f5.inverse());
        assertEquals(new FractionImpl(1,5), f6.inverse());
        assertEquals(new FractionImpl(7,4), f7.inverse());
        assertEquals(new FractionImpl(7, 3), f8.inverse());
        assertEquals(new FractionImpl(2, 1), f9.inverse());
    }

    @Test
    void testCompareTo(){
        assertEquals(-1, f0.compareTo(f1));
        assertEquals(0, f1.compareTo(f2));
        assertEquals(1, f2.compareTo(f3));
        assertEquals(-1, f3.compareTo(f4));
        assertEquals(1, f4.compareTo(f5));
        assertEquals(-1, f5.compareTo(f6));
        assertEquals(1, f6.compareTo(f7));
        assertEquals(1, f7.compareTo(f8));
        assertEquals(-1, f8.compareTo(f9));
    }

    @Test
    void testToString(){
        assertEquals("0", f0.toString());
        assertEquals("1/2", f1.toString());
        assertEquals("1/2", f2.toString());
        assertEquals("-1/3", f3.toString());
        assertEquals("2/3", f4.toString());
        assertEquals("-1", f5.toString());
        assertEquals("5", f6.toString());
        assertEquals("4/7", f7.toString());
        assertEquals("3/7", f8.toString());
        assertEquals("1/2", f9.toString());
    }

    @Test
    void testDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            new FractionImpl(2, 0); });
        Assertions.assertThrows(ArithmeticException.class, () -> {
            new FractionImpl(2, -0); });
        Assertions.assertThrows(ArithmeticException.class, () -> {
            new FractionImpl("2/  0  "); });
        Assertions.assertThrows(ArithmeticException.class, () -> {
            new FractionImpl("0/-0"); });
    }

    @Test
    void testNonLegalInteger() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new FractionImpl("5/ 1  0"); });
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new FractionImpl("   2 0   /8"); });
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new FractionImpl("1  4 / 4  7"); });
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new FractionImpl("12 / 5  2"); });
    }
}