package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//방문
public class BOJ_13023_ABCDE3 {
	static int N, M;
	static boolean[][] friends;// 인접행ㄹㄹ
	static boolean[] visit;
	static boolean done;// 완료여부

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 자료구조
		friends = new boolean[N][N];
		visit = new boolean[N];

		// 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 무향
			friends[a][b] = friends[b][a] = true;
		}
		// 풀이
		//모든 친구 각각 출발
		for(int i = 0; i<N; i++) {
			visit[i] = true;
			dfs(i,0);
			
			if(done) {
				System.out.println(1);
				return;
			}
			visit[i] = false;//원래대로 복귀
		}
		//모두 실패
		System.out.println(0);
	}

	static void dfs(int num, int cnt) {// 친구(정점)번호, depth(count)
		if (done)
			return;

		if (cnt == 4) {// 4번 연속으로 친구가 연결
			done = true;
			return;
		}

		// 계속 친구 탐색
		for (int i = 0; i < N; i++) {
			if (!friends[num][i] || visit[i])
				continue;// num으로부터 갈 수 없는 친구. 이미 방문함
			visit[i] = true;
			dfs(i, cnt + 1);
			visit[i] = false;//내가 방문해온 자리만 visit check
			//갔다가 아닌가벼
			// 해당 노드가 다시 돌아와서 다른 노드를 탐색해야 할 경우 visit가 true면 끝나게 된다.
		}
	}
}
