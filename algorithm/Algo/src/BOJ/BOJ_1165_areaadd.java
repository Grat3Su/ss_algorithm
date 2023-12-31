package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1165_areaadd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
		int[] src = new int[N];
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<N; i++) {
			src[i] = Integer.parseInt(st.nextToken())+src[i-1];
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken());
			
			sb.append(src[y]-src[x]).append("\n");
		}
		
		System.out.println(sb);
	}

}
