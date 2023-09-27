package algo2.off230927;

import java.io.*;
import java.util.*;
//가중치가 1이기 때문에 BFS를 쓸 수 있다.

public class SW_1263_peoplenetwork2_2 {
	static int N, min;
	static ArrayList<ArrayList<Integer>> adjlist;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			adjlist = new ArrayList<>();
			
			for(int i = 0; i<N; i++) {
				adjlist.add(new ArrayList<>());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n==1)
						adjlist.get(i).add(j);
				}
			}
			min = Integer.MAX_VALUE;
			//각 정점(사람) 별로 각자 최단 경로 구해서 n 갱신
			for(int i = 0; i<N; i++) {

				bfs(i);
			}
			sb.append("#").append(t).append(" ").append(min).append("\n");
			

		}
		System.out.println(sb);
	}

	private static void bfs(int V) {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N];
		
		visit[V] = true;
		queue.offer(new Node(V, 0));
		
		int dist = 0;//최단경로 표시
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			//node.v <- adjlist.get(node.v) -> v로부터 갈 수 있는 리스트가 나온다.
			for(int v : adjlist.get(node.v)) {
				if(visit[v])continue;//방문했따
				dist+=node.cnt+1;
				
				if(dist >= min)return;//가지치기
				
				visit[v] = true;
				queue.offer(new Node(v, node.cnt+1));
			}
			 
		}   
		min = Math.min(min, dist);
	}
	
	static class Node{
		int v, cnt;

		public Node(int v, int cnt) {
			super();
			this.v = v;
			this.cnt = cnt;
		}		
	}
}
