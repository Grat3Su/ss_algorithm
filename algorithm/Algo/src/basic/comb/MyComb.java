package basic.comb;

import java.util.Arrays;

public class MyComb {
	static int[] src = {1,7,3,6,5};
	static int[] tgt = new int[3];
	
	public static void main(String[] args) {
		comb(0,0);

	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {//기재조건
			System.out.println(Arrays.toString(tgt));
			
			return;
		}
		
		for(int i = srcIdx; i<src.length; i++) {
			tgt[tgtIdx] = src[i];
			
			comb(i+1, tgtIdx+1);
		}
	}
}
