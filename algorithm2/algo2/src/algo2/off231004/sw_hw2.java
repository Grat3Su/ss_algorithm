package algo2.off231004;
/*
정점 v에서 인접행렬을 사용해서 이어진 방향을 세고 그 수가 정점의 갯수-1개면 모두 이어졌다고 판단하고 ans++
하려고 했습니다.


1
6
6
1 5
3 4
5 4
4 2
4 6
5 2
*/

import java.io.*;
import java.util.*;

//T N M
public class sw_hw2 {
	static int T, N, M;
	static int[][] adjMatrix;
	static boolean[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
		N = Integer.parseInt(br.readLine());// 정점수
		M = Integer.parseInt(br.readLine());// 간선 수

		adjMatrix = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = 1;
		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (find(i)) {
				ans++;
			}
		}
		System.out.println("#"+(t+1)+" "+ans);
		}
	}

	static boolean find(int v) {// 위로 연결된것과 아래로 연결된것의 수를 센다
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 1;
		q.offer(v);// from
		while (!q.isEmpty()) {
			arr = new boolean[N + 1];
			int pollV = q.poll();
			for (int i = 1; i <= N; i++) {// v->
				if (!arr[i] && adjMatrix[pollV][i] == 1) {// 방문안했고 이어져있다.
					arr[i] = true;
					q.offer(i);
					cnt++;
				}
			}

			q.clear();
			q.offer(v);// from
			while (!q.isEmpty()) {
				arr = new boolean[N + 1];
				int pollE = q.poll();
				for (int i = 1; i <= N; i++) {// v->
					if (!arr[i] && adjMatrix[i][pollE] == 1) {// 방문안했고 이어져있다.
						arr[i] = true;
						q.offer(i);
						cnt++;
					}

				}
			}
		}
		if (cnt == N-1)
			return true;
		return false;
	}

}
