package hw;

import java.io.*;
import java.util.*;

public class BOJ_1149_RGBDistance {
	static int[][] RGBmap;
	static int N,min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		RGBmap = new int[N][3];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			RGBmap[i][0]=Integer.parseInt(st.nextToken());
			RGBmap[i][1]=Integer.parseInt(st.nextToken());
			RGBmap[i][2]=Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<N; i++) {
			RGBmap[i][0] += Math.min(RGBmap[i-1][1], RGBmap[i-1][2]);//빨강의 경우 N-1이 파랑과 초록인 경우를 비교해서 더 작은 값을 가진다
			RGBmap[i][1] += Math.min(RGBmap[i-1][0], RGBmap[i-1][2]);//파랑의 경우 빨강과 초록
			RGBmap[i][2] += Math.min(RGBmap[i-1][0], RGBmap[i-1][1]);//초록의 경우 빨강과 파랑
		}
		min = Math.min(RGBmap[N-1][0], RGBmap[N-1][1]);
		min = Math.min(min, RGBmap[N-1][2]);
		System.out.println(min);//셋중에 가장 작은 값을 결과로 출력한다.
	}
	
	static void colored(int cur, int idx, int count) {//-> 45%에서 시간초과....
		if(idx==N) {
			min = Math.min(min, count);
			return;
		}
		if(count>min)return;
		int c = cur;
		if(c!=0) {
			cur = 0;
			colored(cur, idx+1, count+RGBmap[idx][0]);
		}
		 if(c!=1) {
			 cur = 1;
			colored(cur, idx+1, count+RGBmap[idx][1]);			
		}
		if(c!=2) {
			cur = 2;
			colored(cur, idx+1, count+RGBmap[idx][2]);
		}
	}
}
