package sw.offline0822;

import java.util.*;
import java.io.*;
/* 데이터셋
 * T
 * N
 * Arr[] 회사 집 고객
 * 10
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
 */
public class SW_1247_OptimalPath {
	static int T,N,min;
	static int arr[][], tgt[][];//회사랑 집좌표 포함해야해서 +2인거 잊지말기
	static boolean visit[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			int size = N+2;
			arr = new int[size][2];
			tgt = new int[N][2];
			min = Integer.MAX_VALUE;
			visit = new boolean[N+2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<size; i++) {//회사-집-고객'
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			perm(0);
			sb.append("#").append(t+1).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void perm(int tgtIdx) {//순열. because of 순서가 중요하니까
		if(tgtIdx == N) {
			int distance = 0;
			for(int i = 1; i<N; i++) {
				distance += Math.abs(tgt[i-1][0]-tgt[i][0])+Math.abs(tgt[i-1][1]-tgt[i][1]);
			}
			distance += Math.abs(arr[0][0]-tgt[0][0])+Math.abs(arr[0][1]-tgt[0][1]);//회사와 첫번째 고객거리
			distance += Math.abs(arr[1][0]-tgt[N-1][0])+Math.abs(arr[1][1]-tgt[N-1][1]);//마지막 고객과 집 거리
			
			min = Math.min(distance, min);
			return;
		}
		
		for(int i = 2; i<N+2; i++) {
			if(visit[i])	continue;
			tgt[tgtIdx] = arr[i];
			visit[i] = true;
			perm(tgtIdx+1);
			visit[i] = false;
		}
		
	}

}
