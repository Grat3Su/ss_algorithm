package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스3 {
	/*	데이터셋
	 * 	7 3
	 * 	사람 수 N과 제거할 번호 K
	 */
	//K번째 사람이 제거되고 그 배열에서 다시 K번째 사람 제거
	//배열이 빌때까지
	//이거 배열 문제인가?
	static Queue<Integer> queue = new ArrayDeque<>();
	static int N, K;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<N+1; i++) {
			queue.offer(i);
		}
		
		//죽으면 0으로
		int aliveCnt = 1;
		sb.append("<");
		while(!queue.isEmpty()) {
			int num = queue.poll();
			if((aliveCnt%K)==0) {
				sb.append(num).append(", ");
			}else {
				queue.offer(num);//살아있지만 1이 아닌 경우 다시 담는다
			}
			aliveCnt++;
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
}

