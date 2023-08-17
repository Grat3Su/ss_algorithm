package sw;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class battlefield2 {
	/*
	 * 데이터셋 T H W Map N command 1 3 7 .... -..#** #<.**** 23 SURSSSSUSLSRSSSURRDSRDS
	 */
	static int H, W, N, dir;
	static char[][] map;
	static char[] tank = {'^','v','<','>'};
	static char[] command;
	static int[][] shootDir = {{0,-1},{0,1},{1,0},{-1,0}};
	static int[] pPos = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			
			int jcx = 0;
			int jcy = 0;
			for(int i=0;i<h;i++) {
				String tmp = br.readLine();
				if(tmp.contains("<")||tmp.contains(">")||tmp.contains("^")||tmp.contains("v")) {
					jcx = i;
					jcy = Math.max(tmp.indexOf("<"), tmp.indexOf(">"));
					jcy = Math.max(jcy, tmp.indexOf("^"));
					jcy = Math.max(jcy, tmp.indexOf("v"));	
				}
				map[i] = tmp.toCharArray();
			}
			int n = Integer.parseInt(br.readLine());
			char[] inps = br.readLine().toCharArray();
			
			int dx = 0;
			int dy = 0;
			for(char inp : inps) {
				if (inp == 'U') {
					map[jcx][jcy] = '^';
					if (0<=jcx-1&&map[jcx-1][jcy]=='.') {
						map[jcx-1][jcy]='^';
						map[jcx][jcy] ='.';
						jcx = jcx-1;
					}
				}else if (inp == 'D') {
					map[jcx][jcy] = 'v';
					if (jcx+1<h&&map[jcx+1][jcy]=='.') {
						map[jcx+1][jcy]='v';
						map[jcx][jcy] ='.';
						jcx = jcx+1;
					}
				}else if (inp == 'L') {
					map[jcx][jcy] = '<';
					if (0<=jcy-1&&map[jcx][jcy-1]=='.') {
						map[jcx][jcy-1]='<';
						map[jcx][jcy] ='.';
						jcy = jcy-1;
					}
				}else if (inp == 'R') {
					map[jcx][jcy] = '>';
					if (jcy+1<w&&map[jcx][jcy+1]=='.') {
						map[jcx][jcy+1]='>';
						map[jcx][jcy] ='.';
						jcy = jcy+1;
					}
				}else if (inp == 'S') {
					if(map[jcx][jcy]=='>') {
						dx = 0;
						dy = 1;
					}else if(map[jcx][jcy]=='<') {
						dx = 0;
						dy = -1;
					}else if(map[jcx][jcy]=='v') {
						dx = 1;
						dy = 0;
					}else if (map[jcx][jcy]=='^') {
						dx = -1;
						dy = 0;
					}
					if((0<=jcx+dx&&jcx+dx<h)&&(0<=jcy+dy&&jcy+dy<w)) {
						int nowx = jcx+dx;
						int nowy = jcy+dy;
						if(map[nowx][nowy]=='.'||map[nowx][nowy]=='-') {
							while(((0<=nowx+dx&&nowx+dx<h)&&(0<=nowy+dy&&nowy+dy<w))&&(map[nowx+dx][nowy+dy]=='.'||map[nowx+dx][nowy+dy]=='-')) {
								nowx += dx;
								nowy += dy;
							}
							if (((0<=nowx+dx&&nowx+dx<h)&&(0<=nowy+dy&&nowy+dy<w))&&(map[nowx+dx][nowy+dy]=='*')) {
								map[nowx+dx][nowy+dy] = '.';
							}
						}
						else if((map[nowx][nowy]=='*')) {
							map[nowx][nowy] = '.';
						}
					}
				}
			}
			System.out.print("#"+t+1+" ");
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

}
