package BOJ.offline0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* 줄세우기
 * 데이터셋
 * N M 
 * arr[][]
3 2
1 3
2 3
 */
public class BOJ_2252_line {
	static int N, M;
	static int[] topo;
	static List<List<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());//학생 수
		M = Integer.parseInt(st.nextToken());//비교 횟수
		topo = new int[N+1];
		
		//연결리스트
		for(int i = 0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//비교횟수
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
				
			//A->B
			graph.get(A).add(B);
			topo[B]++;//진입 차수 증가
		}
		
		//풀이
		Queue<Integer> queue = new ArrayDeque<>();
		
		//진입 차수가 0인 번호를 큐에 넣는다
		for(int i = 1; i<=N; i++) {
			if(topo[i]==0) {
				queue.offer(i);
			}
		}
		
		//큐를 이용해서 꺼내면서 연결을 끊고 다시 진입차수가 0인 학생을 큐에 넣는다.
		//이것을 반복한다
		while(!queue.isEmpty()) {
			int no = queue.poll();
			
			// queue 에서 꺼낸 번호가 바로 줄세우기 번호가 된다
			sb.append(no).append(" ");
			
			//no 학생으로 부터 갈 수 있는 다른 학생을 모두 대상으로
			List<Integer> list = graph.get(no);
			int size = list.size();
			
			for(int i = 0; i<size; i++) {
				int temp = list.get(i);
				topo[temp]--;//no -> temp 관계인데 no를 그래프에서 제거하므로 temp의 진입차수가 1 줄어든다
				if(topo[temp]==0) {//진입 차수가 0이면 더 이상 누구를 기다릴 필요 없이 새로운 시작점이 된다. queue에 담음
					queue.offer(temp);
				}
			}
		}		
		System.out.println(sb);
	}
}
