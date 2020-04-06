package fraction;

import static org.junit.Assert.*;
import org.junit.Test;

public class FractionTest{
    @Test
    public void testConstructors(){
        assertEquals(1/5, new Fraction(1, 5).toString())
    }
    
}