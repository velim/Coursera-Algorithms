import static org.junit.Assert.*;

import org.junit.Test;


public class TestDeque {

	@Test
	public void testAddFirst() {
		Deque<String> queue = new Deque<String>();
		queue.addFirst("A");
		queue.addFirst("B");
		queue.addFirst("C");
		assertEquals("testAddFirst", "A" , queue.removeLast());		
		assertEquals("testAddFirst", "B" , queue.removeLast());
		assertEquals("testAddFirst", "C" , queue.removeLast());
		assertEquals("size = 0", 0 , queue.size());
	}
	
}
