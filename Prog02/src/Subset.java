

public class Subset {
 
   public static void main(String[] args) {
       int k = Integer.valueOf(args[0]);
       
       RandomizedQueue<String> queue = new RandomizedQueue<String>();
       
       while (!StdIn.isEmpty()) {
           // add to Deque or RandomizedQueue
           queue.enqueue(StdIn.readString());
       }
       
       for (int i = 0; i < k; i++) {
           System.out.println(queue.dequeue());
//           System.out.println(queue.size());
       }
       
   }
}