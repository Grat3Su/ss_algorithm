package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2961_doyoungscook {
	static int N;
	static int[] S; 
	static int[] B; 
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		S = new int[N];
		B = new int[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		min = 9999;
		subSet(0,0);
		System.out.println(min);
	}
	
	static void subSet(int idx, int mask) {
		if(idx == N) {
			result(mask);
			return;
		}
		subSet(idx+1, mask|1<<idx);
		subSet(idx+1, mask);
	}
	
	static void result(int mask) {
		int mul = 1;
		int add = 0;
		int cnt =0;
		for(int i = 0; i<N; i++)
		{
			if((mask&1<<i)!=0) {
				mul*=S[i];
				add+=B[i];
				cnt++;	
				System.out.print(S[i]+" ");
			}
		}
		System.out.println();
		if(cnt>0)
			min = Math.min(min, Math.abs(add-mul));
		//System.out.println(min);
	}

}
