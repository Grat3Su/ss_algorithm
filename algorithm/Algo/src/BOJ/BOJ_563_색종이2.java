package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_563_색종이2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] x = new int[T];
		int[] y = new int[T];
		int result = 0;//겹치는 부분
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[t] = Integer.parseInt(st.nextToken());
			y[t] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<T; i++) {
			for(int j = 0; j<T; j++) {
				if(Math.abs(x[j]-x[i])<10&&Math.abs(y[j]-y[i])<10) {//충돌
					if(x[i]>x[j]) {
						result+=(x[i]>x[j]?(x[j]-x[i]+10):(x[i]-x[j]+10))*(y[i]>y[j]?(y[j]-y[i]+10):(y[i]-y[j]+10));
					}
				}
			}
		}
		
		System.out.println(100*T-result);
	}

}
