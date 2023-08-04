package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_NnM2_perm {
	static int[] tgt;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tgt = new int[M];

		perm(0);
	}

	static void perm(int tgtIdx) {
		if (tgtIdx == M) {
			StringBuilder sb = new StringBuilder();
			for (int i : tgt)
				sb.append(i).append(" ");
			System.out.println(sb);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (tgtIdx>0&&tgt[tgtIdx-1] >= i)// 사용됨
				continue;
			tgt[tgtIdx] = i;
			perm(tgtIdx + 1);
		}
	}

}
