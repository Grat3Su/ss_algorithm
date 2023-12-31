package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_15650_NnM {
	static int[] tgt;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tgt = new int[M]; 
		
		comb(1,0);
		System.out.println(sb);
	}
	
	static void comb( int start, int tgtIdx) {
		if(tgtIdx == M) {
			
			for(int i:tgt)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		if(start > N)
			return;
		
			tgt[tgtIdx] = start;
			comb(start+1, tgtIdx+1);
			comb(start+1, tgtIdx);			
	}

}
