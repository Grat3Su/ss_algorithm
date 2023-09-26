package algo2.off230926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SW_최장증가부분수열_3307_2 {

	static int T,N,len;
	static int[] input;
	//static int[] Lis;
	static int[] memoi;
	//memoi[2] = 5; => (2+1) 길이가 3인 LIS를 만드는 가장 작은 수가 5
	//pos index 변수
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			memoi = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			//solve
			len = 0;
			for(int i = 0; i<N; i++) {
				int pos = Arrays.binarySearch(memoi, 0,len, input[i]);//정렬되어야함
				if(pos >= 0)continue;
				//음수일 때 => 갱신
				//양수로 변환 - 1
				pos = Math.abs(pos)-1;//보정
				memoi[pos] = input[i];
				if(len==pos)len++;//LIS 증가
			}
			sb.append("#").append(t).append(" ").append(len).append("\n");
		}
		System.out.println(sb);
	}
}
