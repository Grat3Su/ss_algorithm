package online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MSTPrimTest_PriorityQueue {
	static class Vertex implements Comparable<Vertex>{
		int no, weight;//정점 번호, 트리 정점과 연결했을 대의 간선비용

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight-o.weight;
		}
		
	}
	
	
	static int V, adjMatrix[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(in.readLine());
		adjMatrix = new int[V][V];

		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[V];
		int[] minEdge = new int[V];// 자신과 트리의 정점들 간의 최소 간선 비용
		
		PriorityQueue<Vertex>pqueue = new PriorityQueue<>();
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0;// 임의의 0 정점을 트리 구성의 시작으로 하기 위해 세팅
		pqueue.offer(new Vertex(0, minEdge[0]));//정점과 최소간선 비용을 넣는다
		
		int result = 0;// 최소 신장 트리 비용
		int min = 0, minVertex = 0, cnt=0;//트리에 추가된 정점의 갯수를 정확하게 관리해야한다

		// 1. 미방문(비트리) 정점 중 최소 간선비용의 정점을 선택
		while(!pqueue.isEmpty()) {
			Vertex cur = pqueue.poll();
			minVertex = cur.no;			
			min = cur.weight;
			
			if(visited[minVertex])continue;
			// 2. 방문(트리)정점에 추가
			visited[minVertex] = true;//방문처리
			result += min;//신장 트리 비용 누적
			if(++cnt == V) break;
			
			//3. 트리에 추가된 새로운 정점 기준으로 비트리 정점과의  간선 비용 고려(a.k.a 영업타임)
			for(int i = 0; i<V; i++) {
				if(visited[i]&&adjMatrix[minVertex][i]!=0&&minEdge[i]>adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
					pqueue.offer(new Vertex(i, minEdge[i]));
				}
			}
			
			System.out.println(result);
			
		}
	}

}
