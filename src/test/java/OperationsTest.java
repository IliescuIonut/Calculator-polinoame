import BusinessLogic.DivideBy0;
import BusinessLogic.Operations;
import DataModels.Polynomial;
import org.junit.Test;

import java.util.Collections;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    Operations op=new Operations();
    @Test
    public void sumTest(){
        Polynomial p1=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(3, 2);
        p1.addMonome(2, 4);
        p1.addMonome(1, -5);
        p1.addMonome(0, 3);
        //2x^3+4x^2-5x+3

        Polynomial p2=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p2.addMonome(4, 5);
        p2.addMonome(3, 2);
        p2.addMonome(1, 5);
        p2.addMonome(0, 10);
        //5x^4+2^3+5x+10;

        Polynomial expectedResult=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        expectedResult.addMonome(4, 5);
        expectedResult.addMonome(3, 4);
        expectedResult.addMonome(2,4);
        expectedResult.addMonome(0, 13);

        Polynomial result=op.addition(p1,p2);

        assertEquals(expectedResult, result);
    }
    @Test
    public void sumTest2(){
        Polynomial p1=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(5, 4);
        p1.addMonome(4, -3);
        p1.addMonome(2, 1);
        p1.addMonome(1, -8);
        p1.addMonome(0,1);
        //4x^5-3x^4+x^2-8x+1

        Polynomial p2=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p2.addMonome(4, 3);
        p2.addMonome(3, -1);
        p2.addMonome(2, 1);
        p2.addMonome(1,2);
        p2.addMonome(0, -1);
        //3x^4-x^3+x^2+2x-1

        Polynomial expectedResult=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        expectedResult.addMonome(5, 4);
        expectedResult.addMonome(3, -1);
        expectedResult.addMonome(2,2);
        expectedResult.addMonome(1, -6);
        //4x^5-6x^4+x^3-10x+2

        Polynomial result=op.addition(p1,p2);

        assertEquals(expectedResult, result);
    }
    @Test
    public void subTest1(){
        Polynomial p1=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(3, 2);
        p1.addMonome(2, 4);
        p1.addMonome(1, -5);
        p1.addMonome(0, 3);
        //2x^3+4x^2-5x+3

        Polynomial p2=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p2.addMonome(4, 5);
        p2.addMonome(3, 2);
        p2.addMonome(1, 5);
        p2.addMonome(0, 10);
        //5x^4+2^3+5x+10;

        Polynomial expectedResult=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        expectedResult.addMonome(4, -5);
        expectedResult.addMonome(1, -10);
        expectedResult.addMonome(2,4);
        expectedResult.addMonome(0, -7);

        Polynomial result=op.subtraction(p1,p2);

        assertEquals(expectedResult, result);
    }
    @Test
    public void subTest2(){
        Polynomial p1=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(5, 4);
        p1.addMonome(4, -3);
        p1.addMonome(2, 1);
        p1.addMonome(1, -8);
        p1.addMonome(0,1);
        //4x^5-3x^4+x^2-8x+1

        Polynomial p2=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p2.addMonome(4, 3);
        p2.addMonome(3, -1);
        p2.addMonome(2, 1);
        p2.addMonome(1,2);
        p2.addMonome(0, -1);
        //3x^4-x^3+x^2+2x-1

        Polynomial expectedResult=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        expectedResult.addMonome(5, 4);
        expectedResult.addMonome(4, -6);
        expectedResult.addMonome(3, 1);
        expectedResult.addMonome(0,2);
        expectedResult.addMonome(1, -10);
        //4x^5-6x^4+x^3-10x+2

        Polynomial result=op.subtraction(p1,p2);

        assertEquals(expectedResult, result);
    }
    @Test
    public void mulTest1(){
        Polynomial p1=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(2, 3);
        p1.addMonome(1, -1);
        p1.addMonome(0, 1);
        //3x^2-x+1

        Polynomial p2=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p2.addMonome(1,1);
        p2.addMonome(0, -2);
        //x-2

        Polynomial expectedResult=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        expectedResult.addMonome(2, -7);
        expectedResult.addMonome(3, 3);
        expectedResult.addMonome(0,-2);
        expectedResult.addMonome(1, 3);
        //3x^2-7x^2+3x-2

        Polynomial result=op.product(p1,p2);

        assertEquals(expectedResult, result);
    }
    @Test
    public void mulTest2(){
        Polynomial p1 = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(2, 3);
        p1.addMonome(1, 2);
        p1.addMonome(0, 1);
        //3x^2+2x+1

        Polynomial p2 = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p2.addMonome(2, 2);
        p2.addMonome(1, 3);
        p2.addMonome(0, 4);
        //2x^2+3x+4


        Polynomial expectedResult = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        expectedResult.addMonome(4, 6);
        expectedResult.addMonome(3, 13);
        expectedResult.addMonome(2, 20);
        expectedResult.addMonome(1, 11);
        expectedResult.addMonome(0, 4);
        //6x^4+13x^3+20x^2+11x+4

        Polynomial result = op.product(p1, p2);
        assertEquals(expectedResult, result);
    }
    @Test
    public void divTest1() throws DivideBy0 {
        Polynomial p1 = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(3, 1);
        p1.addMonome(2, -2);
        p1.addMonome(1, 6);
        p1.addMonome(0,-5);
        //x^3-2x^2+6x-5

        Polynomial p2 = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p2.addMonome(2, 1);
        p2.addMonome(0, -1);
        //x^2-1


        String expectedResult = "Q:x-2.0 R:7.0x-7.0";

        String result = op.division(p1, p2);
        assertEquals(expectedResult, result);
    }
    @Test
    public void divTest2() throws DivideBy0 {
        Polynomial p1 = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(4, 5);
        p1.addMonome(2, 2);
        p1.addMonome(1, -3);
        p1.addMonome(0, 2);
        //5x^4+2x^2-3x+2

        Polynomial p2 = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p2.addMonome(0, 1);
        //1

        String expectedResult = "Q:5.0x^4+2.0x^2-3.0x+2.0 R:0";

        String result = op.division(p1, p2);
        assertEquals(expectedResult, result);
    }
    @Test
    public void derTest1(){
        Polynomial p1 = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(3, -1);
        p1.addMonome(2, -2);
        p1.addMonome(1, 6);
        p1.addMonome(0, 5);
        //x^3-2x^2+6x-5

        Polynomial expectedResult=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        expectedResult.addMonome(2, -3);
        expectedResult.addMonome(1, -4);
        expectedResult.addMonome(0,6);
        //3x^2-4x+6
        Polynomial result=op.derivate(p1);
        assertEquals(expectedResult, result);
    }
    @Test
    public void derTest2(){
        Polynomial p1 = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(5, 4);
        p1.addMonome(4, -3);
        p1.addMonome(3, -2);
        p1.addMonome(2, -5);
        p1.addMonome(1, 6);
        p1.addMonome(0, -9);
        //4x^5-3x^4+2x^3-5x^2+6x-9
        Polynomial expectedResult=new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        expectedResult.addMonome(4, 20);
        expectedResult.addMonome(3, -12);
        expectedResult.addMonome(2,-6);
        expectedResult.addMonome(1, -10);
        expectedResult.addMonome(0, 6);
        //20x^4-12x^3+6x^2-10x+6
        Polynomial result=op.derivate(p1);
        assertEquals(expectedResult, result);
    }

    @Test
    public void intTest1(){
        Polynomial p1 = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(3, 1);
        p1.addMonome(2, 4);
        p1.addMonome(0,5);
        //x^3+4x^2+5

        String expectedResult = "0.25x^4+1.33x^3+5x";

        String result = op.integration(p1);
        assertEquals(expectedResult, result);
    }
    @Test
    public void intTest2(){
        Polynomial p1 = new Polynomial(new TreeMap<>(Collections.reverseOrder()));
        p1.addMonome(4, 5);
        p1.addMonome(3, 4);
        p1.addMonome(2, 3);
        p1.addMonome(1, 2);
        p1.addMonome(0, 22);
        //5x^4+4x^3+3x^2+2x+22
        String expectedResult = "x^5+x^4+x^3+x^2+22x";
        String result = op.integration(p1);
        assertEquals(expectedResult, result);
    }
}