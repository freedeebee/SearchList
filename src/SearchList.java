import java.util.Iterator;

public class SearchList<T extends Comparable<T>> implements SList<T> {

    public class Node {
        T obj;
        Node next;
    }

    private Node head = new Node();
    private Node pointer;

    public SearchList() {
        pointer = head;
    }

    @Override
    public void add(T t) {

        Node n = new Node();

        pointer.next = n;
        n.obj = t;
        pointer = n;


    }

    public void printList(){

        Node iterator = head;
        while (iterator.next != null) {
            System.out.println(iterator.next.obj);
            iterator = iterator.next;
        }
    }

    @Override
    public int count(T t) {
        return 0;
    }

    @Override
    public boolean remove(T t) {
        Node iterator = head;
        int counter = 0;
        while (iterator.next != null) {
            if (iterator.next.obj == t) {
                iterator.next = iterator.next.next;
            }
            iterator = iterator.next;
        }
        return true;
    }

    @Override
    public int noOccurences() {
        return 0;
    }

    @Override
    public int noWords() {
        Node iterator = head;
        int counter = 0;
        while (iterator.next != null) {
            counter ++;
            iterator = iterator.next;
        }
        return counter;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}