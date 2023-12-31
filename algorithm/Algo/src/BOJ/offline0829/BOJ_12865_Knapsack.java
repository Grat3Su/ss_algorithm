package BOJ.offline0829;

import java.util.*;
import java.io.*;

public class BOJ_12865_Knapsack {
	static int[][] things;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		things = new int[N][2];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken());
			things[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(things);
	}
	static class Things{
		int weight, value;

		public Things(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
		
	}

}
