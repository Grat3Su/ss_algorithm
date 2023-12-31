package BOJ.algostudy;

import java.util.*;
import java.io.*;

/*
 * 테스트케이스
 * N
 * Papulation
 * M E
 * 
 * 6
5 2 3 4 1 2
2 2 4
4 1 3 6 5
2 4 2
2 1 3
1 2
1 2
 */
public class BOJ_17471_gerrymendaring {

	static int N, min;
	static int[] P;
	static boolean select[];
	static List<Integer>[] adjList;
	static int[] V;// 0 : 선택안됨 / 1: 선택됨 / 2: (미선택)연결되었다 / 3:(선택)연결되었다

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()) + 1;
		P = new int[N];
		adjList = new ArrayList[N];
		select = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for (int m = 0; m < M; m++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 0; i < adjList[1].size(); i++)
			adjList[1].get(i);

		subSet(1, 0);
		if(min!= Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println(-1);
	}

	static void subSet(int idx, int mask) {
		if (idx >= N) {
			complete(mask);
			return;
		}

		subSet(idx + 1, mask);
		subSet(idx + 1, mask | 1 << idx);
	}

	static void complete(int mask) {
		// bfs
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i < N; i++) {
			if ((mask & 1 << i) != 0) {
				// 선택된 한 정점만 큐에 넣고 bfs
				select[i] = true;
				q.offer(i);
				break;
			}
		}
		if (q.size() == 0)
			return;
		while (!q.isEmpty()) {
			int v = q.poll();

			// 모든 정점에 대해 A 그룹이면서 연결되어있는가
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < adjList[i].size(); j++) {
					int adj = adjList[i].get(j);
					if (adj != 0 && !select[adj] && (mask & 1 << adj) != 0) {// 연결이 되어있다
						select[adj] = true;
						q.offer(adj);
					}
				}
			}
		}
		// B - select : false
		for (int i = 1; i < N; i++) {
			if (!((mask & 1 << i) != 0)) {
				// 선택된 한 정점만 큐에 넣고 bfs
				select[i] = true;
				q.offer(i);
				break;
			}
		}
		while (!q.isEmpty()) {
			int v = q.poll();

			// 모든 정점에 대해 A 그룹이면서 연결되어있는가
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < adjList[i].size(); j++) {
					int adj = adjList[i].get(j);
					if (adj != 0 && !select[adj] && !((mask & 1 << adj) != 0)) {// 연결이 되어있다
						select[adj] = true;
						q.offer(adj);
					}
				}
			}
		}
		// A, B 모두 연결되어 있는지 visit[] 확인
		for (int i = 1; i < N; i++) {
			if (!select[i])
				return;// 연결되어있지 않은게 있다
		}

		// 두 그룹을 나누었고 모두 연결된 상태다
		// 두 그룹의 인구수 차이를 계산. min과 비교
		int sumA = 0;
		int sumB = 0;
		for (int i = 1; i < N; i++) {
			if ((mask & 1 << i) != 0)
				sumA += P[i];// A 누적합
			if (!((mask & 1 << i) != 0))
				sumB += P[i];// B 누적합
		}
		min = Math.min(min, Math.abs(sumA - sumB));
	}
}
