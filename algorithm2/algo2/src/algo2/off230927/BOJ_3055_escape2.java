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

public class BOJ_3055_escape2 {
	static int R, C, ans;
	static char[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int INF = 5000;
	static Queue<Node> water = new ArrayDeque<>();
	static Queue<Node> q = new ArrayDeque<>();
	static Node destination;
	static Node start;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S') {
					q.add(new Node(i, j, 0));
				} else if (map[i][j] == '*') {
					water.add(new Node(i, j));
				}
			}
			System.out.println();

		}
		bfs();

		if (ans != Integer.MAX_VALUE) {
		}
		System.out.println(ans);

	}

	static void m_print() {
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static void bfs() {
		while (!q.isEmpty()) {
			if (!water.isEmpty()) {
				int wSize = water.size();
				for (int k = 0; k < wSize; k++) {
					Node curw = water.poll();
					for (int i = 0; i < 4; i++) {
						int wx = curw.x + dx[i];
						int wy = curw.y + dy[i];

						if (wx < 0 || wx >= R || wy < 0 || wy >= C || map[wx][wy] == 'X' || map[wx][wy] == '*'
								|| map[wx][wy] == 'D')
							continue;
						map[wx][wy] = '*';
						water.offer(new Node(wx, wy));
					}
				}
			}
			int hSize = q.size();
			for (int k = 0; k < hSize; k++) {
				Node curh = q.poll();
				for (int i = 0; i < 4; i++) {
					int x = curh.x + dx[i];
					int y = curh.y + dy[i];

					if (x < 0 || x >= R || y < 0 || y >= C || map[x][y] == 'X' || map[x][y] == '*')
						continue;

					if (map[x][y] == 'D') {
						ans = Math.min(ans, curh.cnt + 1);
						return;
					}
					map[x][y] = 'S';
					q.offer(new Node(x, y, curh.cnt + 1));
				}
			}
		}

		System.out.println("KAKTUS");
	}

	static class Node {
		int x, y, cnt;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}
}
