package ua.edu.ucu.collections.immutable;

public class Node {
    private Node next;
    private Object value;

    public Node(Object value) {
        this.value = value;
        next = null;
    }

    public void setNext(Node newset) {
        next = newset;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(Object newval) {
        value = newval;
    }

    public Object getValue() {
        return value;
    }
}
