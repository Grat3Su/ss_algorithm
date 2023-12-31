package JOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * DataSet
4
-15 5
-10 36
10 73
27 44


3
25 30
10 20
10 15

4
11 50
1 500
60 88
1 4
 */


public class JOL_1820_Fridge2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][2];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] =Integer.parseInt(st.nextToken());
			input[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input,(o1,o2)->o1[1]-o2[1]);
		int max = Integer.MAX_VALUE;
		int count =1;
		
		for(int i = 0; i<N; i++) {
			if(input[i][0]>max) {
				count++;
				max = input[i][1];
			}
		}
		
		System.out.println(count);
	}	
}
