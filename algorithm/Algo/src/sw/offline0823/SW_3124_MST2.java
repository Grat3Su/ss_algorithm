package sw.offline0823;
import java.util.*;
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

public class SW_3124_MST2 {
	static int V,E,sum;
	static Edge[]edges;
	static int[] parents;//서로소를 위한 자료구조	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			parents = new int[V+1];
			edges = new Edge[E];
			for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(from,to,weight);
			}
			
			sum = 0;
			
			Arrays.sort(edges,(e1,e2)->e1.weight-e2.weight);
			make();
			//정렬된 간선 리스트에서 비용이 가장 적은 간선을 선택하면서 사이클이 생기지 않도롣 v-1개 선택한다.
			int cnt = 0;//선택된 간선 수
			for(int i =0; i<E; i++) {
				Edge edge= edges[i];
				if(union(edge.from, edge.to)) {
					cnt++;
					sum+=edge.weight;
				}
				
				if(cnt==V-1) break;
			}
			sb.append("#").append(t+1).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);	 
	}
	
	static void make() {
		for(int i = 0; i<V; i++) {
			parents[i] = i;			
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a]=find(parents[a]);
	}
	//boolean 리턴
	//root가 같으면 false(정점을 추가하면 안된다 사이클 생긴다 같은 서로소에 속한다.)
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)return false;//사이클 발셍 읨ㄴ미로 표헌 불과
		parents[bRoot] = aRoot;
		return true;
	}

	static class Edge{
		int from,to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}	
	}
}
