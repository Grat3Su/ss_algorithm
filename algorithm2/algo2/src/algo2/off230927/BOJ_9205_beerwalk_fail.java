package algo2.off230927;

import java.io.*;
import java.util.*;
//천미터 안에 편의점 있으면 
/*
 * 테스트케이스
2
2
0 0
1000 0
1000 1000
2000 1000
2
0 0
1000 0
2000 1000
2000 2000

->
happy
sad


1
1
0 0
9999 9999
0 1

happy
 */
public class BOJ_9205_beerwalk_fail {
	static int T, N;
	static Node[] pos; 
	static int curBeer;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			N = Integer.parseInt(br.readLine());//편의점의 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			pos = new Node[N+2];
			curBeer = 20;
			//좌표 설정
			//편의점 : 1부터 N까지
			pos[0] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int i = 1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine());
				pos[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));				
			}
			st = new StringTokenizer(br.readLine());
			pos[N+1] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int i = 1; i<N+1; i++) {
				int dist = Math.abs(pos[i-1].x - pos[i].x)+Math.abs(pos[i-1].y - pos[i].y);
				float beer = dist/50;
				curBeer -= beer;
				
				if(curBeer < 0) {
					break;			
				}
				curBeer = 20;
			}
			int dist = Math.abs(pos[N+1].x - pos[N].x)+Math.abs(pos[N+1].y - pos[N].y);
			if(curBeer < 0 || dist>1000) {
				sb.append("sad").append("\n");
			}else {
				sb.append("happy").append("\n");
			}
			
		}
		System.out.println(sb);

	}
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
