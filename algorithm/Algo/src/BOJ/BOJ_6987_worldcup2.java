package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 데이터셋
 * A B C D...
5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4
 */
public class BOJ_6987_worldcup2 {
	static int[][] game;// for-for match 진행을 이어나갈 배열
	static int[] win, lose, draw;// 승 패 무 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		win = new int[6];
		lose = new int[6];
		draw = new int[6];

		// 게임 배열 2팀이 각각 1:1 시합을 이어나가는 형태
		game = new int[15][2];
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				game[idx][0] = i;
				game[idx][1] = j;
				idx++;
			}
		}
		// 입력
		for (int i = 0; i < 4; i++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {// 팀별 3개씩 끊어서
				sum += win[j] = Integer.parseInt(st.nextToken());
				sum += draw[j] = Integer.parseInt(st.nextToken());
				sum += lose[j] = Integer.parseInt(st.nextToken());
			}

			if (sum != 30) {// 유효하지 않음
				System.out.print("0 ");
				continue;
			}
			// 완전탐색
			if (dfs(0))
				System.out.print("1 ");
			else
				System.out.print("0 ");
		}

	}

	// 게임 배열을 이용해서 모든 1:1게임을 순차적으로 진행하면서 win lose draw 자료구조 유효성 검증
	// 가지치기 - win lose draw에 대해 각 배열에 양수일 때만 진행
	// game배열 끝에 도달하면 유효한 결과
	private static boolean dfs(int idx) {
		// 기저조건
		if (idx == 15)
			return true;
		int teamA = game[idx][0];
		int teamB = game[idx][1];

		// a팀이 이기는 경우
		if (win[teamA] > 0 && lose[teamB] > 0) {
			win[teamA]--;
			lose[teamB]--;

			if (dfs(idx + 1))
				return true;
			// 현재 게임의 결과를 이어나갈 때 모든 결과가 문제없으면 true
			win[teamA]++;
			lose[teamB]++;
		}

		// b팀이 이기는 경우
		if (win[teamB] > 0 && lose[teamA] > 0) {
			win[teamB]--;
			lose[teamA]--;

			if (dfs(idx + 1))
				return true;
			// 현재 게임의 결과를 이어나갈 때 모든 결과가 문제없으면 true
			win[teamB]++;
			lose[teamA]++;
		}

		// 비기는 경우
		if (draw[teamA] > 0 && draw[teamB] > 0) {
			draw[teamA]--;
			draw[teamB]--;

			if (dfs(idx + 1))
				return true;
			// 현재 게임의 결과를 이어나갈 때 모든 결과가 문제없으면 true
			draw[teamA]++;
			draw[teamB]++;
		}
		return false;
	}

}
