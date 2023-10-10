package algo2.off231010;

import java.io.*;
import java.util.*;

public class SW_4013_magnet2 {
	static int K;
	static boolean[] check = new boolean[4];
	static List<List<Integer>> magnet;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		magnet = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			magnet.add(new ArrayList<Integer>());
		}

		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet.get(i).add(Integer.parseInt(st.nextToken()));
				}
			}
			int[] mDir = new int[4];
			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());

				spinMagnet(idx, dir);
				mDir[idx] = dir;
				
				for (int i = idx; i < 3; i++) {// 오른쪽 자석 돌리기
					if (magnet.get(idx).get(2) != magnet.get(i + 1).get(6)){
					mDir[i]	 = mDir[i-1] * (-1);
					spinMagnet(i, mDir[i]);
					}
				}
				for (int i = idx; i > 0; i--) {// 왼쪽으로 돌리기
					if (magnet.get(i).get(6) != magnet.get(i - 1).get(2)){
					mDir[i]	 = mDir[i+1] * (-1);
					spinMagnet(i, mDir[i]);
					}
				}
			}
			int ans = 0;
			if (magnet.get(0).get(0) == 1)
				ans += 1;
			for (int i = 1; i < 4; i++) {
				if (magnet.get(i).get(0) == 1)
					ans += (i * 2);
			}
			System.out.println("#"+t+" "+ans);
		}
	}

	static void spinMagnet(int idx, int dir) {
		if (dir == -1) {
			magnet.get(idx).add(0, magnet.get(idx).get(7));
			magnet.get(idx).remove(7);
		} else {
			magnet.get(idx).add(magnet.get(idx).get(0));
			magnet.get(idx).remove(0);
		}
	}
}
