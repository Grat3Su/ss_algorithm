package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_BlackJack {
	static int[] src;
	static int tgt;
	static int N;//배열 크기
	static int M;//비교할 수
	static int result = 0;
	static StringBuilder sb = new StringBuilder();
	static int[] testTgt = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		src = new int[N];
		tgt = 0;
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i<N; i++)
		{
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0,0);
		
		sb.append(result);
		System.out.println(sb);
	}
	
	static void comb(int start, int tgtidx, int test) {
		if(tgtidx == 3)
		{
			for(int i:testTgt) tgt += i;
			if(tgt<=M&&result < tgt) {
				result = tgt;				
			}
			tgt = 0;
			return;
		}
		
		if(start == N) {
			return;
		}
		
		testTgt[tgtidx] = src[start];
		comb(start+1,tgtidx+1,test);
		comb(start+1,tgtidx,test);
	}

}
