package sw;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SW_1289_memoryReset {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t<T; t++)
		{//변수 초기화
			int count = 0;
			String str = sc.next();//문자열 하나씩 읽는다. 공백 이전까지.
			int cnt = str.length();
			int[] inputArray = new int[cnt];
			int[] memArray = new int[cnt];//메모리
			
			//입력
			for(int i = 0; i<cnt; i++)
			{
				inputArray[i] = str.charAt(i) - '0';//char->int
			}
			//메모리 길이만큼 문제에서 제시한 원복 작업 진행
			for(int i = 0; i<cnt; i++)
			{
				if(memArray[i]!= inputArray[i]) {//변경 count 증가, 뒷부분까지 그 값으로 변경
					for(int j = i; j<cnt; j++)
					{
						memArray[j] = inputArray[i];
					}
					count++;					
				}
			}
			
			System.out.printf("#%d %d\n", t, count);			
		}
	}

}
