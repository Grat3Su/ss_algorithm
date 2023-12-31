package online;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	static int N, numbers[];
	static boolean[] isSlelcted;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력으로 주사위 던지는 횟수와 모드(1 2 3 4)
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//주사위 던지는 횟수
		int M = sc.nextInt();//mode
		
		numbers = new int[N];
		
		switch (M) {
		case 1://중복순열
			dice1(0);
			break;
		case 2://순열
			isSlelcted = new boolean[7];
			dice2(0);
			break;
		case 3:
			dice3(0,1);
			break;
		case 4:
			dice4(0,1);
			break;

		default:
			break;
		}

	}
	
	private static void dice1(int cnt) {//cnt + 1 번째 주사위 한번 던지기 cnt : 기존까지 던져진 주사위
		if(cnt == N) 
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		//한 번 던질 때 가능한 상황에 대한 시도(1ㅡ2ㅡ3ㅡ4ㅡ5ㅡ6)
		for(int i = 1; i<=6; i++) {
			//기존 주사위의 눈과 겹치는지 체크할 필요가 없음
			numbers[cnt] = i;
			dice1(cnt+1);
			
		}
	}
	
	private static void dice2(int cnt) {//cnt + 1 번째 주사위 한번 던지기 cnt : 기존까지 던져진 주사위
		if(cnt == N) 
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		//한 번 던질 때 가능한 상황에 대한 시도(1ㅡ2ㅡ3ㅡ4ㅡ5ㅡ6)
		for(int i = 1; i<=6; i++) {
			//기존 주사위의 눈과 겹치는지 체크
			if(isSlelcted[i]) continue; 
			numbers[cnt] = i;
			isSlelcted[i] = true;
			//현 주사위의 눈이 i로 결정된 상태로 다음 이동
			dice2(cnt+1);
			//현 주사위 눈을 다른 선택으로 시도하기 위한 준ㅂ지
		}
	}
	//중복 조합
	private static void dice3(int cnt, int start) {//start : 시작 주사위눈의 수
		for(int i = start; i<=6; i++) {// i : 뽑는 수
			if(cnt == N)
			{
				System.out.println(Arrays.toString(numbers));
				return;
			}
			numbers[cnt] = i;
			dice3(cnt+1, i);
		}
	}
	// 조합
	private static void dice4(int cnt, int start) {//start : 시작 주사위눈의 수
		for(int i = start; i<=6; i++) {// i : 뽑는 수
			if(cnt == N)
			{
				System.out.println(Arrays.toString(numbers));
				return;
			}
			numbers[cnt] = i;
			dice3(cnt+1, i+1);
		}
	}

}
