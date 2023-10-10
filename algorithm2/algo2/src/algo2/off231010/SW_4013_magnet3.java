package algo2.off231010;

import java.io.*;
import java.util.*;

public class SW_4013_magnet3 {
	static int K, ans;
	static int[] score = { 1, 2, 4, 8 };
	static int[][] gear;
	static boolean[] check = new boolean[4];
	// 각 자석별 방향 기록
	static int[] dir;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		gear = new int[4][8];

		// 자석 + 날개 입력
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = s.charAt(j) - '0';
			}
		}
		K = Integer.parseInt(br.readLine());

		// 풀이
		ans = 0;
		// K만큼 회전
		// 입력 받으면서 처리
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 움직이는 자석, 방향
			int id = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			// 현재 시점의 각 자석의 상태 확인 => dir 배열 완성 <= 각 자석이 어느 방향으로 회전할지
			check(id, dir);
			// 자석 회전
			rotate();
		}

		// 남은 자석 상태 채점
		for (int i = 0; i < 4; i++) {
			if (gear[i][0] == 1) {
				ans += score[i];
			}

		}

		System.out.println(ans);
	}

	private static void check(int id, int d) {
		dir = new int[4];// 초기화
		dir[id] = d;

		// 오른쪽
		for (int i = id + 1; i < 4; i++) {
			if (gear[i - 1][2] != gear[i][6]) {// 왼-오 인접한 값이 다르다
				dir[i] = dir[i - 1] * (-1);
			}
		}

		// 왼쪽
		for (int i = id - 1; i >= 0; i--) {
			if (gear[i][2] != gear[i + 1][6]) {// 왼-오 인접한 값이 다르다
				dir[i] = dir[i + 1] * (-1);
			}
		}

	}

	private static void rotate() {
		for (int i = 0; i < 4; i++) {
			int temp;
			// 각 자석별 회전 방향에 따라 회전
			switch (dir[i]) {
			case 1:// 시계
				temp = gear[i][7];
				for (int j = 7; j > 0; j--) {
					gear[i][j] = gear[i][j - 1];
				}
				gear[i][0] = temp;
				break;
			case -1:// 반시계
				temp = gear[i][0];
				for (int j = 0; j < 7; j++) {
					gear[i][j] = gear[i][j + 1];
				}
				gear[i][7] = temp;
				break;
			}
		}

	}

}
