import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int cnt;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // construct an empty deque
    public Deque() {
        cnt = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return (cnt == 0);
    }

    // return the number of items on the deque
    public int size() {
        return cnt;
    }

    // insert the item at the front
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node newnode = new Node();
        if (first != null)
            first.prev = newnode;
        newnode.item = item;
        newnode.next = first;
        if (first == null)
            last = newnode;
        first = newnode;
        cnt++;
    }

    // insert the item at the end
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.prev = oldlast;
        if (first == null)
            first = last;
        if (oldlast != null)
            oldlast.next = last;
        cnt++;
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (cnt == 0)
            throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if (first != null)
            first.prev = null;
        cnt--;
        if (cnt == 0) {
            first = null;
            last = null;
        }
        return item;
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (cnt == 0)
            throw new NoSuchElementException();
        Item item = last.item;
        last = last.prev;
        if (last != null)
            last.next = null;
        cnt--;
        if (cnt == 0) {
            first = null;
            last = null;
        }
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;

            public boolean hasNext() {
                return current != null;
            }

            public Item next() {
                if (current == null)
                    throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

}
