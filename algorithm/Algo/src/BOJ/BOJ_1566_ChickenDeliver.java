package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1566_ChickenDeliver {
	/*
	 * 조합 문제 데이터셋 N M 1 : 집 2 : 치킨 M만큼 2를 남겼을 때 최소 치킨거리 치킨거리? 모든 거리의 합 5 3 0 0 1 0 0
	 * 0 0 2 0 1 0 1 2 0 0 0 0 1 0 0 0 0 0 0 2
	 */
	static int N, M, min, houseSize, srcSize;
	static List<int[]> house, src, tgt;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		house = new ArrayList<>();
		src = new ArrayList<>();
		tgt = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 2차원 배열 입력을 받으면서 집, 치킨집에 대해서 자료구조를 정리
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1)
					house.add(new int[] { i, j }); // 집
				else if (n == 2)
					src.add(new int[] { i, j }); // 치킨집 전체
			}
		}

		// 풀이
		min = Integer.MAX_VALUE;
		houseSize = house.size();
		srcSize = src.size();

		// 조합
		comb(0, 0);
		System.out.println(min);

	}

	static void comb(int srcIdx, int tgtIdx) {
		// 기저조건
		if (tgtIdx == M) {
			// complete code
			// 치킨집 M개를 조합으로 뽑은 상태
			// 이 조합의 치킨거리의 합을 구하고 최소값이면 갱신
			// 모든 집 각각에 대해서 뽑힌 M개의 치킨집 거리 중 최소인 것을 찾아 합
			int sum = 0; // 현재 조합의 치킨 거리의 종합

			for (int i = 0; i < houseSize; i++) {
				int dist = Integer.MAX_VALUE;
				int[] h = house.get(i);

				for (int j = 0; j < M; j++) {
					int[] c = tgt.get(j);
					dist = Math.min(dist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
				}

				sum += dist;
			}

			min = Math.min(min, sum);
			return;
		}
		if (srcIdx == srcSize)
			return;

		tgt.add(src.get(srcIdx)); // 선택
		comb(srcIdx + 1, tgtIdx + 1); // 선택 O
		tgt.remove(src.get(srcIdx)); // 선택 원복
		comb(srcIdx + 1, tgtIdx); // 선택 X <= 배열은 자연스럽게 다음 index 를 덮어 쓰는 구조 ( 원복 필요 )

	}
}
