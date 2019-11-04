package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableLinkedList implements ImmutableList{
    private Node head;
    private Node tail;
    private int size;
    
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

    public ImmutableLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public ImmutableLinkedList(Object[] elements) {
        size = elements.length;
        Node current = new Node(elements[0]);
        head = current;
        tail = current;
        for (int i = 1; i < size; i++) {
            Node newH = new Node(elements[i]);
            current.setNext(newH);
            current = newH;
            tail = newH;
        }
    }

    public ImmutableLinkedList addFirst(Object e){
        return  (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e){
        return (ImmutableLinkedList) add(size, e);
    }

    public Object getFirst(){
        return head.getValue();
    }

    public Object getLast(){
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst(){
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast(){
        return (ImmutableLinkedList) remove(size - 1);
    }

    public ImmutableList add(Object e){
        Object[] elem = new Object[]{e};
        return addAll(elem);
    }

    public ImmutableList add(int index, Object e){
        check(index);
        Object[] elem = new Object[]{e};
        return addAll(index, elem);
    }

    public ImmutableList addAll(Object[] c) {
        int newLenght = size + c.length;
        Object[] newArr = Arrays.copyOf(toArray(), newLenght);
        System.arraycopy(c, 0, newArr, size, c.length);
        return new ImmutableLinkedList(newArr);
    }

    public ImmutableList addAll(int index, Object[] c){
        check(index);
        int newLenght = size + c.length;
        int boundary = index + c.length - 1;
        Object[] newArr = new Object[newLenght];
        Node newH = head;
        int count = 0;
        for (int i = 0; i < newLenght; i++) {
            if (i < index || i > boundary){
                newArr[i] = newH.getValue();
                newH = newH.getNext();
                count++;
            }else{
                newArr[i] = c[i - count];
            }
        }
        return new ImmutableLinkedList(newArr);
    }

    public Object get(int index){
        check(index);
        Node newH = head;
        for (int i = 0; i < index; i++) {
            newH = newH.getNext();
        }
        return newH.getValue();
    }

    public ImmutableList remove(int index){
        check(index);
        Node newH = head;
        Object[] newArr = new Object[size - 1];
        for (int i = 0; i < index; i++){
            newArr[i] = newH.getValue();
            newH = newH.getNext();
        }
        newH = newH.getNext();
        for (int k = index; k < size - 1; k++){
            newArr[k] = newH.getValue();
            newH = newH.getNext();
        }
        return new ImmutableLinkedList(newArr);
    }

    public ImmutableList set(int index, Object e){
        check(index);
        Object[] newArr = Arrays.copyOf(toArray(), size);
        newArr[index] = e;
        return new ImmutableLinkedList(newArr);
    }

    public int indexOf(Object e){
        Node newH = head;
        for (int i = 0; i < size; i++) {
            if (newH.getValue() == e){
                return i;
            }
            newH = newH.getNext();
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public  ImmutableList clear(){
        return new ImmutableLinkedList();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object[] toArray(){
        Object[] arr = new Object[size];
        Node newH = head;
        for (int i = 0; i < size; i++) {
            arr[i] = newH.getValue();
            newH = newH.getNext();
        }
        return arr;
    }

    private void check(int index) {
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}

