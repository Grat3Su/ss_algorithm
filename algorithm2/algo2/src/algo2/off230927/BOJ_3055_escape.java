package algo2.off230927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *
 * 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 
 S : start
 D - destination
 
3 3
D.*
...
.S.
-> 3


3 3
D.*
...
..S
-> KAKTUS
 */



public class BOJ_3055_escape {
	static int R, C;
	static char[][] map;
	static int[][] adjMatrix;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int INF = 5000;
	static Queue<Node> water = new ArrayDeque<>();
	static Node destination;
	static Node start;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		adjMatrix = new int[R][C];
		for(int i = 0; i<R; i++) {
			String s = br.readLine();			
			for(int j = 0; j<C; j++) {
				char c = s.charAt(j);
				if(c == '.') {
					adjMatrix[i][j] = 1;
				}
				else if(c == '*') {
					adjMatrix[i][j] = INF;
					water.offer(new Node(i, j));
				}
				else if(c == 'X') {
					adjMatrix[i][j] = INF+1;
				}
				else if(c=='D') {
					destination = new Node(i, j);
				}
				else if(c=='S') {
					start = new Node(i, j);
				}
			}
			
		}
		bfs(start);
		
	}
	
	static void bfs(Node s) {		
		Queue<Node> h = new ArrayDeque<>();
		h.offer(s);
		while(!water.isEmpty()&&!h.isEmpty()) {
			Node curw = water.poll();
			Node curh = h.poll();
			for(int i = 0; i<4; i++) {
				int wx = curw.x + dx[i];
				int wy = curw.y + dy[i];
				int x = curh.x+dx[i];
				int y = curh.y+dy[i];
				
				if(wx<0||wx>=R||wy<0||wy>=C||adjMatrix[wx][wy]>=INF) continue;
				adjMatrix[wx][wy] = INF;
				water.offer(new Node(wx, wy));

				if(x<0||x>=R||y<0||y>=C||adjMatrix[x][y]>=INF) continue;
				adjMatrix[x][y] = Math.min(adjMatrix[x][y], adjMatrix[curh.x][curh.y]);
				if(x == destination.x&&y==destination.y) {
					System.out.println(adjMatrix[x][y]);
					return;
				}
				h.offer(new Node(x, y));
			}
		}
		System.out.println("KAKTUS");
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
