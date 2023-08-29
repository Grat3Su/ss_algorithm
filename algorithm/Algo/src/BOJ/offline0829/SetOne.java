package BOJ.offline0829;

import java.util.*;
import java.io.*;

public class SetOne {
	static int[] memoi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memoi = new int[N+1];
		System.out.println(make(N));
	}
	
	//n을 1로 만드는 최소 연산
	static int make(int n) {
		if(n==1) return 0;
		if(memoi[n]>0) return memoi[n];
			//3가지 연산 중 최소값을 선택
			
			//1을 더하기
			memoi[n] = make(n-1)+1;
			//2로 나누어 떨어지면 2로 나눈 연산 수+1하고 바로 앞에서 계산된 memoi[n]중 최솟값 선택
			if(n%2==0)memoi[n]=Math.min(memoi[n],make(n/2)+1);
			//3으로 나누기
			if(n%3==0)memoi[n]=Math.min(memoi[n],make(n/3)+1);
			return memoi[n];
	}

}
