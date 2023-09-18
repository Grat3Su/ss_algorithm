package algo_study;

import java.io.*;
import java.util.*;

/*N M
 * 5 7
3994995
9999999
4H99399
9999999
2993994

6
 */

public class BOJ_1103_game2 {

	static int N, M, max;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	static boolean[][] visit;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 1;
		visit = new boolean[M][N];
		map = new int[M][N];
		dp = new int[M][N];

		for (int j = 0; j < N; j++) {
			String s = br.readLine();
			for (int i = 0; i < M; i++) {
				map[i][j] = s.charAt(i) - '0';
			}
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });// 첫 숫자 넣기
		visit[0][0] = true;
		dp[0][0] = 1;

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int scale = map[pos[0]][pos[1]];

			for (int i = 0; i < 4; i++) {
				int newX = (dx[i] * scale) + pos[0];
				int newY = (dy[i] * scale) + pos[1];

				if (newX >= M || newX < 0 || newY >= N || newY < 0) continue;// 체크

				if (map[newX][newY] == 24) continue;

				if (visit[newX][newY]) {// true : 사이클이 있다
					System.out.println(newX+" / "+newY);
					System.out.println(map[newX][newY]);
					System.out.println(map[pos[0]][pos[1]]);
					System.out.println(-1);
					return;
				} // 아니면
				q.offer(new int[] { newX, newY });
				visit[newX][newY] = true;
				dp[newX][newY] = dp[pos[0]][pos[1]] + 1;
				max = Math.max(max, dp[newX][newY]);

			}
		}

		System.out.println(max);

	}

}
