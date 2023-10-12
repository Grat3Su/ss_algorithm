package algo_A;

import java.io.*;
import java.util.*;
/*15`	
11111111
11111111
11111111
11111111
3
1 1
2 1
3 1
 */

public class Magnet {
	static int K, ans;
	static int[] score = { 1, 2, 4, 8 };
	static int[][] gear;
	static int[] dir;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = s.charAt(j) - '0';
			}
		}

		K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			check(id, d);
			rotate();
		}
		for (int i = 0; i < 4; i++) {
			if (gear[i][0] == 1) {
				ans += score[i];
			}
		}
		System.out.println(ans);
	}

	static void check(int id, int d) {
		dir = new int[4];
		dir[id] = d;

		// 오른쪽
		for (int i = id + 1; i < 4; i++) {
			if (gear[i - 1][2] != gear[i][6]) {
				dir[i] = dir[i - 1] * (-1);
			}
		}
		// 왼쪽
		for (int i = id - 1; i >= 0; i--) {
			if (gear[i][2] != gear[i+1][6]) {
				dir[i] = dir[i + 1] * (-1);
			}
		}
	}

	static void rotate() {
		for (int i = 0; i < 4; i++) {
			int temp;

			switch (dir[i]) {
			case 1:// 시계
				temp = gear[i][7];
				for (int j = 7; j > 0; j--) {
					gear[i][j] = gear[i][j - 1];
				}
				gear[i][0] = temp;

				break;
			case -1:
				temp = gear[i][0];
				for (int j = 0; j <7; j++) {
					gear[i][j] = gear[i][j + 1];
				}
				gear[i][7] = temp;
				break;
			}
		}

	}
}
