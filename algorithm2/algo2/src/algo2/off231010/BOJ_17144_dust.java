package algo2.off231010;

import java.io.*;
import java.util.*;

public class BOJ_17144_dust {
	static int[][] map;
	static int[][] dustMap;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int R, C, T, ans;
	static Coord[] cleaner = new Coord[2];// 공기청정기 위치 확인

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[C][R];

		int cnt = 0;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < R; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == -1) {// 공기청정기 위치 확인
					cleaner[cnt].x = i;
					cleaner[cnt].y = j;
					cleaner[cnt].dust = -1;

					cnt++;
				}
			}
		}

		for (int t = 0; t < T; t++) {// T초동안 움직이게 된다.
			spread();
		}

		countDust();
	}

	// 미세먼지 확산
	static void spread() {
		int[][] newMap = new int[C][R];
		List<Coord> dust = new ArrayList<>();

		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (map[i][j] > 0) {// 미세먼지가 존재함
					int cnt = 0;
					for (int d = 0; d < 4; d++) {// 확산
						int x = i + dx[d];
						int y = i + dy[d];
						if (x >= C || x < 0 || y >= R || y < 0)
							continue;
						newMap[x][y] += map[i][j] / 5;
						cnt++;
					}
					map[i][j] =map[i][j] - (map[i][j] / 5); 
					
				}
			}
		}

		for (int i = 0; i < C; i++) {// 기존맵과 새 맵 합치기
			for (int j = 0; j < R; j++) {
				if (map[i][j] != -1 || newMap[i][j] > 0)// 공기청정기가 아니고 미세먼지가 확산
					map[i][j] = newMap[i][j];
			}
		}

		airCleaner();// 공기 청정기 가동
	}

	// 공기청정기 가동
	// 새로운 맵에 이동 기록?
	static void airCleaner() {
		int[][] newMap = new int[C][R];
		int x1 = cleaner[0].x;
		int y1 = cleaner[0].y;
		int x2 = cleaner[1].x;
		int y2 = cleaner[1].y;

		for (int j = 1; j < R - 1; j++) {//오른쪽
			x1++;
			x2++;
			if (map[x1][y1] > 0) {// 위쪽
				newMap[x1][y1] = map[x1][y1];
			}
			if (map[x2][y2] > 0) {// 아래쪽
				newMap[x2][y1] = map[x2][y1];
			}
		}
		newMap[x1][y1 - 1] = map[x1][y1];
		newMap[x2][y2 + 1] = map[x2][y2];
		y1--;
		y2++;
		
		for(int i = 0; i<C-y1; i++) {
			
		}
		for(int i = 0; i<C-y2; i++) {
			
		}

	}

	// 남은 먼지 세기
	static void countDust() {
		int cnt = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if(map[i][j]>0) {
					cnt+=map[i][j];
				}
			}
		}
		System.out.println(cnt);
	}

	static class Coord {
		int x, y, dust;

		public Coord(int x, int y, int dust) {
			this.x = x;
			this.y = y;
			this.dust = dust;
		}
	}
}
