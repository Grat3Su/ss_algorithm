package BOJ.algostudy;

import java.util.*;
import java.io.*;
/*N M map
 * 4 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
 */

public class BOJ_15683_Security {
	static enum Ddir {
		Def, Up, Right, Down, Left
	}

	static int[][] dir;// U R D L
	static int N, M;
	static int[][] map;
	static int[][] cpymap;

	public static void main(String[] args) throws Exception{
		dir = new int[][] { {0,0,0,0},
							{0,1,0,0},
							{0,1,0,1},
							{1,1,0,0},
							{1,1,0,1},
							{1,1,1,1}
		};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		cpymap = new int[M][N];//원본
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cpymap[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				
			}
		}
			
	}

	static void look() {
		
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				
			}
		}
	}
}
