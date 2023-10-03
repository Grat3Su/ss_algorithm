package algo2.off230926;

import java.io.*;
import java.util.*;
/*
. 이동가능
0 민식이
# 벽
1 탈출구


5 5
....1
#1###
.1.#0
....A
.1.#.

-> -1
*/

public class BOJ_1194_달이차오른다가자 {
	static class Coord{
		int x, y, cost, key;
		
		public Coord(int x, int y, int cost, int key){
			this.x = x;
			this.y =y;
			this.cost = cost;
			this.key = key;
		}
	}
	static int N, M;
	static char[][] map;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Coord start;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') {
					start = new Coord(i,j,0,0);
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Coord>q = new ArrayDeque<>();
		boolean[][][]visited = new boolean[N][M][64];
		q.offer(start);
		visited[start.x][start.y][0] = true;
		
		while(!q.isEmpty()) {
			Coord c = q.poll();
			
			if(map[c.x][c.y] == '1') {
				return c.cost;
			}
				
			for(int i = 0; i<4; i++) {
				int x = c.x+dx[i];
				int y = c.y+dy[i];
				if(x>=N || x<0 || y>=M || y<0 || map[x][y]=='#' || visited[x][y][c.key]) continue;//벽이거나 방문했거나
				
				
				if(map[x][y]>='a'&& map[x][y] <='f'){
					int nkey = 1<<(map[x][y]-'a');
					nkey = c.key|nkey;
					visited[x][y][nkey] = true;

					q.offer(new Coord(x,y,c.cost+1, nkey));					
				}else if(map[x][y]>='A'&& map[x][y] <='F'){
					if((c.key&1<<(map[x][y]-'A')) == (int)Math.pow(2, map[x][y] - 'A'));{
						visited[x][y][c.key] = true;
						q.offer(new Coord(x,y,c.cost+1,c.key));
					}
				}else{
					visited[x][y][c.key] = true;
					q.offer(new Coord(x,y,c.cost+1,c.key));
				}
				
			}
		}
		return -1;
		
	}
	

}
