package basic.comb;

import java.util.Arrays;

public class Comb_NP {
	static int[] src = { 1, 2, 3, 4, 5 };
	static int[] tgt = new int[3];
	static int COUNT;
	static int[] index = new int[src.length];

//10101
//00111
//11100
//가장 작은 수 00111에서 11100이 될 때까지 가능한 숫자를 모두 만든다.

	public static void main(String[] args) {
		// index 배열이 뒤쪽에 tgt만큼 1을 채운다.
		for (int i = src.length - 1; i >= src.length - tgt.length; i--) {
			index[i] = 1;
		}

		//System.out.println(Arrays.toString(src));
		while(true) {
			//complete code - 순열이기 때문에
			//System.out.println(Arrays.toString(index));
			int tgtidx = 0;
			for(int i = 0; i<index.length; i++) {
				if(index[i]==1) {
					tgt[tgtidx++]= src[i];
				}
			}
			System.out.println(Arrays.toString(index)+" "+Arrays.toString(tgt));
			
			if(!np(index))break;
		}
	}

	static boolean np(int array[]) {
		// 3가지
		// 앞에서 교환되어야 하는 인덱스&작업
		//int i = src.length - 1;
		int i, j, k;
		i = j = k = src.length-1;
		while (i > 0 && src[i - 1] >= src[i])
			--i;// 큰것이 나타날때까지 감소
		// 이미 가장 큰 수 일때
		// desc
		if (i == 0)
			return false;// 더 이상 큰 수를 만들 수 없음

		// 앞쪽에서 바꿀 index 확정 i-1

		// 뒤에서 교환되어야 하는 인덱스&작업
		//int j = src.length - 1;
		while (src[i - 1] >= src[j])
			--j;

		swap(src, i - 1, j);

		// 앞뒤 교환 후 뒤쪽 정리(교환)
		//int k = src.length - 1;
		while (i < k) {
			swap(src, i++, k--);
		}

		// j 확정
		// 교환 후 뒤쪽을 작은 수로 정리
		return true;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
