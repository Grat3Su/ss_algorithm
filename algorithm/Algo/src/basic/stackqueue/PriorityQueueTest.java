package basic.stackqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

import basic.stackqueue.StackQueueTest3.Node;

public class PriorityQueueTest {

	public static void main(String[] args) {
		/*{
			PriorityQueue<Integer> pqueurInt = new PriorityQueue<>();
			pqueurInt.offer(5);
			pqueurInt.offer(3);
			pqueurInt.offer(2);
			pqueurInt.offer(7);
			pqueurInt.offer(8);
			pqueurInt.offer(1);
			pqueurInt.offer(6);

			while (!pqueurInt.isEmpty()) {
				System.out.print(pqueurInt.poll() + " ");
			}

			for (Integer integer : pqueurInt) {
				System.out.print(integer);
			}
		}*/
		{
			//user define class
			//생성자에 대한 규칙제공
			//comparable interface 생성
			PriorityQueue<Node> pqueurInt = new PriorityQueue<>();
			pqueurInt.offer(new Node(4,1,5));
			pqueurInt.offer(new Node(3,4,1));
			pqueurInt.offer(new Node(2,5,3));
			pqueurInt.offer(new Node(5,2,9));
			
			
			while (!pqueurInt.isEmpty()) {
				System.out.print(pqueurInt.poll() + " ");
			}
			//user define class
			//생성자에 대한 규칙제공
			//comparable interface 생성
//			PriorityQueue<Node> pqueurInt = new PriorityQueue<>((n1,n2)->n2.c-n1.c);
//			pqueurInt.offer(new Node(4,1,5));
//			pqueurInt.offer(new Node(3,4,1));
//			pqueurInt.offer(new Node(2,5,3));
//			pqueurInt.offer(new Node(5,2,9));
//			
//			
//			while (!pqueurInt.isEmpty()) {
//				System.out.print(pqueurInt.poll() + " ");
//			}
			
			
		}
	}
	//사용자 정의 클래스
		static class Node implements Comparable<Node>{
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
			@Override
			public int compareTo(Node o) {
				// TODO Auto-generated method stub
				return o.y - this.y;
			}
			
		}

}
