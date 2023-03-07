package calc;

/**
 * A common interface for stack implementations.
 *
 * The operations shall behave as expected for a stack. In case the operation
 * cannot be performed (e.g, a pop-operation on an empty stack), a runtime
 * exception shall be thrown.
 *
 * @param <E> the type of elements in this stack
 * */
public interface GenericStack<E> {
    E pop();

    E peek();

    void push(E e);

    boolean isEmpty();

    int getSize();
}
