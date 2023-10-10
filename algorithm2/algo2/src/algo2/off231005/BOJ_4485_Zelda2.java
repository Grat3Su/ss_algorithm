package algo2.off231005;
import java.util.*;
import java.io.*;

public class BOJ_4485_Zelda2 {
	static int N, min;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int turn = 0;;
		while(true) {
			turn++;
			N = Integer.parseInt(br.readLine());
			if(N ==0)break;//0이면 끝
			min = Integer.MAX_VALUE;
			
			map = new int[N][N];
			visit = new boolean[N][N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(0,0,0);//0,0에서 시작	
			sb.append("Problem ").append(turn).append(": ").append(min).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y, int cnt) {
		PriorityQueue<Node> q = new PriorityQueue<>((e1, e2) -> e1.cnt - e2.cnt);
		q.offer(new Node(x, y, map[x][y]));
		//visit[x][y] =true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.x == N-1&& n.y == N-1) {
				min = Math.min(min, n.cnt);
			}
			visit[n.x][n.y] = true;
			if(min<n.cnt) break;
			for(int i = 0; i<4; i++) {
				int nx = n.x+dx[i];
				int ny = n.y+dy[i];
				if(nx<0||nx>=N|| ny<0||ny>=N||visit[nx][ny])continue;
				q.offer(new Node(nx,ny,n.cnt+map[nx][ny]));
			}
		}
	}
	
	static void dfs(int x, int y, int cnt) {
		if(x == N-1&& y == N-1) {
			cnt+=map[x][y];
			min = Math.min(min, cnt);
			//System.out.println(cnt);
			return;
		}
		if(cnt > min)return;
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||nx>=N|| ny<0||ny>=N||visit[nx][ny])continue;
			
			visit[x][y] = true;
			dfs(nx,ny,cnt+map[x][y]);
			visit[x][y] = false;
		}
	}
	
	static class Node{
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
}
