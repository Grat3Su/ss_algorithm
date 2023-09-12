package BOJ.algostudy;

import java.io.*;
import java.util.*;

/*N
 * M
 * adjmatrix
 * travel List
 * 4
2
0 1 0 1
1 0 1 0
0 1 0 0
1 0 0 0
1 2
-> yes
 */

public class BOJ_1976_travel2 {
	static int N, M;// 도시의 수/여행 도시 수
	static int[][] adjMatrix;// 인접행렬
	static boolean[] travelList;// 도시 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		adjMatrix = new int[N + 1][N + 1];
		travelList = new boolean[N+1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {//to : i from: j
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//탐색
		st = new StringTokenizer(br.readLine());
		bfs(Integer.parseInt(st.nextToken()));//제일 처음 수 bfs 돌려

		// 방문한 도시 수
		for (int i = 1; i < M; i++) {
			int city = Integer.parseInt(st.nextToken());
			if (!travelList[city]) {//방문하지 않았으면
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(v);
		travelList[v] = true;
		
		while(!queue.isEmpty()) {
			int city = queue.poll();
			for(int i = 1; i<=N; i++) {
				//인접하지 않거나 이미 방문했다면 continue;
				if(adjMatrix[v][i]==0||travelList[i]) continue;
				travelList[i] = true;
				queue.offer(i);
			}
		}
	}

}
