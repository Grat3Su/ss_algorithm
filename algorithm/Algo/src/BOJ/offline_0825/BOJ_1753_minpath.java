package BOJ.offline_0825;
import java.util.*;
import java.io.*;
/* V E
 * u v w
 * 5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */
public class BOJ_1753_minpath {
	static int V,E,K;
	static List<List<Edge>> adjList = new ArrayList<>();//인접 리스트
	static int[] cost;//다익스트라 자료구조 <- 이곳에 답이 정리되어 완성된다.
	static boolean[] visit;
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1,e2)->e1.c-e2.c);
	static StringBuilder sb = new StringBuilder();
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		cost = new int[V+1];
		visit = new boolean[V+1];
		
		//인접 리스트 초기화
		for(int i = 0; i<=V; i++) {
			adjList.add(new ArrayList<Edge>());
			cost[i] = INF;//충분히 큰 값
		}
		//간선
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			//v1 -> v2
			adjList.get(v1).add(new Edge(v1, w));
		}
		
		
		//다이스트라 풀이
		for(int i = 1; i<V; i++) {
			sb.append(cost[i]==INF?"INF":cost[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra() {
		//시작정점
		cost[K] = 0;
		
		pqueue.offer(new Edge(K, 0));
		
		while(!pqueue.isEmpty()) {
			Edge e = pqueue.poll();//최소 비용의 간선
			//꺼낸 간선이 갈 수 있는 정점을 고려 => 이 정점에서 갈 수 있는 다른 정점과의 비용으로 cost[] 갱신
			for(Edge ne:adjList.get(e.v)) {
				//아직 방문하지 않은 정점이면서 동시에 cost[] 버튼을 줄여줄 수 있는 정점
				if(!visit[ne.v]&&ne.c +cost[e.v]<cost[ne.v]) {
					cost[ne.v]=ne.c+cost[e.v];
					pqueue.offer(new Edge(ne.v, cost[ne.v]));//edge 객체를새로 생성
					
					
					
				}
			}
		}
	}
	
	static class Edge{
		int v, c;

		public Edge(int v, int c) {
			super();
			this.v = v;//vertex
			this.c = c;//cost
		}
		
	}
}
