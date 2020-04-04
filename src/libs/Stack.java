package libs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Stack.Node<Item> first = null;
    private int n = 0;

    public Stack() {

    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.n;
    }

    public void push(Item item) {
        Node<Item> oldfirst = this.first;
        this.first = new Stack.Node();
        this.first.item = item;
        this.first.next = oldfirst;
        ++this.n;
    }

    public Item pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        } else {
            Item item = this.first.item;
            this.first = this.first.next;
            --this.n;
            return item;
        }
    }

    public Item peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        } else {
            return this.first.item;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator var2 = this.iterator();

        while(var2.hasNext()) {
            Item item = (Item) var2.next();
            s.append(item);
            s.append(' ');
        }

        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(this.first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                Item item = this.current.item;
                this.current = this.current.next;
                return item;
            }
        }
    }

    private static class Node<Item> {
        private Item item;
        private Stack.Node<Item> next;
        private Node() {
        }
    }
}
