package online.LinkedList;

public class Node<T> {
	private T data;
	private Node<T>link;//다음 노드에 대한 정보
	public Node(T data, Node<T> link) {
		super();
		this.data = data;
		this.link = link;
	}
	public Node(T data) {
		super();
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getLink() {
		return link;
	}
	public void setLink(Node<T> link) {
		this.link = link;
	}
	
}