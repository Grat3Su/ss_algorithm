package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class hwalgo04_부울경_3반_장수영 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i<N+1; i++) {
			queue.offer(i);			
		}
		
		while(queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());			
		}
		
		System.out.println(queue.poll());
	}

}
