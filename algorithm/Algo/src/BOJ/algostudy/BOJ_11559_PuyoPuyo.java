package BOJ.algostudy;

import java.io.*;
import java.util.*;

/* 뿌요뿌요
 * 필요한것?
 * 떨어뜨리기
 * 터지는것 찾기
 * dfs로 depth 체크해서 하면 되지 않을까???
 * depth가 같으면 1연쇄인거임
 * 아니면?
 * 아림이가 말한것처럼 내려오게 할 때 빈칸이 있으면 1연쇄로 취급
 * 
 * 
 * 테스트케이스
 * map[6][12]
 * ......
......
......
......
......
......
......
......
.Y....
.YG...
RRYG..
RRYGG.
 */
public class BOJ_11559_PuyoPuyo {
	static int M = 12, N = 6, cnt;
	static char[][] map = new char[12][6];
	static boolean[][] visit = new boolean[12][6];
	static int[] puyo = new int[2];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < M; i++) {
			String m = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = m.charAt(j);
				if(map[i][j]!='.') {//마지막으로 담긴 뿌요뿌요
					puyo[0] = i;
					puyo[1] = j;
				}
			}
		}

		for (int i = 0; i < M; i++)
			System.out.println(Arrays.toString(map[i]));

		puyopuyo();
	}
	
	static void puyopuyo() {
		// 터지는 뿌요 찾기
		
		// 내리기
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(e)
	}

}
