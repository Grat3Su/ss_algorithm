package BOJ.offline0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* 수빈이가 동생을 찾는 최소 경우
 * [X+1][X-1][X*2] -> 세 가지 경우
 * 데이터셋
 * N수빈 위치  K동생 위치
 * 5 17
 */
public class BOJ_1697_HidenSeek2 {
	static int N,K, min;
	static Queue<Integer> queue = new ArrayDeque<>();
	static boolean[] visit = new boolean[100001];//boolean
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		System.out.println(bfs(N,K));
		
	}
	
	static int bfs(int N, int K) {
		// 최단 단계(초)를 계산해서 return;
		int minus = 0;
		int plus = 0;
		int multiply = 0;
		
		visit[N] = true;//true
		queue.offer(N);
		
		int count = 0;		
		
		while(true) {
			//현재 들어 있는 모든 항목들을 모두 따진다.
			int size = queue.size();
			
			for(int i = 0; i<size; i++) {
			
			//꺼내서 K임을 확인하면 종료
			int curr = queue.poll();
			if(curr == K) return count;//while true라서 무조건 걸린다
			
			//꺼내서 +1, -1, *2 에 대한 계산을 하고 유효하면 다시 큐에 넣는다
			minus = curr-1;
			plus = curr+1;
			multiply = curr*2;

			if(minus >=0&&!visit[minus]) {//홀수가 아니고 아직 방문하지 않음
				visit[minus] = true;
				queue.offer(minus);//꺼낸 curr까지 온 depth보다 한번 더 계산
			}
			if(plus <=100000&&!visit[plus]) {//아직 10만이 넘지 않았고 방문하지 않았다
				visit[plus] = true;
				queue.offer(plus);//꺼낸 curr까지 온 depth보다 한번 더 계산
			}
			if(multiply <=100000&&!visit[multiply]) {//아직 10만이 넘지 않았고 방문하지 않았다
				visit[multiply] = true;
				queue.offer(multiply);//꺼낸 curr까지 온 depth보다 한번 더 계산
			}
		}
			count++;
		}
		//-1은 시작할 때 1을 보장
		//return count;//boolean의 방문 여부 체크 + K까지 오는 데 몇 번 방문해야 하는가
	}

}
