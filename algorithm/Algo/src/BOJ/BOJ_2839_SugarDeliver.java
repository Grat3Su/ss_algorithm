package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_SugarDeliver {
	static int N, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		
		//3kg 5kg
		min = 5000;
		
		dfs(0,0);//5사용 3 사용
		
		min= min==5000?-1:min;
		System.out.println(min);
	}
	
	static void dfs(int five, int three) {
		int sum = five*5+three*3;
		if(sum==N) {
			min = Math.min(min, five+three);
			return;
		}
		else if(sum>N) {
			return;
		}
		dfs(five+1,three);//현재보다 5kg 하나 더 사용
		dfs(five,three+1);//현재보다 3kg 더씀
	}
}
