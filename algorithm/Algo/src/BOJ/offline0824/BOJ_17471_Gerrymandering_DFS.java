package BOJ.offline0824;

import java.util.*;
import java.io.*;

//ㅂ부분집합을 통해서 A, B 두 개의 그룹으로 나누고 각각 연결 여부를 bfs, dfs로 확인한 후 최소값 갱신
public class BOJ_17471_Gerrymandering_DFS {	
	static int N, min;
	static int[][] matrix;
	static boolean[] select;//부분집합 용도
	static boolean[] visit;//bfs 중복 체크
	
	static Queue<Integer>queue = new ArrayDeque<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
	        
	        matrix = new int[N+1][N+1]; // 0 dummy
	        select = new boolean[N+1];
	        visit = new boolean[N+1];
	        min = Integer.MAX_VALUE;
	        
	        // 인구수 -> 별도의 자료구조 대신  matrix[V][0] 를 활용
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for (int i = 1; i <= N; i++) {
	            matrix[i][0] = Integer.parseInt(st.nextToken());
	        }
	        // 그래프 인접 행렬
	        for (int i = 1; i <= N; i++) {
	            st = new StringTokenizer(br.readLine());
	            int n = Integer.parseInt(st.nextToken()); // i 인접한 구역의 수
	            for (int j = 1; j <= n; j++) {
	                int v = Integer.parseInt(st.nextToken());
	                matrix[i][j] = v;
	            }
	        }
		
		//부분집합
		subset(1);//정점번호 1부터 시작
		System.out.println(min==Integer.MAX_VALUE?-1: min);
	}
	static void check() {
		//두 그룹이 각각 유효한지 따짐(연결)
		//그룹별로 따지되, 양쪽 다 연결여부를 확인
		//bfs로 각각 갈 수 있는 곳으로 가서 visit-> true
		//양쪽 모두 따지고 나면 visit 전체가 true가 되었는지 일부라도 false인지
		
		// 자료구조 초기화
		Arrays.fill(visit, false);
		queue.clear();
		
		//A - select : true
		for(int i = 1; i<=N; i++) {
			if(select[i]) {
				//선택된 한 정점만 큐에 넣고 bfs
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}
		if(queue.size()==0)return;
		while(!queue.isEmpty()) {
			int v = queue.poll();
			
			//모든 정점에 대해 A 그룹이면서 연결되어있는가
			for(int i = 1; i<=N; i++) {
				int adj = matrix[v][i];
				if(adj !=0&&!visit[adj]&&select[adj]) {//연결이 되어있다
					visit[adj]=true;
					queue.offer(adj);				
				}
			}
		}
		//B - select : false
		for(int i = 1; i<=N; i++) {
			if(!select[i]) {
				//선택된 한 정점만 큐에 넣고 bfs
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}
		while(!queue.isEmpty()) {
			int v = queue.poll();
			
			//모든 정점에 대해 A 그룹이면서 연결되어있는가
			for(int i = 1; i<=N; i++) {
				int adj = matrix[v][i];
				if(adj !=0&&!visit[adj]&&!select[adj]) {//연결이 되어있다
					visit[adj]=true;
					queue.offer(adj);				
				}
			}
		}
		//A, B 모두 연결되어 있는지 visit[] 확인
		for(int i =1; i<=N; i++) {
			if(!visit[i]) return;//연결되어있지 않은게 있다
		}
		
		//두 그룹을 나누었고 모두 연결된 상태다
		//두 그룹의 인구수 차이를 계산. min과 비교
		int sumA = 0;
		int sumB = 0;
		for(int i =1; i<=N; i++) {
			if(select[i]) sumA+=matrix[i][0];//A 누적합
			if(!select[i]) sumB+=matrix[i][0];//B 누적합
		}
		min = Math.min(min, Math.abs(sumA-sumB));
	}
	static void subset(int srcIdx) {
		if(srcIdx==N+1) {
			//기저조건
			//두개 구역으로 나눈 상태
			check();			
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx+1);
		select[srcIdx] = false;
		subset(srcIdx+1);
		
	}

}
