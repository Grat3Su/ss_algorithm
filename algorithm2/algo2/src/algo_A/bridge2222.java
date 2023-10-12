package algo_A;

import java.io.*;
import java.util.*;

public class bridge2222 {
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visit;
	
	static int[]dx = {1,-1,0,0};
	static int[]dy = {0,0,1,-1};
	

	static int[] parents;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

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
				if(map[i][j]!=0 &&!visit[i][j]) {
					makeIsland(i,j,cnt);
					cnt++;
				}
			}
		}
		
		for(int i =0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j]!=0) {
					for(int d = 0; d<4; d++) {
						makeBridge(i, j, map[i][j], d, 0);
					}
				}
			}
		}
		
		parents = new int[cnt];
	
		for(int i = 1; i<cnt; i++) {
			parents[i] = i;
		}
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(find(n.v1)!=find(n.v2) ) {
				union(n.v1, n.v2);
				ans+=n.cost;
			}
		}
		
		for(int i =1; i<cnt-1; i++) {
			for(int j = i+1; j<cnt; j++)
				if(find(i)!=find(j))	ans=0;
		}
		
		for(int i = 0; i<N; i++)
			System.out.println(Arrays.toString(map[i]));

		System.out.println(ans == 0 ? -1 : ans);
	}
	
	static int find(int a) {
		if(parents[a] == a)return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa<pb) parents[pa] = pb;
		else parents[pb] = pa;
	}
	
	static void makeBridge(int x, int y, int root, int dir, int cnt) {
		if(map[x][y] !=0 && map[x][y]!=root) {//다른 섬이랑 만났다
			if(cnt>1) {
				pq.offer(new Node(root, map[x][y], cnt+1));
			}
			return;
		}
		
		int nx =  x+dx[dir];
		int ny =  y+dy[dir];
		
		if(nx <0||nx>=N||ny<0||ny>=M)return;
		makeBridge(nx,ny,root,dir,cnt+1);
	}
	
	static void makeIsland(int x, int y, int cnt) {
		map[x][y] = cnt;
		visit[x][y] = true;
		
		for(int i = 0; i<4; i++) {
			int nx =  x+dx[i];
			int ny =  y+dy[i];
			
			if(nx <0||nx>=N||ny<0||ny>=M||visit[nx][ny]||map[nx][ny]==0)continue;
			
			makeIsland(nx, ny, cnt);
		}
	}

	static class Node {
		int v1, v2, cost;

		public Node(int v1, int v2, int cost) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [v1=" + v1 + ", v2=" + v2 + ", cost=" + cost + "]";
		}

	}
}
