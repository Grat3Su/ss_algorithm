package algo2.off230926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SW_최장증가부분수열_3307 {

	static int T,N,len;
	static int[] input;
	static int[] Lis;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			Lis = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			//solve
			len = 0;
			for(int i = 0; i<N; i++) {
				Lis[i] = 1;//자기 자신의 수로 만들 수 있는 les가 1이므로 초기화
				
				//맨 앞에서 현재 따지는 i보다 작은 수가지
				for(int j = 0; j <i;j++) {
					//j로 따지는 수가 현재 i번째 수보다 작은 수
					//j의 lis값은 i의 lis보다 크거나 같은 경우
					if(input[j]<input[i]&&Lis[j]>=Lis[i]) {
						Lis[i] = Lis[j]+1;
					}
					len = Math.max(len, Lis[i]);
				}
			}
			sb.append("#").append(t).append(" ").append(len).append("\n");
		}
		System.out.println(sb);
	}
}
