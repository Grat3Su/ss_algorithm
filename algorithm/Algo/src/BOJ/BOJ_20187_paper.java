package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/* 데이터셋
 * K - 2^k 배열
 * Arr
 * H - 구멍위치
2
R D D R
3
 */

public class BOJ_20187_paper {

	static int[][] ans;
	static int size,K,H;
	static Queue<Character> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		size = (int) Math.pow(2,K);
		ans = new int[size][size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<(2*K); i++) {
			queue.offer(st.nextToken().charAt(0));
		}
		H = Integer.parseInt(br.readLine());
		int[] cur = {0,0};//x,y 
		fold(cur, size,size);
		
		for(int i = 0; i<size; i++)
			System.out.println(Arrays.toString(ans[i]));
	}
	
	static void fold(int[] cur, int w, int h) {
		if(queue.isEmpty()) {
			ans[cur[0]][cur[1]] = H;
			return;
		}
		
			char c =queue.poll(); 
			switch (c) {
			case 'L':
				w/=2;				
				fold(cur,w,h);
				
				for(int i = cur[0]+w; i<cur[0]+w; i++) {
					for(int j = cur[1]; j<h; j++) {
						int hh = ans[cur[0]+(i -(cur[0]+w))][j];
						if(hh <2)
							ans[i][j] = hh+2;
						else
							ans[i][j] = hh-2;
					}
				}					
				w*=2;
				
				break;
			case 'R':
				w/=2;
				cur[0]+=w;
				fold(cur,w,h);
				
				for(int i = cur[0]-w; i<cur[0]; i++) {
					for(int j = cur[1]; j<h; j++) {
						int hh = ans[i+w][j];
						if(hh <2)
							ans[i][j] = hh+2;
						else
							ans[i][j] = hh-2;
					}
				}		
				cur[0]-=w;
				w*=2;
				break;
			case 'D':
				h/=2;
				cur[1]+=h;
				fold(cur,w,h);
				for(int i = cur[0]; i<w; i++) {
					for(int j = cur[1]-h; j<h; j++) {
						int hh = ans[i][j];
						if(hh <2)
							ans[i][j] = hh+2;
						else
							ans[i][j] = hh-2;
					}
				}	
				cur[1]-=h;
				h*=2;
				break;
			case 'U':
				h/=2;
				fold(cur,w,h);
				
				h*=2;
				break;

			default:
				break;
			
		}
		
	}

}
