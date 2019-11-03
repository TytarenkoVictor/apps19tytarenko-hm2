package ua.edu.ucu.collections;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    private Stack s;

    @Before
    public void setUp() {
        s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3.0);
        s.push("d");
    }

    @Test
    public void testPop() {
        assertEquals("d", s.pop());
        assertEquals(3.0, s.pop());
        assertEquals(2, s.pop());
    }

    @Test
    public void testPeek() {
        assertEquals("d", s.peek());
    }

    @Test
    public void testPush(){
        s.push("RR");
        assertEquals("RR", s.peek());
    }
}
