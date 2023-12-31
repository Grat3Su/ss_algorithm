package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//bottom up 방식
public class BOJ_1992_QuadTree3 {
/* 데이터셋
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011
-> 안됨(같은 문자열이라고 인식해서)
4 
1111
0000
1111
0000
-> 해결 ret1의 길이를 체크하는 방법으로
 */
	static char[][] map;
	static int N;
	//static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];

		for (int i = 0; i < N; i++) {
			// StringTokenizer st = new StringTokenizer(br.readLine());

			String s = br.readLine();
			map[i] = s.toCharArray();

		}
		System.out.println(divide(0, 0, N));
		
	}

	static String divide(int y, int x, int n) {// 맨 밑에서부터 문자열을 만든다.
		if(n == 1)
			return String.valueOf(map[y][x]);// 이 좌표에 있는걸 문자열로. 기저조건
		//4 영역 모두 조사해서(재귀) 모두가 같은지 다른지 처리
		int half = n / 2;
		String ret1 = divide(y, x, half);
		String ret2 = divide(y, x + half, half);
		String ret3 = divide(y + half, x, half);
		String ret4 = divide(y + half, x + half, half);

		if(ret1.length() ==1&&ret1.equals(ret2)&&ret1.equals(ret3)&&ret1.equals(ret4))			return ret1;
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("(").append(ret1).append(ret2).append(ret3).append(ret4).append(")");
			
			return sb.toString();
		}
			
	}
}
