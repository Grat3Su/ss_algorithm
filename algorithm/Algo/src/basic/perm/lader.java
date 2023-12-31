package basic.perm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lader {
	static int[][] map = new int[100][100];
	static int result = 0;
	public static void main(String[] args) throws IOException{
		//아래에서부터 올라가는데 3개 체크 
		//System.setIn(new FileInputStream("input (2).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int T = Integer.parseInt(st.nextToken());

		int end = -1;
		for(int t = 0; t<T; t++) {
			for(int i = 0; i<100; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100; j++)
				{
					map[j][i] = Integer.parseInt(st.nextToken());
					if(map[j][i] == 2)
					{
						end = j;
					}
				}
			}
		}
		climbLader(end, 99, false, false);
		
	}
	
	static void climbLader(int x, int y, boolean left, boolean right)
	{
		if(y == 0) {
			result = x;
			System.out.println("wow");
			System.out.println(result);
			System.out.println(y);
			return;
		}
				
		if(!left&& x<99 &&map[x+1][y] == 1) {
			right = true;
			System.out.println("right");
			x++;
		}
		
		else if(!right&& x>1 &&map[x-1][y] == 1) {
			left = true;
			System.out.println("left");
			x--;
		}
		else if(!left&&!right)
			y--;
		if(right&&map[x+1][y] == 0) {
			System.out.println("noright");
			right = false;
		}
		if(left&&map[x-1][y] == 0) {
			System.out.println("noleft");
			left = false;
		}
		climbLader(x, y, left, right);
	}

}
