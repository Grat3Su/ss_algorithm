package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_bakery {
	static int[][] map;
	static int R,C,ans,col[];
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		R = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		map = new int [R][C];
		ans = 0;
		col = new int[C];
		
		for(int i = 0; i<R; i++) {
			//StringTokenizer st = new StringTokenizer(br.readLine());
			String s = br.readLine(); 
			for(int j = 0; j<C; j++) {
				if(s.charAt(j) =='X')
				map[i][j] = 2;
				else
					map[i][j] = 0;
			}
		}
		

	}
	
	static void setPipe(int row) {
		
		if(row == R-1) {
		
			return;
		}
		for(int i = 0; i<C; i++) {
			
		}
		setPipe(row+1);
	}
	
	static boolean isAvailable(int row) {
		
		
		
		return true;
	}

}
