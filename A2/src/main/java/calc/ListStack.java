package calc;

/**Stack implemented as LinkedList */
public class ListStack<E> implements GenericStack<E> {
    private Node <E> top;

    public ListStack(){ 
        this.top = new Node<>(null, null);
    }

    /** Removes and returns top element */
    public E pop() {
        if (isEmpty())
            throw new RuntimeException("Tried to pop an empty Stack!");

        Node <E> nodeToPop = top;
        top = top.getNext();
        return nodeToPop.getData();
    }

    /** Returns top element without removing it */
    public E peek() { 
        if (isEmpty())
            throw new RuntimeException("Tried to peek an empty Stack!");

        return top.getData();
    }

    /** Adds E element on the top of the stack.*/
    public void push(E element) { top = new Node<>(element, top); }

    /** Checks if the stack is empty. */
    public boolean isEmpty() { return !top.hasNext(); }

    
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