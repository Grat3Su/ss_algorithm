package algo_A;

import java.io.*;
import java.util.*;

public class bridge22 {
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visit;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 초기화
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬에 번호를 붙여용
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					island(i, j, cnt);
					cnt++;
				}
			}
		}

		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0)
					for (int d = 0; d < 4; d++) {
						makeBridge(i, j, map[i][j], d, 0);
					}
			}
		}

		// 크루스칼
		parent = new int[cnt];

		for (int i = 1; i < cnt; i++) {
			parent[i] = i;
		}

		while (!pq.isEmpty()) {
			Node n = pq.poll();
			System.out.println(n);
			if (find(n.v1) != find(n.v2)) {
				union(n.v1, n.v2);
				ans += n.cost;
			}
		}

		for (int i = 1; i < cnt; i++) {
			for (int j = i + 1; j < cnt; j++) {
				if (find(i) != find(j))
					ans = 0;
			}
		}

		System.out.println(ans == 0 ? -1 : ans);

		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa < pb)
			parent[pa] = pb;
		else
			parent[pb] = pa;
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	// 다리 만들고 pq에 저장
	static void makeBridge(int x, int y, int root, int dir, int cnt) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny]==root)
			return;
		// 기저조건 : 다른 섬에 도달
		if (map[nx][ny] != 0) {
			if (map[nx][ny] != root) {
				if (cnt > 1) {
					pq.offer(new Node(root, map[nx][ny], cnt));
				}
			}
			return;
		}
		makeBridge(nx, ny, root, dir, cnt + 1);
	}

	// 섬 번호 매기기
	static void island(int x, int y, int cnt) {
		visit[x][y] = true;
		map[x][y] = cnt;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0 || visit[nx][ny])
				continue;
			island(nx, ny, cnt);
		}
	}

	public static class Node {
		int v1, v2, cost;

		@Override
		public String toString() {
			return "Node [v1=" + v1 + ", v2=" + v2 + ", cost=" + cost + "]";
		}

		public Node(int v1, int v2, int cost) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

	}
}
