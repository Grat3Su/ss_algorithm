package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11660_ArrayAreaAdd {
//각 좌표의 원점으로부터의 좌표까지의 사각형 영역의 합을 미리 계산
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
		int[][] src = new int[N][N];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());//배열
			for(int j = 1; j<N; j++) {
				src[i][j] = Integer.parseInt(st.nextToken())+src[i-1][j]+src[i][j-1]-src[i-1][j-1];
			}
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());//배열
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = src[x2][y2] - src[x1-1][y2] - src[x2][y1-1]+src[x1-1][y1-1];
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

}
