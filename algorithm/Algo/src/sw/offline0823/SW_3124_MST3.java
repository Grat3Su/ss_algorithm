package sw.offline0823;

import java.util.*;

import online.AdjList;

import java.io.*;

/* 데이터셋
 * T
 * V정점 E간선
 * 1
3 3
1 2 1
2 3 2
1 3 3
 */
//선택된 정점들로부터 갈 수 있는 최소 비용 간선의 정점 <-우선순위큐
//간선리스트->인접리스트
public class SW_3124_MST3 {
	static int V, E, sum;
	static List<List<Edge>> adjList;
	static boolean[] visit;//방문(선택)
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1,e2)->e1.weight-e2.weight);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList<List<Edge>>();
			
			for(int i = 0; i<V+1; i++) {
				adjList.add(new ArrayList<>());
			}

			visit = new boolean[V + 1];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				adjList.get(from).add(new Edge(to,weight));
				adjList.get(to).add(new Edge(from,weight));
			}

			sum = 0;

			pqueue.clear();	
			prim();
			// 정렬된 간선 리스트에서 비용이 가장 적은 간선을 선택하면서 사이클이 생기지 않도롣 v-1개 선택한다.
			
			sb.append("#").append(t + 1).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	static void prim() {
		int cnt =1;//선택된 정점의 수
		visit[1] = true;//시작정점 visit(선택)
		
		pqueue.addAll(adjList.get(1));
		
		while(!pqueue.isEmpty()) {
			Edge edge = pqueue.poll();//현재 pqueue에 담긴 간선들 중 비용이 가장 싼 간선이 선택
			if(visit[edge.v]) continue;//이미 선택된 정점이면 무시
			
			visit[edge.v] = true;
			sum+=edge.weight;
			cnt++;
			if(cnt==V) break;
			
			//선택된 정점으로부터 갈 수 있는 간선을 모두 pqueue에 담는다.
			//pqueue.addAll(adjList.get(edge.v));//#1 따지지 않고 넣는다
			
			//#2 골라서 넣는다
			for(Edge e : adjList.get(edge.v)) {
				if(visit[e.v])
					pqueue.add(e);
			}
		}
	}

	static class Edge {
		int v, weight;

		public Edge(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}
	}
}
