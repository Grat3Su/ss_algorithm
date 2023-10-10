package online;

import java.io.*;
import java.util.*;

public class SW_5656_brick {//완탐+구현
	static int N, W, H;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0-1,1};
	
	
	static class point{
		int r, c, cnt;

		public point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());//구슬 던지는 횟수
			W = Integer.parseInt(st.nextToken());//가로(열크기)
			H = Integer.parseInt(st.nextToken());//세로(행크기)
			
			int[][] map = new int[H][W];
			
			for(int i = 0; i<H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//2차원 맵 입력			
		}
	}
	
	
	//구슬 던지기 : 중복 순열
	static boolean drop(int cnt, int[][] map) {
		//cnt : 직전까지 떨어뜨린 구슬 수
		//map : 직전 상태까지의 map
		//return : 모든 벽돌이 제거되었는지 여부
		
		//모든 구슬을 다 던졌다면 남은 벽돌 수 갱신
		int [][] newMap = map;
		for (int c = 0; c < W; c++) {//모든 열에 대해 시도
			//해당 열에 떨어뜨릴 경우 제거되게 되는 맨 윗벽돌 찾기
			
			//벽돌이 존재하지 ㅇ낳는다며ㅓㄴ(해당 열은 모두 빈칸)
						
			
			//벽돌이 존재한다면
			
			//함께 제거될 인접벽돌 연쇄 찾기
			//제거(벽돌 내리기)
			//다음 구슬 던지기
		}
		for (int r = 0; r < H; r++) {
			
			if(r==H) {
				copy(name, newMap);
			}
		}
	}
	
	//인접한 제거 벽돌 찾기 : Flood Fill (4방향 BFS)
	static void boom(int[][] map, int r, int c) {
		Queue<point>queue = new ArrayDeque<>();
		
		if(map[r][c] >1)queue.offer(new point(r, c, map[r][c]));
		map[r][c] = 0;
		while(!queue.isEmpty()) {
			point cur = queue.poll();
			
		}
				
	}
	
	
	//벽돌 내리기 : 빈자리 위쪽 벽돌 찾아 내리기
	
	
	//배열 복사하기
	static void copy(int[][] map, int[][] newMap) {
		for(int r = 0; r<H; r++) {
			for(int c = 0; c<W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}
	
	//남은 벽돌 개수 구하기 : 매번 구슬 던지기 전에 사용할 목적
	static int getRemain(int[][] map) {
		int cnt = 0;
		for(int r = 0; r<H; r++) {
			for(int c = 0; c<W; c++) {
				if(map[r][c]!=0)cnt++;//벽돌일때만 세기
			}
		}
		return cnt;
	}
	
	
	//디버깅용(상태출력)

}
