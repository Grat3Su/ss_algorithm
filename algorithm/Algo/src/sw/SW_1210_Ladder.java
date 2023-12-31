package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1210_Ladder {
	// delta
	// 왼-오-위

	static int[] dy = { 0, 0, -1 };
	static int[] dx = { -1, -1, 0 };
	static int[][] ladder = new int[100][100];

	// 시작 위치, 도착점
	static int sy, sx, ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input (2).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			br.readLine(); // testcase 날리기
			// ladder 초기화
			// 1. ladder = new int[][]//속도는 빠르지만 메모리 낭비
			// for-for 해서 lader[][]//메모리에는 좋지만 속도에 지장있음

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			// 시작 좌표는 맨 밑에 있는 값이므로 별도로 for문 사용
			sy = 99;
			for (int i = 0; i < 100; i++) {
				sx = i;
				break;
			}
			// 탐색 시작
			int dir = 2;// 시작 방향은 위
			while (true)
				if (dir == 2) {
					// 왼 오 위 순서
					for (int d = 0; d < 3; d++) {
						int ny = sy + dy[d];
						int nx = sx + dx[d];

						if (nx >= 0 && nx < 100 && ladder[ny][nx] == 1) {
							sy = ny;
							sx = nx;
							dir = d;
							break;// 방향이 선택되면 그 방향으로 이동
						}
					}
				} else if (dir == 1) {// 옆
					// 왼 오 위 순서
					// 위로가는 우선순위 검토
					int ny = sy - 1;
					int nx = sx;

					if (ladder[ny][nx] == 1) {
						sy = ny;
						dir = 2;
					} else// 위에 못가는
					{
						sx = sx + dx[dir];
					}
			// 옆 sy == 0 확인
			if (sy == 0) {
				ans = sx;
				break;
			}
				}

			sb.append("#").append(t).append(" ").append("\n");
			System.out.println(sb);
		}
	}
}