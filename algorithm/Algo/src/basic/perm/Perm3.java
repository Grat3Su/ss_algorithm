package basic.perm;

import java.util.Arrays;

//순열 기본
//중복x
//모든 수를 대상으로 현재 자리를 채우는 경우의 수를 따지되, 이전에 사용한 수는 제외
//이전에 사용된 수 <= select
//이전에 방문한 곳 <= visit
//^ boolean 배열 사용 <= index가 수를 의미
//만약 src의 첫번째 index를 tgt의 특정 인덱스 위치에 고정시키면 perm()의 파라미터를 0이 아닌 1부터 호출할 구 있다.
public class Perm3 {
	static int[] tgt = new int[5];//src와 동일한 수의 순열
	static int[] arr = {1,2,3,4,5};//0번을 tgt의 세번째 위치에 고정시킨다
	static boolean[] check = new boolean[arr.length];//tgt check
	static int COUNT;
	
	public static void main(String[] args) {
		//perm을 돌리기 전에 고정 위치를 처리
		tgt[2] = arr[0];
		check[2] = true;//들여다볼 필요 없다
		
		perm(1);//0번은 고정시켰기 때문에 1번부터 시작한다.
		System.out.println(COUNT);
	}
	
	//재귀 호출로 만든다
	//tgtidx에 수를 채우는 작업
	static void perm(int srcIdx) {//인덱스를 받는데 tgt에 무엇을 채울지
		if(srcIdx == tgt.length)
		{
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		for(int i = 0; i<arr.length; i++)
		{
			if(check[i])//사용됨
				continue;
			tgt[i] = arr[srcIdx];
			check[i] = true;
			perm(srcIdx+1);
			check[i] = false;
		}
	}
}
