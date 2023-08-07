package online.LinkedList;

import java.util.EmptyStackException;

public class LinkedListStack<E> implements Istack<E> {

	private Node<E> top = null;//맨 처음은 공백
	@Override
	public void push(E e) {//첫 노드로 삽입
		top = new Node<>(e, top);
		
	}

	@Override
	public E pop() {//첫 노드 삭제해서 반환해야함
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		Node<E> popNode = top;
		top = popNode.getLink();
		return popNode.getData();
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getData();
	}

	@Override
	public int size() {
		int size = 0;
		
		for(Node<E> temp = top; temp!=null; temp = temp.getLink()) {
			++size;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {		
		return top == null;
	}

}
