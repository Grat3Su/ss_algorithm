package algo2.off231011;

import java.io.*;
import java.util.*;

public class SW_8382_dirChange {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] pos = new int[2];
			int[] pos2 = new int[2];

			pos[0] = (Integer.parseInt(st.nextToken()));
			pos[1] = (Integer.parseInt(st.nextToken()));
			pos2[0] = (Integer.parseInt(st.nextToken()));
			pos2[1] = (Integer.parseInt(st.nextToken()));

			int x = Math.abs(pos[0] - pos2[0]);
			int y = Math.abs(pos[1] - pos2[1]);

			int ans = 0;			
			int abs = (Math.abs(x-y));
			ans+= Math.min(x, y)*2;
			if(abs == 0) {
			}
			else if(abs%2 == 0) {
				ans += abs/2*4;
			}else if(abs%2 ==1) {
				ans += abs/2*4+1;
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

	}

}
