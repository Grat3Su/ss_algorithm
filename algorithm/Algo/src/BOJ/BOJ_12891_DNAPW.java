package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891_DNAPW {
	static int N;
	static char[] charArr;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());//배열 길이
		int L = Integer.parseInt(st.nextToken());//문자열 길이
		String s = bf.readLine();//문자열 읽기
		int[] charNum = new int[4];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<4; i++) {
			charNum[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		for(int i = 0; i<L; i++) {
			//add()
		}
			
		
		System.out.println(result);
	}
	
	static void add(char c) {
		switch(c) {
		case 'A':
			arr[0]++;
			break;
		case 'C':
			arr[1]++;
			break;
		case 'G':
			arr[2]++;
			break;
		case 'T':
			arr[3]++;
			break;
		}		
	}
	static void remove(char c) {
		switch(c) {
		case 'A':
			arr[0]--;
			break;
		case 'C':
			arr[1]--;
			break;
		case 'G':
			arr[2]--;
			break;
		case 'T':
			arr[3]--;
			break;
		}	
	}

}
