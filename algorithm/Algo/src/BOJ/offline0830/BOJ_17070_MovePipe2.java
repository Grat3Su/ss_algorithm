package BOJ.offline0830;

import java.util.*;
import java.io.*;

public class BOJ_17070_MovePipe2 {
	static Pipe head;
	static Pipe tail;
	static int N, count;
	static int[][] map;
	static int[] dx = { 1, 1, 0 };
	static int[] dy = { 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		head = new Pipe(1, 0, 0);
		tail = new Pipe(0, 0, 0);
		bfs();
		System.out.println(count);
	}

	static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { head.x, head.y, head.dir });

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int dir = pos[2];
			if (pos[0] == N - 1 && pos[1] == N - 1) {
				count++;
			}
			
			int x = pos[0];
			int y = pos[1];
			if (x >= N || y >= N || map[x][y] != 0)
				continue;
			
			if (dir == 0) {
				for (int i = 0; i < 2; i++) {
					x += dx[i];
					y += dy[i];
					
					q.offer(new int[] { x, y, i });
				}
			}
			else if (dir == 1) {
				for (int i = 1; i < 3; i++) {
					x += dx[i];
					y += dy[i];
					
					q.offer(new int[] { x, y, i });

				}
			}
			else if (dir == 3) {
					x = pos[0] + dx[2];
					y = pos[1] + dy[2];
					q.offer(new int[] { x, y, 2 });
			}
		}
	}

	static class Pipe {
		int x, y, dir;

		public Pipe(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
