package sw.offline0822;

import java.util.*;
import java.io.*;

//기본적인 순열
public class SW_1247_OptimalPath_perm {
	static int T, N, comY, comX, homeX, homeY, min;
	static int cust[][], tgt[];// 회사랑 집좌표 포함해야해서 +2인거 잊지말기
	static boolean select[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			cust = new int[N][2];
			select = new boolean[N];
			tgt = new int[N];
			min = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {// 회사-집-고객'
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			perm(0);
			sb.append("#").append(t + 1).append(" ").append(min).append("\n");

		}
		System.out.println(sb);
	}

	static void perm(int tgtIdx) {
		// complete code
		if (tgtIdx == N) {
			//회사->첫번째 고객
			int sum = distance(comY,comX,cust[tgt[0]][0],cust[tgt[0]][1]);
			//첫번째 고객->마지막 고객
			for(int i = 0; i<N-1; i++) {
				sum += distance(cust[tgt[i]][0],cust[tgt[i]][1],
						cust[tgt[i+1]][0],cust[tgt[i+1]][1] );
			}
			
			//마지막 고객->집
			sum += distance(homeY,homeX,cust[tgt[N-1]][0],cust[tgt[N-1]][1]);
			min = Math.min(min, sum);
					
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(select[i])	continue;
			
			tgt[tgtIdx] = i;
			select[i] = true;
			perm(tgtIdx+1);
			select[i] = false;
		}
	}
	
	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1-y2)+Math.abs(x1-x2);
	}

}
