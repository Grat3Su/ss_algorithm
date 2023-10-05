package off231004;

import java.util.*;
import java.io.*;

/*
 * 그래프 자료구조를 준비하고 크루스칼로 풀이
 * 섬-> 정점
 * dfs()
 * 다리-> 간선
 * 세로 vr 가로 hr
 */

public class BOJ_17472_Bridge2_prim {
	static int N, M, min;
	static int V;// 정점
	static int[][] map;
	static boolean[][] visit;

	// 한 정점에서 갈 수 있는 다른 정점(간선관리)
	static ArrayList<ArrayList<Edge>> vertex;
	static boolean[] visitPrim;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		// map input <- 섬은 -1로

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) * (-1);// 바다 : 0, 섬 : -1로 초기화
			}
		}

		// dfs
		int num = 1;// 정점 1번부터
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1 && !visit[i][j]) {
					// 새로운 섬(정점)
					dfs(i, j, num);
					num++;
				}
			}
		}
		// 정점 수
		V = num - 1;
		vertex = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i <= V; i++) {
			vertex.add(new ArrayList<Edge>());
		}
		visitPrim = new boolean[V + 1];

		// 맵으로 부터 간선 정보 계산
		// 가로
		hr();
		// 세로
		vr();

		// prim 풀이
		int cnt = 1;
		// 시작정점은 1부터
		visitPrim[1] = true;
		pq.addAll(vertex.get(1));// 시작 1번 정점에서 갈 수 있는 모든 다른 정점을 담고
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			// visit체크 하고 안가본 정점이면 다시 집어넣는다.
			if (visitPrim[e.v])
				continue;

			// 방문하고 큐에 넣는다
			visitPrim[e.v] = true;
			pq.addAll(vertex.get(e.v));

			min += e.cost;
			cnt++;

			if (cnt == V)	break;
		}
		if (cnt != V || min == 0)
			min = -1;
		System.out.println(min);

//		for (int i = 0; i < N; i++)
//			System.out.println(Arrays.toString(map[i]));
	}

	private static void addEdge(int v1, int v2, int cost) {
		// 뒤져서 중복인 항목을 제거하는 것이 손해가 될 수 있다.
		boolean same = false;
		for (Edge edge : vertex.get(v1)) {// v1 정점에서 갈 수 있는 다른 정점(간선) 경로 각각
			if (edge.v == v2) {
				same = true;
				// 같은게 있으면 기존것을 더 작은 값으로 갱신
				edge.cost = Math.min(edge.cost, cost);
				break;
			}
		}

		// 새로운 간선 추가
		if (!same)
			vertex.get(v1).add(new Edge(v2, cost));
	}

	private static void vr() {
		for (int i = 0; i < N; i++) {// 행으로 내려오면서
			int prev = 0;// 이전좌표
			int curr = 0;// 현재 좌표
			int v1 = 0;
			int v2 = 0;
			int cost = 0;

			// 옆으로 쭉 가면서
			for (int j = 0; j < N; j++) {
				curr = map[j][i];
				if (prev == 0 && curr != 0) {// 0-> 0이 아닌 좌표(바다->섬, 최초 시작점->섬)
					if (v1 == 0) {
						v1 = curr;
					} else {
						// 간선 발생
						v2 = curr;
						if (cost > 1) {
							// 간선 추가 (v1, v2, cost)
							addEdge(v1, v2, cost);
							addEdge(v2, v1, cost);
						}
						v1 = v2;
						v2 = 0;
						cost = 0;
					}
				} else if (v1 != 0 && curr == 0) {
					cost++;
				}
				prev = curr;
			}
		}
	}

	private static void hr() {
		for (int i = 0; i < N; i++) {// 행으로 내려오면서
			int prev = 0;// 이전좌표
			int curr = 0;// 현재 좌표
			int v1 = 0;
			int v2 = 0;
			int cost = 0;

			// 옆으로 쭉 가면서
			for (int j = 0; j < M; j++) {
				curr = map[i][j];
				if (prev == 0 && curr != 0) {// 0-> 0이 아닌 좌표(바다->섬, 최초 시작점->섬)
					if (v1 == 0) {
						v1 = curr;
					} else {
						// 간선 발생
						v2 = curr;
						if (cost > 1) {
							// 간선 추가 (v1, v2, cost)
							addEdge(v1, v2, cost);
							addEdge(v2, v1, cost);
						}
						v1 = v2;
						v2 = 0;
						cost = 0;
					}
				} else if (v1 != 0 && curr == 0) {
					cost++;
				}
				prev = curr;
			}

		}

	}

	// dfs
	static void dfs(int y, int x, int num) {
		visit[y][x] = true;
		map[y][x] = num;

		// 사방탐색
		// 갈 수 있는 곳을 계속 가면서 재귀호출 dfs를 이어간다.
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M || visit[ny][nx])
				continue;
			if (map[ny][nx] == -1)
				dfs(ny, nx, num);
		}
	}

	static class Edge {
		int v, cost;

		public Edge(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}
	}
}
