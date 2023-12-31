package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1954_Snail {
	static int N;
	static int[][] src;
	static int[][] tgt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		src = new int[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				src[i][j] = j+(i*N)+1;
			}
		}
		
	}
	
	//dir-> 0 : > | 1 : v | 2 : < | 3 : ^  
	static void snail(int startX, int startY, int dir, int tgtIdx) {
		if(tgtIdx > N*2-1) {
			return;
		}
		
		for(int i = 0; i<N; i++) {
		}
		
	}
}
