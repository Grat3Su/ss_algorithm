package BOJ.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2026_WarmVirus {
/* 데이터셋
 * N
 * edge
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 */
	static boolean[] visited;
	static int N, M;
	static List<Integer>adjList = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		visited = new boolean[N];
	}
	
}
