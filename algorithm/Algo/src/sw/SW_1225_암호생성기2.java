package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1225_암호생성기2 {
	
	static StringTokenizer st;
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//테스트 케이스가 몇개인지 모른다
		
		while(true) {
			String t = br.readLine();
			
			if(t==null||t.length() ==0)
				break;
			
			//초기화
			queue.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<8; i++) {

				queue.offer(Integer.parseInt(st.nextToken()));
			}
			solve();
			sb.append("#").append(t).append(" ");
			for(int i:queue) sb.append(i).append(" ");			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void solve() {
		int num = 0;
		while(true) {//사이클 반볻
			for(int i = 0; i<5; i++) {
				num = queue.poll()-i;
				
				if(num <=0) {
					queue.offer(0);
					return;
				}
				
				queue.offer(num);
			}
			
		}
	}

}
