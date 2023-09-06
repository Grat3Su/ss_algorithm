package BOJ.algostudy;

import java.util.*;
import java.io.*;
/*
 * 테스트케이스
 * N
 * Papulation
 * M E
 * 
 * 6
5 2 3 4 1 2
2 2 4
4 1 3 6 5
2 4 2
2 1 3
1 2
1 2
 */
public class BOJ_17471_gerrymendaring {

	static int N;
	static int[] P;
	static boolean select[];
	static List<Integer>[] adjList; 
	static int[] V;//0 : 선택안됨 / 1: 선택됨 / 2: (미선택)연결되었다 / 3:(선택)연결되었다 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine())+1;
		P = new int[N];
		adjList = new ArrayList[N];
		select = new boolean[N];
		for(int i = 1; i<N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int m = 0; m<M; m++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		System.out.println(adjList[1].size());
		for(int i = 0; i<adjList[1].size(); i++)
			adjList[1].get(i);
	}
	
	static void subSet(int idx, int mask) {
		if(idx>=N) {
			complete(mask);
			return;
		}
		
		subSet(idx+1, mask);
		subSet(idx+1, mask|1<<idx);
	}
	static void complete(int mask) {
		int selectRes = 0;
		int ubnselectRes = 0;
		//bfs
		Queue<Integer>q = new ArrayDeque<Integer>();
		q.offer(e)
	}
}
