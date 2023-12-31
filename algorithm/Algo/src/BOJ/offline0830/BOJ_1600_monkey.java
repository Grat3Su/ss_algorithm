package BOJ.offline0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
//K<- 몇 번 사용했는지, visit 추가 관리
public class BOJ_1600_monkey {
	static int K,W,H;
	static int[][] map;
	static boolean[][][] visit;//k가 추가됨
	
	//상하좌우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	//격자 말
	static int[] hdy = {-2, -2, -1, -1, 2,  2, 1,  1};
	static int[] hdx = { 1, -1,  2, -2, 1, -1, 2, -2};
	
	//큐
	static Queue<Node> queue = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visit = new boolean[H][W][K+1];
		
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//풀이
		bfs();//출력 포함
	}
	
	static void bfs() {
		//시작 좌표 처리
		visit[0][0][K] = true;
		queue.offer(new Node(0,0,K,0));
		
		//큐가 빌때까지 bfs탐색
		//한 점에서 다음 이동을 고려 할 깨
		//1. 사방 탐색으로 갈 수 있는 곳을 찾아서 큐에 담는다.
		//2. 격자 말처럼 갈 수 있는 곳을 찾아서 큐에 담는다.(아직 K만큼 다 쓰지 않음 -> 말처럼 가면 K 감소처리)
		//큐에서 꺼낸 노드가 오른쪽 맨 아래 좌표에 도달하면 성공(d 출력)
		//큐에서 모두 꺼내고 처리했는데도 도달하지 못함 -> -1 출력
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			//목표 도달 체크
			if(node.y == H-1&& node.x == W-1) {
				System.out.println(node.d);
				return;
			}
			//상하좌우
			for(int i = 0; i<4; i++) {
				int ny =  node.y+dy[i];
				int nx =  node.x+dx[i];
				
				if(ny<0|nx<0|| ny>=H||nx>=W||map[ny][nx]==1||visit[ny][nx][node.k])continue;
				visit[ny][nx][node.k]=true;
				queue.offer(new Node(ny, nx, node.k, node.d+1));//말 격자로 이동.  x->kㄴ느 그대로
			}
			
			if(node.k ==0)continue;
			
			for(int i = 0; i<8; i++) {
				int ny =  node.y+hdy[i];
				int nx =  node.x+hdx[i];
				
				if(ny<0|nx<0|| ny>=H||nx>=W||map[ny][nx]==1||visit[ny][nx][node.k-1])continue;
				visit[ny][nx][node.k-1]=true;
				queue.offer(new Node(ny, nx, node.k-1, node.d+1));//말 격자로 이동.  x->kㄴ느 그대로
			}
		}
		System.out.println(-1);
	}
	
	static class Node{
	int y,x,k,d;

	public Node(int y, int x, int k, int d) {
		super();
		this.y = y;
		this.x = x;
		this.k = k;
		this.d = d;
	}	
	}
}
