package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1
5 1000
100 200
300 500
250 300
500 1000
400 400	//Test Case 갯수
//Test Case #1, N = 5, L = 1000
//Test Case #1, 첫번째 재료 정보



 */
public class SW_5215_HamburgerDiet {	
	static int N, max;
	static int limit;
	static Item[] src;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		
		
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			src = new Item[N];
			limit = Integer.parseInt(st.nextToken());			
			max = 0;
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i] = new Item(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));				
			}
			//부분집합
			subset(0,0);//두 번째 인자가 mask
			
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
			
		}
		System.out.println(sb);
	}
	
	//부분집합
	static void subset(int idx, int mask) {
		if(idx == N) {
			int cal = 0;
			int point = 0;
			//for문을 통해서 선택된 재료들에 대한 cal, point의 계산
			for(int i = 0; i<N; i++) {//i번째 재료의 선택 여부 (mask에 기록)
				if((mask&1<<i)==0)	continue;
				cal+=src[i].c;
				point+=src[i].p;
			}
			//칼로리 체크, max 처리
			if(cal <=limit)max=Math.max(max, point);
			return;
		}

		subset(idx+1, mask|1<<idx);//선택

		subset(idx+1, mask);//미선택
	}
	
	static class Item{
		int p, c;
		Item(int p, int c){
			this.p = p;
			this.c = c;
		}
	}
}
