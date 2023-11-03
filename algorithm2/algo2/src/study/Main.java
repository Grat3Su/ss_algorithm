package study;

import java.io.*;
import java.util.*;
/*
 * 원판 크기 적힌 수 회전 수
4 4 1
1 1 2 3
5 2 4 2
3 1 3 5
2 1 3 2
2 0 1
2의 배수를 0방향으로 1칸

->30

주의 : 자기 옆도 확인하고 없앤다
 */

public class Main {
	static int N, M, T, cycle, ans, total, totalsum;// 원판 크기. 적힌 수. 회전 수. X의 배수. 방향. 움직일 횟수.
	static int[][] circle;
	static int[][] info;// 배수 방향 움직일 횟수
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		circle = new int[M][N];
		info = new int[T][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				circle[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			info[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<T; i++)
			rotate();

		for (int i = 0; i < N; i++)
			System.out.println(Arrays.toString(circle[i]));
		System.out.println(ans);
	}

	// 1. 원판을 돌린다(어떻게....)
	static void move() {
		if (cycle == T) {// 모두 다 돌았다.
			sum();
		}
		// info[0]의 배수가 info[1]의 방향으로 info[2]만큼 움직임
		for (int i = 0; i < info[cycle][2]; i++) {// 움직임 확인
			for (int j = 0; j < M; j++) {
				if (j % info[cycle][0] == 0) {// 배수 확인

				}
			}
		}
		cycle++;
	}
	
	static void makeavg() {
		//평균 구하고 평균보다 크면 -1, 작으면 +1
		if(totalsum==0||total==0)return;
		int avg = totalsum/total;
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {				
				if(circle[i][j] >avg) {
					circle[i][j]--;
				}else if(circle[i][j] <avg){
					circle[i][j]++;
				}
			}
		}
	}

	static void rotate() {
		total = 0;
		totalsum = 0;
		//for (int t = 0; t < T; t++) {
			for (int i = 0; i < info[cycle][2]; i++) {// 회전할 판 선택
				if (i % info[cycle][0] == 0) {
					if (info[cycle][1] == 0) {// 시계방향 -> 1씩++
						int tmp = circle[i][M - 1];
						for (int j = 0; j < M - 1; j++) {
							circle[i][j] = circle[i][j + 1];
						}
						circle[i][0] = tmp;
					} else {// 반시계
						int tmp = circle[i][0];
						for (int j = M - 1; j > 0; j++) {
							circle[i][j - 1] = circle[i][j];
						}
						circle[i][M - 1] = tmp;
					}
				}

			}
		//}
		cycle++;
		
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				totalsum+=circle[i][j];
				total++;
				if(circle[i][j] != -1) {
					totalsum-=circle[i][j];
					total--;
					removeNum(i,j,circle[i][j]);
				}					
			}
		}
	}

	// 2. 인접한 숫자를 지운다.
	static void removeNum(int x, int y, int resetnum) {
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (ny < 0 || ny >= N)
				continue;
			if (nx < 0)
				nx = M - 1;
			else if (nx >= M)
				nx = 0;
			if (circle[nx][ny] == -1)
				continue;
			if (circle[nx][ny] == resetnum) {
				circle[nx][ny] = -1;
				flag = true;
				removeNum(nx, ny, resetnum);
			}
		}
		if(!flag)makeavg();

	}

	// 3. 더한다.
	static void sum() {
		
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				ans+= (circle[i][j]!=-1?circle[i][j]:0);
			}
		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
