import static org.junit.Assert.*;

import org.junit.Test;


public class TestDeque {

	@Test
	public void testAddFirst() {
		Deque<String> queue = new Deque<String>();
		queue.addFirst("A");
		queue.addFirst("B");
		queue.addFirst("C");
		assertEquals("A", "A" , queue.removeLast());
		queue.addFirst("D");
		assertEquals("B", "B" , queue.removeLast());
		assertEquals("C", "C" , queue.removeLast());
		queue.addFirst("E");
		queue.addFirst("F");
		assertEquals("D", "D" , queue.removeLast());
		assertEquals("E", "E" , queue.removeLast());
		assertEquals("F", "F" , queue.removeLast());
		queue.addFirst("G");		
		assertEquals("G", "G" , queue.removeLast());
		
		assertEquals("size = 0", 0 , queue.size());
	}
	
}
