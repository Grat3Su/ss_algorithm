package basic.perm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class NMPerm {
	static int N,M;
	static int[]arr;
	static int[]tgt;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		check = new boolean[N];
		tgt = new int[M];
		
		for(int i = 0; i<N; i++)
			arr[i] = i+1;
		
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
			tgt[tgtidx] = arr[i];
			check[i] = true;
			perm(tgtidx+1);
			check[i] = false;
		}
			
	}

}
