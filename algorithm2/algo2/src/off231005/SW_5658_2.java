package off231005;

import java.util.*;
import java.io.*;

public class SW_5658_2 {
	static int T, N, K, rot;
	static int[] arr;
	static ArrayDeque<Integer> q = new ArrayDeque<Integer>();
	static TreeSet<Integer> TS = new TreeSet<>();
	static ArrayList<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			String hexNums = br.readLine();
			int oneSize = N / 4;
			for (int i = 0; i < oneSize; i++) {
				int start = 0;
				int end = oneSize;

				for (int j = 0; j < 4; j++) {
					String hex = hexNums.substring(start, end);
					int num = Integer.parseInt(hex, 16);
					if (!list.contains(num)) {
						list.add(num);
					}
					start = end;
					end += oneSize;

				}
				char c = hexNums.charAt(N - 1);
				hexNums = c + hexNums.substring(0, N - 1);
			}

			Collections.sort(list);
			sb.append("#").append(t).append(" ").append(list.get(list.size() - K)).append("\n");
		}
		System.out.println(sb);
	}
}
