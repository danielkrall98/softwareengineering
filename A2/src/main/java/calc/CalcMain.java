package calc;

/**
 * Main class of the application.
 *
 * It implements the Calculator interface.
 * The two calculation methods must use the stack provided in the constructor.
 *
 * Additionally, it provides 2 methods to obtain instances of the two
 * different stack implementations.
 *
 */
public class CalcMain implements Calculator {
    private GenericStack<Double> stack;

    /**
     * Constructor for the calculator.
     * @param stack an instance of a stack that implements the interface {@code GenericStack}
     */
    public CalcMain(GenericStack<Double> stack) {
        this.stack = stack;
    }

    /** {@inheritDoc} */
    @Override
    public double calcInfix(String[] s) throws CalcException {
        return calcPostfix(Calculator.infix2postfix(s));
    }

    /** {@inheritDoc} */
    @Override
    public double calcPostfix(String[] s) throws CalcException {
        char c;
        double a = Double.NaN;
        double b = Double.NaN;
        double result;

        for(String NumOrOp : s){
            if(NumOrOp.length() == 0){
                //empty expression
                throw new CalcException("The expression contained empty inputs!");
            }

            c = NumOrOp.charAt(0);

                switch (c) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        if(stack.isEmpty())
                            throw new CalcException("Not enough operands!");
                        a = stack.pop();

                        if(stack.isEmpty())
                            throw new CalcException("Not enough operands!");
                        b = stack.pop();

                        switch(c){
                            case '+':
                                stack.push(b + a);
                                break;

                            case '-':
                                stack.push(b - a);
                                break;

                            case '*':
                                stack.push(b * a);
                                break;

                            case '/':
                                if(a == 0){
                                    //Division by 0 error
                                    throw new CalcException("Division by 0!");
                                }
                                stack.push(b / a);
                                break;
                            }
                            break;

                    default:
                        //Not an operation, so expect number
                        try {
                            stack.push(Double.parseDouble(NumOrOp));
                        } catch (Exception e) {
                            //input neither operation nor number
                            throw new CalcException("Invalid number input: " + NumOrOp);
                        }
                }
        }

        result = stack.pop();

        if(!stack.isEmpty())
            throw new CalcException("Not enough operations!");
        else
            return result;
    }

    /**
     * Creates and returns a new instance of an array-based stack with limited
     * capacity. The stack must not change the capacity.
     *
     * @param capacity the capacity of the stack (i.e., maximum number of elements
     *                 to be stored in the stack)
     * @return an instance of the array-based stack with the given capacity
     */
    public static GenericStack<Double> getArrayStack(int capacity) {
        return new ArrayStack<Double>(capacity);
    }

    /**
     * Creates and returns a new instance of a list-based stack with unbound
     * capacity.
     *
     * @return an instance of a list-based stack (with unbound capacity)
     */
    public static GenericStack<Double> getListStack() {
        return new ListStack<Double>();
    }

}
