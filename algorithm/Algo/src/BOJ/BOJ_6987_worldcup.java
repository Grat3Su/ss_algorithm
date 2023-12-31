package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 데이터셋
 * A B C D...
5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4
 */
public class BOJ_6987_worldcup {
	static int[][] team;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			team = new int[6][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					team[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (check())
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");
		}
		System.out.println(sb);
	}

	static boolean check() {
		int sum = 0;
		int duce = 0;
		int[] dx = { 1, -1 };
		int idx = 0;
		boolean maxwin = false;
		for (int i = 0; i < team.length; i++) {
			if (team[i][0] + team[i][1] + team[i][2] != 5)// 한 팀의 경기가 5번 있어야함
				return false;
			sum += team[i][0];
			sum -= team[i][2];// 모든 승/패 합이

			if (team[i][1] != 0) {// 무승부가 0이 아니면
				duce += (team[i][1] * dx[idx]);
				idx += 1;
				if (idx > 1)
					idx = 0;
			}
			
			if(team[i][0]==5) {
				if(maxwin)	return false;
				else	maxwin = true;
			}
		}
		if (sum != 0 || duce != 0)
			return false;
		return true;
	}

}
