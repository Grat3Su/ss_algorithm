package online.LinkedList;

public interface Istack<E> {
	void push(E e);
	E pop();
	E peek();
	int size();
	boolean isEmpty();
}
