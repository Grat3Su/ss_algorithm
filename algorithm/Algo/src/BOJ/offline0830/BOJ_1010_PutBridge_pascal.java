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

//DP-pascal
public class BOJ_1010_PutBridge_pascal {
	static int N, M,ans;
	static int[][] memoi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			memoi = new int[M+1][M+1];
			memoi[0][0] = 1;
			
			//파스칼 삼각형
			for(int i = 1; i<=M; i++) {//밑으로 : 행
				for(int j = 0; j<=i; j++) {//옆으로 : 열
					//맨 앞 맨 뒤는 1
					if(j==0|| j==i) {
						memoi[i][j] = 1;
						continue;
					}
					memoi[i][j] = memoi[i-1][j-1] + memoi[i-1][j];//왼 오
				}
			}
			System.out.println(memoi[M][N]);
		}
	}
}
