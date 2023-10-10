package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 미생물격리 {
	static int Ans = 0, T, N, M, K;
	static class Virus implements Comparable<Virus>{
		int r, c,cnt,d,t;
		public Virus(int r, int c, int cnt, int d, int t) {
			this.r=r;
			this.c=c;
			this.cnt=cnt;
			this.d=d;
			this.t=t;
		}
		@Override
		public int compareTo(Virus o) {
			return Integer.compare(o.cnt, this.cnt);
		}
	}
	static ArrayList<Virus> vs ;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(미생물격리.class.getResourceAsStream("3.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			vs = new ArrayList<>();
			N=sc.nextInt();
			M=sc.nextInt();
			K=sc.nextInt();
			for (int i = 0; i < K; i++) {
				vs.add(new Virus(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), i));
			}
			//System.out.println(vs.size());
			for (int i = 0; i < M; i++) {
				solving();
			}
			
			for (int i = 0; i < vs.size(); i++) {
				Ans += vs.get(i).cnt;
			}
			
			System.out.printf("#%d %d\n", tc, Ans);
		}
	}
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,-1,1};
	private static void solving() {
		// 바이러스 이동
		for (int i = 0; i < vs.size(); i++) {
			Virus v = vs.get(i);
			v.r += dr[v.d];
			v.c += dc[v.d];
			
			// 경계에 들어오면
			if(v.r==0||v.r==N-1||v.c==0||v.c==N-1) {
				// 크기가 반으로 줄입니다
				v.cnt /= 2;
				// 방향전환
				switch (v.d) {
				case 1:
					v.d=2;
					break;
				case 2:
					v.d=1;
					break;
				case 3:
					v.d=4;
					break;
				case 4:
					v.d=3;
					break;
				}
			}
			// 1보다 작은 군집은 지움니다
			if(v.cnt < 1) {
				vs.remove(i--);
			}
		}
		// 같은 위치에 있는 바이러스들은 합쳐지고 그중 가장 큰 바이러스의 방향으로 이동한다
		// 크기순으로 정렬했기 때문에 같은 위치라면 먼저나오는 놈 방향으로 정하면 된다 
		Collections.sort(vs);
		for (int i = 0; i < vs.size()-1; i++) {
			Virus v1 = vs.get(i);
			for (int j = i+1; j < vs.size(); j++) {
				Virus v2 = vs.get(j);
				if(v1.r==v2.r&&v1.c==v2.c) {
					// v1.cnt 더 크므로 v1 으로 합체
					v1.cnt += v2.cnt;
					vs.remove(j);
					j--;
				}
			}
		}
	}
}




