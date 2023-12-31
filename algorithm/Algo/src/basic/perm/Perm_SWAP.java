package basic.perm;

import java.util.Arrays;

//순열  swap
//src 각 항목(원소)가 자신의 위치를 변경하면서 순열을 만들어간다
//위치르 변경할 때 마다 뒤쪽 자리의 항목과 swap이 발생
//최초 swap은 자기 자신의 위치도 포함
public class Perm_SWAP {
	static int[] src = {1,2,3,4,5};
	static int TGT_COUNT = 3;//뽑을 수
	static int COUNT;
	
	public static void main(String[] args) {
		
		perm(0);
		System.out.println(COUNT);
	}
	
	//재귀 호출로 만든다
	//tgtidx에 수를 채우는 작업
	static void perm(int srcidx) {//인덱스를 받는데 tgt에 무엇을 채울지
		if(srcidx == TGT_COUNT)
		{
			for(int i = 0; i<TGT_COUNT;i++) {
				System.out.print(src[i]+", ");
			}
			System.out.println();
			COUNT++;
			return;
		}
		//
		for(int i = srcidx; i<src.length; i++)
		{
			int temp = src[srcidx];
			src[srcidx] = src[i];
			src[i] = temp;
			
			perm(srcidx+1);
			temp = src[srcidx];
			src[srcidx] = src[i];
			src[i] = temp;
		}
	}
}
