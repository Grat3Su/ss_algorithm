package basic.comb;

import java.util.Arrays;

public class Comb_For {
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3];//--- 
	static int COUNT;
	//<= src 맨 앞에서 순차적으로 고려 이미 사용한 src는 재사용하지 않음
	// 되돌아오지 않는다. 단방향으로 이동
	
	public static void main(String[] args) {
		comb(0,0);
		System.out.println(COUNT);
	}
	
	static void comb(int srcIdx, int tgtIdx)
	{
		if(tgtIdx == tgt.length) {
			COUNT++;
			System.out.println(Arrays.toString(tgt));
			return;
		}
		
		//파라미터로 전해진 srcIdx부터 src에서 따지면 된다. srcIdx 이전의 src는 이미 사용되었다.
		for(int i =srcIdx; i<src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i+1, tgtIdx+1);
		}
	}

}
