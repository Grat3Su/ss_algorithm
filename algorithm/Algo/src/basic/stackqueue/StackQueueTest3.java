package basic.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

//여러개의 데이터를 포함하는 객체를 다루는 부분 <= y,x,c(비용)
//user defined class
//array <-- type 동일
public class StackQueueTest3 {

	public static void main(String[] args) {
		//사용자 정의 클래스
		//stack
		Deque<Node>stack = new ArrayDeque<>();
		stack.push(new Node(3,0,1));
		stack.push(new Node(1,2,3));
		stack.push(new Node(7,4,-3));
		stack.push(new Node(5,0,4));

		while(!stack.isEmpty()) {
			System.out.println("stack : " + stack.pop());
		}
		
		//Queue
		Queue<Node> queue= new ArrayDeque<>();
		queue.offer(new Node(4,1,5));
		queue.offer(new Node(3,4,1));
		queue.offer(new Node(2,5,3));
		queue.offer(new Node(5,2,9));
		while(!queue.isEmpty()) {
			System.out.println("queue : " + queue.poll());
		}
		
		//배열
//		Deque<int[]>stack = new ArrayDeque<>();
//		stack.push(new int[] {3,0,1});
//		stack.push(new int[] {1,2,3});
//		stack.push(new int[] {7,4,-3});
//		stack.push(new int[] {5,0,4});
//
//		while(!stack.isEmpty()) {
//			System.out.println("stack : " + Arrays.toString(stack.pop()));
//		}
//		
//		//Queue
//		Queue<int[]> queue= new ArrayDeque<>();
//		queue.offer(new int[] {3,0,1});
//		queue.offer(new int[] {1,2,3});
//		queue.offer(new int[] {7,4,-3});
//		queue.offer(new int[] {5,0,4});
//		while(!queue.isEmpty()) {
//			System.out.println("queue : " +Arrays.toString(queue.poll()));
//		}
	}
	
	//사용자 정의 클래스
	static class Node{
		int y, x, c;
		Node(int y, int x, int c){//기본 생성자x public x
			this.y = y;
			this.x = x;
			this.c =c;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", c=" + c + "]";
		}
		
	}

}
/*
 * 
  */
 