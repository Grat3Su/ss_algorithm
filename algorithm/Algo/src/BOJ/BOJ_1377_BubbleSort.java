package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1377_BubbleSort {//변하지 않는 위치를 찾는거같은데

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		boolean changed = false;
		int[] A = new int[N];
		
		for(int i = 0; i<N; i++)
			A[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N-1; i++) {
			boolean change = false;
			for(int j = i+1; j<N; j++) {
				if(A[j-1] > A[j]) {//j-1 = i
					int t = A[i];
					A[i] = A[j];
					A[j] = t;
					change = true;
				}				
			}			
			
		    if (!change) {
		        sb.append(i+1).append("\n");
		        break;
		    }
		} 
		if(sb!=null)
		System.out.println(sb);
		else
			System.out.println(0);
	}
}