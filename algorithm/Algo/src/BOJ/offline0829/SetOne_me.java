package BOJ.offline0829;

import java.util.*;
import java.io.*;

public class SetOne_me {
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		min=Integer.MAX_VALUE;
		molu(N,0);
		System.out.println(min);
	}
	
	static void molu(int n,int count) {
		if(n<1)return;
		if(n==1) {
			min = Math.min(count, min);
			return;		
		}
		if(min<count)return;
		if(n%3==0)molu(n/3,count+1);
		if(n%2==0)molu(n/2,count+1);
		molu(n-1,count+1);
	}

}
