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
public class SW_4012_ingredients2 {
	static int [][]map;
	static boolean []select;
	static int T, N, min,halfN;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			select = new boolean[N];
			halfN = N/2;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//풀이
			
			
			comb(1, 0);
			sb.append("#").append(t+1).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void comb(int srcidx, int tgtidx) {
		if (tgtidx == halfN) {
			check();
			return;
		}

		if (srcidx == N)
			return;
		select[srcidx] = true;
		comb(srcidx + 1, tgtidx + 1);
		select[srcidx] = false;
		comb(srcidx + 1, tgtidx);
	}

	private static void check() {
		int sumA = 0;
		int sumB = 0;
		
		for(int i =0; i<N-1;i++) {
			for(int j =i+1; j<N;j++) {
				if(select[i]&&select[j]) {
					sumA+=map[i][j];
					sumA+=map[j][i];
				}else if(!select[i]&&!select[j]) {
					sumB+=map[i][j];
					sumB+=map[j][i];
					
				}
			}			
		}
		min = Math.min(min,Math.abs(sumA-sumB));
			
		
	}
	

}
