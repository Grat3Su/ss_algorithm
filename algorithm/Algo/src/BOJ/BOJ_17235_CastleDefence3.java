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

public class BOJ_17235_CastleDefence3 {

	static int N, M, D, max;
	static int[][] map;
	static int[] archer = new int[3];
	// 최초 테케 입력으로부터 조합 완성 후 시뮬레이션을 시작할 때마다 사용(원본)
	// enemycopy->enemy로 복사 후 시뮬레이션 진행
	static List<Enemy> enemyCopy = new ArrayList<>();
	static List<Enemy> enemy = new ArrayList<>();// 시뮬레이션 과정에서 사용되는(변하는 에너미를 관리)
	// 궁수로부터 가장 가까운 적을 찾는...
	static PriorityQueue<Enemy> pqueue = new PriorityQueue<>((e1, e2) -> e1.d == e2.d ? e1.x - e2.x : e1.d - e2.d);

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
					enemyCopy.add(new Enemy(i, j));
				}
			}
		}

		comb(0, 0);// M개 x자리(y는 바로 밑)에서 3개를 뽑아서 archer[](tgt)에 담고 처리
		System.out.println(max);
	}

	static void check() {
		// 시뮬레이션 진행
		// 적군 초기화
		enemy.clear();
		for (Enemy e : enemyCopy) {
			enemy.add(new Enemy(e.y, e.x));// 원본을 보호하기 위해 변수 복사., 객체 공유X
		}
		int dead = 0;
		while (true) {
			// 궁수 세명이 한명씩 적군을 쏜다
			for (int i = 0; i < 3; i++) {
				pqueue.clear();

				int ac = archer[i];// 현재 궁수의 x좌표
				int size = enemy.size();// 현재 적군의 크기
				for (int j = 0; j < size; j++) {// 현재 모든 적군에 대해
					Enemy e = enemy.get(j);
					e.d = Math.abs(ac - e.x) + Math.abs(N - e.y);
					if (e.d <= D) {// 사정거리 안에 들어오는 적이면 pqueue에 담는다
						pqueue.offer(e);
					}
				}
				// pqueue를 이용해서 우선순위가 높은 적군을 꺼낸다.
				if (pqueue.isEmpty()) {
					pqueue.poll().dead = true;
				}
			}

			// 죽은 적군을 enemy 제거, 남은 적군 한 칸 아래로 이동. 경계선을 벗어나면 enemy에서 제거
			for (int i = enemy.size() - 1; i >= 0; i--) {
				Enemy e = enemy.get(i);

				if (e.dead) {
					enemy.remove(i);
					dead++;
				} else if (e.y == N - 1) {
					enemy.remove(i);
				} else {
					e.y++;
				}
			}

			// 시뮬레이션 종료 조건
			if (enemy.size() == 0)
				break;
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
