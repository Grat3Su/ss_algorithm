package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_11286_절댓값힙 {
	//10만개으 정수 배열을 만들고 from, to idx를 이용s
	static int N, from, to;
	static int[] array = new int[10_0000];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		//N개의 연산 처리
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				check();
			}
			else {
				array[to++] = num;
			}
		}
	}
	static void check() {
		//대상이 없을 때 0 <= 최초, 다 꺼냈을 때
		if(from == to) {
			System.out.println(0);
			return;
		}
		
		//최솟값(최솟값의 인덱스)
		int minNum = Integer.MAX_VALUE;
		int minIdx = from;//시작
		
		for(int i = from; i<to; i++) {
			//array[i]를 따져본다
			if(Math.abs(minNum)==Math.abs(array[i])) {;//절댓값이 같은 경우
				if(array[i]<minNum) {
					minNum = array[i];
					minIdx = i;
				}
			}else if(Math.abs(minNum)>Math.abs(array[i])) {
				minNum = array[i];
				minIdx = i;
			}
		}
		System.out.println(minNum);
		//최솟값을 뺀다. < from과 바꿔치기
		array[minIdx] = array[from];
		from++;
	}
}
