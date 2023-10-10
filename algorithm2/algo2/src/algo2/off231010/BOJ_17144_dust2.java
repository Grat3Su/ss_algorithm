package algo2.off231010;

import java.io.*;
import java.util.*;

//시뮬레이션
//먼지 확산 + 공기 청정기 동작 반복
public class BOJ_17144_dust2 {
	static int R, C, T, ans;
	static int[][] map, tempMap;
	// cpos[0][1] : 위쪽 공기 청정기 x
	static int[][] cPos = new int[2][2];

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		tempMap = new int[R][C];

		int cnt = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == -1) {// 공기청정기 위치 확인
					cPos[cnt][0] = i;
					cPos[cnt][1] = j;

					cnt++;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			// 확산
			spread();
			// 청정
			clear();
		}
		// 미세먼지 잔량
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					ans += map[i][j];
			}
		}
		System.out.println(ans);
	}

	static void spread() {
		// tempMap 초기화
		// tempMap에 풀이를 적용해간다.
		// tempMap => map
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tempMap[i][j] = 0;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 이전 좌표에서 현 좌표에 의미 있는 값이 생겼을 수 있기 때문
				tempMap[i][j] += map[i][j];// 누적합

				// 5로 나눈 나머지가 5 이상
				if (map[i][j] < 5)
					continue;

				int spreadCnt = map[i][j] / 5;
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];

					if (nx >= C || nx < 0 || ny >= R || ny < 0)
						continue;
					tempMap[i][j] -= spreadCnt;
					tempMap[ny][nx] += spreadCnt;
				}
			}
		}
		// tempMap => map
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = tempMap[i][j];
			}
		}
	}

	static void clear() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tempMap[i][j] = 0;
			}
		}

		for (int i = 0; i < 2; i++) {
			int ny = cPos[i][0];
			int nx = cPos[i][1] + 1;// 공기 청정기 x 다음 위치

			// ------------------>
			while (nx < C - 1) {
				tempMap[ny][nx + 1] = map[ny][nx];
				nx++;
			}

			// 위, 아래
			if (i == 0) {// 위 청정기
				while (ny > 0) {
					tempMap[ny - 1][nx] = map[ny][nx];
					ny--;
				}
			} else {// 아래 청정기
				while (ny < R - 1) {
					tempMap[ny + 1][nx] = map[ny][nx];
					ny++;
				}

			}
			// <----------------
			while (nx > 0) {
				tempMap[ny][nx - 1] = map[ny][nx];
				nx--;
			}

			// 아래, 위
			if (i == 0) {// 위 청정기
				while (ny < cPos[i][0] - 1) {// 내려올 때 위쪽 청정기의 y좌표 하나 이전
					tempMap[ny + 1][nx] = map[ny][nx];
					ny++;
				}
			} else {// 아래 청정기
				while (ny > cPos[i][0] + 1) {
					tempMap[ny - 1][nx] = map[ny][nx];
					ny--;
				}

			}
		}
		// tempMap => map
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if( i == 0 || i == R - 1 || j == 0 || j == C - 1 || i == cPos[0][0] || i == cPos[1][0])
                    map[i][j] = tempMap[i][j];
			}
		}
	}

}
