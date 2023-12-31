package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2493_tower2 {//입력 처리.
	// input 길이가 꽤 크다. 50만개 입력
	// Scanner, BufferedReader 경우의 차이가 커짐
	// output도 크다->Stringbuilder
	// 자료구조? 모두 다 담고 왔다갔다 하는 배열보다 불필요한 자료는 제거하는 stack

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<int[]> stack = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());

			// stack에서 현재 높이보다 작은 애들은 제거, 큰 것이 나오면 그 번호를 출력
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= height) {
					sb.append(stack.peek()[0]+1).append(" ");
					break;
				}
				stack.pop();// height보다 작으면 제거
			}
			// 내가 제일 높으면
			if (stack.isEmpty()) {
				sb.append("0 ");
			}
			stack.push(new int[] { i, height });
		}
		System.out.println(sb);
	}
}
