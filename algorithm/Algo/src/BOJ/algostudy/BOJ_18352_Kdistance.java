package BOJ.algostudy;
import java.io.*;
import java.util.*;
/*
 * 테스트케이스
 * 첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가
 * 4 4 2 1
1 2
1 3
2 3
2 4

->4
 */
public class BOJ_18352_Kdistance {
	static int N, M, K, X;
	static List<Integer>[]  adjList;
	static boolean[] visited;
	static int[] minDis;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1;//vertex
		M = Integer.parseInt(st.nextToken());//엣지
		
		K = Integer.parseInt(st.nextToken());//제한		
		X = Integer.parseInt(st.nextToken());//출발 도시
		visited = new boolean[N];
		minDis = new int[N];
		Arrays.fill(minDis, Integer.MAX_VALUE);
		adjList = new ArrayList[N];
		for(int i = 1; i<N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i<M; i++) {			
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			adjList[to].add(from);
		}
		visited[X] = true;
		dfs(X,0);
		
		for(int i = 0; i<N; i++) {
			if(minDis[i]==K) {
				sb.append(i).append("\n");				
			}
		}
		
		if(sb.length()==0)
			sb.append(-1);
		System.out.println(sb);
	}
	static void dfs(int v, int cnt) {
		if(v >= N)return;
		minDis[v] = Math.min(minDis[v], cnt);
		if(cnt == K) {//가지치기
			return;
		}
		visited[v] = true;
		for(int i = 0; i<adjList[v].size(); i++) {//간선이 존재한다면 거기로 간다			
			if(!visited[adjList[v].get(i)]) {
				dfs(adjList[v].get(i),cnt+1);
			}
		}
		visited[v] = false;//방문체크
	}

}
