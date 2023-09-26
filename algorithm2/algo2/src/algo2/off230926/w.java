package algo2.off230926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class w {
	static int N, M, min;
	static char[][] map;
	static int[][] dp;
	static boolean[][] visit;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visit = new boolean[N][M];
		
		int x=0;
		int y=0;
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') {
					x=i;
					y=j;
				}
			}
		}
		//Arrays.fill(dp, Integer.MAX_VALUE);
		Coord start = new Coord(x, y, new boolean[6]);
		bfs(start);
		System.out.println(min);
	}
	
	static void bfs(Coord pos) {
		Queue<Coord>q = new ArrayDeque<>();
		q.offer(pos);
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Coord c = q.poll();
			visit[c.x][c.y] = true;
			
			cnt++;
			if(map[c.x][c.y] == '1') {
				min = Math.min(min, cnt);
				return;
			}
				
			for(int i = 0; i<4; i++) {
				int x = c.x+dx[i];
				int y = c.y+dy[i];
				if(x>=M || x<0 || y>=N || y<0 || map[x][y]=='#' || visit[x][y]) continue;//벽이거나 방문했거나
				
				
				if(map[x][y]!='.') {//앞에서 벽을 걸렀다. 문 아니면 열쇠
					if(map[x][y]-'a' <0&&c.key[map[x][y]-'A']) {//문이고 열쇠가 있나
					}else if(map[x][y]-'a' <0&&!c.key[map[x][y]-'A']) continue;//문이고 열쇠가 없다
					
					if(map[x][y]-'a' >=0&&!c.key[map[x][y]-'a']) {//열쇠를 전에  찾았나
						c.key[map[x][y]-'a'] = true;
						Arrays.fill(visit, false);
					}
					q.offer(new Coord(x, y, c.key));
				}
				
			}
		}
		
		
	}
	
	static class Coord{
		int x, y;
		boolean[] key;//a b c d e f
		public Coord(int x, int y, boolean[] key) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
}
