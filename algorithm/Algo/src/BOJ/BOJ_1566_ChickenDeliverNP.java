package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1566_ChickenDeliverNP {
	/*
	 * 조합 문제 데이터셋 N M 1 : 집 2 : 치킨 M만큼 2를 남겼을 때 최소 치킨거리 치킨거리? 모든 거리의 합 5 3 0 0 1 0 0
	 * 0 0 2 0 1 0 1 2 0 0 0 0 1 0 0 0 0 0 0 2
	 */
	static int N, M, min, houseSize, srcSize;
	static List<int[]> house, src, tgt;
	static int[] index;
	static int[][] memoi;

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

		// memoi
		memoi = new int[houseSize][srcSize];

		for (int i = 0; i < houseSize; i++) {
			int[] h = house.get(i);

			for (int j = 0; j < srcSize; j++) {
				int[] c = src.get(j);
				memoi[i][j] = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
			}
		}

		// NP
		index = new int[srcSize]; // srcSize -> M : 0000111...111 ( 1의 수가 M개 ) ->..-> 111...110000
		for (int i = srcSize - M; i < srcSize; i++) {
			index[i] = 1;
		}

		// 조합 by NP
		while (true) {
			// complete code
			int sum = 0; // 현재 조합의 치킨 거리의 종합

			for (int i = 0; i < houseSize; i++) {
				int dist = Integer.MAX_VALUE;
				int[] h = house.get(i);

				for (int j = 0; j < srcSize; j++) { // 모든 치킨집에 대해서
					if (index[j] == 1) { // j번째 치킨집이 선택되었으면
						int[] c = src.get(j);
						dist = Math.min(dist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
					}
				}

				sum += dist;
			}

			min = Math.min(min, sum);

			if (!np(index))
				break;
		}
		System.out.println(min);
	}

	static boolean np(int array[]) {
		int i, j, k;
		i = j = k = srcSize - 1;

		while (i > 0 && array[i - 1] >= array[i])
			--i;

		if (i == 0)
			return false;

		while (array[i - 1] >= array[j])
			--j;

		swap(array, i - 1, j);

		while (i < k) {
			swap(array, i++, k--);
		}

		return true;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
