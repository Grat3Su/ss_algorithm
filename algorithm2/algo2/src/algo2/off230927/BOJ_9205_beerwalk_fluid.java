package algo2.off230927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 간선 비용이 존재? 맨하튼 거리가 간선 비용이 아니다. 단순 연결여부를 파악하기 위한 중간값
// bfs() 또는 플로이드워셜로 가능

// 계속 맥주를 마시면서(떨어지면 다시 채워서) 가야 하기 때문에 집 - 편의점... - 공연장 까지 최소 거리(비용)를 구해야 한다.
// 집 -> 편의점1, 집-> 편의점2..집->공연장의 최소 거리를 구하는 것이 아님 <== 다익스트라 X, 플로이드워샬 O

// 우선 테케 입력값으로부터 비용 matrix 초기값을 구성
//   그래프로 그렸을 때, 정점이 연결된 것과 연결 안된 것의 구별은?  
//   두 정점의 거리가 1000 ( 50x20 ) 보다 멀면 연결이 안된 걸로 계산 <= 맥주 20개 x 50m
//   matrix 를 단순 거리의 최소값으로 계산 X
// 
// 계속 happy 할 수 있는 가 를 묻는 문제
// V[집][공연장] 의 값이 BIG 이면 sad
public class BOJ_9205_beerwalk_fluid{
	static int T, N, V;
	static int BIG = 101*32767*2; // 편의점 100, 거리 범위 음양수
	static int[][] input, matrix;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
		
			N = Integer.parseInt(br.readLine());
			V = N + 2; // 편의점 + 집 + 공연장
			
			input = new int[V][2];
			matrix = new int[V][V];
			
			// 입력 처리
			for (int i = 0; i < V; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 입력으로부터 인접행렬을 만든다.
			for (int i = 0; i < V; i++) {
				int vy = input[i][0];
				int vx = input[i][1];
				
				for (int j = 0; j < V; j++) {
					if( i == j ) continue;
					
					int ty = input[j][0];
					int tx = input[j][1];
					int dis = Math.abs(ty-vy) + Math.abs(tx-vx); // 맨하튼 거리
					
					if( dis <= 1000 ) { // 맥주를 마시면서 갈 수 있는 거리
						matrix[i][j] = dis;
					}else { // 맥주를 마시면서 갈 수 없는 거리
						matrix[i][j] = BIG;
					}
				}
			}
			
//			System.out.println();
//			for (int i = 0; i < V; i++) {
//				System.out.println(Arrays.toString(matrix[i]));
//			}
			
			// 플로이드 워셜 적용
			for (int k = 0; k < V; k++) {
				for (int i = 0; i < V; i++) {
					if( k == i ) continue;
					for (int j = 0; j < V; j++) {
						if( i == j || k == j ) continue;
						matrix[i][j] = Math.min( matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
			}
		
//			System.out.println();
//			for (int i = 0; i < V; i++) {
//				System.out.println(Arrays.toString(matrix[i]));
//			}
		
			// 집 0 -> 공연장 V-1 까지의 거리가 BIG 보다 작으면 happy => 중간에 BIG 이 있다면 ( 1000 보다 큰 ) BIG 보다 크다.
			sb.append( matrix[0][V-1] < BIG ? "happy" : "sad").append("\n");			
		}
		System.out.println(sb);
	}
}
