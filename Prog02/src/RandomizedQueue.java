import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] s;
    private int cnt = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        s = (Item[]) new Object[1];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return cnt == 0;
    }

    // return the number of items on the queue
    public int size() {
        return cnt;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (cnt == s.length)
            doublearray();
        s[cnt++] = item;
    }

    private void doublearray() {
        Item[] newarray = (Item[]) new Object[s.length * 2];
        for (int i = 0; i < s.length; i++)
            newarray[i] = s[i];
        s = newarray;
    }

    // delete and return a random item
    public Item dequeue() {
        if (cnt == 0)
            throw new NoSuchElementException();
        int rand = StdRandom.uniform(cnt);
        Item item = s[rand];
        s[rand] = s[cnt - 1];
        s[cnt - 1] = null;
        cnt--;
        if (cnt > 0 && cnt < (s.length / 4))
            shrinkarray();
        return item;
    }

    private void shrinkarray() {
        Item[] newarray = (Item[]) new Object[cnt];
        for (int i = 0; i < cnt; i++)
            newarray[i] = s[i];
        s = newarray;

    }

    // return (but do not delete) a random item
    public Item sample() {
        if (cnt == 0)
            throw new NoSuchElementException();
        int rand = StdRandom.uniform(s.length);
        while (s[rand] == null)
            rand = StdRandom.uniform(s.length);
        return s[rand];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private boolean[] inner = new boolean[s.length];
            private int tc = 0;

            public boolean hasNext() { return tc < cnt; }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                int act = StdRandom.uniform(inner.length);
                while (inner[act] || s[act] == null)
                    act = StdRandom.uniform(inner.length);
                inner[act] = true;
                tc++;
                return s[act];
            }

            public void remove() { throw new UnsupportedOperationException(); }

        };
    }
}