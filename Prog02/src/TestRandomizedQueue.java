import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class TestRandomizedQueue {

	@Test
	public void test() {
		int N = 10000;
		int enqcnt = 0;
		int deqcnt = 0;
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println("1");
		queue.enqueue("A");
		System.out.println("2");
//		for(int i = 0; i <N; i++){
//			if (StdRandom.uniform(10) == 9){
//				queue.dequeue();
//				deqcnt++;
//			}else{
//				queue.enqueue(String.valueOf(i));
//				enqcnt++;
//			}
//		}
		System.out.println(enqcnt);
		System.out.println(deqcnt);
	}
}
