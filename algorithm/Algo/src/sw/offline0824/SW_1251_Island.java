package sw.offline0824;

import java.util.*;
import java.io.*;

/*Edge = (E* L^2)
 * 테스트 케이스
 * T
 * N
 * X X
 * Y Y
 * E
 * 10
2
0 0
0 100
1.0
4
0 0 400 400
0 100 0 100
1.0
6
0 0 400 400 1000 2000
0 100 0 100 600 2000
0.3
9
567 5 45674 24 797 29 0 0 0
345352 5464 145346 54764 5875 0 3453 4545 123
0.0005
 */
//좌표들이 크니까 
//비용계산 생각
//결과값도 크다
//크루스칼 프리마 모두 써서 풀어보기
public class SW_1251_Island {
	static int T, N;
	static long ans;

	static int[] parents;
	static int[][] island;

	static long[][] edges;// e1 e2 distance
	static double E;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			island = new int[N][2];// X Y
			// x
			StringTokenizer st = new StringTokenizer(br.readLine());
			// x
			for (int i = 0; i < N; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
			}
			// y
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][1] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			parents = new int[N];
			makeSet();

			// 전체 간선 따져야한다
			int size = N * (N - 1) / 2;// N개의 정점을 연결하는 모든 간선의 수
			edges = new long[size][3];

			int idx = 0;
			for (int v1 = 0; v1 < N - 1; v1++) {
				for (int v2 = v1 + 1; v2 < N; v2++) {
					edges[idx][0] = v1;
					edges[idx][1] = v2;
					edges[idx][2] = distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]);
					idx++;
				}
			}
			// 쿠르스칼 풀이
			// 정렬
			Arrays.sort(edges, (o1, o2) -> Long.compare(o1[2], o2[2]));// 비용으로 계산
			ans = 0;
			int cnt = 0;

			for (int i = 0; i < size; i++) {
				// union 호출 대신 직접 코드 작성 (call stack save!)
				int px = findSet((int) edges[i][0]);// x의 최조ㅓㅇ 대표자 집합 원소
				int py = findSet((int) edges[i][1]);// y의 최종 대표자집합 원소

				// 만약 px==py<=x,y 는 서로 같은 서로소 집합
				// 그렇지 않으면 <=x,y는 서로 다른 서로소 집합
				if (px == py)
					continue;
				//parents[py] = px;
				if (px > py)
					parents[py] = px;
				else
					parents[px] = py;

				ans += edges[i][2];// 누적비용
				cnt++;
				if (cnt == N - 1)
					break;
			}
			sb.append("#").append(t + 1).append(" ").append(Math.round(ans * E)).append("\n");
		}
		System.out.println(sb);
	}

	static long distance(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	// 서로소 집합을 표현하는 자료구조 생성 및 초기화
	static void makeSet() {// 집합 만들깅
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	// 소속된 서로소 집합의 대표 원소를 리턴
	static int findSet(int x) {// 어떤 수 x에 대해 대표자 리턴
		// 기저조건
		// value와 index 같은 조건
		if (parents[x] == x)
			return x;
		else
			return parents[x] = findSet(parents[x]);// path compression 하지 않는 경우
	}
	

}
