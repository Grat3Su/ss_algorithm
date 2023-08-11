package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_snowhie {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int []real = new int[9];
		int []index = new int[9];
		int sum = 0;
		for(int i = 0; i<9; i++) {
			real[i] = Integer.parseInt(br.readLine());		
			 sum += real[i]; 
		}
		index[7]=1;
		index[8]=1;
		
		while(true) {
			int tgtidx = 0;
			for(int i = 0; i<9; i++) {
				
					
			}
		}
	}
	
	static boolean np(int[] array) {
		int i, j, k;
		i=j=k = array.length-1;
		while(i>0&&array[i-1]>=array[i]) --i;
		
		if(i==0) return false;

		while(array[i-1]>=array[j]) --j;
		swap(array, i-1, j);
		
		while(i<k) swap(array, i++,k--);
		
		return true;
	}
	static void swap(int[]arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
