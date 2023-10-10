package algo2.off231010;

import java.io.*;
import java.util.*;

//서로소 문제
//크루스칼이냐 프림이냐가 문제네..
public class SW_7465_village {
	static int N, M, ans;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			
		}

	}
	
	static boolean union(int a, int b) {
		
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
	}

}
