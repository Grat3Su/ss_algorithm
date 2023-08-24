package hw;
///https://www.acmicpc.net/problem/15961

import java.util.*;
import java.io.*;

/* n(접시수) d(가짓수d) k(연속으로 먹는 접시 수) c(쿠폰번호)
 * 8 30 4 30
7
9
7
30
2
7
9
25
 */
//슬라이딩 윈도우


public class BOJ_15961_Sushi {
	static int N,D,K,C,max;
	static int[] rail;
	static int[] sushi;//이 배열에 투포인터로  ++ --
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer>queue = new ArrayDeque<Integer>();
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		max = 0;
		sushi = new int[D];
		rail = new int[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			rail[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; i++) {
			if(i>=K)	sushi[rail[i-K]]--;
			
			sushi[rail[i]]++;
				
		}
		
	}

}
