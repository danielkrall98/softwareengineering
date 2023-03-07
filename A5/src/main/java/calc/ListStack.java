package calc;

/**Stack implemented as LinkedList */
public class ListStack<E> implements GenericStack<E> {
    private Node <E> top;
    private int size;

    public ListStack(){ 
        this.top = new Node<>(null, null);
        size = 0;
    }

    /** Removes and returns top element */
    public E pop() {
        if (isEmpty())
            throw new RuntimeException("Tried to pop an empty Stack!");

        Node <E> nodeToPop = top;
        top = top.getNext();

        size--;
        return nodeToPop.getData();
    }

    /** Returns top element without removing it */
    public E peek() { 
        if (isEmpty())
            throw new RuntimeException("Tried to peek an empty Stack!");

        return top.getData();
    }

    /** Adds E element on the top of the stack.*/
    public void push(E element) { top = new Node<E>(element, top); size++;}

    /** Checks if the stack is empty. */
    public boolean isEmpty() { return !top.hasNext(); }

    /** returns current size of stack */
    public int getSize(){ return size; }

    
    /**
     * Class representing a node of a linkedList
     */
    private class Node <T> {
        private T data;
        private Node <T> next;

        private Node(T data, Node <T> next) {
            this.data = data;
            this.next = next;
        }

        private Node <T> getNext() { return next; }

        private boolean hasNext() { return next != null; }

        private T getData() { return this.data; }
    }
}