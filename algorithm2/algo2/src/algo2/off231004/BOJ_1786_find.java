package algo2.off231004;

import java.util.*;
import java.io.*;

public class BOJ_1786_find {
	static char[] T, P;
	static int[] pi;
	static int N, cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		N = P.length;
		
		kmp();
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	static void kmp() {
		//pi 배열
		makePi();
		
		//패턴 매칭
		int tLength = T.length;
		
		int j = 0;
		
		for(int i = 0; i<tLength; i++) {
			while(j>0&&T[i]!=P[j]) {
				j = pi[j-1];
			}
			if(T[i]==P[j]) {
				//현재 text의 i번째 글자와 패턴의 j번째 글자가 일치한 상황
				// 1. 모두 일치
				//2. 일부 일치
				if(j==N-1) {//모두 일치
					cnt++;
					sb.append(i-j+1).append(" ");
					j = pi[j];
				}else {//일부 일치
					j++;//나머지ㅣ 일치를 확인하기 위해 인덱스 증가
				}
			}
		}
	}
	
	static void makePi() {
		pi = new int[N];// 부분일치 테이블
		//j 접두사쪽 인덱스, i 접미사쪽 인덱스
		int j = 0;
		for (int i = 1; i < N; i++) {
			//i번째 값(위쪽) j번째 값(앞쪽) 값이 일치하거나 j==0이면 while문 벗어난다.
			while (j > 0 && P[i] != P[j]) {
				j = pi[j - 1];// 왜냐면 j 전까지는 일치했기 때문에
			}
			//현재 시점은 j==0이거나 i번째 값과 j번째 값이 일치
			if (P[i] == P[j])
				pi[i] = ++j;
		}
	}

}
