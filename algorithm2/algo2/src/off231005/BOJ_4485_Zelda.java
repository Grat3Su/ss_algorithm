package off231005;
import java.util.*;
import java.io.*;

public class BOJ_4485_Zelda {
	static int N;
	static int[][] map, cost;
	static boolean[][] visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1};
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1,e2)->e1.c-e2.c);
	static final int INF = Integer.MAX_VALUE; 
	
	static class Edge{
		int x,y,c;

		public Edge(int y, int x, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int turn = 0;;
		while(true) {
			turn++;
			N = Integer.parseInt(br.readLine());
			if(N ==0)break;//0이면 끝
			
			map= new int[N][N];
			cost= new int[N][N];//시작부터 현재까지 최소비용 관리
			
			//입력처리 + cost초기화
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}
			
			//다익스트라 풀이
			dijkstra();
			sb.append("Problem ").append(turn).append(": ").append(cost[N-1][N-1]).append("\n");
		}	
		System.out.println(sb);
	}

	private static void dijkstra() {
		cost[0][0] = map[0][0];
		
		pqueue.offer(new Edge(0, 0, map[0][0]));
		
		//큐에서 비용이 가장 작은 엣지를 선택해서 그 엣지를 거치는 새로운 좌표의 cost비용 줄일 수 있으면 갱신
		while (!pqueue.isEmpty()) {
			Edge e = pqueue.poll();
			//꺼낸것에서부터 갈 수 있는 새로운 좌표 획득 -> 시작점에서 획득한 좌표로 이동할 때 최소 비용과 꺼낸 것을 거쳐서 가는 최소비용을 비교
			for(int d = 0; d<4; d++) {
				int nx = e.x + dx[d];
				int ny = e.y + dy[d];
				
				if(nx<0||nx>=N|| ny<0||ny>=N)continue;
				//비용비교
				//현재 기준 시작점(0,0) -> 고려하는 좌표(ny,nx)로 가는 최소 비용은  cost[ny][nx]에 기록되어 있다.
				//꺼낸 좌표를 거쳐가는 비용 e.c + map[ny][nx]를 비교
				
				if(e.c+map[ny][nx] < cost[ny][nx]) {
					cost[ny][nx] = e.c+map[ny][nx];
					pqueue.offer(new Edge(ny, nx, cost[ny][nx]));
				}
			}
		}
		
	}
}
