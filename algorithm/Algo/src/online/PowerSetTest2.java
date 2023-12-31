package online;

import java.util.Scanner;

public class PowerSetTest2 {
	static int N, SUM, input[];
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		SUM = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println(sb);
	}
	
	private static void generateSubset(int cnt) {
		//cnt : 직전까지 고려된 원소의 개수, 현재 처리할 원소의 인덱스
		if(cnt == N) {//부분집합 완성
			//부분집합의 구성원소의 합을 구하고 sum과 비교
			int temp = 0, tCnt = 0;
			
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					temp += input[i];
					tCnt++;
				}
			}
			
			if(temp==SUM) {
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) {
						System.out.print(input[i]+" ");
					}
				}
			}
			System.out.println("");
			sb.append("\n");
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		isSelected[cnt] = false;
		generateSubset(cnt+1);
		
	}
	
}
