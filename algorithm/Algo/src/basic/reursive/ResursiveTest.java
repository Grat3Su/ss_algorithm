package basic.reursive;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

//재귀 호출
//메소드가 자기 자신 메소드를 다시 호출
//static 변수를 통해 재귀 호출하는 동안 공유
//static 변수를 사용하지 않을 경우, 파라미터 이용 공유
//스택 오버플로우 에러가 발생하지 않으려면 무한 반복 호출x < 기저조건(탈출조건) 필요
public class ResursiveTest {

	public static void main(String[] args) {
		//m1(0);
		//m2();
		//m2_corrent();
		//m2_corrent2();
		//m3_(5);
		//factorial(5);
		System.out.println(factorial_2(5));
	}
	
	static int m1_cnt = 0;
	static void m1(int j)
	{
		int i = 0;
		System.out.println(i++);
		System.out.println(j);
		
		m1(++j);
	}
	
	//기저 조건 추가
	//1,2가 모두 6번 출력 => 2 출력시 0이 모두 출력
	static int m2_cnt = 5;
	static void m2() {
		System.out.println("1 m2_cnt = "+m2_cnt);
		
		if(m2_cnt>0) {
			m2_cnt--;
			m2();
		}
		System.out.println("2 m2_cnt = "+m2_cnt);
	}

	static int m2_cnt_corrent = 5;
	static void m2_corrent() {
		System.out.println("1 m2_cnt_corrent = "+m2_cnt_corrent);
		
		if(m2_cnt_corrent==0) {
			return;
		}
		m2_cnt_corrent--;
		m2_corrent();
		System.out.println("2 m2_cnt_corrent = "+m2_cnt_corrent);
	}
	
	//기저조건을 앞으로 이동
	//공유되는 변수의 변화를 워ㄴ복
	static int m2_cnt_corrent2 = 5;
	static void m2_corrent2() {
		if(m2_cnt_corrent2==0) {
			return;
		}
		
		System.out.println("1 m2_cnt_corrent = "+m2_cnt_corrent2);
		m2_cnt_corrent2--;
		m2_corrent2();
		m2_cnt_corrent2++;
		System.out.println("2 m2_cnt_corrent2 = "+m2_cnt_corrent2);
	}
	
	//재귀호출 공유 변수를 static이 아닌 파라미터로 할 경우
	static void m3(int m3_cnt) {
		if(m3_cnt==0)
		return;
		
		System.out.println("1 m3_cnt = "+m3_cnt);
		m3_cnt--;
		m3(m3_cnt);
		m3(m3_cnt--);
		System.out.println("2 m3_cnt = "+m3_cnt);

	}
	//팩토리얼
	static int result = 1;
	
	static void factorial(int n) {
		if(n==1)
		{
			System.out.println(result);
			return;
		}
		result = result*n;
	factorial(n-1);
}
	static int factorial_2(int n) {
		if(n==1)
		{
			//System.out.println(result);
			return 1;
		}
		return n* factorial_2(n-1);
	}
}