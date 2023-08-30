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
public class BOJ_1010_PutBridge_comb {
	static int N, M,ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			comb(0,0);
			System.out.println(ans);
		}
	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == N) {
			ans++;
			return;
		}
		
		if(srcIdx == M)return;
		
		comb(srcIdx+1, tgtIdx);
		comb(srcIdx+1, tgtIdx+1);
	}

}
