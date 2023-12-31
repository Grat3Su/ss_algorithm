package BOJ.offline0830;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/* 테스트 케이스
 * T
 * NM
 * 3
2 2
1 5
13 29
 */
public class BOJ_1010_PutBridge_math2 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			BigInteger child = BigInteger.ONE;
			BigInteger parent = BigInteger.ONE;
			for(int i = 0; i<N; i++) {
				child = child.multiply(new BigInteger(String.valueOf(M-i)));
				parent = parent.multiply(new BigInteger(String.valueOf(i+1)));
			}
			System.out.println(child.divide(parent));
		}
	}

}
