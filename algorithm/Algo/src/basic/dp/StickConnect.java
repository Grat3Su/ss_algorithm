package basic.dp;

import java.util.Arrays;

public class StickConnect {
	static int[] memoi = new int[7];
	public static void main(String[] args) {
		memoi[1] = 2;
		memoi[2] = 5;
		
		for(int i = 3; i<=6; i++) {
			//i 길이를 만들려면
			//길이 1짜리 연결 방법 +길이 2짜리 연결 방법
			//길이 1을 사용-> i-1의 길이를 만드는 방법 수+1(방법의 수 : 2)
			//길이 2를 사용-> i-2 길이를 만드는 방법 수+2(방법의 수 : 1)
			memoi[i]=memoi[i-1]*2+memoi[i-2];
		}
		System.out.println(memoi[6]);
		System.out.println(Arrays.toString(memoi));
	}

}
