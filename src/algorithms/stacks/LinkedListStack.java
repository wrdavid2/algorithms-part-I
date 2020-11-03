package algorithms.stacks;

public class LinkedListStack<T> {
    private class Node<T> {
        T item;
        Node<T> next;
    }

    private Node<T> first = null;

    public LinkedListStack() {
    }

    public void push(T item) {
        Node<T> oldFirst = first;
        first = new Node<T>();
        first.item = item;
        first.next = oldFirst;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }


}
