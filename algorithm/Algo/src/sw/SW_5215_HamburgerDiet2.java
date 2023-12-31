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

//dfs+param 형태로 풀기...
//item 클래스 대신 2차원 배열 사용
public class SW_5215_HamburgerDiet2 {	
	static int N, max;
	static int limit;
	static int[][] src;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		
		
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			src = new int[N][2];
			limit = Integer.parseInt(st.nextToken());			
			max = 0;
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i][0] = Integer.parseInt(st.nextToken());				
				src[i][1] = Integer.parseInt(st.nextToken());				
			}
			//부분집합
			dfs(0,0,0);//두 번째 인자가 mask
			
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
			
		}
		System.out.println(sb);
	}
	
	//부분집합
	static void dfs(int idx, int point, int cal) {
		if(idx == N) {
			//complete code
			//if(cal<=limit)
			max = Math.max(max, point);
			// L 조건을 따지지 않는다<= 이전에 미리 가지치기로 조건을 따질것
			return;
		}

		dfs(idx+1, point, cal);//비선택 - 전달받은 point, cal을 그대로 다음 재귀 호출에 전달
		//가지치기
		//다음 재귀 호출의 cal가 이미 l을 초과하면 가지 않는다.
		int nextCal = cal + src[idx][1];
		if(nextCal<=limit)//필요없는 부분을 쳐내니까 성능이 빨라짐. memorization도 기억해둘것
			dfs(idx+1, point+src[idx][0], nextCal);//선택
	}
}
