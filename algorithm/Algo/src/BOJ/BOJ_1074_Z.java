package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
/*
 * 데이터셋 N, 방문할 r,c가 몇번째인지 
2 3 1
 */
	static int N;
	static int[][] src;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int count = 0;
		double n = Math.pow(2, N);
		src = new int[(int)n][c];
		int R = 0;
		int C = 0;
		while(R <=r&&C<=c) {
			for(int i = 0; i<2; i++) {
				for(int j = 0; j<2; j++) {
					src[R+i][C+j] = count;
					count++;
				}				
			}
			if((C+=2)==n) {
				R+=2;
				C=0;
			}
			else if(R>=n)
				break;
		}
		System.out.println(src[r][c]);
	}

}
