package calc;

/** Stack implemented with Array */
public class ArrayStack<E> implements GenericStack<E> {
    private E[] stack;
    private int counter; // used to keep track of elements

    public ArrayStack(int size) {
        stack = (E[]) new Object[size];
        counter = 0;
    }

    /** Removes and returns top element */
    public E pop() {
        if (isEmpty())
            throw new RuntimeException("Tried to pop an empty Stack!");

        E item = null;
        counter--;
        item = stack[counter];
        stack[counter] = null;

        return item;
    }

    /** Returns top element without removing it */
    public E peek() {
        if (isEmpty())
            throw new RuntimeException("Tried to peek an empty Stack!");

        return stack[counter - 1];
    }

    /**
     * Adds E on the top of the stack (as last array element)
     * 
     * @param element : Element to add
     */
    public void push(E element) {
        stack[counter++] = element;
    }

    /**Empty if counter 0 or less*/
    public boolean isEmpty() {
        return counter <= 0;
    }
}