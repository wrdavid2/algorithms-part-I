import algorithms.stacks.arithmeticExpressionEval.FullyParenthesized;
import org.junit.*;

public class FullyParenthesizedTest {

    @Test
    public void FullyParenthesized_HappyTest() {
        String expr = "(1+((2+3)*(4*5)))";

        FullyParenthesized expression = new FullyParenthesized(expr);
        double val = expression.evaluate();
        Assert.assertEquals(101.0, val, .05);
    }
}