package calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Interface for the infix/postfix Calculator.
 */
public interface Calculator {

    /**
     * performs the calculation on the given input in infix notation. Supported operations are:
     * addition (+), substraction (-), multiplication (*), and division (/).
     * Also parenthesis '(', ')' are allowed.
     *
     * @param expression the input to the calculation in infix form
     * e.g., ["(", "1.5", "+" , "2", ")", "*", "(", "3", "-", "4", ")"]
     * @return the result of the calculation, e.g. -3.5 for the above input
     * @throws CalcException if anything goes wrong during the calculation (e.g., in case of an illegal input)
     */
    double calcInfix(String[] expression) throws CalcException;

    /**
     * performs the calculation on the given input in postfix notation. Supported operations are:
     * addition (+), substraction (-), multiplication (*), and division (/)
     *
     * @param expression the input to the calculation in postfix form
     * e.g., ["1.5", "2", "+", "3", "4", "-", "*"]
     * @return the result of the calculation, e.g. -3.5 for the above input
     * @throws CalcException if anything goes wrong during the calculation (e.g., in case of an illegal input)
     */
    double calcPostfix(String[] expression) throws CalcException;

    static int getPrec(String op) {
        if ("*".equals(op) || "/".equals(op))
            return 2;
        if ("+".equals(op) || "-".equals(op))
            return 1;
        return -1;
    }

    /**
     * Converts a given infix-expression into postfix notation.
     *
     * @param expression the expression in infix notation
     * @return the expression in postfix notation
     */
    static String[] infix2postfix(String expression[]) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String exp : expression) {
            int prec = getPrec(exp);
            if (prec > 0) { //operation
                while (!stack.empty() && prec <= getPrec(stack.peek())) {
                    result.add(stack.pop());
                }
                stack.push(exp);
            } else if ("(".equals(exp)) {
                stack.push("(");
            } else if (")".equals(exp)) {
                while (!stack.peek().equals("(")) {
                    result.add(stack.pop());
                }
                stack.pop();
            } else { //assumes to be a number
                result.add(exp);
            }
        }
		while (!stack.isEmpty()){ //pop everything remaining
            result.add(stack.pop());
        }
        return result.toArray(new String[]{});
    }
}
