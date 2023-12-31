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
public class BOJ_1010_PutBridge_math {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			long child = 1;
			long parent = 1;
			for(int i = 0; i<N; i++) {
				child = child*(M-i);
				parent = parent*(i+1);
			}
			System.out.println(child/parent);
		}
	}

}
