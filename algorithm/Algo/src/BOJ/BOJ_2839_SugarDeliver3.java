package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2839_SugarDeliver3 {
	// greedy
	// 3보다는 5를 사용하는게 유리
	// 5 -> 최대한 많이 3-> 최대한 적게
	// 5가 나눠지는 상황
	// 3 빼기, 나누기..

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())+1;
		// 3kg 5kg

		int[] dp = new int[N];
		Arrays.fill(dp, 5000);
		dp[3] = 1;
		dp[5] = 1;
		
		for(int i = 6; i<N; i++) {
			dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
		}
		if(dp[N-1]>=5000)
			System.out.println(-1);
		else
			System.out.println(dp[N-1]);
	}
}
