package basic.dp;

import java.util.Arrays;

public class apartColor {
	static int[] memoi = new int[11];
	public static void main(String[] args) {
		memoi[1]=2;//1층을 칠하는 방법 2개		
		memoi[2]=3;//2층을 칠하는 방법 3개
		
		for(int i = 3; i<=10; i++) {
			memoi[i]=memoi[i-1]+ memoi[i-2];//늘어나는 수 = memoi[i-1]의 노란색 수
			
		}
		
		System.out.println(memoi[8]);
		System.out.println(Arrays.toString(memoi));
	}

}
