package JOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * DataSet
4
-15 5
-10 36
10 73
27 44


3
25 30
10 20
10 15

4
11 50
1 500
60 88
1 4
 */


public class JOL_1820_Fridge {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Chemistry[] c = new Chemistry[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c[i] = new Chemistry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Queue<Chemistry> queue = new ArrayDeque<>();
		int curMin = Integer.MAX_VALUE;
		Arrays.sort(c);
		curMin = c[N-1].min;
		int curMax = c[N-1].max;
		
		for(int i = 0; i<N; i++) {
			queue.offer(c[i]);
		}
		int fridge = 0;
		while(!queue.isEmpty()) {
			Chemistry mm = queue.peek();
			if(mm.min >= curMin) {
				fridge++;
				curMin = mm.min;				
			}
			else if(curMin>=mm.max) {
				curMin = mm.min;
			}
			queue.poll();//어쨌든 빼낸다
		}
		System.out.println(fridge);
	}
	
	
	static class Chemistry implements Comparable<Chemistry>{
		int min;
		int max;
		public Chemistry(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		@Override
		public int compareTo(Chemistry o) {
			// TODO Auto-generated method stub
			return o.max-this.max;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		public int getMax() {
			return max;
		}
		public void setMax(int max) {
			this.max = max;
		}
	}

}
