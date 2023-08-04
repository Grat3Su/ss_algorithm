package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//
public class BOJ_2798_BlackJack2 {
	static int N,M,max;
	static int[] src;
	//완탐 : 가능한 3개의 수를 완성해가는 방법 ㅡ= 3개의 카드와 합을 param
	
	
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
		
		dfs(0,0,0);
		System.out.println(max);
	}
	//sum을 파라미터로
	static void dfs(int start, int cnt, int sum) {
		if(cnt == 3)
		{
			if(max<=M) {
				max = Math.max(max, sum);				
			}
			return;
		}
		
		if(start == N) {  return;	}
		
		dfs(start+1, cnt+1,sum+src[start]);
		dfs(start+1, cnt,sum);
	}

}
