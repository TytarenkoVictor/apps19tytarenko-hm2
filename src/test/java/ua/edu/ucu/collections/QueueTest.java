package ua.edu.ucu.collections;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {
    private Queue q;

    @Before
    public void setUp() {
        q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3.0);
        q.enqueue("d");
    }

    @Test
    public void testPeek() {
        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());
        assertEquals(3.0, q.dequeue());
    }

    @Test
    public void testDequeue() {
        assertEquals(1, q.peek());
    }

    @Test
    public void testEnqueue(){
        q.enqueue(22);
        assertEquals(1, q.dequeue());
    }

}
