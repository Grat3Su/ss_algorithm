package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2001_AttackFly {
//	구간합으로 풀어보자
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken()) + 1;
			int N = Integer.parseInt(st.nextToken());

			int[][] arr = new int[M][M];
			for (int i = 1; i < M; i++) {// 구간합 구하기
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
				}
			}
			int result = 0;
			for (int i = 1; i < M; i++) {
				for (int j = 1; j < M; j++) {//NN만큼 구하기
					if(i+N>M||j+N>M)
						break;
					int res = arr[i + N - 1][j + N - 1] - arr[i - 1][j + N - 1] - arr[i + N - 1][j - 1]
							+ arr[i - 1][j - 1];
					if (result < res)
						result = res;
				}
			}
//			int result = 0;
//			for (int i = 1; i < M - N; i++) {
//				for (int j = 1; j < M - N; j++) {//NN만큼 구하기
//					int res = arr[i + N - 1][j + N - 1] - arr[i - 1][j + N - 1] - arr[i + N - 1][j - 1]
//							+ arr[i - 1][j - 1];
//					if (result < res)
//						result = res;
//				}
//			}
			System.out.println("#" + (t + 1) + " " + result);
		}
	}

}
