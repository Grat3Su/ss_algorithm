package algo2.off231010;

import java.io.*;
import java.util.*;

public class SW_7465_village {
	static int N, M, ans;
	static boolean[] visit;
	static List<List<Integer>> adjList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			adjList = new ArrayList<>();
			visit = new boolean[N];

			for(int i = 0; i<N; i++){
				adjList.add(new ArrayList<Integer>());
			}

			for(int i = 0; i<M; i++){
				st = new StringTokenizer(br.readLine());

				int to = Integer.parseInt(st.nextToken())-1;
				int from = Integer.parseInt(st.nextToken())-1;

				//양방향
				adjList.get(to).add(from);
				adjList.get(from).add(to);
			}			

			int ans = 0;
			for(int i = 0; i<N; i++){
				if(!visit[i]){
					dfs(i);
					ans++;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx){
		if(idx == N){
			return;
		}
		visit[idx] = true;
		for(int i = 0; i<adjList.get(idx).size(); i++){
			int next = adjList.get(idx).get(i);
			if(visit[next])	continue;
			dfs(next);
		}
	}
}
