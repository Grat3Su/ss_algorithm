package basic.perm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class NMPerm3 {
	static int N,M;
	static int[]tgt;//자연수를 쓰니까 꼭 src 배열을 사용하지 않아도 된다. 아주 빨라진다.
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());//문자열을 토큰화해서 받아들인다.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N];
		tgt = new int[M];
		
		perm(0);
	}
	
	static void perm(int tgtidx) {
		if(tgtidx == M)
		{
			for(int i:tgt)
			{
				System.out.print(i+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(check[i])	continue;
			tgt[tgtidx] = i+1;
			check[i] = true;
			perm(tgtidx+1);
			check[i] = false;
		}
			
	}

}
