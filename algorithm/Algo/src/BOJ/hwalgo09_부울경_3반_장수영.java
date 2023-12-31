package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hwalgo09_부울경_3반_장수영 {
static int[] small = new int[9];
static int[] tgt = new int[2];
static int alladd;
static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		alladd = 0;
		for(int i = 0; i<9; i++) {
			small[i] = Integer.parseInt(br.readLine());
			alladd+=small[i];
		}
		comb(0,0);
		System.out.println(sb);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == 2) {
			if(alladd-(tgt[0]+tgt[1])==100) {
				for(int i:small) {
					if(i!=tgt[0]&&i!=tgt[1]) {
						sb.append(i).append("\n");
					}
				}
			}
			return;
		}
		if(srcIdx==small.length) return;
		
		tgt[tgtIdx] = small[srcIdx];
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);
	}
	static void swap(int[]arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
