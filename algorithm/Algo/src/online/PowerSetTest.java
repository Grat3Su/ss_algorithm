package online;

import java.util.Scanner;

public class PowerSetTest {
	static int N, input[];
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
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
			for (int i = 0; i < N; i++) {
				//System.out.println(isSelected[i]?input[i]:"X");
				sb.append(isSelected[i]?input[i]:"X").append(" ");
			}
			sb.append("\n");
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		isSelected[cnt] = false;
		generateSubset(cnt+1);
		
	}
	
}
