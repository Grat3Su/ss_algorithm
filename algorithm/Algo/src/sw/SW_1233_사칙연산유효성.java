package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1233_사칙연산유효성 {
	/*
	 * 검증할 유효성 이진 트리의 아래로부터 검증해야함<dfs 1. 검증하는 노드가 숫자이면 자식이 없는지 확인 2. 검증하는 노드가 연산자이면
	 * 자신의 유효성에 의존 <=dfs
	 */
	static int N, ans;
	static char[] node;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N + 1];

			// 두번째만 관리
			for (int i = 1; i < N + 1; i++) {
				node[i] = br.readLine().split(" ")[1].charAt(0);
			}

			// 완전 이진트리지만 자식이 한 쪽만 있는 경우
			if (N % 2 == 0) {
				sb.append("#").append(" ").append(0).append("\n");
				continue;
			}

			ans = dfs(1) ? 1 : 0;// 바닥에서부터 dfs(1) 수행되고 최종 결과가 true /false에 따라 처리
			sb.append("#").append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	//x 위치 노드가 유용한지 검사
	static boolean dfs(int x) {
		//기저조건
		if(x >N) return false;
		
		//숫자 노드인지 아닌지 만약 숫자면 자식이 없어야한다.
		if(Character.isDigit(node[x])) {
			if(x*2>N) return true;
			return false;
		}else {//숫자 노드가 아니면 연산자이므로 두 자식의 유효성에 의존한다.
			return dfs(x*2)&&dfs(x*2+1);			
		}
	}
}
