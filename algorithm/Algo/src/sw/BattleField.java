package sw;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BattleField {
	/*
	 * 데이터셋 T H W Map N command 1 3 7 .... -..#** #<.**** 23 SURSSSSUSLSRSSSURRDSRDS
	 */
	static int H, W, N, dir;
	static char[][] map;
	static char[] tank = {'^','v','<','>'};
	static char[] command;
	static int[][] shootDir = {{0,-1},{0,1},{1,0},{-1,0}};
	static int[] pPos = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[W][H];

		for (int i = 0; i < W; i++) {			
			map[i] = br.readLine().toCharArray();
			
			for(int j = 0; j<H; j++) {
				if(map[i][j]==tank[0]||map[i][j]==tank[1]||map[i][j]==tank[2]||map[i][j]==tank[3]) {//탱크 위치 표시
					pPos[0] = i;
					pPos[1] = j;
				}
			}
		}

		N = Integer.parseInt(br.readLine());
		command = new char[N];//명령어
		command = br.readLine().toCharArray();
		dir = 2;//탱크 방향
		for (int i = 0; i < N; i++) {// 명령실행
			switch (command[i]) {
			case 'U':
				dir = 0;
				tankDir();
				
				break;
			case 'D':
				dir = 1;
				tankDir();
				
				break;
			case 'L':
				dir = 2;
				tankDir();
				break;
			case 'R':
				dir = 3;
				tankDir();
				break;
			case 'S':
				shoot(shootDir[dir][0],shootDir[dir][1]);//방향에 맞춰서 발사
				
				break;

			default:
				break;
			}

			for(int k = 0; k<W; k++) {
				for(int j = 0; j<H; j++) {
					System.out.print(map[k][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<W; i++) {
			for(int j = 0; j<H; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static void tankDir() {
		int x = pPos[0]+shootDir[dir][0];
		int y = pPos[1]+shootDir[dir][1];
		map[pPos[0]][pPos[1]]= tank[dir];//현재 방향으로 보기
		
		if(x<0||x>=W||y<0||y>=H)	return;//맵 밖
		else if(map[x][y] == '#')	return;//강철벽
		else if(map[x][y] == '-')	return;//물
		else if(map[x][y] == '*') 	return;//벽돌 벽
		
		if(map[x][y]=='.') {
			map[pPos[0]][pPos[1]] = '.';
			map[x][y] = tank[dir];
			pPos[0] = x;
			pPos[1] = y;
		}
	}
	
	static void shoot(int dx, int dy) {
		if(pPos[0]+dx<0||pPos[0]+dx>=W||pPos[1]+dy<0||pPos[1]+dy>=H)	return;//맵 밖
		else if(map[pPos[0]+dx][pPos[1]+dy] == '*')	map[pPos[0]+dx][pPos[1]+dy] = '.';//강철벽
		else if(map[pPos[0]+dx][pPos[1]+dy] == '#') {//벽돌벽
			map[pPos[0]+dx][pPos[1]+dy] = '.';
			return;
		}
		
		shoot(dx+shootDir[dir][0],dy+shootDir[dir][1]);
	}
}
