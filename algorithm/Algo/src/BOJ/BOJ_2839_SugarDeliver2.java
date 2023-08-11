package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_SugarDeliver2 {
	// greedy
	// 3보다는 5를 사용하는게 유리
	// 5 -> 최대한 많이 3-> 최대한 적게
	// 5가 나눠지는 상황
	// 3 빼기, 나누기..

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 3kg 5kg
		int count = 0;// 봉투갯수
		while (true) {
			if (N < 0) {
				System.out.println(-1);
				break;
			}
			if (N % 5 == 0) {//5를 최대한 많이 사용하기 위해 나누어 떨어지면 나눈다
				System.out.println((N / 5 + count));
				break;
			} else {//5로 나누어 떨어지지 않음ㄴ 3만큼 줄인다.
				N -= 3;
				count++;
			}
		}
	}
}
