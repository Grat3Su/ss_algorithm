package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2961_doyoungscook2 {
	static int N;
	static int[][] src; 
	static boolean[] selected; 
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(bf.readLine());
		src = new int[N][2];
		selected = new boolean[N];
		min = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}
		subSet(0,0);
		System.out.println(min);
	}
	
	static void subSet(int idx, int mask) {
		if(idx == N) {
			//result(mask);
			int sin = 1;
			int ssn = 0;
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				if(selected[i]) {
					sin*=src[i][0];
					ssn+=src[i][1];
					cnt++;
				}
			}
			if(cnt>0)
				min = Math.min(min, Math.abs(sin-ssn));
			return;
		}
		selected[idx] = true;
		subSet(idx+1,mask);
		selected[idx] = true;
		subSet(idx+1,mask);
	}
	
}
