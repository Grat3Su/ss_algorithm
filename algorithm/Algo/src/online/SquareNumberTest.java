package online;

import java.util.Scanner;

public class SquareNumberTest {
	static int X, N;
	static int callCnt1, callCnt2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		N = sc.nextInt();
		
		System.out.println(exp1(X,N));
		System.out.println("exp1 : "+callCnt1);
		System.out.println(exp2(X,N));
		System.out.println("exp2 : "+callCnt2);
	}
	//재귀 : 분할정복 미적용
	//X^n = X*X^n-1
	//X^n-1 = X*X^n-2
	static long exp1(long x, int n) {
		callCnt1++;
		if(n==1) return x;
		return x*exp1(x, n-1);
	}

	//재귀 : 분할 ㅓㅇ복 적용
	//n : 짝수 	X^n = X^n/2*X^n/2
	//n : 홀수	X^n = X^n-1/2*X^n-1/2*X^1
	//n : 홀수	X^n/2 => X^n-1/2과 같음
	static long exp2(long x, int n) {
		callCnt2++;
		if(n==1) return x;
		long y = exp2(x, n/2);
		return (n%2==0)?y*y:y*y*x;
	}
}
