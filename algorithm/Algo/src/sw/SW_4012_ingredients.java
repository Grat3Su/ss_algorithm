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
public class SW_4012_ingredients {
	static int []tgt;
	static boolean []selected;
	static int [][]map;
	static int T, N, add, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			selected = new boolean[N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					add += map[i][j];
				}
			}
			comb(0, 0);
			sb.append("#").append(t+1).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void comb(int srcidx, int tgtidx) {
		if (tgtidx == N/2) {
			int A = 0;
			for (int i = 0; i < N; i++) {
				for(int j = i+1; j<N; j++) {
					if(selected[i]&&selected[j]) {
						A += (map[i][j] + map[j][i]);				
					}
				}
			}
			int B = add - A;
			min = Math.min(min,Math.abs(A-B));
			return;
		}

		if (srcidx == N)
			return;

		selected[srcidx] = true;
		comb(srcidx + 1, tgtidx);
		selected[srcidx] = false;
		comb(srcidx + 1, tgtidx + 1);
	}

}
