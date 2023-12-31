package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2493_tower {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] tower = new int[N];
		int[] ans = new int[N];
		ans[0] = 0;

		for (int i = 0; i < N; i++) {// 배열 생성
			tower[i] = Integer.parseInt(st.nextToken());
		}

		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(N - 1);
		for (int i = N - 2; i > -1; i--) {
			while (!stack.isEmpty()) {
				if (tower[stack.peek()] <= tower[i]) {
					ans[stack.peek()] = i+1;
					stack.pop();
				}
				else
					break;
			}
			stack.push(i);
		}

		for(int i:ans) sb.append(i).append(" "); 
		System.out.println(sb);
	}

}
