package calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    static final int ARRAYSTACKSIZE = StackTest.ARRAYSTACKSIZE;

    static Stream<CalcMain> calculatorProvider() {
        return Stream.of(
            new CalcMain(CalcMain.getListStack()),
            new CalcMain(CalcMain.getArrayStack(ARRAYSTACKSIZE))
        );
    }

    static Stream<Arguments> validPostfixProvider() {
        return Stream.of(
            Arguments.of(
                new CalcMain(CalcMain.getListStack()), 
                new Pair<String[], Double>(new String[]{"1", "2", "+", "9", "3", "/", "+"}, 6.0)),
            Arguments.of(
                new CalcMain(CalcMain.getArrayStack(ARRAYSTACKSIZE)), 
                new Pair<String[], Double>(new String[]{"1", "2", "+", "9", "3", "/", "+"}, 6.0)),
            Arguments.of(
                new CalcMain(CalcMain.getListStack()),
                new Pair<String[], Double>(new String[]{"1", "2", "+", "9", "+", "3", "/"}, 4.0)),
            Arguments.of(
                new CalcMain(CalcMain.getArrayStack(ARRAYSTACKSIZE)),
                new Pair<String[], Double>(new String[]{"1", "2", "+", "9", "+", "3", "/"}, 4.0))
        );
    }

    static Stream<Arguments> invalidPostfixProvider() {
        return Stream.of(
            Arguments.of(
                new CalcMain(CalcMain.getListStack()), 
                new String[]{"1.5", "2", "+", "3", "4", "-"}),
            Arguments.of(
                new CalcMain(CalcMain.getArrayStack(ARRAYSTACKSIZE)), 
                new String[]{"1.5", "2", "+", "3", "4", "-"}),
            Arguments.of(
                new CalcMain(CalcMain.getListStack()),
                new String[]{"-", "1.5", "2", "+", "3", "4", "-"}),
            Arguments.of(
                new CalcMain(CalcMain.getArrayStack(ARRAYSTACKSIZE)),
                new String[]{"-", "1.5", "2", "+", "3", "4", "-"}),
            Arguments.of(
                new CalcMain(CalcMain.getListStack()),
                new String[]{"", "1.5", "2", "+", "3", "4", "-"}),
            Arguments.of(
                new CalcMain(CalcMain.getArrayStack(ARRAYSTACKSIZE)),
                new String[]{"", "1.5", "2", "+", "3", "4", "-"}),
            Arguments.of(
                new CalcMain(CalcMain.getListStack()),
                new String[]{"1.5", "2", "+", "3", "-", "-"}),
            Arguments.of(
                new CalcMain(CalcMain.getArrayStack(ARRAYSTACKSIZE)),
                new String[]{"1.5", "2", "+", "3", "-", "-"}),
            Arguments.of(
                new CalcMain(CalcMain.getListStack()),
                new String[]{"1", "0", "/"}),
            Arguments.of(
                new CalcMain(CalcMain.getArrayStack(ARRAYSTACKSIZE)),
                new String[]{"1", "0", "/"}),
            Arguments.of(
                new CalcMain(CalcMain.getListStack()),
                new String[]{"Hallo"}),
            Arguments.of(
                new CalcMain(CalcMain.getArrayStack(ARRAYSTACKSIZE)),
                new String[]{"Hallo"})
        );
    }

    static Stream<Arguments> validInfixProvider() {
        return Stream.of(
            Arguments.of(
                new CalcMain(CalcMain.getListStack()), 
                new Pair<String[], Double>(new String[]{"(", "1", "+", "1", ")", "*", "2", "-", "(", "9", "/", "3", ")"}, 1.0)),
            Arguments.of(
                new CalcMain(CalcMain.getArrayStack(ARRAYSTACKSIZE)), 
                new Pair<String[], Double>(new String[]{"(", "1", "+", "1", ")", "*", "2", "-", "(", "9", "/", "3", ")"}, 1.0))
        );
    }

    @BeforeEach
    public void setup() {
        //setup if nessesary
    }

    @ParameterizedTest
    @MethodSource({"calculatorProvider"})
    public void testCalcMain(CalcMain calculator){
        assertNotNull(calculator);
    }

    @ParameterizedTest
    @MethodSource("validPostfixProvider")
    public void testValidPostfix(CalcMain calculator, Pair<String[], Double> pair) {
        assertDoesNotThrow(() -> calculator.calcPostfix(pair.getFirst()));

        try {
            assertEquals(pair.getSecond(), calculator.calcPostfix(pair.getFirst()));
        } catch (CalcException e) {
            //already caught with assertDoesNotThrow
        }
    }

    @ParameterizedTest
    @MethodSource("invalidPostfixProvider")
    public void testInvalidPostfix(CalcMain calculator, String[] calc) {
        assertThrows(CalcException.class, () -> calculator.calcPostfix(calc));
    }

    @ParameterizedTest
    @MethodSource("validInfixProvider")
    public void testValidInfix(CalcMain calculator, Pair<String[], Double> pair) {
        assertDoesNotThrow(() -> calculator.calcInfix(pair.getFirst()));

        try {
            assertEquals(pair.getSecond(), calculator.calcInfix(pair.getFirst()));
        } catch (CalcException e) {
            //already caught with assertDoesNotThrow
        }
    }
}
