package ua.edu.ucu.collections.immutable;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ImmutableArrayListTest {
    private ImmutableArrayList numberint;
    private ImmutableArrayList numberfloat;
    private ImmutableArrayList string;
    private ImmutableArrayList empty;

    @Before
    public void setUp(){
        numberint = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5, 6});
        numberfloat = new ImmutableArrayList(new Object[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0});
        string = new ImmutableArrayList(new Object[]{"a", "b", "c", "d", "e", "f"});
        empty = new ImmutableArrayList();
    }

    @Test
    public void testAdd() {
        ImmutableArrayList test1 = (ImmutableArrayList) numberint.add(10);
        ImmutableArrayList test2 = (ImmutableArrayList) numberfloat.add(10.0);
        ImmutableArrayList test3 = (ImmutableArrayList) string.add("a");
        ImmutableArrayList test5 = (ImmutableArrayList) numberint.add(3, 10);
        Object[] expected1 = {1, 2, 3, 4, 5, 6, 10};
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 10.0};
        Object[] expected3 = {"a", "b", "c", "d", "e", "f", "a"};
        Object[] expected5 = {1, 2, 3, 10, 4, 5, 6};
        assertArrayEquals(expected1, test1.toArray());
        assertArrayEquals(expected2, test2.toArray());
        assertArrayEquals(expected3, test3.toArray());
        assertArrayEquals(expected5, test5.toArray());

    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testError() {
        numberint.add(-2, 10);
        numberint.add(100, 10);
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList test1 = (ImmutableArrayList) numberint.addAll(numberfloat.toArray());
        Object[] expected1 = {1, 2, 3, 4, 5, 6, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        assertArrayEquals(expected1, test1.toArray());
        ImmutableArrayList test2 = (ImmutableArrayList) numberfloat.addAll(4, string.toArray());
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, "a", "b", "c", "d", "e", "f", 5.0, 6.0};
        assertArrayEquals(expected2, test2.toArray());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
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
        ImmutableArrayList test1 = (ImmutableArrayList) numberint.remove(1);
        Object[] expected1 = {1, 3, 4, 5, 6};
        assertArrayEquals(expected1, test1.toArray());
        ImmutableArrayList test2 = (ImmutableArrayList) numberfloat.remove(4);
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, 6.0};
        assertArrayEquals(expected2, test2.toArray());
        ImmutableArrayList test3 = (ImmutableArrayList) string.remove(0);
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
        ImmutableArrayList test1 = (ImmutableArrayList) numberint.set(1, "rr");
        Object[] expected1 = {1, "rr", 3, 4, 5, 6};
        assertArrayEquals(expected1, test1.toArray());
        ImmutableArrayList test2 = (ImmutableArrayList) numberfloat.set(4, 5);
        Object[] expected2 = {1.0, 2.0, 3.0, 4.0, 5, 6.0};
        assertArrayEquals(expected2, test2.toArray());
        ImmutableArrayList test3 = (ImmutableArrayList) string.set(0, 0);
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
}

