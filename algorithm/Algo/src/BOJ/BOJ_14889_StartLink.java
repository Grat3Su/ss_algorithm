package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 4
0 1 2 3
4 0 5 6
7 1 0 2
3 4 5 0

https://www.acmicpc.net/problem/14889
 */

public class BOJ_14889_StartLink {
	static int N, halfN;
	static boolean[] checked;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		checked = new boolean[N];
		halfN = N/2;
	}
	
	static void comb(int srcidx, int tgtidx, int mask) {
		if(tgtidx == halfN) {
			check(mask);
			return;
		}
		
		if(srcidx == N) return;
		
		comb(srcidx+1, tgtidx, mask|1<<srcidx);
		comb(srcidx+1, tgtidx, mask|1<<srcidx);
	}
	static void check(int mask) {
		
	}

}
