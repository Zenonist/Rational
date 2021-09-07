import org.junit.Assert;
import org.junit.Test;

public class RationalTest {
    @Test
    public void testAdd() {
        Rational x = new Rational();
        x.numerator = 1;
        x.denominator = 2;
        Rational y = new Rational();
        y.numerator = 1;
        y.denominator = 4;
        x.add(y);
        Assert.assertEquals(3, x.numerator);
        Assert.assertEquals(4,x.denominator);
    }
    @Test
    public void testSubtract() {
        Rational x = new Rational();
        x.numerator = 5;
        x.denominator = 6;
        Rational y = new Rational();
        y.numerator = 1;
        y.denominator = 2;
        x.subtract(y);
        Assert.assertEquals(1, x.numerator);
        Assert.assertEquals(3,x.denominator);
    }
    @Test
    public void testMultiply() {
        Rational x = new Rational();
        x.numerator = 7;
        x.denominator = 8;
        Rational y = new Rational();
        y.numerator = 2;
        y.denominator = 4;
        x.multiply(y);
        Assert.assertEquals(7,x.numerator);
        Assert.assertEquals(16,x.denominator);
    }
    @Test
    public void testDivide() {
        Rational x = new Rational();
        x.numerator = 6;
        x.denominator = 4;
        Rational y = new Rational();
        y.numerator = 8;
        y.denominator = 4;
        x.divide(y);
        Assert.assertEquals(3,x.numerator);
        Assert.assertEquals(4,x.denominator);
    }
    @Test
    public void testEquals1(){
        try{
            Rational x = new Rational(4,6);
            Rational y = new Rational(4,6);
            Assert.assertTrue(x.equals(y));
        }catch (Rational.Illegal illegal){
            illegal.printStackTrace();
        }

    }
    @Test
    public void testEquals2(){
        try{
            Rational x = new Rational(4,8);
            Rational y = new Rational(4,6);
            Assert.assertFalse(x.equals(y));
        }catch (Rational.Illegal illegal){
            illegal.printStackTrace();
        }
    }
    @Test (expected = ClassCastException.class)
    public void testEquals3(){
        try{
            Rational x = new Rational(4,8);
            String y = "Test";
            x.equals(y);
        }catch (Rational.Illegal illegal){
            illegal.printStackTrace();
        }

    }
    @Test
    public void testCompareTo1() throws Rational.Illegal {
        Rational x = new Rational(4,6);
        Rational y = new Rational(4,6);
        Assert.assertEquals(0,x.compareTo(y));
    }
    @Test
    public void testCompareTo2() throws Rational.Illegal {
        Rational x = new Rational(1,2);
        Rational y = new Rational(1,6);
        Assert.assertEquals(-1,x.compareTo(y));
    }
    @Test
    public void testCompareTo3() throws Rational.Illegal {
        Rational x = new Rational(1,3);
        Rational y = new Rational(1,2);
        Assert.assertEquals(1,x.compareTo(y));
    }
    @Test (expected = Rational.Illegal.class)
    public void testCompareTo4() throws Rational.Illegal {
        Rational x = new Rational(4,8);
        String y = "Test";
        x.compareTo(y);
    }
    @Test
    public void TestToString() throws Rational.Illegal {
        Rational x = new Rational(5,6);
        Assert.assertEquals("5/6",x.toString());
    }
    @Test (expected = Rational.Illegal.class)
    public void TestConstruct() throws Rational.Illegal {
        Rational x = new Rational(5,0);
    }
}
