import java.util.Iterator;

public class SearchList<T extends Comparable<T>> implements SList<T> {

    public class Node {
        T obj;
        Node next;
        int occurences;

        public Node() {
            this.obj = null;
            this.next = null;
            this.occurences = 1;
        }
    }

    private Node head;

    @Override
    public void add(T t) {
        Node pointer;
        Node n = new Node();
        n.obj = t;

        if(head != null && head.obj.compareTo(n.obj) == 0) {
            head.occurences++;
            return;
        }

        if(head == null || head.obj.compareTo(n.obj) > 0) {
            n.next = head;
            head = n;
        }
        else {

            pointer = head;

            while(pointer.next != null && pointer.next.obj.compareTo(n.obj) <= 0) {
                if (pointer.next.obj.compareTo(n.obj) == 0) {
                    pointer.next.occurences++;
                    return;
                }
                pointer = pointer.next;
            }

            n.next = pointer.next;
            pointer.next = n;

        }
    }

    public void printList(){

        Node iterator = head;
        while (iterator != null) {
            System.out.println(iterator.obj + "\tvorkommen: " + iterator.occurences);
            iterator = iterator.next;
        }
    }

    @Override
    public int count(T t) {
        Node iterator = head;
        while (iterator != null) {
            if(t.compareTo(iterator.obj) == 0) return iterator.occurences ;
            iterator = iterator.next;
        }
        return 0;
    }

    @Override
    public boolean remove(T t) {
        Node iterator = head;
        while (iterator.next != null) {
            if (iterator.next.obj.compareTo(t) == 0) {
                iterator.next = iterator.next.next;
            }
            iterator = iterator.next;
        }
        return true;
    }

    @Override
    public int noOccurences() {
        Node iterator = head;
        int sum = 0;
        while (iterator != null) {
            sum += iterator.occurences;
            iterator = iterator.next;
        }
        return sum;
    }

    @Override
    public int noWords() {
        Node iterator = head;
        int counter = 0;
        while (iterator != null) {
            counter ++;
            iterator = iterator.next;
        }
        return counter;
    }

    @Override
    public Iterator<T> iterator() {

        Node current = head;

        Iterator<T> iterator = new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                return null;
            }
        };
        return iterator;
    }
}