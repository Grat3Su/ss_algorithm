package BOJ.algostudy;

import java.io.*;
import java.util.*;

/*
 * 테스트 케이스
 * 5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1

->11
 */

public class BOJ_1167_treeLen {
	static int N;
	static int[][] adjMatrix;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			
		}
	}

}