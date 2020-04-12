package fraction;

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
    public void config(){
        f0 = new FractionImpl(0);
        f1 = new FractionImpl(1, 2);
        f2 = new FractionImpl(2, 4);
        f3 = new FractionImpl(1, 3);
        f4 = new FractionImpl(2, 3);
        f5 = new FractionImpl(3, 3);
        f6 = new FractionImpl(5);
        f7 = new FractionImpl("4/7");
        f8 = new FractionImpl("    3/7");
        f9 = new FractionImpl("5/  1 0");
}

    @Test
    public void testFraction() {
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
    }

    @Test
    public void testGcd() {
        assertEquals(4, ((FractionImpl)f0).gcd(8, 12));
    }

    @Test
    public void testNorm() {
        assertEquals(new FractionImpl(0), f0);
        assertEquals(new FractionImpl(1, 2), f1);
        assertEquals(new FractionImpl(1, 2), f2);
//        assertEquals(new FractionImpl(0), f3);
//        assertEquals(new FractionImpl(0), f4);
//        assertEquals(new FractionImpl(0), f5);
//        assertEquals(new FractionImpl(0), f6);
//        assertEquals(new FractionImpl(0), f7);
//        assertEquals(new FractionImpl(0), f8);
//        assertEquals(new FractionImpl(0), f9);
    }

    @Test
    public void testAdd(){
        assertEquals(new FractionImpl(1, 2), f0.add(f1));
        assertEquals(new FractionImpl(1), f1.add(f2));
        assertEquals(new FractionImpl(5,6), f2.add(f3));
        assertEquals(new FractionImpl(1), f3.add(f4));
        assertEquals(new FractionImpl(5, 3), f4.add(f5));
        assertEquals(new FractionImpl(6), f5.add(f6));
        assertEquals(new FractionImpl(39, 7), f6.add(f7));
        assertEquals(new FractionImpl(1), f7.add(f8));
        assertEquals(new FractionImpl(13, 14), f8.add(f9));
    }

//    @Test
//    public void testSubtract(){
//        assertEquals(new FractionImpl(), f0.subtract(f1));
//        assertEquals(new FractionImpl(), f1.subtract(f2));
//        assertEquals(new FractionImpl(), f2.subtract(f3));
//        assertEquals(new FractionImpl(), f3.subtract(f4));
//        assertEquals(new FractionImpl(), f4.subtract(f5));
//        assertEquals(new FractionImpl(), f5.subtract(f6));
//        assertEquals(new FractionImpl(), f6.subtract(f7));
//        assertEquals(new FractionImpl(), f7.subtract(f8));
//        assertEquals(new FractionImpl(), f8.subtract(f9));
//    }
//
//    @Test
//    public void testMultipy(){
//        assertEquals(new FractionImpl(), f0.multiply(f1));
//        assertEquals(new FractionImpl(), f1.multiply(f2));
//        assertEquals(new FractionImpl(), f2.multiply(f3));
//        assertEquals(new FractionImpl(), f3.multiply(f4));
//        assertEquals(new FractionImpl(), f4.multiply(f5));
//        assertEquals(new FractionImpl(), f5.multiply(f6));
//        assertEquals(new FractionImpl(), f6.multiply(f7));
//        assertEquals(new FractionImpl(), f7.multiply(f8));
//        assertEquals(new FractionImpl(), f8.multiply(f9));
//    }
//
//    @Test
//    public void testDivide(){
//        assertEquals(new FractionImpl(), f0.divide(f1));
//        assertEquals(new FractionImpl(), f1.divide(f2));
//        assertEquals(new FractionImpl(), f2.divide(f3));
//        assertEquals(new FractionImpl(), f3.divide(f4));
//        assertEquals(new FractionImpl(), f4.divide(f5));
//        assertEquals(new FractionImpl(), f5.divide(f6));
//        assertEquals(new FractionImpl(), f6.divide(f7));
//        assertEquals(new FractionImpl(), f7.divide(f8));
//        assertEquals(new FractionImpl(), f8.divide(f9));
//    }

}