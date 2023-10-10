package algo2.off231004;

import java.util.*;
import java.io.*;

/*
 * N M
7 8
0 0 0 0 0 0 1 1
1 1 0 0 0 0 1 1
1 1 0 0 0 0 0 0
1 1 0 0 0 1 1 0
0 0 0 0 0 1 1 0
0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1

-> 9
 */

public class BOJ_17472_Bridge2 {
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] adjMatrix = new int[7][7];
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int parents[];

	public static void main(String[] args) throws Exception {
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

		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] == 1) {// 방문하지 않은 섬
					bfs(new int[] { i, j }, cnt);
					cnt++;
				}
			}
		}
		parents = new int[cnt];

		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {// 섬일때
					for (int d = 0; d < 4; d++)
						makeBridge(new int[] { i, j }, map[i][j], 0, d);
				}
			}
		}
		
		for(int i = 0; i<cnt; i++) {
			parents[i] = i;//make
		}
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();			
			if(find(n.to) != find(n.from)) {//부모가 같다 = 싸이클
				union(n.to, n.from);
				ans += n.weight;
			}
		}
		
		for(int i = 1 ; i<cnt; i++) {
			for(int j = i+1; j<cnt;j++) {
				if(find(i)!=find(j)) {
					ans = 0;
				}
			}
		}
		
		System.out.println(ans==0?-1:ans);
//		for (int i = 0; i < N; i++)
//			System.out.println(Arrays.toString(map[i]));
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pb<pa)
			parents[pb] = pa;
		else
			parents[pa] = pb;
	}
	
	static int find(int a) {
		if(a==parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	static void makeBridge(int[] pos, int root, int cnt, int dir) {		
		int x = pos[0] + dx[dir];
		int y = pos[1] + dy[dir];

		if (x < 0 || x >= N || y < 0 || y >= M||map[x][y] == root) {
			return;
		}

		if (map[x][y] != 0) {// 시작섬이 아닌 어디든 도달했다
			adjMatrix[root][map[x][y]] = cnt;
			if(cnt >1)//길이는 1 이상이어야함
				pq.offer(new Node(root, map[x][y], cnt));//to from weight
			return;
		}
		
		//map[pos[0]][pos[1]] == 0이면 움직인다.
		makeBridge(new int[] {x,y}, root, cnt+1, dir);
	}

	static void bfs(int[] pos, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { pos[0], pos[1] });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			visit[x][y] = true;
			map[x][y] = cnt;

			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx < 0 || cx >= N || cy < 0 || cy >= M || map[cx][cy] == 0 || visit[cx][cy])
					continue;
				q.offer(new int[] { cx, cy });

			}
		}

	}
	static class Node implements Comparable<Node>{
		int to, from, weight;

		public Node(int x, int y, int weight) {
			super();
			this.to = x;
			this.from = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {			
			return this.weight - o.weight;
		}
		
	}

}
