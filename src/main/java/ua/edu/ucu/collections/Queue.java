package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList q;

    public Queue() {
        q = new ImmutableLinkedList();
    }

    public Object peek() {
        return q.getFirst();
    }

    public Object dequeue() {
        Object dec = peek();
        q = q.removeFirst();
        return dec;
    }

    public void enqueue(Object e) {
        q = q.addLast(e);
    }
}
