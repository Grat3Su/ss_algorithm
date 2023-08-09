package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* 데이터 셋
18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0
 */
public class BOJ_11286_heap {

	static int N;
	static PriorityQueue<Integer> pqueue = new PriorityQueue<>(
			(n1, n2) -> Math.abs(n1) == Math.abs(n2) ? n1 - n2 : Math.abs(n1) - Math.abs(n2));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// N개의 연산 처리
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				Integer min = pqueue.poll();
				System.out.println(min == null ? 0 : min);
			} else {
				pqueue.offer(num);
			}
		}
	}
}