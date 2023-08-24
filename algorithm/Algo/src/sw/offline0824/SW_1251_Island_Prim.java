package sw.offline0824;
import java.util.*;
import java.io.*;
/*Edge = (E* L^2)
 * 테스트 케이스
 * T
 * N
 * X X
 * Y Y
 * E
 * 10
2
0 0
0 100
1.0
4
0 0 400 400
0 100 0 100
1.0
6
0 0 400 400 1000 2000
0 100 0 100 600 2000
0.3
9
567 5 45674 24 797 29 0 0 0
345352 5464 145346 54764 5875 0 3453 4545 123
0.0005
 */
//좌표들이 크니까 
//비용계산 생각
//결과값도 크다
//크루스칼 프리마 모두 써서 풀어보기
public class SW_1251_Island_Prim {
	static int T,N;
	static long ans;
	
	static int[][] island;
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2)->Long.compare(e1.c, e2.c));
	static boolean[] visit;	
	static long[][] edges;//e1 e2 distance
	static double E;
	static List<List<Edge>> vertex;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			island = new int[N][2];//X Y
			StringTokenizer st = new StringTokenizer(br.readLine());
			//x
			for(int i = 0; i<N; i++) {	
				island[i][0] =Integer.parseInt(st.nextToken()); 
			}
			//y
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				island[i][1] =Integer.parseInt(st.nextToken()); 
			}
			E = Double.parseDouble(br.readLine());
			vertex = new ArrayList<>();
			for(int i = 0; i<N; i++) {
				vertex.add(new ArrayList<Edge>());
				
			}

			//전체 간선 따져야한다
			int size = N*(N-1)/2;//N개의 정점을 연결하는 모든 간선의 수
			edges = new long[size][3];
			
			int idx = 0;
			for(int v1=0; v1<N-1; v1++) {
				for(int v2 = v1+1; v2 <N; v2++) {
					Edge edge1 = new Edge(v2,distance(island[v1][0],island[v2][0],island[v1][1],island[v2][1]));
					Edge edge2 = new Edge(v1,distance(island[v1][0],island[v2][0],island[v1][1],island[v2][1]));
					vertex.get(v1).add(edge1);
					vertex.get(v2).add(edge2);
				}
			}
			//프림 풀이
			visit = new boolean[N];
			pqueue.clear();
			
			ans = 0;
			int cnt = 1;
			visit[0] = true;
			pqueue.addAll(vertex.get(0));
			
			while(!pqueue.isEmpty()) {
				Edge edge = pqueue.poll();
				
				if(visit[edge.v])continue;
				
				visit[edge.v] = true;
				ans+=edge.c;
				cnt++;
				
				if(cnt==N) break;
				for(Edge e : vertex.get(edge.v)) {
					if(visit[e.v])continue;
					pqueue.offer(e);
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(Math.round(ans*E)).append("\n");
		}
		System.out.println(sb);
	}
	
	static long distance(int x1, int x2, int y1, int y2) {
		return (long)(Math.pow(x1-x2,2)+Math.pow(y1-y2, 2));
	}
	
	
	//어떤 정점으로부터 선택해서 다른 정점으로 이동 할 수 ㅇ있는
	static class Edge{
		int v;
		long c;
		public Edge(int v, long c) {
			super();
			this.v = v;
			this.c = c;
		}
		
	}
}
