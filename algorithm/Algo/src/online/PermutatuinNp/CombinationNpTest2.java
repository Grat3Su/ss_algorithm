package online.PermutatuinNp;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationNpTest2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int[] input = new int[N];
		int[] p = new int[N];
		
		for(int i = 0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		int cnt = 0;
		while(++cnt<=R)	 p[N-cnt] = 1; 
		
		do{
			//p 배열을 이용ㅎㄴ 조합확인
			for(int i = 0; i<N; i++) {
				if(p[i]==0)continue;
				System.out.print(input[i]+"\t");
			}
			System.out.println();
			
		}while(np(p));
//		long start = System.nanoTime();
//		do {
//			System.out.println(Arrays.toString(input));
//		}while(np(input));
//		
//		long end = System.nanoTime();
//		System.out.println((end-start)/1_000_000.0);
	}
	
	static boolean np(int[]p) {//P:다음 순열을 원하는 기존 순열의 배열
		//다음 수열을 만들수 있었는지 여부를 따지기 위해 bool형
		
		int N = p.length;
		int i = N-1;
		while(i>0&&p[i-1]>=p[i]) --i;
		//1. 직전값을 비교해서 크면 기준을 옮긴다
		//2. 상황을 만족하지 못해서 내려온다
		if(i==0) return false;//다음 순열 없음(가장 큰 순열의 형태)
		//2.곡대기 직전(i-1) 위치에 교환할 한단계 큰 수 뒤쪽부터 찾기
		int j = N-1;
		while(p[i-1]>=p[j])--j;
		//3. 꼭대기 직전 (i-1)위치의 수와 한단계 큰 수를 교환하기.
		swap(p, i-1, j);
		
		//4. 꼭대부터 맨 뒤까지의 수를 오름차순의 형태로 바꿈
		int k = N-1;
		while(i<k) {
			swap(p,i++,k--);//i는 뒤로가ㅣ고 k는 앞으로
			//ik가 같아지면 끝난다
		}
		return true;
	}
	
	static void swap(int[]p, int a, int b) {
		int temp=p[a];
		p[a]=p[b];
		p[b]=p[a];
	}

}
