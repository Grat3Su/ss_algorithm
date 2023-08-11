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
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<9; i++) {
			real[i] = Integer.parseInt(br.readLine());		
			 sum += real[i]; 
		}
		index[7]=1;
		index[8]=1;
		while(true) {
			int tgtidx = 0;
			int[]x = new int[2];
			x[0] = 0;
			int sub = 0;
			for(int i = 0; i<9; i++) {
				if(index[i]==1) {
					sub +=real[i];
					if(x[0]!=0) x[0] = real[i];
					else x[1] = real[i];
				}
			
				if(sum-sub==100) {
					for(int j = 0; j<9;j++) {
						if(real[j]!=x[0]&&real[j]!=x[1])
							sb.append(real[j]).append("\n");
					}
					break;
				}
					
			}
			
			if(!np(index))break;
		}
		System.out.println(sb);
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
