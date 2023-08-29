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
public class BOJ_12865_NormalBackpack2 {
	static int N,K;
	static int[] weight, value;
	static int[]memoi;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		memoi = new int[K+1];
		weight = new int[N+1];
		value = new int[N+1];
				
		
		for(int i = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<N+1; i++) {
			int w = weight[i];
			int v = value[i];
			for(int k = K; k>=w; k--) {
				if(w<=k) {
					memoi[k] = Math.max(memoi[k], memoi[k-w]+v);//자기값을 더한다
				}
				
			}
		}
		System.out.println(memoi[K]);
	}

}
