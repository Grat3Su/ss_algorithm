package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/* 데이터셋
 * R C(알파벳수 겸 y)
 * 2 4
CAAB
ADCB
 */
public class BOJ_1987_Alphabet {
	static int R, C,max;
	static char[][] map;
	static boolean[] checked = new boolean[26];//알파벳 체크
	static int[] dx = {-1,1,0,0};
	static int[]dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		max = 0;
		for(int i = 0; i<R;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j = 0; j<C; j++) {
				map[i][j] = s.charAt(R);
			}
		}
		dfs(0,0,0);
		
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int cnt) {
		if(checked[map[x][y]-'A']) {//알파벳 체크
			max = Math.max(max, cnt);
			return;
		}
		cnt++;
		int c = map[x][y]-'A';
		checked[c] = true;
		if(x<C&&x>0&&y<R&&y>0) {
			for(int i = 0; i<4; i++) {
				dfs(x+dx[i], y+dy[i],cnt);
			}
		}
		
		checked[c] = false;		
	}

}
