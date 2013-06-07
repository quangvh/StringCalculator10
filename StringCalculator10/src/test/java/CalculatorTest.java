import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * User: quangvh
 * Date: 6/7/13
 */
public class CalculatorTest {
    @Test
    public void testEmptyString() throws Exception {
        assertEquals(Calculator.add(""), 0);
    }

    @Test
    public void testOneNumber() throws Exception {
        assertEquals(Calculator.add("1"), 1);
    }

    @Test
    public void testTwoNumber() throws Exception {
        assertEquals(Calculator.add("1,2"), 3);
    }

    @Test
    public void testUnknownNumber() throws Exception {
        assertEquals(Calculator.add("1,5,10,15,20"), 51);
    }

    @Test
    public void testHaveNewLine() throws Exception {
        assertEquals(Calculator.add("1\n2,3\n,4"), 10);
    }

    @Test
    public void testDifferentDelimiter() throws Exception {
        assertEquals(Calculator.add("//;\n1;2;3"), 6);
    }

    @Test
    public void testNegativeNumber() {
        try {
            Calculator.add("-1,-3,-5");
            fail("Exception");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "negatives not allowed -1 -3 -5");
        }
    }

    @Test
    public void testIgnoreMoreThanOneThousand() throws Exception {
        assertEquals(Calculator.add("1,1002,3,2013"), 4);
    }

    @Test
    public void testCustomDelimiter() throws Exception {
        assertEquals(Calculator.add("//[***]\n1***2***3"), 6);
    }

    @Test
    public void testCustomAnyDelimiter() throws Exception {
        assertEquals(Calculator.add("//[*][%]\n1*2%3"), 6);
    }

    @Test
    public void testCustomAnyLengthDelimiter() throws Exception {
        assertEquals(Calculator.add("//[***][*][%][##]\n1***2*3%4##5"), 15);
    }
}
