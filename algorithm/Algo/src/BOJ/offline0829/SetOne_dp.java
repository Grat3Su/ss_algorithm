package BOJ.offline0829;

import java.util.*;
import java.io.*;

public class SetOne_dp {
	static int[] memoi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memoi = new int[N+1];
		
		memoi[1] = 0;
		for(int i = 2; i<=N; i++) {
			memoi[i] = memoi[i-1]+1;
			
			if(i%2==0)memoi[i] = Math.min(memoi[i], memoi[i/2]+1);
			if(i%3==0)memoi[i] = Math.min(memoi[i], memoi[i/3]+1);
		}
		System.out.println(memoi[N]);
	}
}
