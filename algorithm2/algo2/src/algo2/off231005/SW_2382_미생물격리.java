package algo2.off231005;
import java.io.*;
import java.util.*;
/*
 * 2
7 2 9
1 1 7 1
2 1 7 1
5 1 5 4
3 2 8 4
4 3 14 1
3 4 3 3
1 5 8 2
3 5 100 1
5 5 1 1
10 17 46
7 5 724 2
7 7 464 3
2 2 827 2
2 4 942 4
4 5 604 4
7 2 382 1
6 5 895 3
8 7 538 4
6 1 299 4
4 7 811 4
3 6 664 2
6 8 868 2
7 6 859 2
4 6 778 2
5 4 842 3
1 3 942 1
1 1 805 3
3 2 350 3
2 5 623 2
5 3 840 1
7 1 308 4
1 8 323 3
2 3 82 3
2 6 115 2
8 3 930 1
6 2 72 1
2 1 290 3
4 8 574 4
8 5 150 3
8 2 287 2
2 8 909 2
2 7 588 2
7 3 30 3
5 8 655 3
3 8 537 1
4 2 350 3
5 6 199 1
5 5 734 2
3 3 788 1
8 4 893 1
1 4 421 4
6 3 616 2
1 2 556 4
7 8 8 1
5 2 702 2
4 4 503 3

-> 145
-> 5507
 */
public class SW_2382_미생물격리 {
	//테케T 크기 N 격리시간 M 군집갯수 K
	static int T, N, M, K, ans;
	static int[][] map;
	static int[] dx = {0,0,-1,1};//,상하좌우
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
	}
	
	static class Node{
		int x, y, weight, dir;

		public Node(int x, int y, int weight, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
			this.dir = dir;
		}
		
	}

}
