package basic.dp;

public class fibonacci {

	public static void main(String[] args) {
//		long result = fibo_rc(40);
//		long result = fibo_rc_memoi(50);
		long result = fibo_dp_memoi(50);
		System.out.println(result);

	}
//단순 재귀 호출
	static long fibo_rc(int n) {
		if(n==1||n==2) return 1;
		
		return fibo_rc(n-1)+fibo_rc(n-2);
	}
	
	//memoi
	static long[] memoi_rc = new long[51];
	static long fibo_rc_memoi(int n) {
		if(n==1||n==2) return 1;
		
		if(memoi_rc[n]>0) return memoi_rc[n];
		
		return memoi_rc[n] = fibo_rc_memoi(n-1)+fibo_rc_memoi(n-2);
	}
	//dp
	static long[] memoi_dp = new long[51];
	static long fibo_dp_memoi(int n) {//재귀구조를  사용하지 않기 때문에 더 빠르다
		memoi_dp[1] = 1;
		memoi_dp[2] = 1;
		for(int i = 3; i<=n; i++) {
			memoi_dp[i]=memoi_dp[i-1]+memoi_dp[i-2];
		}
		return memoi_dp[n];
	}
}
