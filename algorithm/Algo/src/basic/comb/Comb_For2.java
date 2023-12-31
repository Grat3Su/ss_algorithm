package basic.comb;

import java.util.Arrays;

public class Comb_For2 {
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[4];//--- 
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
		if(srcIdx==src.length)
			return;//src를 고려했으면 종료
		
		tgt[tgtIdx] = src[srcIdx];//현재 tgtidx에 srcidx 값을 결정
		comb(srcIdx+1, tgtIdx+1);// 다음 tgtidx에 srcidx 다음 값을 고려
		comb(srcIdx+1, tgtIdx);//	현재 tgtidx에 다음  srcidx 값을 고려
		// 다음 가지
	}

}
