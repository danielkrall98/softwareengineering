package calc;

public class Main {
    public static void main(String[] args) {
        CalcMain calculator = new CalcMain(CalcMain.getListStack());

        //String[] expInfix = {"1", "+", "2", "+", "9", "/", "3"};                  //6
        String[] expInfix = {"(", "1", "+", "2", "+", "9", ")", "/", "3"};          //4

        //String[] expPostfix = {"1", "2", "+", "9", "3", "/", "+"};                //6
        //String[] expPostfix = {"1", "2", "+", "9", "+", "3", "/"};                //4
        //String[] expPostfix ={"1.5", "2", "+", "3", "4", "-"};                    //Not enough operations
        String[] expPostfix ={"1", "9", "/", "9", "/"};                             //0.012345679012345678


        // try {
        //     System.out.println("Infix: " + calculator.calcInfix(expInfix));
        // } catch (CalcException e) {
        //     e.printStackTrace();
        // }

        try {
            System.out.println("Postfix: " + calculator.calcPostfix(expPostfix));
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }
}
