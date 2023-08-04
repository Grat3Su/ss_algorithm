package basic.perm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//출력이 !까지 나오니까 출력이 매우 크다
//print 대신 Stringbuilder 사용
public class NMPerm_bitmask {
	static int[]tgt;
	static int[]src= {};
	static int N, M;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());//문자열을 토큰화해서 받아들인다.
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tgt = new int[M];
		
		perm(0,0);
	}
	
	static void perm(int tgtidx,int mask) {
		if(tgtidx == M)
		{
//			for(int i:tgt)
//			{
//				sb.append(i).append(" ");
//				//System.out.print(i+" ");
//			}
//			sb.append("\n");
//			//System.out.println("");
			System.out.println(Arrays.toString(tgt));
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if((mask&1<<i)!=0)continue;
			tgt[tgtidx] = i;
			perm(tgtidx+1, mask|1<<tgtidx);
			perm(tgtidx+1, mask);
		}
			
	}

}
