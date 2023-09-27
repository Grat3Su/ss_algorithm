package algo2.off230927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// 간선 비용이 존재? 맨하튼 거리가 간선 비용이 아니다. 단순 연결여부를 파악하기 위한 중간값
// bfs() 또는 플로이드워셜로 가능

// SW_사람네트워크2_1263_2 는 모든 사람의 CC 를 구해서 최소값을 찾아야 하므로 bfs() 를 모든 사람(정점)에 대해서 진행
// 이 문제는 집 -> 락페스티벌로 가는 경로만 따지면 된다.
// SW_사람네트워크2_1263_2 는 CC 를 구하기 위해 Node 에 cnt 변수를 관리 ( 이 cnt의 합이 CC )
// 이 문제는 연결성만 본다. cnt 필요X
public class BOJ_9205_beerwalk_bfs {
	static int T, N, V;
	static int[][] input;
	static ArrayList<ArrayList<Integer>> adjList;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
		
			N = Integer.parseInt(br.readLine());
			V = N + 2; // 편의점 + 집 + 공연장
			
			input = new int[V][2];
			adjList = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				adjList.add(new ArrayList<>());
			}
			
			// 입력 처리
			for (int i = 0; i < V; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 입력으로부터 인접행렬을 만든다.
			for (int i = 0; i < V; i++) {
				int vy = input[i][0];
				int vx = input[i][1];
				
				for (int j = 0; j < V; j++) {
					if( i == j ) continue;
					
					int ty = input[j][0];
					int tx = input[j][1];
					int dis = Math.abs(ty-vy) + Math.abs(tx-vx); // 맨하튼 거리
					
					if( dis <= 1000 ) { // 맥주를 마시면서 갈 수 있는 거리
						adjList.get(i).add(j);
					}
				}
			}
			
			// 집 -> 락페스티벌
			bfs();
			
		}
	}
	
	static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[V];
		
		// 시작점(집) 추가
		visit[0] = true;
		queue.offer(new Node(0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if( node.v == V-1) { // 종점 락페스트벌에 도착하면 종료
				System.out.println("happy");
				return;
			}
			
			for (int v : adjList.get(node.v)) {
				
				if( visit[v] ) continue;
				visit[v] = true;
				queue.offer(new Node(v));
			}
		}
		System.out.println("sad"); // 여기까지 왔으면 종점 락페스티벌에 도착하지 못함.
	}
	
	static class Node{
		int v;
		Node(int v){
			this.v = v;
		}
	}
}
