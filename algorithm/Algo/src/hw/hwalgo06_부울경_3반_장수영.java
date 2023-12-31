package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 데이터셋
4
3 45
20 20 20
6 10
1 2 5 8 9 11
4 100
80 80 60 60
4 20
10 5 10 16	// 테스트 케이스 개수
// 첫 번째 테스트 케이스 N = 3, M = 45
// 3개의 과자 봉지 무게 a1 = 20, a2 = 20, a3 = 20
 */
public class hwalgo06_부울경_3반_장수영 {
	static int[] tgt;
	static int[] A;
	static StringBuilder sb = new StringBuilder();
	static int M,N, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 배열 크기
			M = Integer.parseInt(st.nextToken());// 무게
			A = new int[N];
			tgt = new int[2];
			ans = -1;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i<N-1; i++) {
				for(int j = i+1; j<N; j++) {
					if(A[i]+A[j] >M)
						continue;
					else if(A[i]+A[j]>ans)
						ans = A[i]+A[j];
				}
			}
			
			//snack(0, 0);
			sb.append("#").append(t+1).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
