package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_BlackJack3 {
	static int N,M,max;
	static int[] src;
	static int[] tgt = new int[3];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		src = new int[N];
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i<N; i++)
		{
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0);
		System.out.println(max);
	}
	
	static void comb(int start, int tgtidx) {
		if(tgtidx == 3)
		{
			int result = tgt[0]+tgt[1]+tgt[2];
			if(result<=M&&max < result) {
				max = result;				
			}
			return;
		}
		
		if(start == N) {  return;	}
		
		tgt[tgtidx] = src[start];
		comb(start+1,tgtidx+1);
		comb(start+1,tgtidx);
	}

}
