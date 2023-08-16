package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 데이터셋 
 * T
 * N
 * int arr[][]
 */
public class SW_4012_ingredients3 {
	static int []tgt;
	static int [][]map;
	static boolean []select;
	static int []arrA;
	static int []arrB;
	static int T, N, add, min,halfN;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			halfN = N/2;
			arrA= new int[N/2];
			arrB = new int[N/2];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					add += map[i][j];
				}
			}
			//풀이
			
			
			comb(1, 0,0);
			sb.append("#").append(t+1).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void comb(int srcidx, int tgtidx,int mask) {
		if (tgtidx == halfN) {
			check(mask);
			return;
		}

		if (srcidx == N)
			return;
		select[srcidx] = true;
		tgt[tgtidx] = srcidx;
		comb(srcidx + 1, tgtidx + 1,mask|1<<srcidx);
		select[srcidx] = false;
		comb(srcidx + 1, tgtidx,mask);
	}

	private static void check(int mask) {
		int sumA = 0;
		int sumB = 0;
		int idxA = 0;
		int idxB = 0;
		for(int i = 0; i<N; i++) {
			if((mask&1<<i)!=0)arrA[idxA++] = i;
			else arrB[idxB++] = i;
		}
		
		for(int i =0; i<halfN;i++) {
			for(int j =0; j<halfN;j++) {
				if(i==j) continue;
				sumA+=map[arrA[i]][arrA[j]];
				sumA+=map[arrB[i]][arrB[j]];
			}			
		}
		min = Math.max(min,Math.abs(sumA-sumB));
			
		
	}
	

}
