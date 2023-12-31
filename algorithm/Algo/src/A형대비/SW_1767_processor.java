package A형대비;

import java.util.*;
import java.io.*;

/*
 * 테스트케이스
 * T
 * N
 * Arr
 * 1
7    
0 0 1 0 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 1 0
0 0 0 0 0 0 0
1 1 0 1 0 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 0
 */
public class SW_1767_processor {
	static int T, N, minWireLength, maxCore;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static List<Core> coreList;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			// 초기화
			map = new int[N][N];
			coreList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						
					
					if(i==0||j==0||i==N-1||j==N-1) continue;
					coreList.add(new Core(i,j));
					}
				}				
			}
			minWireLength  = Integer.MAX_VALUE;
			maxCore = 0;
			connect(0,0,0);
			sb.append("#").append(t+1).append(" ").append(minWireLength).append("\n");
		}
		System.out.println(sb);
	}

	static void connect(int idx, int coreCnt, int wireCnt) {
		if(idx==coreList.size()) {
			if(maxCore<coreCnt) {//최대한 많은 코어에 연결
				maxCore = coreCnt;
				minWireLength = wireCnt;
			}else if(maxCore == coreCnt){//전선 길이의 합이 최소가 되는 값
				minWireLength = Math.min(wireCnt, minWireLength);
			}
			return;
		}
		
		//인덱스 위치 코어의 좌표
		int x = coreList.get(idx).x;
		int y = coreList.get(idx).y;
		
		for(int i = 0; i<4; i++) {
			int count=0, nx =x, ny =y;
			
			while(true) {//그 방향으로 계속 간다
				nx+=dx[i];
				ny+=dy[i];
				
				if(ny<0||ny>=N||nx<0||nx>=N) break;
				
				//가는 길에 다른 코어나 전선이 있으면?
				if(map[ny][nx]==1) {
					count = 0; 
					break;
				}
				
				count++;
			}
			
			int fill_x = x; 
			int fill_y = y; 
			
			for(int j = 0; j<count; j++) {
				fill_x+=dx[i];
				fill_y+=dy[i];
				map[fill_y][fill_x] = 1;
			}
			if(count==0) {
				connect(idx+1, coreCnt, wireCnt);
			} else{
				connect(idx+1, coreCnt+1, wireCnt+count);	
				
				//원본으로 되돌리기
				fill_x = x;
				fill_y = y;
				
				for(int j = 0; j<count; j++) {
					fill_x += dx[i];
					fill_y += dy[i];
					map[fill_y][fill_x] = 0;
				}
			}
		}
		
	}
	static class Core {
		int x, y;

		public Core(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
