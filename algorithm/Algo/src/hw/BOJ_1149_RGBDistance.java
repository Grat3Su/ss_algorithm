package hw;

import java.io.*;
import java.util.*;

public class BOJ_1149_RGBDistance {
	static int[][] RGBmap;
	static int N,min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		RGBmap = new int[N][3];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			RGBmap[i][0]=Integer.parseInt(st.nextToken());
			RGBmap[i][1]=Integer.parseInt(st.nextToken());
			RGBmap[i][2]=Integer.parseInt(st.nextToken());
		}
		
		colored(-1, 0,0);
		System.out.println(min);
	}
	
	static void colored(int cur, int idx, int count) {
		if(idx==N) {
			min = Math.min(min, count);
			return;
		}
		if(count>min)return;
		
		if(cur!=0) {
			cur = 0;
			colored(cur, idx+1, count+RGBmap[idx][0]);
		}
		 if(cur!=1) {
			 cur = 1;
			colored(cur, idx+1, count+RGBmap[idx][1]);			
		}
		if(cur!=2) {
			cur = 2;
			colored(cur, idx+1, count+RGBmap[idx][2]);		
			
		}
	}
}