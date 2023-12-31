package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//np 방식
public class SW_6808_CardGame_NP {
	static int[] input = new int[19];
	static int[] guCard = new int[9];
	static int[] inCard = new int[9];
	static int count, win, lose,N,T;// win/lose
	static StringBuilder sb = new StringBuilder();
	int []score = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = 9;
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			win = 0;
			lose = 0;
			Arrays.fill(input, 0);
			//규영이 카드
			int num = 0;			
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());// 뽑은 카드 체크
				input[num] =1;
				guCard[i] = num;
			}
			//인영이 카드
			num = 0;
			for(int i = 1; i<=18; i++) {
				//num = Integer.parseInt(st.nextToken());
				if(input[i]==0) {
					inCard[num++] = i;
				}
			}
			
			//이미 정렬되어 있다. inCard
			while(true) {
				check();
				if(!np(inCard))break;
			}
			
			np(input);
			sb.append("#").append(t+1).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

	static boolean np(int array[]) {
		// 3가지
		// 앞에서 교환되어야 하는 인덱스&작업
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i])
			--i;// 큰것이 나타날때까지 감소
		// 이미 가장 큰 수 일때
		// desc
		if (i == 0)
			return false;// 더 이상 큰 수를 만들 수 없음

		// 앞쪽에서 바꿀 index 확정 i-1

		// 뒤에서 교환되어야 하는 인덱스&작업
		int j = array.length - 1;
		while (array[i - 1] >= array[j])
			--j;

		swap(array, i - 1, j);

		// 앞뒤 교환 후 뒤쪽 정리(교환)
		int k = array.length - 1;
		while (i < k) {
			swap(array, i++, k--);
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
	static void check() {
		int guSum = 0;
		int inSum = 0;
		for(int i = 0; i<N; i++) {
			if(guCard[i]>inCard[i]) guSum+=guCard[i]+inCard[i];
			else inSum+=guCard[i]+inCard[i];
		}
		
		if(guSum>inSum)win++;
		else if(guSum<inSum)lose++;
	}
}
