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

public class SW_3124_MST {
	static int V,E;
	static Edge[]edgeList;
	static int[] parents;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken())+1;
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E];
			for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from,to,weight);
			}
			Arrays.sort(edgeList);
			 
			 make();
			 		 
			 long result = 0;//MST 비용
			 int count=0;//연결된 간선 갯수 
			for(Edge edge:edgeList) {//비용이 작은 간선 순으로 꺼내어서 처리
				if(union(edge.from, edge.to)) {
					result+=edge.weight;
					if(++count==V-1)break;
				}			
			}
			sb.append("#").append(t+1).append(" ").append(result);
		}
		System.out.println(sb);	 
	}
	
	static void make() {
		parents = new int[V];
		for(int i = 0; i<V; i++) {
			parents[i] = i;			
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a]=find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)return false;//사이클 발셍 읨ㄴ미로 표헌 불과
		parents[bRoot] = aRoot;
		return true;
	}

	static class Edge implements Comparable<Edge>{
		int from,to;
		long weight;

		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (int)(this.weight - o.weight);
		}
		
	}
}
