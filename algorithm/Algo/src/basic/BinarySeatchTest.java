package basic;

import java.util.Arrays;

import online.LinkedList.Node;
import sun.reflect.generics.tree.ArrayTypeSignature;

public class BinarySeatchTest {

	public static void main(String[] args) {
		int[] input = {1,5,7,10,13};//정렬됨
		
//		System.out.println(Arrays.binarySearch(input, 1));
//		System.out.println(Arrays.binarySearch(input, 5));
//		System.out.println(Arrays.binarySearch(input, 3));
//		System.out.println(Arrays.binarySearch(input, 6));
//		System.out.println(Arrays.binarySearch(input, 0));
//		//바이너리 서치 결과가 음수면 못찾은 것, 만약 찾는 키가 있었다면 어느 인덱스에 있ㅇ야하는지 리턴
//		System.out.println(Arrays.binarySearch(input, 2,3));
//		
		Node[] list = {new Node(1,3),new Node(5,2),new Node(3,7),new Node(2,4)};
		Arrays.sort(list);
		System.out.println(Arrays.binarySearch(list, new Node(5,2)));

		System.out.println(Arrays.binarySearch(list, new Node(5,2),(n1,n2)->n2.x-n1.x));
		
	}
	static class Node implements Comparable<Node>{
		int x; int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Noede [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}
		
	}

}
