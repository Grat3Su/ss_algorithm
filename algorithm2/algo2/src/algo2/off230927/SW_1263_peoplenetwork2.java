package algo2.off230927;

import java.io.*;
import java.util.*;

//프로이드-워샬
public class SW_1263_peoplenetwork2 {
	static int N, min;
	static int[][] matrix;
	static int INF = 5000;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			// 최대 사람 수 1000
			matrix = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (i!=j && n==0	)
						matrix[i][j] = INF;
					else
						matrix[i][j] = n;
				}
			}
			
			//플로이드-워샬 사용 => matrix[i][j] : i->j로가는 최단
			for(int k = 0; k<N; k++) {//경유지 -> 고정하고 반복해야함
				for(int i = 0; i<N; i++) {
					if(i==k)continue;
					for(int j = 0; j<N; j++) {
						if(j==i|| j==k)continue;
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
						
					}
				}
			}
			min = Integer.MAX_VALUE;
			for(int i = 0; i<N; i++) {//N명의 사람 각각에 대해서 CC를 구하고 그 중 최솟값을 min
				int sum = 0;
				for(int j = 0; j<N; j++) {
					sum+=matrix[i][j];
				}
				min = Math.min(min, sum);
			}
			sb.append("#").append(t).append(" ").append(min).append("\n");
			

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (i == j)
//						continue;
//
//					for (int k = 0; k < N; k++) {
//						if (i == k || k == j)
//							continue;
//						if (matrix[i][j] > matrix[i][k] + matrix[k][j])
//							dp[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
//					}
//				}
//			}

		}
		System.out.println(sb);
	}

}
