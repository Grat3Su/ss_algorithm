package online;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class AdjList {
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
		
		int[][]adjMatrix = new int[V][V];
		//간선이 있으면 1 없으면 0
		
		//연결리스트로 인접 리스트 표현
		Node adjList[] = new Node[V];
		
		for(int i = 0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] =adjMatrix[to][from] =1;
			adjList[from] =new Node(to,adjList[from]); 
			adjList[to] =new Node(from,adjList[to]);
		}
		for(Node node:adjList) {
			//System.out.println(node);
		}
		
		bfs(adjMatrix);
		bfsList(adjList);
	}
	static void bfs(int adjMatrix[][]) {
		int size = adjMatrix.length;
		Queue<Integer> queue = new ArrayDeque<Integer>();//큐에 넣는 ㄱㅄ은 방문대상을 관리할 값과 그 밖의 값들을 넣을 수 있다.
		boolean[] visited = new boolean[size];
		
		//탐색 시작점 정점0
		queue.offer(0);
		visited[0]  = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current+65));
			
			//한 정점의 인접 ㅈ정점들 체크하며 대기열에 넣기
			for(int i = 0; i<size; i++) {
				if(adjMatrix[current][i] !=0&&!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}					
			}
		}
			dfs(adjMatrix, visited, 0);
		}
	static void dfs(int adjMatrix[][],boolean [] visited, int current) {
		
		visited[current]  = true;
		
			System.out.println((char)(current+65));
			
			//한 정점의 인접 ㅈ정점들 체크하며 대기열에 넣기
			for(int i = 0,size = adjMatrix.length; i<size; i++) {
				if(adjMatrix[current][i] !=0&&!visited[i]) {
					
					dfs(adjMatrix, visited, i); 
				}					
			}
		
		
	}
		static void bfsList(Node adjList[]) {
			int size = adjList.length;
			Queue<Integer> queue = new ArrayDeque<>();//큐에 넣는 ㄱㅄ은 방문대상을 관리할 값과 그 밖의 값들을 넣을 수 있다.
			boolean[] visited = new boolean[size];
			
			//탐색 시작점 정점0
			queue.offer(0);
			visited[0]  = true;
			
			while(!queue.isEmpty()) {
				int current = queue.poll();
				System.out.println((char)(current+65));
				
				//한 정점의 인접 ㅈ정점들 체크하며 대기열에 넣기
				for(Node temp = adjList[current];temp!=null; temp = temp.next) {
					if(!visited[temp.vertex]) {
						queue.offer(temp.vertex);
						visited[temp.vertex] = true;
					}
					
				}
				
			}
	}
		static void dfsList(int adjMatrix[][],boolean [] visited, int current) {
		
		visited[current]  = true;
		
			System.out.println((char)(current+65));
			
			//한 정점의 인접 ㅈ정점들 체크하며 대기열에 넣기
//			for(Node temp = adjlist[current]; temp !=null; temp = temp.next) {
//				if!visited[vertex]) {
//					
//					dfs(adjMatrix, visited, i); 
//				}					
//			}
		
		
	}

}
