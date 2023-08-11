package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 
10
5
2 1 0 1
3 5 3 7 9
6
4 1 0 0
1 2 3 4 5 6

…	
// 총 테스트 케이스의 개수 T = 10
// 첫 번째 테스트 케이스, N = 5 본문 예제
// 각 연산자의 개수 '+' 2 개, '-' 1 개, '*' 0 개, '/' 1 개
// 수식에 사용되는 숫자
// 두 번째 테스트 케이스, N = 6
// 각 연산자의 개수 '+' 4 개, '-' 1 개, '*' 0 개, '/' 0 개
// 수식에 사용되는 숫자
 */

public class SW_4008_numMake {
	static int T, N;
	static int[] operator = new int[4];
	static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			input = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				
			}

		}
	}
	
	void calculate() {
		
	}

}
