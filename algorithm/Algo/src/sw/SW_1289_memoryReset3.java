package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//static
//char[]
//buffered reader
//stringbuilder
public class SW_1289_memoryReset3 {
	static int T, count;
	static char[] input, memory;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {// 변수 초기화
			count = 0;
			input = br.readLine().toCharArray();// 문자열에서 배열을 만들어서 리턴
			int cnt = input.length;
//			
//			//메모리 길이만큼 문제에서 제시한 원목작업 진행
//			for(int i = 0; i<cnt; i++)
//			{
//				if(memory[i]!=input[i]) {
//					for(int j = i; j<cnt; j++)
//					{
//						memory[j] = input[i];
//					}
//					count++;
//				}
//			}
			// -> 이 부분
			memoryRecover(cnt, 0, '0');

			// 메모리 길이만큼 문제에서 제시한 원복 작업 진행
			// sb.append("#").append(t).append(" ").append(count);
			// System.out.println(sb);
			System.out.printf("#%d %d\n", t, count);
		}
	}

	static void memoryRecover(int cnt, int index, char cur) {
		if (index >= cnt)
			return;
		
		if (input[index] != cur) {
			count++;
			cur = input[index];
		}

		memoryRecover(cnt, ++index, cur);
		return;
	}

}
