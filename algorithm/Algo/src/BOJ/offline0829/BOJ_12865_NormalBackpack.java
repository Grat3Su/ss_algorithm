package BOJ.offline0829;

import java.io.*;
import java.util.*;
/* 가치 합의 최대
 * N K
 * W V
 * 4 7
6 13
4 8
3 6
5 12
 */
public class BOJ_12865_NormalBackpack {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] memoi = new int[N+1][K+1];
		int[][] item = new int [N+1][2];
		
		for(int i = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0]= Integer.parseInt(st.nextToken());
			item[i][1]= Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<N+1; i++) {
			for(int w = 1; w<=K; w++) {
				if(item[i][0]<=w) {
					int sel_o = memoi[i-1][w-item[i][0]]+item[i][1];
					int sel_x = memoi[i-1][w];
					
					memoi[i][w] = Math.max(sel_o, sel_x);
				}else {
					memoi[i][w] = memoi[i-1][w];
				}
				
			}
		}
		System.out.println(memoi[N][K]);
	}

}
