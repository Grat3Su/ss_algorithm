package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//top-down 형식
public class BOJ_1992_QuadTree2 {
/* 데이터셋
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011
 */
	static char[][] map;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];

		for (int i = 0; i < N; i++) {
			// StringTokenizer st = new StringTokenizer(br.readLine());

			String s = br.readLine();
			map[i] = s.toCharArray();

		}
		divide(0, 0, N);
		System.out.println(sb);
	}

	static void divide(int y, int x, int n) {// 분할
		if (!check(y, x, n)) {
			int half = n / 2;
			// 4분할
			sb.append("(");
			divide(y, x, half);
			divide(y, x + half, half);
			divide(y + half, x, half);
			divide(y + half, x + half, half);
			sb.append(")");
		}

	}

	// 시작점 y,x에서 너비 높이 n 영역이 모두 같은 문자인지 확인
	static boolean check(int y, int x, int n) {
		char ch = map[y][x];
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (ch != map[i][j])
					return false;
			}
		}
		// 이 영역은 모든 문자가 같다
		sb.append(ch);
		return true;// 재구ㅣ 호출 안함
	}

}
