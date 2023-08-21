package online;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class AdjMatrixTest2 {
	static class Node{//인접리스트 안에 들어가는 노드
		int vertex;//관계를 맺고 있는 타정점 정보
		Node next;//연결리스트를 유지하기 위한 다음노드
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		//int[][]adjMatrix = new int[V][V];
		//간선이 있으면 1 없으면 0
		
		//연결리스트로 인접 리스트 표현
		Node adjList[] = new Node[V];
		
		for(int i = 0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] =new Node(to,adjList[from]); 
			adjList[to] =new Node(from,adjList[to]);
		}
		for(Node node:adjList) {
			System.out.println(node);
		}
		
	}

}
