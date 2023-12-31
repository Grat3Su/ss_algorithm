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
		sushi = new int[D+1];
		rail = new int[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			rail[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; i++) {			
			sushi[rail[i]]++;//현재 레일의 값을 스시배열에 +1해준다
			if(i>=K) {
				check();
				sushi[rail[i-K]]--;// K보다 크면 지나친 스시 값을 뺜다
			}
		}
		System.out.println(max);
	}
	
	static void check() {
		int count = 0;
		boolean c = false;
		for(int d =0 ; d<D+1; d++) {//해당칸에 있나 없나를 체크
			if(sushi[d]>0) {
				count++;
				if(d == C) {//쿠폰
					c = true;
				}
			}
		}
		if(!c)
			count++;
		
		max = Math.max(max, count);
	}
	
	

}
