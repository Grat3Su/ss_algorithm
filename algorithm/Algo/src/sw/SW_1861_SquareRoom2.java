package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1861_SquareRoom2 {
//BFS로 푸는 문제래
//첫 번째 테스트 케이스는 1 또는 3이 적힌 곳에 있어야 한다.
//두 번째 테스트 케이스는 3 또는 6이 적힌 곳에 있어야 한다.
	
	static StringBuilder sb = new StringBuilder();
	static int N, ans, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][]start = new int[3][2];
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {			
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][]map = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						start[0][0] = i;
						start[0][1] = j;
					}
					else if(map[i][j]==3) {
						start[0][0] = i;
						start[0][1] = j;
					}
					else if(map[i][j]==6) {
						start[0][0] = i;
						start[0][1] = j;
					}
					
				}
			}
			
			
		}
		
	}	
}
