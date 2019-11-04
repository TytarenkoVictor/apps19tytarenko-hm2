package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList st;

    public Stack() {
        st = new ImmutableLinkedList();
    }

    public Object peek() {
        return st.getFirst();
    }

    public void push(Object e) {
        st = st.addFirst(e);
    }

    public Object pop() {
        Object result = peek();
        st = st.removeFirst();
        return result;
    }
}
