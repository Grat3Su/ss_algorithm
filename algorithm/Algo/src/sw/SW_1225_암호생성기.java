package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1225_암호생성기 {
	
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<11; t++) {//test case
			int T = Integer.parseInt(br.readLine());
			queue.clear();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int dec = 1;
			while(queue.peek()!=0) {
				int num = queue.poll();
				
				if(num-dec <=0 )
				{
					queue.offer(0);
					break;
				}
				
				queue.offer(num-dec);
				dec = (dec==5?1:dec+1);				
			}
			sb.append("#").append(t).append(" ");
			for(int i = 0; i<8; i++) sb.append(queue.poll()).append(" ");			
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
