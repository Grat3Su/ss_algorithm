package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 데이터셋
 * N M D
 * Arr
5 5 1
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1
 */


public class BOJ_17235_CastleDefence {

	static int N,M,D;
	static int[][]map;
	static int [] archer = new int[3];
	static int[] dx = {1, 0,-1};
	static int[] dy = {0,-1};
	static int cury, cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		cury = M;
		cnt = 0;
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0);
		System.out.println(cnt);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
        if(tgtIdx == 3) {
        	//이제 여기서 적 공격 가능한지 확인하는 함수 추가해야함
        	attack();
            return;
        }
        if(srcIdx == N)return;
        
        archer[tgtIdx] = srcIdx;
        comb(srcIdx+1, tgtIdx+1);
        comb(srcIdx+1, tgtIdx);
    }
	
	static void attack() {
		cury -=1;
		if(cury <0)
			return;
		boolean[] atarcher = new boolean[3];
		for(int a = 0; a<3; a++) {
			int lm = cury-D;
			if(lm<0)
				lm = 0;
			for(int i = cury; i>cury-D; i--) {
				for(int j = 0; j<M; j++) {
					if(map[j][i]==1&&!atarcher[a]) {
						if((Math.abs(i-archer[a])+Math.abs(j-cury+1)) > D) continue;
						map[j][i] = 0;
						atarcher[a] = true;
						cnt++;
						break;
					}
				}
			}
		}
		attack();
	}
}
