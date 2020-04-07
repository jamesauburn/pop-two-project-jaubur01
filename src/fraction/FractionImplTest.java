package fraction;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FractionImplTest{

//    @BeforeAll
//    public void setUp(){
//
//    }

    @Test
    public void testConst(){
        assertEquals("3/5", new FractionImpl(3, 5).toString());



        assertEquals("3", new FractionImpl(3).toString());



        //assertEquals("3/5", new FractionImpl("3/5").toString());
    }

    @Test
    public void add(){
        System.out.println("Hello");
    }

//    @Test
//    public void testGcd(){
//        assertEquals(4, new ((FractionImpl)f6).computeGCD(8, 12));
//    }
}