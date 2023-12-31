package A형대비;
import java.util.*;
import java.io.*;
/* 최소 몇번만에 빨간 구슬이 탈출 할 수 있는가
 * 테스트 케이스
 * N M 세로 가로
 * Map
 * 5 5
#####
#..B#
#.#.#
#RO.#
#####
 */
public class BOJ_13460_BizEscape {
	static int N,M, min;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x=0, y =0;
		map = new char[M][N];
		visit = new boolean[M][N];
		for(int i = 0; i<M; i++) {
			String s = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = (s.charAt(j)); 
				if(map[i][j] =='R')	//queue.offer(new int[] {i,j});
				{
					x = i;
					y = j;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		dfs(x,y,0);
		
		System.out.println(min);
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			
		}
	}
	static void dfs(int x, int y, int cnt) {
		if(map[x][y]=='O') {
			min = Math.min(min, cnt);
			return;
		}
		
		if(x == M||y==N||x<0||y<0) {
			return;
		}
		cnt++;
		for(int i = 0; i<4; i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(visit[cx][cy]||cx == M||cy==N||cx<0||cy<0||map[cx][cy]=='#')
				continue;
			visit[cx][cy] = true;
			dfs(cx, cy, cnt);
			visit[cx][cy] = false;
		}
	}

}
