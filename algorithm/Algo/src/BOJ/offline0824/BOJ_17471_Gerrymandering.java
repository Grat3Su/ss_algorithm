package BOJ.offline0824;

import java.util.*;
import java.io.*;

/*
 * 테스트 케이스
 * N
 * 인구
 * V, 인접한 구역
 * 6
5 2 3 4 1 2
2 2 4
4 1 3 6 5
2 4 2
2 1 3
1 2
1 2
 */
//subset으로 나눠서 할수있지않을까?
public class BOJ_17471_Gerrymandering {
	static class Vertex {
		int no, population;
	}

	static int N, V;
	static int[] parents;
	static int[] population;
	static List<List<Integer>> adjList = new ArrayList<List<Integer>>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine())+1;
		population = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {//인구
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; i++) {//인접 리스트
			adjList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			while (!st.hasMoreTokens()) {// 인접 리스트
				adjList.get(v).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		boolean[] visit = new boolean[N];
		

	}
	
	static void subset() {
		
	}

}
