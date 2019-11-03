package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList{
    private int size;
    private Object[] arr;

    public ImmutableArrayList() {
        arr = new Object[1];
        size = 0;
    }

    public ImmutableArrayList(Object[] elements) {
        size = elements.length;
        arr = Arrays.copyOf(elements, elements.length);
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
        int newLenght = arr.length + c.length;
        Object[] newArr = Arrays.copyOf(arr, newLenght);
        System.arraycopy(c, 0, newArr, arr.length, c.length);
        return new ImmutableArrayList(newArr);
    }

    public ImmutableList addAll(int index, Object[] c){
        check(index);
        int newLenght = arr.length + c.length;
        int boundary = index + c.length - 1;
        Object[] newArr = new Object[newLenght];
        int count = 0;
        for (int i = 0; i < newLenght; i++) {
            if (i < index || i > boundary){
                newArr[i] = arr[count];
                count++;
            }else{
                newArr[i] = c[i - count];
            }
        }
        return new ImmutableArrayList(newArr);
    }
    public Object get(int index){
        check(index);
        return arr[index];
    }

    public ImmutableList remove(int index){
        check(index);
        Object[] newArr = Arrays.copyOf(arr, arr.length - 1);
        for (int i = index; i < arr.length - 1; i++){
            newArr[i] = arr[i + 1];
        }
        return new ImmutableArrayList(newArr);
    }

    public ImmutableList set(int index, Object e){
        check(index);
        Object[] newArr = Arrays.copyOf(arr, arr.length);
        newArr[index] = e;
        return new ImmutableArrayList(newArr);
    }

    public int indexOf(Object e){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e){
                return i;
            }
        }
        return -1;
    }

    public int size(){
        return arr.length;
    }

    public  ImmutableList clear(){
        return new ImmutableArrayList();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object[] toArray(){
        return Arrays.copyOf(arr, size);
    }

    private void check(int index) {
        if (index > size){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}

