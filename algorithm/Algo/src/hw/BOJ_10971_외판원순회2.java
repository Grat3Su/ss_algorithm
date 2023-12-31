package hw;
import java.util.*;
import java.io.*;
public class BOJ_10971_외판원순회2 {
	static int N;
	static int[][] map;
	static long min;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		//초기화
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		min = Integer.MAX_VALUE;
		
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit[1] = true;
		dfs(1, 1, 1, 0);
		System.out.println(min);
	}
	
	public static void dfs(int start, int now, int cnt, int cost) {
		if (now == start && cost > 0) {
			min = Math.min(min, cost);
			return;
		}

		for (int n = 1; n <= N; n++) {
			if (map[now][n] > 0) {
				if (n == start && cnt == N) {
					cost += map[now][n];
					dfs(start, n, cnt + 1, cost);
				} else if (!visit[n]) {
					visit[n] = true;
					cost += map[now][n];

					dfs(start, n, cnt + 1, cost);

					cost -= map[now][n];
					visit[n] = false;
				}
			}
		}
	}
}
