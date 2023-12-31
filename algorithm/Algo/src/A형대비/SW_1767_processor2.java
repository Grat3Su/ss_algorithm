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
public class SW_1767_processor2 {
	static int N, max,totalCnt, min,map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<int[]> list; //  전선을 놓아야할 코어리스트
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			// 초기화
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i==0||j==0||i==N-1||j==N-1) continue;
					if(map[i][j]==1) {// 가장자리 코어 제외
					list.add(new int[]{i,j});
					totalCnt++;
					}
				}				
			}
			go(0,0);
			sb.append("#").append(t+1).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	//코어를 선택(4방향 시도)/비선택
	static void go(int index, int coreCnt) {//고려해야 할 코어의 idx, corecnt 연결된 코어 수
		//가지치기 : 현재까지 연결된 코어 수 + 남은 코어 수 <임시 최대 코어 연결 수
		if(coreCnt+(totalCnt-index)<max) return;
		//기저조건  처리
		if(index == totalCnt) {
			int res = getLength();//놓아진 전선의 길이의 합
			if(coreCnt >max) {
				max = coreCnt;
				min = res;
			} else if(max == coreCnt) {
				if(min>res) {
					min = res;
				}
			}
			return;
		}
		
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		//현재 코어 선택(4방향 시도)
		for(int d = 0; d<4; d++) {
			
			//현재 코어의 위치에서 해당 방향으로 전선 놓기가 가능한지 체크			
			if(isAvailable(r,c,d)) //해당 방향으로 전선을 놓을 수 있을지를 판단
				continue;
			//가능하다면 전선 놓기
			setStatus(r,c,d,2);
			//다음 코어로 가기
			go(index+1, coreCnt+1);
			//새로운  방향을 시도하기 위해 놓았던 전선 지우기
			setStatus(r,c,d,0);		
			
		}
		//현재 코어 비선택
		go(index+1, coreCnt);
		
	}

	private static int getLength() {
		int lCnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j]==2) {
					lCnt++;
				}
			}
		}
		return lCnt;
	}

	private static void setStatus(int r, int c, int d, int status) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr<0||nr>=N||nc <0||nc>=N) break;
			map[nr][nc] = status;
		}
	}

	private static boolean isAvailable(int r, int c, int d) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr<0||nr>=N||nc <0||nc>=N) break;
			if(map[nr][nc]!=0)return false;
		}
		return true;
	}
}
