package off231005;

import java.io.*;
import java.util.*;

public class SW_5656_brick {
	static int T, N, W, H, ans;
	static int[][]map;
	static StringBuilder sb = new StringBuilder();
	

	static class Brick {
		//벽돌이 쏴진 위치, 몇번째 발사인지
		int x, y, cnt;
		int map[][];

		public Brick(int x, int y, int cnt, int[][] map) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.map = map;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N =Integer.parseInt(st.nextToken());
			W =Integer.parseInt(st.nextToken());
			H =Integer.parseInt(st.nextToken());
			
			map = new int[W][H];
			
			for(int i = 0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<W; j++) {
					map[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int[][] map2 = brickFall(map);
			//맵 출력해본거
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					System.out.print(map2[j][i]+" ");
					
				}
				System.out.println();
			}
			
		}		
	}
	
	static int[][] ballFall(int[][] board, int x) {
		int br = 0; 
		for(int i = 0; i<H; i++) {
			if(board[x][i] != 0) {//벽돌에 닿았다
				br = board[x][i];//
				board = splitBrick(board, br);
				break;
			}
		}
		
		return brickFall(board);
	}
	
	static int[][] splitBrick(int[][] board, int n){
		for(int i = 0; i<n ; i++) {
			
		}
		return board;
	}
	
	static int[][] brickFall(int[][] board) {		
		for(int i = 0; i<W; i++) {
			for(int j = H-1; j>=0; j--) {
				if(board[i][j] != 0)continue;
				
				for(int k =j-1; k>=0; k--) {
					if(board[i][k]!=0) {
						board[i][j] = board[i][k];
						board[i][k] = 0;
					break;
					}
				}
			}
		}		
		return board;
	}

}
