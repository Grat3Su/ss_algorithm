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


public class BOJ_15961_Sushi2 {
	static int N,D,K,C,ans;
	static int[] rail;//레일 위에 있는 초밥들
	static int[] sushi;//모든 스시
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 0;
		sushi = new int[D+1];
		rail = new int[N];
		for(int i = 0; i<N; i++) {
			rail[i] = Integer.parseInt(br.readLine());//레일에 모두 담는다
		}

		slide();
		System.out.println(ans);
	}
	
	static void slide() {
		int total=0;
		for (int i = 0; i < K; i++) {
			if(sushi[rail[i]] ==0) total++;
			sushi[rail[i]]++;//레일에 있는 초밥의 수를 올린다.
		}
		ans = total;
		
		for (int i = 1; i < N; i++) {
			if(ans<=total) {
				if(sushi[C]==0) {
					ans = total+1;
				}else {
					ans = total;
				}
			}
			//회전 초밥
			sushi[rail[i-1]]--;//레일에 담긴 초밥 내려놓고
			if(sushi[rail[i-1]]==0)total--;//초밥 선택이 없으면 토탈값을 깎는다.
			
			if(sushi[rail[(i+K-1)%N]]==0)total++;//집은적 없는 초밥이면 ++
			sushi[rail[(i+K-1)%N]]++;//레일에 있는 초밥을 집었다.
		}
	}	
	

}
