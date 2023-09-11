package BOJ.algostudy;

import java.io.*;
import java.util.*;

import javax.xml.bind.ParseConversionEvent;

/*N
 * M
 * adjmatrix
 * travel List
 * 3
3
0 1 0
1 0 1
0 1 0
1 2 3
 */

public class BOJ_1976_travel {
	static int N, M;// 도시의 수/여행 도시 수
	static int[][] adjMatrix;// 인접행렬
	static boolean[] travelList;// 도시 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		adjMatrix = new int[N + 1][N + 1];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//탐색

		// 방문한 도시 수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int city = Integer.parseInt(st.nextToken());
			if (!travelList[city]) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");

	}

}
