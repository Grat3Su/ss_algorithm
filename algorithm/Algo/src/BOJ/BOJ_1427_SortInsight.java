package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;



public class BOJ_1427_SortInsight {
	static int[]arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		String sortArr = br.readLine();
		arr = new int[sortArr.length()];
		for(int i = 0; i<sortArr.length(); i++) {
			arr[i] = sortArr.charAt(i)-'0';
		}
		//Arrays.sort(arr,Collections.reverseOrder());
		
		System.out.println(Arrays.toString(arr));
	}
	
//	int sort(int a, int b) {
//		return 
//	}

}
