package algo2.off231005;

import java.util.*;
import java.io.*;

public class SW_5658 {
	static int T, N, K, rot;
	static int[] arr;
	static ArrayDeque<Integer> q = new ArrayDeque<Integer>();
	static TreeSet<Integer> TS = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			String s = br.readLine();
			for (int i = 0; i < N; i++) {
				if (s.charAt(i) < 'A') {
					arr[i] = s.charAt(i) - '0';
					q.offer(arr[i]);
				} else {
					arr[i] = (10 + s.charAt(i) - 'A' + 1);
					q.offer(arr[i]);
				}
			}
		}

		rot = N / 4;
		//System.out.println(rot);
		for (int r = 0; r < rot; r++) {//로테이션
			for (int j = 0; j < 4; j++) {//한 변의 합
				int sum = 0;
				for (int i = 0; i < rot; i++) {
					if((j*rot)+r+i>=N){//r+i가 배열보다 크면 0부터 읽어야함
						sum += arr[((j*rot)+i+r)-N];
						//System.out.println(arr[((j*rot)+i+r)-N]);
						}
					else {
						sum += arr[(j*rot)+r+i];
						//System.out.println(arr[(j*rot)+r+i]);
					}
					
				}
				//System.out.println("-------------------------");
				System.out.println(sum);
				//System.out.println("-------------------------");
				TS.add(sum);
			}
		}
		
		int x = 0;
		for(int i : TS) {
			x++;
			if(x==K)
				System.out.println(i);
		}
		

		System.out.println(Arrays.toString(arr));
	}

}
