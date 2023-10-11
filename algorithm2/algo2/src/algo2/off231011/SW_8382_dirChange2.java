package algo2.off231011;

import java.io.*;
import java.util.*;

public class SW_8382_dirChange2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = (Integer.parseInt(st.nextToken()));
			int y1 = (Integer.parseInt(st.nextToken()));
			int x2 = (Integer.parseInt(st.nextToken()));
			int y2 = (Integer.parseInt(st.nextToken()));

			int x = Math.abs(x1 - x2);
			int y = Math.abs(y1 - y2);

			//두 길이로 만들 수 있는 정사각형 길이 line 구
			int line = (x+y)/2;
			int ans = 2*line+Math.abs(x-line) +Math.abs(y-line);

			sb.append("#").append(t).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

	}

}
