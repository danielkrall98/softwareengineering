package calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class StackTest {
    static final int ARRAYSTACKSIZE = 20;

    static Stream<GenericStack<Double>> stackImplementationProvider() {
        return Stream.of(
            new ListStack<Double>(),
            new ArrayStack<>(ARRAYSTACKSIZE)
        );
    }

    @BeforeEach
    public void setup() {
        //setup if nessesary
    }

    @ParameterizedTest
    @MethodSource("stackImplementationProvider")
    public void testPush(GenericStack<Double> stack) {
        for(int i = 0; i < ARRAYSTACKSIZE; i++){
            assertDoesNotThrow(() -> stack.push(0.0));
        }

        //Arraystack size exeded
        if(stack instanceof ArrayStack){
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> { stack.push(0.0); });
        }
    }

    @ParameterizedTest
    @MethodSource("stackImplementationProvider")
    public void testPop(GenericStack<Double> stack) {
        stack.push(0.0);
        assertEquals(0.0, stack.pop());

        assertThrows(RuntimeException.class, () -> { stack.pop(); });
    }

    @ParameterizedTest
    @MethodSource("stackImplementationProvider")
    public void testPeek(GenericStack<Double> stack) {
        assertThrows(RuntimeException.class, () -> { stack.peek(); });

        stack.push(0.0);
        assertEquals(0.0, stack.peek());
    }    

    @ParameterizedTest
    @MethodSource("stackImplementationProvider")
    public void testIsEmpty(GenericStack<Double> stack) {
        assertTrue(stack.isEmpty());
        stack.push(0.0);
        assertFalse(stack.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stackImplementationProvider")
    public void testGetSize(GenericStack<Double> stack) {
        assertEquals(0,stack.getSize());
        
        stack.push(0.0);
        assertEquals(1,stack.getSize());

        stack.pop();
        assertEquals(0,stack.getSize());
    }
}