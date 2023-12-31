package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.corba.se.spi.orbutil.fsm.Input;

/*
 * 데이터셋
 *  N Arr M Find 
5
4 1 5 2 3
5
1 3 7 9 5
 */
public class BOJ_1920_NumFind {
	static int N,M;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ;i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Arrays.sort(input);
		
		for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(Arrays.binarySearch(input, num)>=0) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}				
		}
		System.out.println(sb);
	}

}
