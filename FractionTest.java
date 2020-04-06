package fraction;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest{

    @Test
    public void testConstructors(){
        assertEquals(1/5, new Fraction(1, 5).toString());
    }

    @Test
	public void testAdd(){
		assertEquals(new Fraction(2, 3).add(new Fraction("8/  -11")), 0);
    }
}