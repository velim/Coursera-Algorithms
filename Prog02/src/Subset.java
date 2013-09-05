
public class Subset {
 
   public static void main(String[] args){
       int k = Integer.valueOf(args[0]);
       
       Deque<String> queue = new Deque<String>();
       
       while(!StdIn.isEmpty()){
           // add to Deque or RandomizedQueue
           queue.addLast(StdIn.readString());
       }
       
   
       for (int i = 0; i < k; i++){
           System.out.println(queue.removeFirst()); 
       }
       
   }
}