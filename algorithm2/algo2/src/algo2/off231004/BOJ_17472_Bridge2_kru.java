package algo2.off231004;

import java.util.*;
import java.io.*;

/*
 * 그래프 자료구조를 준비하고 크루스칼로 풀이
 * 섬-> 정점
 * dfs()
 * 다리-> 간선
 * 세로 vr 가로 hr
 */

public class BOJ_17472_Bridge2_kru {
	static int N, M, min;
	static int V;//정점
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2)->e1.cost - e2.cost);
	static int parent[];//서로소 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		//map input <- 섬은 -1로

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())*(-1);//바다 : 0, 섬 : -1로 초기화
			}
		}
		
		//dfs
		int num = 1;//정점 1번부터
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j]==-1&& !visit[i][j]) {
					//새로운 섬(정점)
					dfs(i,j,num);
					num++;
				}
			}
		}
		V = num-1;
		parent = new int[V+1];
		makeSet();
		
		//맵으로 부터 간선 정보 계산
		//가로
		hr();
		//세로
		vr();
		
		//크루스칼 풀이
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			//사이클여부
			if(union(e.v1, e.v2)){//선택해도 된다.
				cnt++;
				min += e.cost;//최솟값 누적 계산
			}
			
			if( cnt== V-1)break;			
		}
		if(cnt!=V-1||min==0)min = -1;
		System.out.println(min);

//		for (int i = 0; i < N; i++)
//			System.out.println(Arrays.toString(map[i]));
	}
	
	private static void addEdge(int v1, int v2, int cost) {
		// 뒤져서 중복인 항목을 제거하는 것이 손해가 될 수 있다.
		boolean same = false;
		for(Edge edge:pq) {//poll은 다름. 맨 앞에서 맨 뒤로 반복해서 요소를 뽑아냄
			 if(edge.v1 == v1 && edge.v2 == v2) {
				 same =true;
				 //같은게 있으면 기존것을 더 작은 값으로 갱신
				 edge.cost = Math.min(edge.cost, cost);
				 break;
			 }
		}
		
		//새로운 간선 추가
		if(!same)pq.offer(new Edge(v1, v2, cost));
	}
	
	private static void vr() {
		for(int i = 0; i<N; i++) {//행으로 내려오면서
			int prev = 0;//이전좌표
			int curr = 0;//현재 좌표
			int v1 = 0;
			int v2 = 0;
			int cost = 0;
			
			//옆으로 쭉 가면서
			for(int j = 0; j<N; j++) {
				curr = map[j][i];
				if (prev == 0 && curr != 0) {// 0-> 0이 아닌 좌표(바다->섬, 최초 시작점->섬)
					if(v1 == 0) {
						v1 =curr;
					}else {
						//간선 발생
						v2 = curr;
						if(cost>1) {
							//간선 추가 (v1, v2, cost)
							addEdge(v1,v2,cost);
						}
						v1 = v2;
						v2 = 0;
						cost = 0;
					}
				}else if(v1!=0&&curr==0) {
					cost++;
				}
				prev = curr;
			}
			
		}
		
	}

	private static void hr() {
		for(int i = 0; i<N; i++) {//행으로 내려오면서
			int prev = 0;//이전좌표
			int curr = 0;//현재 좌표
			int v1 = 0;
			int v2 = 0;
			int cost = 0;
			
			//옆으로 쭉 가면서
			for(int j = 0; j<M; j++) {
				curr = map[i][j];
				if (prev == 0 && curr != 0) {// 0-> 0이 아닌 좌표(바다->섬, 최초 시작점->섬)
					if(v1 == 0) {
						v1 =curr;
					}else {
						//간선 발생
						v2 = curr;
						if(cost>1) {
							//간선 추가 (v1, v2, cost)
							addEdge(v1,v2,cost);
						}
						v1 = v2;
						v2 = 0;
						cost = 0;
					}
				}else if(v1!=0&&curr==0) {
					cost++;
				}
				prev = curr;
			}
			
		}
		
	}


	//크루스칼
	static void makeSet() {
		for(int i = 1; i<=V; i++)
			parent[i] = i;
	}
	static int findSet(int x) {
		if(parent[x]==x)return x;
		else return parent[x] = findSet(parent[x]);
	}
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px == py)return false;
		if(px<py)parent[py] = px;
		else parent[px] = py;
		return true; 
	}
	
	//dfs
	static void dfs(int y, int x, int num) {
		visit[y][x] = true;
		map[y][x] = num;
		
		//사방탐색
		//갈 수 있는 곳을 계속 가면서 재귀호출 dfs를 이어간다.
		for(int i = 0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny<0||ny>=N||nx<0||nx>=M||visit[ny][nx])continue;
			if(map[ny][nx] ==-1) dfs(ny,nx,num);
		}
	}

	static class Edge {
		int v1, v2, cost;

		public Edge(int v1, int v2, int cost) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}


	}

}
