package algorithms.stacks.arithmeticExpressionEval;

import java.util.Stack;

//Use E. W. Dijkstra (algorithm) from the 1960s. Just need 2 stacks
//Proceed from left to right and take chars one at a time
// Push operands onto the operand stack
// Push operators onto the operator stack
// Ignore Left parentheses
// On encountering a right parenthesis, pop an operator, pop the requisite number of operands,
// and push onto the operand stack the result of applying that operator to those operands
// after the final right parenthesis has been processed, there is on value on the stack, which is the value of the expression
public class FullyParenthesized {

    Stack<String> operators = new Stack<String>();
    Stack<Double> values = new Stack<Double>();
    String _str;

    FullyParenthesized(String str) {
        _str = str;
    }

    private double Evaluate() {
        for (int i = 0; i < _str.length(); ++i) {
            String l = Character.toString(_str.charAt(i));
            if (l.equals("(")) {
                //Do nothing
            } else if (l.equals("+")) {
                operators.push(l);
            } else if (l.equals("-")) {
                operators.push(l);
            } else if (l.equals("*")) {
                operators.push(l);
            } else if (l.equals("/")) {
                operators.push(l);
            } else if (l.equals(")")) {
                String op = operators.pop();
                double operand1 = values.pop();
                double operand2 = values.pop();
                if (op.equals("+")) {
                    values.push(operand2 + operand1);
                } else if (op.equals("-")) {
                    values.push(operand2 - operand1);
                } else if (op.equals("*")) {
                    values.push(operand2 * operand1);
                } else if (op.equals("/")) {
                    values.push(operand2 / operand1);
                }
            } else {
                values.push(Double.parseDouble(l));
            }
        }
        return values.pop();
    }

}
