package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/* 데이터셋 - 정점 갯수 | 간선 갯수 | 탐색을 시작할 번호
4 5 1
1 2
1 3
1 4
2 4
3 4
 */

public class BOJ_1260_DFSBFS_list2 {
	   static int N, M, V;
	    static int from, to;
	    static boolean[] visited;
	    static List<List<Integer>> graph = new ArrayList<>();
	    static Queue<Integer> queue = new ArrayDeque<>();
	    
	    static StringBuilder sb =  new StringBuilder();

	    public static void main(String[] ars) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        V = Integer.parseInt(st.nextToken());

	        visited = new boolean[N + 1];

	        for (int i = 0; i <= N; i++) {
	            graph.add(new ArrayList<>());
	        }
	        for (int i = 0; i < M; i++) {
	            st = new StringTokenizer(br.readLine());
	            from = Integer.parseInt(st.nextToken());
	            to = Integer.parseInt(st.nextToken());
	            graph.get(from).add(to);
	            graph.get(to).add(from);
	        }
	        
	        for (int i = 1; i <= N; i++) {
	            Collections.sort(graph.get(i));
	        }

	        DFS(V);
	        visited = new boolean[N + 1];
	        System.out.println();
	        BFS(V);

	    }

	    static void DFS(int idx) {
	        sb.append(idx).append(" ");
	        System.out.print(idx + " ");
	        visited[idx] = true;
	        int size = graph.get(idx).size();
	        // for 문의 i는 inedx <-정점과 무관
	        for (int i = 0; i < size; i++) {
	            int v = graph.get(idx).get(i);
	            if (visited[v])
	                continue;
	            DFS(v);
	        }

	    }

	    static void BFS(int idx) {
	        
	        queue.offer(idx);
	        visited[idx] = true;
	        while (!queue.isEmpty()) {
	            int cur = queue.poll();
	            sb.append(cur+" ");
	            System.out.print(cur + " ");
	            List<Integer> adjList = graph.get(cur);
	            for (int i = 0; i < graph.get(idx).size(); i++) {
	                int v = graph.get(idx).get(i);
	                if (visited[v])
	                    continue;
	                queue.offer(adjList.get(i));
	                visited[v] = true;
	            }
	        }
	    }
}
