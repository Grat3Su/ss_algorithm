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
public class BOJ_1010_PutBridge_comb_memoi {
	static int N, M;
	static int[][] memoi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			memoi = new int[M+1][M+1];
			
			System.out.println(comb(M,N));
		}
	}
	static int comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == srcIdx||tgtIdx ==0) {			
			return memoi[srcIdx][tgtIdx] = 1;
		}
		//이미 계산된 것이 있으면 그걸 이용한다.
		if( memoi[srcIdx][tgtIdx] >0)return  memoi[srcIdx][tgtIdx];
		
		
		// 아직 계산된 값이 없으면 선택 비선택 두 가지 경우의 수를 모두 구한 뒤에 합친다.
		return  memoi[srcIdx][tgtIdx] = comb(srcIdx-1,tgtIdx-1) +comb(srcIdx-1,tgtIdx) ;
	}

}
