package online;

import java.util.Scanner;

public class NQueenTest1 {
	static int N,col[],ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];//1부터 사용
		ans = 0;//가능한 경우의 수
		
		setQueen(1);
		System.out.println(ans);
	}
	
	//퀸을 현재 가능한 모든 곳에 놓기
	static void setQueen(int row) {//퀸을 놓으려는 행
		//가지치기 : 직전까지 놓여진 상태
		if(!isAvailable(row-1)) return;//유망한가? 매 순간마다 불린다.
		//상태공간 트리에서 매 순간 반복적으로 불린다.
		
		//기저조건
		if(row>N) {//유망하지 않으면 이미 가지치기 당했다
			ans++;
			return;
		}
		
		//유도파트
		for(int i = 1; i<=N; i++) {//1열에서 N열까지 시도 
			col[row] = i;
			setQueen(row+1);
		}
	}
	
	static boolean isAvailable(int row) {//row : 마지막으로 놓인 퀸
		for(int i = 1;i<row; i++) {
			if(col[i]==col[row]||row-i == Math.abs(col[row]-col[i])) {
				return false;//유망하지 않음. 위협하는 자리에 있음
			}			
		}
		return true;
		
	}
}
