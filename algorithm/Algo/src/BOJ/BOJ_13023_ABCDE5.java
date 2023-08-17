package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//class to List
public class BOJ_13023_ABCDE5 {
	static int N, M;
	//static boolean[][] friends;// 인접행ㄹㄹ
	static Friend[] friends;//배열
	static boolean[] visit;
	static boolean done;// 완료여부

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		friends = new Friend[N];
		// 자료구조
		for (int i = 0; i < N; i++) {
			friends[i]=new Friend(i);//생성자 전달
			}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 무향
			friends[a].list.add(b);//a->b
			friends[b].list.add(a);//b->a
		}
		visit = new boolean[N];
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
		if (done)	return;

		if (cnt == 4) {// 4번 연속으로 친구가 연결
			done = true;
			return;
		}
		
		List<Integer>numFriends = friends[num].list;
		int size = numFriends.size();
		for (int i = 0; i < size; i++) {
			int n = numFriends.get(i);	
			
			if (visit[n])	continue;// num으로부터 갈 수 없는 친구. 이미 방문함
			visit[n] = true;
			dfs(n, cnt + 1);
			visit[n] = false;//내가 방문해온 자리만 visit check
			//갔다가 아닌가벼 하고 돌아올때 true면 다시 방문 불가능
			// 해당 노드가 다시 돌아와서 다른 노드를 탐색해야 할 경우 visit가 true면 끝나게 된다.
		}		
		// 계속 친구 탐색
		
	}
	
	static class Friend{
		int num;
		List<Integer> list = new ArrayList<>();
		Friend(int num){
			this.num = num;			
		}
	}
}
