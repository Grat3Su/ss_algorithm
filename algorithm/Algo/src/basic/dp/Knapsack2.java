package basic.dp;

import java.util.Arrays;

public class Knapsack2 {
	static int[] memoi = new int[11];
	static int[][] item = { { 0, 0 }, { 5, 10 }, { 4, 40 }, { 3, 50 }, { 6, 30 } };
	static int limit = 10;

	public static void main(String[] args) {
		// 모든 아이템에 대해서 첫 뻔째 아이템에서 최선의 결과를 구한 후
		// 두 번재 아이템에서 첫 번째 아이템을 고려한 최선의 결과와 비교해서 다시 최선의 결과를 얻는다.
		// 이 과정을 모든 아이템에 대해 진행한다.
		// 최선의 결과는 메모이 배열에 기록한다.

		// item
		for (int i = 1; i <= 4; i++) {
			// 가장 큰 무게부터 작은 무게로 움직이면서
			for (int w = limit; w >= item[i][0]; w--) {
				// memoi[w] => i번째 아이템을 고려하기 전까지 w 무게를 만드는 데 최상의 value
				// memoi[w]를 새로운 현재 고려하는 값으로 덮어쓰지 않으면 이전 item을 고려한 최상의 value

				memoi[w] = Math.max(memoi[w], memoi[w - item[i][0]] + item[i][1]);// 이전 , 현재
			}
			System.out.println(Arrays.toString(memoi));
		}
		System.out.println(memoi[10]);
	}
}
