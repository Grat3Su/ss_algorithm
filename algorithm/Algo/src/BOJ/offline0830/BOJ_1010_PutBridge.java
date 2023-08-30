package BOJ.offline0830;

import java.io.*;
import java.util.*;

/* 테스트 케이스
 * T
 * NM
 * 3
2 2
1 5
13 29
 */
public class BOJ_1010_PutBridge {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int result = 1;
			for(int i = 0; i<N; i++) {
				result *= M-i;
				result/=i+1;
			}
			System.out.println(result);
		}
	}

}
