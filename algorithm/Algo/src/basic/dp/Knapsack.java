package basic.dp;

import java.util.Arrays;


public class Knapsack {
	static int[][] memoi = new int[5][11];
	static int[][] item= {{0,0},{5,10},{4,40},{3,50},{6,30}};
	static int limit = 10;
	
	public static void main(String[] args) {
		// 모든 아이템에 대해서 첫 뻔째 아이템에서 최선의 결과를 구한 후
		// 두 번재 아이템에서 첫 번째 아이템을 고려한 최선의 결과와 비교해서 다시 최선의 결과를 얻는다.
		// 이 과정을 모든 아이템에 대해 진행한다.
		// 최선의 결과는 메모이 배열에 기록한다.
		
		//item
		for(int i = 1; i<=4; i++) {
			for(int w = 1; w<=limit; w++) {
				//현재 item이 현재 무게에 선택 가능?
				if(item[i][0]<=w) {
					//선택O
					//memoi[i-1][w] => i번째 item을 고려하기 전까지 w 무게를 만드는 데 최상의 value
					int select_0 = memoi[i-1][w-item[i][0]]+item[i][1];
					
					//선택x
					int select_x = memoi[i-1][w];
					
					memoi[i][w] = Math.max(select_0, select_x);
				}else {
					memoi[i][w]=memoi[i-1][w];
				}
			}
			for(int j = 0; j<=4; j++) {
				System.out.println(Arrays.toString(memoi[j]));
			}
			System.out.println("=========================");
		}
		System.out.println(memoi[4][10]);
		
		for(int i = 0; i<=4; i++) {
			System.out.println(Arrays.toString(memoi[i]));
		}
		System.out.println("=========================");
	}

}
