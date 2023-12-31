package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_1233_사칙연산유효성2 {
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
				sb.append("#").append(t).append(" ").append(0).append("\n");
				continue;
			}

			ans = 1;
			int idx = N;//마지막 노드부터 확인
			while(idx !=1) {
				//맨 밑 노드가 연산자이거나 
				if(!Character.isDigit(node[idx])
						||!Character.isDigit(node[idx-1])
						||Character.isDigit(node[idx/2])) {
					ans = 0;
					break;
				}
					node[idx/2] = '1';
					idx -=2;
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		System.out.println(Arrays.toString(node));
	}		
}
