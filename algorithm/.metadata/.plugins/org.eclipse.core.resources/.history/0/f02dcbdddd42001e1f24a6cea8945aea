package BOJ.algostudy;

import java.util.*;
import java.io.*;
/*며칠이 지나야 토마토가 모두 익나?
 * M N
 * 6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
 */
public class BOJ_7576_Tomato {
	static int M,N, ans,day;
	static int[][] box;
			
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int x = 0;
		int y = 0;
		box = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				if(box[i][j] == 1) {
					x = i;
					y = j;
				}
			}
		}
		bfs(x,y);
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(box[i][j]!=1) {					
					System.out.println(-1);
					//return;
				}				
			}
		}
		System.out.println(day);
	}
	static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{x,y});//첫번쨰
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			day++;
			
			for(int i = 0; i<4; i++) {
				int cx = cur[0]+dx[i];
				int cy = cur[1]+dy[i];
				
				if(cx>-1&&cx<N&&cy>-1&&cy<M)
					if(box[cx][cy]==0) {
						box[cx][cy]=1;
						queue.offer(new int[] {cx,cy});
					}
			}
		}
	}
}
