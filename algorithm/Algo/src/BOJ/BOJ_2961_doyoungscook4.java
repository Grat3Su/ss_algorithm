package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2961_doyoungscook4 {
	static int N;
	static int[][] src; 
	static boolean[] selected; 
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(bf.readLine());
		src = new int[N][2];
		selected = new boolean[N];
		min = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int subCnt = 1<<N;//모든 부분 집합의 수
		//0은 재료가 없다는 뜻이니까 제외
		for(int i = 1; i<subCnt; i++) {
			//각 재료별 선택 비선택 고려해서 신맛 쓴맛 계산
			//i가 이미 부분집합의 한 경우니까 mask or selection 역할
			int sin = 1;
			int ssn = 0;
			
			for(int j = 0; j<N; j++) {
				if((i&1<<j)!=0) {
					sin*=src[j][0];
					ssn+=src[j][1];
				}
			}
			min = Math.min(min, Math.abs(sin-ssn));
		}
		
		System.out.println(min);
	}
}
