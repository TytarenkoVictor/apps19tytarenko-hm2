package ua.edu.ucu.collections.immutable;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList numberint;
    private ImmutableLinkedList numberfloat;
    private ImmutableLinkedList string;
    private ImmutableLinkedList empty;

    @Before
    public void setUp(){
        numberint = new ImmutableLinkedList(new Object[]{1, 2, 3, 4, 5, 6});
        numberfloat = new ImmutableLinkedList(new Object[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0});
        string = new ImmutableLinkedList(new Object[]{"a", "b", "c", "d", "e", "f"});
        empty = new ImmutableLinkedList();
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList test1 = (ImmutableLinkedList) numberint.add(10);
        ImmutableLinkedList test2 = (ImmutableLinkedList) numberfloat.add(10.0);
        ImmutableLinkedList test3 = (ImmutableLinkedList) string.add("a");
        ImmutableLinkedList test5 = (ImmutableLinkedList) numberint.add(3, 10);
        Object[] expected1 = {1, 2, 3, 4, 5, 6, 10};
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 10.0};
        Object[] expected3 = {"a", "b", "c", "d", "e", "f", "a"};
        Object[] expected5 = {1, 2, 3, 10, 4, 5, 6};
        assertArrayEquals(expected1, test1.toArray());
        assertArrayEquals(expected2, test2.toArray());
        assertArrayEquals(expected3, test3.toArray());
        assertArrayEquals(expected5, test5.toArray());

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testError() {
        numberint.add(-2, 10);
        numberint.add(100, 10);
    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList test1 = (ImmutableLinkedList) numberint.addAll(numberfloat.toArray());
        Object[] expected1 = {1, 2, 3, 4, 5, 6, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        assertArrayEquals(expected1, test1.toArray());
        ImmutableLinkedList test2 = (ImmutableLinkedList) numberfloat.addAll(4, string.toArray());
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, "a", "b", "c", "d", "e", "f", 5.0, 6.0};
        assertArrayEquals(expected2, test2.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testError2() {
        numberint.addAll(-2, string.toArray());
        numberint.addAll(100, numberfloat.toArray());
    }

    @Test
    public void testGet(){
        Object test1 = numberint.get(0);
        assertEquals(1, test1);
        Object test2 = numberfloat.get(1);
        assertEquals(2.0, test2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testError3() {
        numberfloat.get(600);
        numberint.get(-1111);
    }

    @Test
    public void testRemove(){
        ImmutableLinkedList test1 = (ImmutableLinkedList) numberint.remove(1);
        Object[] expected1 = {1, 3, 4, 5, 6};
        assertArrayEquals(expected1, test1.toArray());
        ImmutableLinkedList test2 = (ImmutableLinkedList) numberfloat.remove(4);
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, 6.0};
        assertArrayEquals(expected2, test2.toArray());
        ImmutableLinkedList test3 = (ImmutableLinkedList) string.remove(0);
        Object[] expected3 = {"b", "c", "d", "e", "f"};
        assertArrayEquals(expected3, test3.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testError4() {
        numberint.remove(100);
        numberfloat.remove(-10);
        string.remove(99);
    }

    @Test
    public void testSet(){
        ImmutableLinkedList test1 = (ImmutableLinkedList) numberint.set(1, "rr");
        Object[] expected1 = {1, "rr", 3, 4, 5, 6};
        assertArrayEquals(expected1, test1.toArray());
        ImmutableLinkedList test2 = (ImmutableLinkedList) numberfloat.set(4, 5);
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, 5, 6.0};
        assertArrayEquals(expected2, test2.toArray());
        ImmutableLinkedList test3 = (ImmutableLinkedList) string.set(0, 0);
        Object[] expected3 = {0, "b", "c", "d", "e", "f"};
        assertArrayEquals(expected3, test3.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testError5() {
        numberint.set(100, 34);
        numberfloat.set(-10, 787);
        string.set(99, "rt");
    }

    @Test
    public void testIndexof(){
        assertEquals(0, numberint.indexOf(1));
        assertEquals(-1, numberint.indexOf('a'));
        assertEquals(-1, numberfloat.indexOf(1));
        assertEquals(-1, string.indexOf(1));
    }

    @Test
    public void testSize(){
        assertEquals(6, numberint.size());
        assertEquals(6, numberfloat.size());
        assertEquals(6, string.size());
    }

    @Test
    public void testClear() {
        ImmutableList test1 = numberint.clear();
        Object[] expected1 = new Object[0];
        ImmutableList test2 = numberfloat.clear();
        Object[] expected2 = new Object[0];
        ImmutableList test3 = string.clear();
        Object[] expected3 = new Object[0];
        assertArrayEquals(expected1, test1.toArray());
        assertArrayEquals(expected2, test2.toArray());
        assertArrayEquals(expected3, test3.toArray());
    }

    @Test
    public void testIsEmpty() {
        boolean test1 = numberfloat.isEmpty();
        boolean test2 = numberint.isEmpty();
        boolean test3 = string.isEmpty();
        boolean test4 = empty.isEmpty();
        assertFalse(test1);
        assertFalse(test2);
        assertFalse(test3);
        assertTrue(test4);
    }

    @Test
    public void testToArray() {
        Object[] test1 = numberint.toArray();
        Object[] test2 = numberfloat.toArray();
        Object[] test3 = string.toArray();
        Object[] expected1 = {1, 2, 3, 4, 5, 6};
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        Object[] expected3 = {"a", "b", "c", "d", "e", "f"};
        assertArrayEquals(expected1, test1);
        assertArrayEquals(expected2, test2);
        assertArrayEquals(expected3, test3);
    }

    @Test
    public void testToString() {
        String test1 = numberint.toString();
        String test2 = numberfloat.toString();
        String test3 = string.toString();
        String expected1 = "[1, 2, 3, 4, 5, 6]";
        String expected2 = "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]";
        String expected3 = "[a, b, c, d, e, f]";
        assertEquals(expected1, test1);
        assertEquals(expected2, test2);
        assertEquals(expected3, test3);
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList test1 = numberint.addFirst(0);
        ImmutableLinkedList test2 = numberfloat.addFirst(0.0);
        ImmutableLinkedList test3 = string.addFirst("f");
        Object[] expected1 = {0, 1, 2, 3, 4, 5, 6};
        Object[] expected2 = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        Object[] expected3 = {"f", "a", "b", "c", "d", "e", "f"};
        assertArrayEquals(expected1, test1.toArray());
        assertArrayEquals(expected2, test2.toArray());
        assertArrayEquals(expected3, test3.toArray());
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList test1 = numberint.addLast(0);
        ImmutableLinkedList test2 = numberfloat.addLast(0.0);
        ImmutableLinkedList test3 = string.addLast("f");
        Object[] expected1 = {1, 2, 3, 4, 5, 6, 0};
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 0.0};
        Object[] expected3 = {"a", "b", "c", "d", "e", "f", "f"};
        assertArrayEquals(expected1, test1.toArray());
        assertArrayEquals(expected2, test2.toArray());
        assertArrayEquals(expected3, test3.toArray());
    }

    @Test
    public void testGetFirst() {
        assertEquals(1, numberint.getFirst());
        assertEquals(1.0, numberfloat.getFirst());
        assertEquals("a", string.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals(6, numberint.getLast());
        assertEquals(6.0, numberfloat.getLast());
        assertEquals("f", string.getLast());
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList test1 = numberint.removeFirst();
        ImmutableLinkedList test2 = numberfloat.removeFirst();
        ImmutableLinkedList test3 = string.removeFirst();
        Object[] expected1 = {2, 3, 4, 5, 6};
        Object[] expected2 = {2.0, 3.0, 4.0, 5.0, 6.0};
        Object[] expected3 = {"b", "c", "d", "e", "f"};
        assertArrayEquals(expected1, test1.toArray());
        assertArrayEquals(expected2, test2.toArray());
        assertArrayEquals(expected3, test3.toArray());
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList test1 = numberint.removeLast();
        ImmutableLinkedList test2 = numberfloat.removeLast();
        ImmutableLinkedList test3 = string.removeLast();
        Object[] expected1 = {1, 2, 3, 4, 5};
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, 5.0};
        Object[] expected3 = {"a", "b", "c", "d", "e"};
        assertArrayEquals(expected1, test1.toArray());
        assertArrayEquals(expected2, test2.toArray());
        assertArrayEquals(expected3, test3.toArray());
    }
}
