package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;

import com.sun.corba.se.pept.transport.ContactInfo;

public class SW_1861_SquareRoom4 {
//BFS로 푸는 문제래
//첫 번째 테스트 케이스는 1 또는 3이 적힌 곳에 있어야 한다.
//두 번째 테스트 케이스는 3 또는 6이 적힌 곳에 있어야 한다.
	
	static int T,N,No,COUNT;//NO : 가장 길게 갈 수 있는 방 번호 CONT : 몇번 이동하는가
	static int[][] map;
	static int[][] memoi;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {			
			//초기화
			No = 0;
			COUNT = 1;			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];			
			memoi = new int[N][N];			

			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					int no = map[i][j] = Integer.parseInt(st.nextToken());					
					int cnt = dfs(i,j);//i,j에서 갈 수 있는 모든 방을 간다.
					if(cnt>COUNT) {
						COUNT = cnt;
						No = no;
				}else if(cnt==COUNT) {
					No = no<No?no:No;
				}
			}
		
		
		}
			sb.append("#").append(t).append(" ").append(No).append(" ").append(COUNT).append("\n");
		}
		System.out.println(sb);
	}
	
		static int dfs(int y, int x) {
			//이미 방문해서 계산된 곳
			if(memoi[y][x]!=0) return memoi[y][x];
			
			for(int d = 0; d<4; d++) {
				int ny = y+dy[d];
				int nx = x + dx[d];
				
				if(ny<0||nx<0||ny>=N||nx>=N||map[ny][nx]!=map[y][x]+1)continue;
				return memoi[y][x] = dfs(ny, nx)+1;				
			}
			return memoi[y][x] = 1;
		}
}












