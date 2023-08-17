package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1873_BattleField {
	/*
	 * 데이터셋 T H W Map N command 1 3 7 .... -..#** #<.**** 23 SURSSSSUSLSRSSSURRDSRDS
	 */
	static int H, W, N;
	static char[][] map;
	static char[] command;
	static int[][] shootDir = {{0,-1},{0,1},{1,0},{-1,0}};
	static int[] pPos = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[W][H];

		for (int i = 0; i < W; i++) {			
			map[i] = br.readLine().toCharArray();
			
			for(int j = 0; j<H; j++) {
				if(map[i][j]=='<'||map[i][j]=='^'||map[i][j]=='v'||map[i][j]=='>') {//탱크 위치 표시
					pPos[0] = i;
					pPos[1] = j;
				}
			}
		}

		N = Integer.parseInt(br.readLine());
		command = new char[N];
		command = br.readLine().toCharArray();
		int dir = 0;
		for (int i = 0; i < N; i++) {// 명령실행
			switch (command[i]) {
			case 'U':
				dir = 0;
				
				break;
			case 'D':
				dir = 1;
				
				break;
			case 'L':
				dir = 2;
				
				break;
			case 'R':
				dir = 3;
				
				break;
			case 'S':
				shoot(shootDir[dir][0],shootDir[dir][1]);//방향에 맞춰서 발사
				
				break;

			default:
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<W; i++) {
			for(int j : map[i]) {
				sb.append(j);
			}
		}
		
		System.out.println(sb);
	}

	static void shoot(int dx, int dy) {
		if(map[pPos[0]+dx][pPos[1]+dy] == '*')	return;//강철벽
		if(map[pPos[0]+dx][pPos[1]+dy] == '#') {//벽돌벽
			map[pPos[0]+dx][pPos[1]+dy] = '.';
			return;
		}
		if(pPos[0]+dx<0||pPos[0]+dx>=W||pPos[1]+dy<0||pPos[1]+dy>=H)	return;//맵 밖
	}

}
