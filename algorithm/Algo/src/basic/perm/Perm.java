package basic.perm;

import java.util.Arrays;

//순열 기본
//중복x
//모든 수를 대상으로 현재 자리를 채우는 경우의 수를 따지되, 이전에 사용한 수는 제외
//이전에 사용된 수 <= select
//이전에 방문한 곳 <= visit
//^ boolean 배열 사용 <= index가 수를 의미
public class Perm {
	static int[] tgt = new int[3];//---
	static int[] arr = {1,2,3,4,5};
	static boolean[] check = new boolean[arr.length];//tgt check
	static int COUNT;
	
	public static void main(String[] args) {
		
		perm(0);
		System.out.println(COUNT);
	}
	
	//재귀 호출로 만든다
	//tgtidx에 수를 채우는 작업
	static void perm(int tgtidx) {//인덱스를 받는데 tgt에 무엇을 채울지
		if(tgtidx == tgt.length)
		{
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		for(int i = 0; i<arr.length; i++)
		{
			if(check[i] == true)//사용됨
				continue;
			check[i] = true;
			tgt[tgtidx] = arr[i];
			perm(tgtidx+1);
			check[i] = false;
		}
	}
}
