package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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
//enemycopy <- 입력을 처리하면서 동적으로 add()...arraylist가 합당
//enemy 갯수를 알고 있으니까 배열 사용<=삭제의 경우 null로 처리
//enemy class=> 배열로 변경
public class BOJ_17235_CastleDefence4 {

	static int N, M, D, max,enemySize;
	static int[][] map;
	static int[] archer = new int[3];
	// 최초 테케 입력으로부터 조합 완성 후 시뮬레이션을 시작할 때마다 사용(원본)
	// enemycopy->enemy로 복사 후 시뮬레이션 진행
	static List<int[]> enemyCopy = new ArrayList<>();
	static int[][] enemy;// 시뮬레이션 과정에서 사용되는(변하는 에너미를 관리)
	// 궁수로부터 가장 가까운 적을 찾는...
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {// enemy
					enemyCopy.add(new int[]{i,j,0});
				}
			}
		}
		enemySize = enemyCopy.size();
		//enemy[]생성
		enemy = new int[enemySize][3];
		

		comb(0, 0);// M개 x자리(y는 바로 밑)에서 3개를 뽑아서 archer[](tgt)에 담고 처리
		System.out.println(max);
	}

	static void check() {
        // 시물레이션 진행
        // 적군 초기화
        for(int i = 0; i<enemySize; i++) {
            int[] e = enemyCopy.get(i);
            enemy[i] = new int[] {e[0], e[1], e[2]}; // 복제(새로생성)
        }
        // while() 시물레이션 진행
        int dead = 0; // 죽인 적군의 수
        int enemyCnt = enemySize; // enemy[] 아직 살아 있는 적의 수
        while(true) {
            // 궁수 3명이 한명씩 적군 쏜다.
            for (int i = 0; i < 3; i++) {
                // 가장 가까운 적??                
                int ac = archer[i]; // 현재 궁수의 x좌표
                int size =enemySize; // 현재 적군의 크기
                
                int minD = Integer.MAX_VALUE;
                int minX = Integer.MAX_VALUE;
                int minIdx = -1; // 가장 가까운 거리에 있는 적의 index
                
                for (int j = 0; j < size; j++) { // 현재 모든 적군에 대해서
                    int[] e = enemy[j];
                    if(e == null) continue; // 이미 죽은 적은 제외
                    int d = Math.abs(ac - e[1]) + Math.abs(N - e[0]);
                    
                    if( d > D ) continue; // 사정거리 밖의 적은 skip
                    
                    // 사정거리안의 적이라면
                    if( minD == d ) {
                        if( minX > e[1] ) {
                            minX = e[1];
                            minIdx = j; // 적의 index
                        }
                    }else if( minD > d) {
                        minD = d;
                        minX = e[1];
                        minIdx = j; // 적의 index
                    }
                }
                
                // minIdx 가 유효하면 (있으면)
                if( minIdx != -1 ) {
                    enemy[minIdx][2] = 1;
                }                
            }
            
            // 죽은 적군을 enemy 제거, 남은 적군 한 칸 아래로 이동, 경계선을 벗어나면 enemy 에서 제거
            for (int i = 0; i <enemySize; i++) {
                if(enemy[i] == null) continue; // 이미 죽은 적은 제외
                if( enemy[i][2] == 1 ) {
                    enemy[i] = null;
                    dead++;
                    enemyCnt--;
                }else if(enemy[i][0] == N - 1) {
                    enemy[i] = null;
                    enemyCnt--;
                }else {
                    enemy[i][0]++;
                }
            }
            
            // 시물레이션 종료 조건
            if( enemyCnt == 0 ) break;
        }
        
        max = Math.max(max, dead);
    }

	private static void comb(int srcidx, int tgtidx) {
		if (tgtidx == 3) {
			check();
			return;
		}

		if (srcidx == M)
			return;

		archer[tgtidx] = srcidx;

		comb(srcidx + 1, tgtidx + 1);
		comb(srcidx + 1, tgtidx);

	}

	static class Enemy {
		int y, x, d;// d: 궁수와ㅇ의 거리
		boolean dead;

		public Enemy(int y, int x) {// d, dead<= 시뮬레이션을 진행하면서 세팅해야함
			super();
			this.y = y;
			this.x = x;
		}
	}
}
