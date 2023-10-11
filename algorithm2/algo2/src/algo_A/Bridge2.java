package algo_A;
/*
 * 7 8
0 0 0 0 0 0 1 1
1 1 0 0 0 0 1 1
1 1 0 0 0 0 0 0
1 1 0 0 0 1 1 0
0 0 0 0 0 1 1 0
0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1
->9
 */

import java.io.*;
import java.util.*;

public class Bridge2 {
	static int N, M, min;
	static int V;
	static int[][] map;
	static boolean[][] visit;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static int[] parent;

	static class Edge {
		int v1, v2, cost;

		public Edge(int v1, int v2, int cost) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		
	}

	static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					dfs(i, j, num);
					num++;
				}
			}
		}
		
		V = num-1;
		parent = new int[V+1];
		for(int i = 1; i<=V; i++) {
			parent[i] = i;
		}
		
		//간선 정보 생성
		//가로
		hr();
		//세로
		vr();
		
		//크루스칼
		

	}
	
	static void vr() {
		for(int i = 0; i<N; i++) {
			int prev = 0;
		}
	}
	
	static void hr() {
		
	}

	static void dfs(int x, int y, int idx) {
		visit[x][y] = true;
		map[x][y] = idx;
	
		for(int d = 0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx>=N||nx<0||ny>=M||ny<0||visit[nx][ny])continue;
			if(map[ny][nx]==1)dfs(nx,ny,idx);
		}
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static boolean union(int a, int b) {
		int pa = parent[a];
		int pb = parent[b];

		if (pa == pb)
			return false;

		if (pa < pb)
			parent[pb] = pa;
		else
			parent[pa] = pb;
		return true;
	}

}
