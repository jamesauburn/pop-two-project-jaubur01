package fraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionImplTest {

    @Test
    public void testConst() {
        assertEquals("3/5", new FractionImpl(3, 5).toString());



        assertEquals("3/1", new FractionImpl(3).toString());



        assertEquals("3/5", new FractionImpl("3/5").toString());
    }

    @Test
    void add() {
        System.out.println("Hello");
    }
}